package com.springboot.chapter15.controller;

import com.springboot.chapter15.service.PurchaseService;
import com.springboot.chapter15.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 购买产品的控制器
 * @Author 傅琦
 * @Date 2019/5/7 19:26
 * @Version V1.0
 */
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

    @PostMapping("/purchase")
    /**
     *@Description: 购买产品的映射方法
     *@parameters: [userId, productId, quantity]
     *@return: com.springboot.chapter15.vo.ResultVo<java.lang.Object>
     *@Author: 傅琦
     *@Date: 2019/5/7 19:33
     */
    public ResultVo<Object> purchase(@RequestParam("userId") Long userId,
                                     @RequestParam("productId") Long productId,
                                     @RequestParam("quantity") int quantity){
        boolean success = purchaseService.purchase(userId, productId, quantity);
        String message = success ? "抢购成功": "抢购失败";
        ResultVo<Object> result = new ResultVo<>(success, message, null);
        return result;
    }
}
