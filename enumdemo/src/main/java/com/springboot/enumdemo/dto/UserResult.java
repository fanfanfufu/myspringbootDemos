package com.springboot.enumdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: User的mybatis操作返回结果的封装
 * @Author 傅琦
 * @Date 2019/4/23 20:22
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserResult<T> {
    private String state;
    private T data;
}
