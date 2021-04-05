package com.cskaoyan.bean;

/**
 * @Auther Piter_Liu
 * @Description 数据库返回的javabean
 * @Date 2019/9/30
 */

public class OrderInfoForData {
    int id;
    int user_id;
    String mobile;
    String address;
    double actual_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getActual_price() {
        return actual_price;
    }

    public void setActual_price(double actual_price) {
        this.actual_price = actual_price;
    }
}
