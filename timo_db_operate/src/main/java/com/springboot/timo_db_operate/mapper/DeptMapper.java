package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: Dept的Mapper层接口
 * @Author 傅琦
 * @Date 2019/4/27 9:42
 * @Version V1.0
 */
@Mapper
public interface DeptMapper {

    /**
     * 增加一个部门
     * @param dept
     * @return int
     */
    int addDept(@Param("dept")Dept dept);

    /**
     * 根据部门名称删除一个部门
     * @param deptName
     * @return int
     */
    int deleteDept(@Param("deptName") String deptName);

    /**
     * 修改某个部门的信息
     * @param dept
     * @return int
     */
    int modifyDept(@Param("dept") Dept dept);

    /**
     * 根据部门名称获取部门Id
     * @param deptName
     * @return Integer
     */
    Long getDeptId(@Param("deptName") String deptName);

    /**
     * 获取所有部门信息
     * @return List<Dept>
     */
    List<Dept> getAllDept();
}
