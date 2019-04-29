package com.springboot.timo_db_operate.service;

import com.github.pagehelper.PageInfo;
import com.springboot.timo_db_operate.dto.ResultDto;
import com.springboot.timo_db_operate.pojo.ActionLog;

/**
 * @Description: 日志相关操作的service层接口
 * @Author 傅琦
 * @Date 2019/4/29 21:56
 * @Version V1.0
 */
public interface ActionLogService {
    ResultDto<PageInfo<ActionLog>> getAllLog(int pageNumber, int pageSize);
}
