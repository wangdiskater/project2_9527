package com.cskaoyan.vo.wx.order;

import java.util.List;

/**
 * @version 1.0
 * @ClassName WxOrderListVo
 * @Description 前端显示全部订单
 * @Author wangdi
 * @Date 2019/10/6 11:44
 **/

public class WxOrderListVo {
    String orderStatusText;
    boolean isGroupin;  //通过是否有groupon_price判断
    String orderSn;
    double actualPrice;
    List<WxOrderGoodsVo> goodsList;
    int id;  //订单id
    WxOrderHandleOption handleOption;

    @Override
    public String toString() {
        return "WxOrderListVo{" +
                "orderStatusText='" + orderStatusText + '\'' +
                ", isGroupin=" + isGroupin +
                ", orderSn='" + orderSn + '\'' +
                ", actualPrice=" + actualPrice +
                ", goodsList=" + goodsList +
                ", id=" + id +
                ", handleOption=" + handleOption +
                '}';
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
    }

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

    public List<WxOrderGoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<WxOrderGoodsVo> goodsList) {
        this.goodsList = goodsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WxOrderHandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(WxOrderHandleOption handleOption) {
        this.handleOption = handleOption;
    }
}
