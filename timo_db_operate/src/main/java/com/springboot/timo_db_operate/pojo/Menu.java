package com.springboot.timo_db_operate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Description: Menu实体类，对应sys_menu表
 * @Author 傅琦
 * @Date 2019/4/24 21:33
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("menu")
public class Menu {
    private Long menuId;
    private String menuName;
    private Long pid;
    private String pids;
    private String url;
    private String perms;
    private String icon;
    private byte type;
    private Integer sort;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private User createBy;
    private User updateBy;
    private byte menuStatus;
}
