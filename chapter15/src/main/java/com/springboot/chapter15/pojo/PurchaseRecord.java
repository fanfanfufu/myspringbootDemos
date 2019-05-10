package com.springboot.chapter15.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 购买记录POJO
 * @Author 傅琦
 * @Date 2019/5/7 14:50
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("purchaseRecord")
public class PurchaseRecord implements Serializable {
    private static final long serialVersionUID = 2132755647151006739L;
    private Long purchaseRecordId;
    private Long userId;
    private Long productId;
    private double price;
    private int quantity;
    private double sum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date purchaseTime;
    private String note;
}
