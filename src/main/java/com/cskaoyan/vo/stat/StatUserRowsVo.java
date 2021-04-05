package com.cskaoyan.vo.stat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description 用户数据封装给前端
 * @Date 2019/9/30
 */

public class StatUserRowsVo {
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date day;
    int users;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
