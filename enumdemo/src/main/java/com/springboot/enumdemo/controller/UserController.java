package com.springboot.enumdemo.controller;

import com.springboot.enumdemo.dto.UserResult;
import com.springboot.enumdemo.dto.UserVo;
import com.springboot.enumdemo.pojo.User;
import com.springboot.enumdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: User控制器接口及实现
 * @Author 傅琦
 * @Date 2019/4/23 20:58
 * @Version V1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findUserByName")
    UserResult<Object> findUserByName(@RequestParam("userName") String userName){
        return userService.findUserByName(userName);
    }

    @PostMapping("/addUser")
    UserResult<String> addUser(@RequestBody UserVo userVo){
        return userService.addUser(new User(userVo));
    }

    @PostMapping("/modifyUser")
    UserResult<String> modifyUser(@RequestBody UserVo userVo){
        return userService.modifyUser(new User(userVo));
    }
}
