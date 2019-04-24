package com.springboot.enumdemo.service;

import com.springboot.enumdemo.dto.UserResult;
import com.springboot.enumdemo.pojo.User;

/**
 * @Description: User内部Service接口
 * @Author 傅琦
 * @Date 2019/4/23 20:16
 * @Version V1.0
 */
public interface UserService {
    UserResult<Object> findUserByName(String userName);

    UserResult<String> addUser(User user);

    UserResult<String> modifyUser(User user);
}
