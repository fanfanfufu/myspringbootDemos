package com.springboot.chapter15.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 视图层返回结果的封装
 * @Author 傅琦
 * @Date 2019/5/7 17:30
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultVo<T> {
    private boolean state;
    private String message;
    private T data;
}
