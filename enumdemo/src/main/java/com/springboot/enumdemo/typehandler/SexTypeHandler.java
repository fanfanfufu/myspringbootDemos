package com.springboot.enumdemo.typehandler;

import com.springboot.enumdemo.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: 枚举装类处理类
 * @Author 傅琦
 * @Date 2019/4/23 14:46
 * @Version V1.0
 */
// 声明JDBC的类型
@MappedJdbcTypes(JdbcType.INTEGER)
// 声明Java类型
@MappedTypes(SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    /**
     *@Description: 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     *@parameters: [resultSet, s]
     *@return: com.springboot.enumdemo.enumeration.SexEnum
     *@Author: 傅琦
     *@Date: 2019/4/23 14:59
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int sex = resultSet.getInt(columnName);
        if (sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getSexById(sex);
    }

    /**
     *@Description: 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     *@parameters: [resultSet, i]
     *@return: com.springboot.enumdemo.enumeration.SexEnum
     *@Author: 傅琦
     *@Date: 2019/4/23 15:06
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int sex = resultSet.getInt(columnIndex);
        if (sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getSexById(sex);
    }

    /**
     *@Description: 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     *@parameters: [callableStatement, i]
     *@return: com.springboot.enumdemo.enumeration.SexEnum
     *@Author: 傅琦
     *@Date: 2019/4/23 15:07
     */
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int sex = callableStatement.getInt(columnIndex);
        if (sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getSexById(sex);
    }

    /**
     *@Description: 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     *@parameters: [preparedStatement, i, sexEnum, jdbcType]
     *@return: void
     *@Author: 傅琦
     *@Date: 2019/4/23 15:09
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getId());
    }
}
