package com.springboot.timo_db_operate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Description: SysFile实体类，对应sys_file表
 * @Author 傅琦
 * @Date 2019/4/24 21:30
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("sysFile")
public class SysFile {
    private Long id;
    private String name;
    private String path;
    private String mime;
    private Long size;
    private String md5;
    private String sha1;
    private User createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
