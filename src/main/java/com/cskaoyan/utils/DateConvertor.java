package com.cskaoyan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/9/30
 */

public class DateConvertor {

    public static String getCustomConvertDate(Date time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(time);
        return date;
    }
}
