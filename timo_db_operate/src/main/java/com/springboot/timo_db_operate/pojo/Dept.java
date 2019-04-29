package com.springboot.timo_db_operate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Description: Dept实体类
 * @Author 傅琦
 * @Date 2019/4/24 19:30
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("dept")
public class Dept {
    private Long deptId;
    private String deptName;
    private Long pid;
    private String pids;
    private Integer sort;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private Long createBy;
    private Long UpdateBy;
    private byte status;
}
