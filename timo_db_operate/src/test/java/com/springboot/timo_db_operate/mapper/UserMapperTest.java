package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Dept;
import com.springboot.timo_db_operate.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @Date 2019/4/22 20:40
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapperTest(){
        assert userMapper != null;
    }

    @Test
    public void findAllUser() {
        try {
            List<User> userList = userMapper.findAllUser();
            for (User user: userList){
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findByCondition() {
        byte status = 1;
        String deptName = "研发部门";
        List<User> users = userMapper.findByCondition(status, deptName, null, null);
        System.out.println(users);
    }

    @Test
    public void addUser() {
        Dept dept = new Dept();
        dept.setDeptId(8L);
        dept.setDeptName("后勤部门");
        User user = new User();
        user.setUserId(20L);
        user.setUsername("李雷");
        user.setNickname("lilei");
        user.setPassword("lilei123");
        user.setSalt("新华中学");
        user.setDept(dept);
        user.setPicture(null);
        user.setSex("1");
        user.setEmail("21334@45.com");
        user.setPhone("132456");
        user.setRemark("三号学生");
        int result = userMapper.addUser(user);
        System.out.println(result);
    }

    @Test
    public void deleteUser() {
        int i = userMapper.deleteUser("sdss");
        assert i == 1;
    }

    @Test
    public void modifyMessage() {
        Dept dept = new Dept();
        dept.setDeptId(10L);
        User user = new User();
        user.setUserId(20L);
        user.setUsername("李雷");
        user.setNickname("lilei");
        user.setSalt("新华中学");
        user.setDept(dept);
        user.setSex("1");
        user.setEmail("21334@45.com");
        user.setPhone("132456789987");
        user.setRemark("三好学生");
        int i = userMapper.modifyMessage(user);
        System.out.println(i);
    }

    @Test
    public void modifyPassword() {
        User user = new User();
        user.setUserId(20L);
        user.setUsername("李雷");
        String newpassword = "LiLeiLoveHanMeimei";
        int result = userMapper.modifyPassword(user, newpassword);
        System.out.println(result);
    }
}