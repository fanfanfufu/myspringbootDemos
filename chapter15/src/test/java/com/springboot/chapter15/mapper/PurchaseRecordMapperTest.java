package com.springboot.chapter15.mapper;

import com.springboot.chapter15.pojo.PurchaseRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description: 购买记录mapper接口的测试类
 * @Author 傅琦
 * @Date 2019/5/7 16:29
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseRecordMapperTest {
    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Test
    public void purchaseRecordMapperTest(){
        assert purchaseRecordMapper != null;
    }

    @Test
    public void addPurchaseRecord() {
        PurchaseRecord purchaseRecord = new PurchaseRecord();
        purchaseRecord.setUserId(1L);
        purchaseRecord.setProductId(1L);
        purchaseRecord.setPrice(2.00);
        purchaseRecord.setQuantity(50);
        purchaseRecord.setSum(100.00);
        purchaseRecord.setPurchaseTime(new Date());

        int result = purchaseRecordMapper.addPurchaseRecord(purchaseRecord);
        System.out.println(result);
    }
}