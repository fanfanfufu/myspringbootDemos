package com.springboot.enumdemo.pojo;

import com.springboot.enumdemo.dto.UserVo;
import com.springboot.enumdemo.enumeration.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @Description: User实体类
 * @Author 傅琦
 * @Date 2019/4/23 14:21
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("user")
public class User {
    private int id;
    private String userName;
    private SexEnum sex;
    private String note;

    public User(UserVo userVo){
        this.id = userVo.getId();
        this.userName = userVo.getUserName();
        this.sex = SexEnum.getSexByMessage(userVo.getGender());
        this.note = userVo.getNote();
    }
}
