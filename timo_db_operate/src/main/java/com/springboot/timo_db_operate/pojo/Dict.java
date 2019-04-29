package com.springboot.timo_db_operate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Description: Dict实体类
 * @Author 傅琦
 * @Date 2019/4/24 21:27
 * @Version V1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Alias("dict")
public class Dict {
    private Long dictId;
    private String dictTitle;
    private String dictName;
    private byte dictType;
    private String dictValue;
    private String dictRemark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private User createBy;
    private User updateBy;
    private byte dictStatus;
}
