package com.cskaoyan.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther
 * @Description String <--> Integer[]
 * @Date 2019/10/2
 */
@MappedTypes(Integer[].class)
public class TransferIntegerArray implements TypeHandler<Integer[]> {

    ObjectMapper objectMapper = new ObjectMapper();
    /*插入数据 由javabean转换为数据库接收的类型*/

    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, Integer[] strings, JdbcType jdbcType) throws SQLException {
        try {
            String jsonArray = objectMapper.writeValueAsString(strings);
            preparedStatement.setString(index,jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    //由数据中查询出的结果转换成javabean中的类型
    @Override
    public Integer[] getResult(ResultSet resultSet, String parameterName) throws SQLException {
        String value = resultSet.getString(parameterName);
        return parseString2IntegerArray(value);
    }

    private Integer[] parseString2IntegerArray(String value) {

        Integer[] strings = new Integer[0];
        if (value == null){
            return strings;
        }
        try {
            strings = objectMapper.readValue(value, Integer[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    @Override
    public Integer[] getResult(ResultSet resultSet, int index) throws SQLException {
        String value = resultSet.getString(index);
        return parseString2IntegerArray(value);
    }

    @Override
    public Integer[] getResult(CallableStatement callableStatement, int index) throws SQLException {
        String value = callableStatement.getString(index);
        return parseString2IntegerArray(value);
    }
}
