package com.springboot.enumdemo.mapper;

import com.springboot.enumdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: mybatis操作接口
 * @Author 傅琦
 * @Date 2019/4/23 15:21
 * @Version V1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 根据id查询user
     * @param userName
     * @return User
     */
    User findUserByName(String userName);

    /**
     * 增加User，成功返回1，失败返回0
     * @param user
     * @return int
     */
    int addUser(@Param("tuser") User user);

    /**
     * 修改User信息，成功返回1，失败返回0
     * @param user
     * @return int
     */
    int modifyUser(@Param("tuser") User user);
}
