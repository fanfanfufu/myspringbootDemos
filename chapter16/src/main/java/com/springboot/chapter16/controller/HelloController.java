package com.springboot.chapter16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: hello, world控制器
 * @Author 傅琦
 * @Date 2019/5/11 15:14
 * @Version V1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    /**
     *@Description: 根据/hello请求地址返回“Hello, World！”
     *@parameters: []
     *@return: java.lang.String
     *@Author: 傅琦
     *@Date: 2019/5/11 15:15
     */
    public String hello(){
        return "Hello, World!";
    }
}
