package com.springboot.timo_db_operate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: service层处理结果的封装类
 * @Author 傅琦
 * @Date 2019/4/29 21:51
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultDto<T> {
    private String state;
    private T data;
}
