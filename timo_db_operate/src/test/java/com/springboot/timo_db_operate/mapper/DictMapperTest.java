package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Dict;
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
 * @Description: 测试DictMapper接口
 * @Author 傅琦
 * @Date 2019/4/29 15:45
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictMapperTest {
    @Autowired
    private DictMapper dictMapper;

    @Test
    public void dictMapperTest(){
        assert dictMapper != null;
    }

    @Test
    public void addDict() {
        User user = new User(20L, "李雷");
        byte dictType = 2;
        byte dictStatus = 1;
        Date nowTime = new Date();
        Dict dict = new Dict();
        dict.setDictTitle("测试类型");
        dict.setDictName("TEST_TYPE2");
        dict.setDictType(dictType);
        dict.setDictValue("对以测试");
        dict.setDictRemark("测试字典插入");
        dict.setCreateTime(nowTime);
        dict.setUpdateTime(nowTime);
        dict.setCreateBy(user);
        dict.setUpdateBy(user);
        dict.setDictStatus(dictStatus);

        int result = dictMapper.addDict(dict);
        System.out.println(result);
    }

    @Test
    public void deleteDict() {
        String dictTitle = "测试类型";
        String dictName = "TEST_TYPE2";
        int result = dictMapper.deleteDict(dictTitle, dictName);
        System.out.println(result);
    }

    @Test
    public void modifyDict() {
        User user = new User(12L, "fanfanfufu");
        Date nowTime = new Date();
        Dict dict = new Dict();
        dict.setDictId(10L);
        dict.setDictName("TEST_TYPE2");
        dict.setDictValue("随意测试");
        dict.setUpdateTime(nowTime);
        dict.setUpdateBy(user);

        int result = dictMapper.modifyDict(dict);
        System.out.println(result);
    }

    @Test
    public void getAllDict() {
        List<Dict> dicts = dictMapper.getAllDict();
        for (Dict dict: dicts){
            System.out.println(dict);
        }
    }

    @Test
    public void getByCondition() {
        byte dictStatus = 1;
        String dictTitle = "类型";
        String dictName = "STATUS";
        List<Dict> dictList = dictMapper.getByCondition(dictStatus, null, dictName);
        for (Dict dict: dictList){
            System.out.println(dict);
        }
    }
}