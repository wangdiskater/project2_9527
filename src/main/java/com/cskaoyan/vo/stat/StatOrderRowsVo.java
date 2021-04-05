package com.cskaoyan.vo.stat;

/**
 * @Auther Piter_Liu
 * @Description 订单数据封装给前端
 * @Date 2019/10/1
 */

public class StatOrderRowsVo {

    double amount;
    int orders;
    int customers;
    String day;
    double pcr;

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

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getPcr() {
        return pcr;
    }

    public void setPcr(double pcr) {
        this.pcr = pcr;
    }
}
