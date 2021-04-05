package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description 用户统计
 * @Date 2019/9/30
 */

public class StatUserRows {

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date date;
    int users;

    public Date getDay() {
        return date;
    }

    public void setDay(Date day) {
        this.date = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
