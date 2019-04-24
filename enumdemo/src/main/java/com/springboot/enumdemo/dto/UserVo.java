package com.springboot.enumdemo.dto;

import com.springboot.enumdemo.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: User类的视图层封装
 * @Author 傅琦
 * @Date 2019/4/23 21:13
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserVo {
    private int id;
    private String userName;
    private String gender;
    private String note;

    public UserVo(User user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.gender = user.getSex().getMessage();
        this.note = user.getNote();
    }
}
