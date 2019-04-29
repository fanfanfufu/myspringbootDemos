package com.springboot.timo_db_operate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 性别枚举类
 * @Author 傅琦
 * @Date 2019/4/24 19:13
 * @Version V1.0
 */
@Getter
@AllArgsConstructor
public enum Gender {
    /**
     * 性别实例，只有两种
     */
    MAN("1", "男"),
    WOMAN("2", "女");

    private String number;
    private String message;

    /**
     *@Description: 根据数字匹配性别
     *@parameters: [number]
     *@return: com.springboot.timo_db_operate.enums.Gender
     *@Author: 傅琦
     *@Date: 2019/4/24 19:18
     */
    public static Gender getGenderByNumber(String number){
        for (Gender gender: Gender.values()){
            if (number.equals(gender.getNumber())){
                return gender;
            }
        }
        return null;
    }

    /**
     *@Description: 根据文字描述匹配性别
     *@parameters: [message]
     *@return: com.springboot.timo_db_operate.enums.Gender
     *@Author: 傅琦
     *@Date: 2019/4/24 19:18
     */
    public static Gender getGnderByMessage(String message){
        for (Gender gender: Gender.values()){
            if (message.equals(gender.getMessage())){
                return gender;
            }
        }
        return null;
    }
}
