package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Menu;
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
 * @Description: menuMapper的测试类
 * @Author 傅琦
 * @Date 2019/4/29 8:54
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuMapperTest {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void menuMapperTest(){
        assert menuMapper != null;
    }

    @Test
    public void addMenu() {
        User user = new User(20L, "李雷");
        Date nowTime = new Date();
        byte menuStatus = 1;
        byte type = 2;
        Menu menu = new Menu();
        menu.setMenuName("测试4");
        menu.setPid(147L);
        menu.setPids("[0], [147]");
        menu.setUrl("/test/no4");
        menu.setPerms("#");
        menu.setType(type);
        menu.setSort(2);
        menu.setCreateTime(nowTime);
        menu.setUpdateTime(nowTime);
        menu.setCreateBy(user);
        menu.setUpdateBy(user);
        menu.setMenuStatus(menuStatus);

        int result = menuMapper.addMenu(menu);
        System.out.println(result);
    }

    @Test
    public void deleteMenu() {
        String menuName = "测试3";
        int result = menuMapper.deleteMenu(menuName);
        System.out.println(result);
    }

    @Test
    public void modifyMenu() {
        User user = new User(20L, "李雷");
        Date nowTime = new Date();
        byte menuStatus = 1;
        byte type = 2;
        Menu menu = new Menu();
        menu.setMenuId(151L);
        menu.setMenuName("测试3");
        menu.setPid(147L);
        menu.setPids("[0], [147]");
        menu.setUrl("/test/no3");
        menu.setPerms("#");
        menu.setType(type);
        menu.setSort(3);
        menu.setUpdateTime(nowTime);
        menu.setUpdateBy(user);
        menu.setMenuStatus(menuStatus);

        int result = menuMapper.modifyMenu(menu);
        System.out.println(result);
    }

    @Test
    public void getAllMenu() {
        List<Menu> menuList = menuMapper.getAllMenu();
        for (Menu menu: menuList){
            System.out.println(menu);
        }
    }

    @Test
    public void getMenuByCondition() {
        byte menuStatus = 1;
        String menuName = "管理";
        String url = "/system";
        List<Menu> menuList = menuMapper.getMenuByCondition(menuStatus, null, url);
//        System.out.println(menuList.size());
        for (Menu menu: menuList){
            System.out.println(menu);
        }
    }
}