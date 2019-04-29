package com.springboot.timo_db_operate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Description: User实体类
 * @Author 傅琦
 * @Date 2019/4/19 20:23
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("user")
public class User {
    private Long userId;
    private String username;
    private String nickname;
    private String password;
    private String salt;
    private Dept dept;
    private String picture;
    private String sex;
    private String email;
    private String phone;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private byte status;

    public User(Long userId, String username){
        this.userId = userId;
        this.username = username;
    }
}
