package com.springboot.chapter15.service.serviceimpl;

import com.springboot.chapter15.pojo.PurchaseRecord;
import com.springboot.chapter15.service.PurchaseService;
import com.springboot.chapter15.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Description: 定时任务接口的实现
 * @Author 傅琦
 * @Date 2019/5/10 16:09
 * @Version V1.0
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private PurchaseService purchaseService;

    private static final String PRODUCT_SCHEDULE_SET = "product_schedule_set";
    private static final String PURCHASE_PRODUCT_LIST = "purchase_list_";
    private static final int ONE_TIME_SIZE = 1000;

    @Override
    /**
     * 每天凌晨开启执行任务
     * @Scheduled(cron = "0 0 1 * * ?")
     * 下面是用于测试的配置，每分钟执行一次任务
     */
    @Scheduled(fixedRate = 1000 * 60)
    public void purchaseTask() {
        System.out.println("定时任务开始。。。。。。");
        Set<String> productList = redisTemplate.opsForSet().members(PRODUCT_SCHEDULE_SET);
        List<PurchaseRecord> purchaseRecordList = new ArrayList<>();
        for (String productIdStr: productList){
            Long productId = Long.parseLong(productIdStr);
            String purchaseKey = PURCHASE_PRODUCT_LIST + productId;
            BoundListOperations<String, String> operations = redisTemplate.boundListOps(purchaseKey);
            long size = redisTemplate.opsForList().size(purchaseKey);
            long times = size % ONE_TIME_SIZE == 0 ? size / ONE_TIME_SIZE : size / ONE_TIME_SIZE + 1;
            for (int i = 0; i < times; i++){
                List<String> prList = null;
                if (i == 0){
                    prList = operations.range(i * ONE_TIME_SIZE, (i+1) * ONE_TIME_SIZE);
                }else {
                    prList = operations.range(i * ONE_TIME_SIZE + 1, (i+1) * ONE_TIME_SIZE);
                }

                for (String prStr: prList){
                    PurchaseRecord purchaseRecord = this.createPurchaseRecord(productId, prStr);
                    purchaseRecordList.add(purchaseRecord);
                }
                try{
                    purchaseService.dealRedisPurchase(purchaseRecordList);
                }catch (Exception e){
                    e.printStackTrace();
                }
                purchaseRecordList.clear();
            }
            redisTemplate.delete(purchaseKey);
            redisTemplate.opsForSet().remove(PRODUCT_SCHEDULE_SET, productIdStr);
        }
        System.out.println("定时任务结束。。。。。。");
    }

    private PurchaseRecord createPurchaseRecord(Long productId, String prStr){
        String[] arr = prStr.split(",");
        Long userId = Long.parseLong(arr[0]);
        int quantity = Integer.parseInt(arr[1]);
        double sum = Double.valueOf(arr[2]);
        double price = Double.valueOf(arr[3]);
        Long time = Long.parseLong(arr[4]);
        Date purchaseTime = new Date();

        PurchaseRecord purchaseRecord = new PurchaseRecord();
        purchaseRecord.setProductId(productId);
        purchaseRecord.setPrice(price);
        purchaseRecord.setPurchaseTime(purchaseTime);
        purchaseRecord.setSum(sum);
        purchaseRecord.setQuantity(quantity);
        purchaseRecord.setUserId(userId);
        purchaseRecord.setNote("购买日志，时间：" + purchaseTime.getTime());
        return purchaseRecord;
    }
}
