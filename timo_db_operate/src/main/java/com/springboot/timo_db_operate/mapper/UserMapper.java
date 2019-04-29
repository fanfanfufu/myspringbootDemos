package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: User操作的mapper层接口
 * @Author 傅琦
 * @Date 2019/4/19 21:02
 * @Version V1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有用户的信息
     * @return List<User>
     */
    List<User> findAllUser();

    /**
     * 根据不同的查询条件进行单独或者混合查询
     * @param status byte 可以为空
     * @param title Long 可以为空
     * @param username String 可以为空
     * @param nickname String 可以为空
     * @return List<User>
     */
    List<User> findByCondition(@Param("status") byte status, @Param("title") String title,
                               @Param("username") String username, @Param("nickname") String nickname);

    int addUser(@Param("user") User user);

    /**
     * 根据用户名删除用户数据
     * @param username
     * @return
     */
    int deleteUser(@Param("username") String username);

    /**
     * 修改用户数据
     * @param user
     * @return
     */
    int modifyMessage(@Param("user") User user);

    int modifyPassword(@Param("user") User user, @Param("newPassword") String newPassword);
}
