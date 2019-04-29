package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 菜单管理的Mapper层接口
 * @Author 傅琦
 * @Date 2019/4/27 22:57
 * @Version V1.0
 */
@Mapper
public interface MenuMapper {
    int addMenu(@Param("menu") Menu menu);

    int deleteMenu(@Param("menuName") String menuName);

    int modifyMenu(@Param("menu") Menu menu);

    List<Menu> getAllMenu();

    List<Menu> getMenuByCondition(@Param("menuStatus") byte menuStatus,
                                   @Param("menuName") String menuName,
                                   @Param("url") String url);
}
