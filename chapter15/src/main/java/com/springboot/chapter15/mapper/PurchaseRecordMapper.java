package com.springboot.chapter15.mapper;

import com.springboot.chapter15.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 购买记录Mapper
 * @Author 傅琦
 * @Date 2019/5/7 16:11
 * @Version V1.0
 */
@Mapper
public interface PurchaseRecordMapper {
    /**
     * 增加购买记录
     * @param purchaseRecord
     * @return
     */
    int addPurchaseRecord(@Param("purchaseRecord") PurchaseRecord purchaseRecord);
}
