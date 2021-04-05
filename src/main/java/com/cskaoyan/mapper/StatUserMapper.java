package com.cskaoyan.mapper;

import com.cskaoyan.bean.StatUserRows;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *  统计报表 --- 用户统计接口
 */

public interface StatUserMapper {
    /**
     * @return 查询各个日期的用户增长数
     */
    List<StatUserRows> queryStatUser(@Param("time1") Date date1,
                                     @Param("time2") Date date2);

    /**
     * @return 查询所有注册日期
     */
    List<Date> queryRegistrationDate();

    Date queryChangeDate(@Param("date") Date date);

    Date addOneOnChangeDate(@Param("date")Date date);
}
