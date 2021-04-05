package com.cskaoyan.vo.stat;

/**
 * @Auther Piter_Liu
 * @Description 商品数据封装给前端
 * @Date 2019/10/1
 */

public class StatGoodsRowsVo {

    double amount;
    int orders;
    String day;
    int products;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
}
