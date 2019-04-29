package com.springboot.timo_db_operate.mapper;

import com.springboot.timo_db_operate.pojo.ActionLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description: 日志的Mapper层接口测试类
 * @Author 傅琦
 * @Date 2019/4/29 21:11
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionLogMapperTest {
    @Autowired
    private ActionLogMapper actionLogMapper;

    @Test
    public void actionLogMapperTest(){
        assert actionLogMapper != null;
    }

    @Test
    public void addActionLog() {
        ActionLog actionLog = new ActionLog();
        actionLog.setLogName("测试1");
        byte logType = 3;
        actionLog.setLogType(logType);
        actionLog.setIpAddress("172.16.9.190");
        actionLog.setClazz("com.springboot.timodatabaseoperate");
        actionLog.setMethod("test1()");
        actionLog.setModel("model1");
        actionLog.setRecordId(250L);
        actionLog.setMessage("测试数据库接口插入日志");
        actionLog.setCreateTime(new Date());
        actionLog.setOperatorName("小邪");
        actionLog.setOperateBy(14L);

        int result = actionLogMapper.addActionLog(actionLog);
        System.out.println(result);
    }

    @Test
    public void deleteOneLog() {
        int result = actionLogMapper.deleteOneLog(1038L);
        System.out.println(result);
    }

    @Test
    public void getAllLog() {
        List<ActionLog> actionLogs = actionLogMapper.getAllLog();
        System.out.println(actionLogs.size());
    }

    @Test
    public void getByCondition() {
        byte logType = 0;
        String logName = "部门管理";
        List<ActionLog> actionLogs = actionLogMapper.getByCondition(logType, logName);
        System.out.println(actionLogs.size());
    }
}