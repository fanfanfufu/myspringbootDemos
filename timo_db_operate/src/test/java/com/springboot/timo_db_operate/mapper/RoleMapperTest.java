package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Role;
import com.springboot.timo_db_operate.pojo.SysFile;
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
 * @Description: 测试roleMapper接口
 * @Author 傅琦
 * @Date 2019/4/28 9:43
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void roleMapperTest(){
        assert roleMapper != null;
    }

    @Test
    public void addRole() {
        User user = new User();
        user.setUserId(20L);
        user.setUsername("李雷");
        Date nowTime = new Date();
        byte roleStatus = 1;
        Role role = new Role(null, "测试roleMapper接口", "test1", null,
                nowTime, nowTime, user, user, roleStatus);
        int result = roleMapper.addRole(role);
        System.out.println(result);
    }

    @Test
    public void deleteRole() {
        String roleName = "测试roleMapper接口";
        int result = roleMapper.deleteRole(roleName);
        System.out.println(result);
    }

    @Test
    public void modifyRole() {
        User user = new User();
        user.setUserId(12L);
        user.setUsername("fanfanfufu");
        Date nowTime = new Date();
        byte roleStatus = 2;
        Role role = new Role(5L, "测试roleMapper接口", "test1", null,
                null, nowTime, null, user, roleStatus);
        int result = roleMapper.modifyRole(role);
        System.out.println("result: " + result);
    }

    @Test
    public void getAllRoles() {
        List<Role> roles = roleMapper.getAllRoles();
        for (Role role: roles){
            System.out.println(roles);
        }
    }

    @Test
    public void getRoleByCondition() {
        byte roleStatus = 1;
        List<Role> roleList = roleMapper.getRoleByCondition(roleStatus, null, null);
        for (Role role: roleList){
            System.out.println(role);
        }
    }
}