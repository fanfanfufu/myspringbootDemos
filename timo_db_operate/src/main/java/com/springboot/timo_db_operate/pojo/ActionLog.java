package com.springboot.timo_db_operate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Description: ActionLog实体类
 * @Author 傅琦
 * @Date 2019/4/24 21:18
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("actionLog")
public class ActionLog {
    private Long logId;
    private String logName;
    private byte logType;
    private String ipAddress;
    private String clazz;
    private String method;
    private String model;
    private Long recordId;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private String operatorName;
    private Long operateBy;
}
