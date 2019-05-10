package com.springboot.chapter15.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @Description: 产品POJO
 * @Author 傅琦
 * @Date 2019/5/7 14:47
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("product")
public class Product implements Serializable {
    private static final long serialVersionUID = 989901737123806162L;
    private Long productId;
    private String productName;
    private int stock;
    private double price;
    private int version;
    private String note;
}
