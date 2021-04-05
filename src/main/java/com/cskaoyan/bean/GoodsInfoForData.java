package com.cskaoyan.bean;

/**
 * @Auther Piter_Liu
 * @Description 数据库返回的javabean
 * @Date 2019/10/1
 */

public class GoodsInfoForData {
    int id;
    int order_id;
    String goods_name;
    int number;
    double price;

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
