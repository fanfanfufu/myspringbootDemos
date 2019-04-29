package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: Dict的Mapper层接口
 * @Author 傅琦
 * @Date 2019/4/27 22:57
 * @Version V1.0
 */
@Mapper
public interface DictMapper {
    /**
     * 增加字典
     * @param dict
     * @return
     */
    int addDict(@Param("dict") Dict dict);

    /**
     * 根据字典名和字典标题删除字典
     * @param dictTitle
     * @param dictName
     * @return
     */
    int deleteDict(@Param("dictTitle") String dictTitle,
                   @Param("dictName") String dictName);

    /**
     * 修改字典的信息
     * @param dict
     * @return
     */
    int modifyDict(@Param("dict") Dict dict);

    /**
     * 查询所有字典
     * @return
     */
    List<Dict> getAllDict();

    /**
     * 根据状态、字典名、字典标识删除字典
     * @param dictStatus
     * @param dictTitle
     * @param dictName
     * @return
     */
    List<Dict> getByCondition(@Param("dictStatus") byte dictStatus,
                             @Param("dictTitle") String dictTitle,
                             @Param("dictName") String dictName);
}
