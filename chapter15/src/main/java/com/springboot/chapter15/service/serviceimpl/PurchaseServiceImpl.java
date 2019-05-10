package com.springboot.chapter15.service.serviceimpl;

import com.springboot.chapter15.mapper.ProductMapper;
import com.springboot.chapter15.mapper.PurchaseRecordMapper;
import com.springboot.chapter15.pojo.Product;
import com.springboot.chapter15.pojo.PurchaseRecord;
import com.springboot.chapter15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Description: 购买产品的业务层实现
 * @Author 傅琦
 * @Date 2019/5/7 17:11
 * @Version V1.0
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    String purchaseScript =
            " redis.call('sadd', KEYS[1], ARGV[2]) \n"
            + "local productPurchaseList = KEY[2]..ARGV[2] \n"
            + "local userId = ARGV[1] \n"
            + "local product = 'product_'..ARGV[2] \n"
            + "local quantity = tonumber(ARGV[3]) \n"
            + "local stock = tonumber(redis.call('hget', product, 'stock')) \n"
            + "local price = tonumber(redis.call('hget', product, 'price')) \n"
            + "local purchase_date = ARGV[4] \n"
            + "if stock < quantity then return 0 end \n"
            + "stock = stock - quantity \n"
            + "redis.call('hset', product, 'stock', tostring(stock)) \n"
            + "local sum = price * quantity \n"
            + "local purchaseRecord = userId..','..quantity..','"
            + "..sum..','..price..','..purchase_date \n"
            + "redis.call('rpush', productPurchaseList, purchaseRecord) \n"
            + "return 1 \n";

    private static final String PURCHASE_PRODUCT_LIST = "purchase_list_";

    private static final String PRODUCT_SCHEDULE_SET = "product_schedule_set";

    private String sha1 = null;

    private PurchaseRecord initPurchaseRecord(Long userId, Product product, int quantity){
        PurchaseRecord purchaseRecord = new PurchaseRecord();
        purchaseRecord.setPrice(product.getPrice());
        purchaseRecord.setProductId(product.getProductId());
        purchaseRecord.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        purchaseRecord.setSum(sum);
        purchaseRecord.setUserId(userId);

        return purchaseRecord;
    }

    @Override
    /**
     * 启动数据库事务机制
     */
    @Transactional(rollbackFor = Exception.class)
    /**
     *@Description: 购买产品的具体实现
     *@parameters: [userId, productId, quantity]
     *@return: boolean
     *@Author: 傅琦
     *@Date: 2019/5/7 17:18
     */
    public boolean purchase(Long userId, Long productId, int quantity) {
        // 获取产品
        Product product = productMapper.getProduct(productId);
        // 比较库存和购买数量
        if (product.getStock() < quantity){
            // 库存不足
            return false;
        }
        productMapper.decreaseProduct(productId, quantity);

        PurchaseRecord purchaseRecord = this.initPurchaseRecord(userId, product, quantity);
        purchaseRecordMapper.addPurchaseRecord(purchaseRecord);
        return true;
    }

    @Override
    public boolean purchaseRedis(Long userId, Long productId, int quantity) {
        Long purchaseDate = System.currentTimeMillis();
        Jedis jedis = null;
        try {
            jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
            if (sha1 == null){
                sha1 = jedis.scriptLoad(purchaseScript);
            }
            Object res = jedis.evalsha(sha1,
                    2,
                    PRODUCT_SCHEDULE_SET,
                    PURCHASE_PRODUCT_LIST,
                    userId + "",
                    productId + "",
                    quantity + "",
                    purchaseDate + "");
            Long result = (Long) res;
            return result == 1;
        }finally {
            if (jedis != null && jedis.isConnected()){
                jedis.close();
            }
        }

    }

    @Override
    /**
     * 运行该方法启用新的独立事务来运行
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean dealRedisPurchase(List<PurchaseRecord> purchaseRecordList) {
        for (PurchaseRecord purchaseRecord: purchaseRecordList){
            purchaseRecordMapper.addPurchaseRecord(purchaseRecord);
            productMapper.decreaseProduct(purchaseRecord.getProductId(), purchaseRecord.getQuantity());
        }
        return true;
    }
}
