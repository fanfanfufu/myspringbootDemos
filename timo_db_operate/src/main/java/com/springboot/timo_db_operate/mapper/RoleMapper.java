package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: Role的Mapper层接口
 * @Author 傅琦
 * @Date 2019/4/27 22:02
 * @Version V1.0
 */
@Mapper
public interface RoleMapper {
    /**
     * 增加角色
     * @param role
     * @return int
     */
    int addRole(@Param("role")Role role);

    /**
     * 根据角色名删除角色
     * @param roleName
     * @return
     */
    int deleteRole(@Param("roleName") String roleName);

    /**
     * 修改单个角色的信息
     * @param role
     * @return
     */
    int modifyRole(@Param("role") Role role);

    /**
     * 获取所有的角色
     * @return
     */
    List<Role> getAllRoles();

    /**
     * 根据不同的条件查询角色
     * @param roleStatus
     * @param name
     * @param roleName
     * @return
     */
    List<Role> getRoleByCondition(@Param("roleStatus") byte roleStatus, @Param("name") String name,
                                  @Param("roleName") String roleName);
}
