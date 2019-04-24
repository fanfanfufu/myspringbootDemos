package com.springboot.enumdemo.mapper;

import com.springboot.enumdemo.enumeration.SexEnum;
import com.springboot.enumdemo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description: Mapper的单元测试
 * @Author 傅琦
 * @Date 2019/4/23 17:05
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void userMapperTest(){
        assert userMapper != null;
    }

    @Test
    public void findUserByName() {
        String userName = "李雷";
        User user = userMapper.findUserByName(userName);
        System.out.println(user.getSex().getMessage());
    }

    @Test
    public void addUser() {
        User user = new User(6, "张全蛋", SexEnum.MALE, "富土康2号流水线检修工");
        System.out.println(userMapper.addUser(user));
    }

    @Test
    public void modifyUser() {
        User user = new User(1, null, null, "中学英语作文最常用的姓名之一");
        System.out.println(userMapper.modifyUser(user));
    }
}