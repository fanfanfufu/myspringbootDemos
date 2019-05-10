package com.springboot.chapter15.mapper;

import com.springboot.chapter15.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 产品Mapper
 * @Author 傅琦
 * @Date 2019/5/7 15:03
 * @Version V1.0
 */
@Mapper
public interface ProductMapper {
    /**
     * 根据productId获取单个产品
     * @param productId
     * @return
     */
    Product getProduct(Long productId);

    /**
     * 减库存
     * @param productId
     * @param quantity
     * @return
     */
    int decreaseProduct(@Param("productId") Long productId,
                        @Param("quantity") int quantity);
}
