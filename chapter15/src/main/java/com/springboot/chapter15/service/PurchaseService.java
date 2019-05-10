package com.springboot.chapter15.service;

import com.springboot.chapter15.pojo.PurchaseRecord;

import java.util.List;

/**
 * @Description: 购买产品的业务层接口
 * @Author 傅琦
 * @Date 2019/5/7 17:06
 * @Version V1.0
 */
public interface PurchaseService {
    boolean purchase(Long userId, Long productId, int quantity);

    boolean purchaseRedis(Long userId, Long productId, int quantity);

    boolean dealRedisPurchase(List<PurchaseRecord> purchaseRecordList);
}
