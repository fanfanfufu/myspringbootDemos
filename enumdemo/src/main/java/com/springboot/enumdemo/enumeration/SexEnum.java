package com.springboot.enumdemo.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 性别枚举类
 * @Author 傅琦
 * @Date 2019/4/23 14:22
 * @Version V1.0
 */
@Getter
@AllArgsConstructor
public enum SexEnum {
    /**
     * 男女实例
     */
    MALE(1, "男"),
    FEMALE(2, "女");

    private int id;
    private String message;

//    SexEnum (int id, String message){
//        this.id = id;
//        this.message = message;
//    }

    /**
     *@Description: 根据输入的id来获取对应的性别实例
     *@parameters: [id]
     *@return: com.springboot.enumdemo.enumeration.SexEnum
     *@Author: 傅琦
     *@Date: 2019/4/23 19:28
     */
    public static SexEnum getSexById(int id){
        for (SexEnum sex: SexEnum.values()){
            if (sex.getId() == id){
                return sex;
            }
        }
        return null;
    }

    /**
     *@Description: 根据所输入的属性来获取对应的性别实例
     *@parameters: [message]
     *@return: com.springboot.enumdemo.enumeration.SexEnum
     *@Author: 傅琦
     *@Date: 2019/4/23 19:29
     */
    public static SexEnum getSexByMessage(String message){
        for (SexEnum sexEnum: SexEnum.values()){
            if (message.equals(sexEnum.getMessage())){
                return sexEnum;
            }
        }
        return null;
    }
}
