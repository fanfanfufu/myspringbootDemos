package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description: 测试deptMapper接口
 * @Author 傅琦
 * @Date 2019/4/27 16:22
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptMapperTest {
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void deptMapperTest(){
        assert deptMapper != null;
    }

    @Test
    public void addDept() {
        Dept dept = new Dept();
        dept.setDeptName("测试Mapper接口");
        dept.setPid(2L);
        dept.setPids("[0],[1],[2]");
        dept.setSort(1);
        dept.setRemark("测试插入接口");
        Date nowTime = new Date();
        dept.setCreateTime(nowTime);
        dept.setUpdateTime(nowTime);
        dept.setCreateBy(2L);
        dept.setUpdateBy(2L);
        byte x = 1;
        dept.setStatus(x);

        int result = deptMapper.addDept(dept);
        System.out.println(result);
    }

    @Test
    public void delete() {
        String deptName = "测试Mapper接口";
        int result = deptMapper.deleteDept(deptName);
        System.out.println(result);
    }

    @Test
    public void modifyDept() {
        Dept dept = new Dept();
        dept.setDeptId(19L);
        dept.setDeptName("测试Mapper接口");
        dept.setPid(3L);
        dept.setPids("[0],[1],[3]");
        dept.setSort(1);
        dept.setRemark("测试修改接口");
        Date nowTime = new Date();
        dept.setUpdateTime(nowTime);
        System.out.println("time: " + nowTime.toString());
        dept.setUpdateBy(1L);
        byte x = 1;
        dept.setStatus(x);

        int result = deptMapper.modifyDept(dept);
        System.out.println(result);
    }

    @Test
    public void getDeptId() {
        String deptName = "测试Mapper接口";
        Long deptId = deptMapper.getDeptId(deptName);
        System.out.println(deptId);
    }

    @Test
    public void getAllDept() {
        List<Dept> deptList = deptMapper.getAllDept();
        for (Dept dept: deptList){
            System.out.println(dept);
        }
    }
}