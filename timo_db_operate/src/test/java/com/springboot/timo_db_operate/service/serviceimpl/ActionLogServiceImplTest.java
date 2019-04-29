package com.springboot.timo_db_operate.service.serviceimpl;

import com.github.pagehelper.PageInfo;
import com.springboot.timo_db_operate.dto.ResultDto;
import com.springboot.timo_db_operate.pojo.ActionLog;
import com.springboot.timo_db_operate.service.ActionLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description: ActionLogServiceImpl的测试类
 * @Author 傅琦
 * @Date 2019/4/29 22:12
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionLogServiceImplTest {
    @Autowired
    private ActionLogService actionLogService;

    @Test
    public void ActionLogServiceTest(){
        assert actionLogService != null;
    }

    @Test
    public void getAllLog() {
        ResultDto<PageInfo<ActionLog>> resultDto = actionLogService.getAllLog(1, 10);
        System.out.println(resultDto);
    }
}