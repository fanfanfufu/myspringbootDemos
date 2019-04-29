package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.ActionLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 操作日志的mapper层接口
 * @Author 傅琦
 * @Date 2019/4/27 22:56
 * @Version V1.0
 */
@Mapper
public interface ActionLogMapper {
    /**
     * 增加日志
     * @param actionLog
     * @return
     */
    int addActionLog(@Param("actionLog") ActionLog actionLog);

    /**
     * 删除单条日志
     * @param logId
     * @return
     */
    int deleteOneLog(@Param("logId") Long logId);

    /**
     * 根据条件批量删除部分日志
     * @param logName
     * @param logType
     * @return
     */
    int deleteManyLog(@Param("logName") String logName,
                      @Param("logType") byte logType);

    /**
     * 清空表中所有日志
     * @return
     */
    int deleteAllLog();

    /**
     * 获取所有日志
     * @return
     */
    List<ActionLog> getAllLog();

    /**
     * 根据条件查询日志
     * @param logType
     * @param logName
     * @return
     */
    List<ActionLog> getByCondition(@Param("logType") byte logType,
                                   @Param("logName") String logName);
}
