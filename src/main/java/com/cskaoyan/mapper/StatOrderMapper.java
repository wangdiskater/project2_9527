package com.cskaoyan.mapper;

import com.cskaoyan.bean.OrderInfoForData;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StatOrderMapper {

    /**
     * @return 查询所有下单日期
     */
    List<Date> queryOrderDate();

    /**
     * @param date 日期格式转换-->'年月日'
     * @return
     */
    Date queryChangeDate(@Param("date") Date date);

    /**
     * @param date 传入的日期+1
     * @return
     */
    Date addOneOnChangeDate(@Param("date")Date date);

    /**
     * @param date1 开始日期
     * @param date2 截止日期
     * @return
     */
    List<OrderInfoForData> queryOrder(@Param("time1") Date date1,
                                @Param("time2") Date date2);
}
