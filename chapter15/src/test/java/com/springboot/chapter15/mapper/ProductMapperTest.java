package com.springboot.chapter15.mapper;

import com.springboot.chapter15.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description: 测试productMapper
 * @Author 傅琦
 * @Date 2019/5/7 15:51
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void productMapperTest(){
        assert productMapper != null;
    }

    @Test
    public void getProduct() {
        Product product = productMapper.getProduct(1L);
        System.out.println(product);
    }

    @Test
    public void decreaseProduct() {
        int result = productMapper.decreaseProduct(1L, 50);
        assert result == 1;
    }
}