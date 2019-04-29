package com.springboot.timo_db_operate.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.timo_db_operate.dto.ResultDto;
import com.springboot.timo_db_operate.mapper.ActionLogMapper;
import com.springboot.timo_db_operate.pojo.ActionLog;
import com.springboot.timo_db_operate.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: ActionLogService接口的实现类
 * @Author 傅琦
 * @Date 2019/4/29 22:00
 * @Version V1.0
 */
@Service
public class ActionLogServiceImpl implements ActionLogService {
    @Autowired
    private ActionLogMapper actionLogMapper;

    @Override
    public ResultDto<PageInfo<ActionLog>> getAllLog(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        try {
            List<ActionLog> actionLogList = actionLogMapper.getAllLog();
            if (actionLogList == null){
                return new ResultDto<PageInfo<ActionLog>>("fail", null);
            }else {
                PageInfo<ActionLog> actionLogPageInfo = new PageInfo<>(actionLogList);
                return new ResultDto<PageInfo<ActionLog>>("success", actionLogPageInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
