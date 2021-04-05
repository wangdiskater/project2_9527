package com.cskaoyan.vo.wx.groupon;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */

public class MyWxOrderVo {
    String orderSn;
    double actualPrice;
    int orderStatus;


    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
