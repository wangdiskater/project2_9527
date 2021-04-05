package com.cskaoyan.vo.wx.order;

import com.cskaoyan.bean.Order;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @version 1.0
 * @ClassName WxOrderInfoVo
 * @Description 显示订单详情的订单信息
 * @Author wangdi
 * @Date 2019/10/6 16:29
 **/

public class WxOrderInfoVo {
    String consignee;
    String address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    String orderSn;
    double actualPrice;
    String mobile;
    String orderStatusText;
    double goodsPrice;
    double couponPrice;
    double integralPrice;
    int id;
    double freightPrice;
    WxOrderHandleOption handleOption;

    public WxOrderInfoVo() {
    }



    public WxOrderInfoVo(Order order) throws ParseException {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.consignee = order.getConsignee();
        this.address = order.getAddress();
        this.addTime = simpleFormatter.parse(order.getAdd_time());
        this.orderSn = order.getOrder_sn();
        this.actualPrice = order.getActual_price();
        this.mobile = order.getMobile();
        this.orderStatusText = getStatusTextByCode(order.getOrder_status());
        this.goodsPrice = order.getGoods_price();
        this.couponPrice = order.getCoupon_price();
        this.id = order.getId();
        this.freightPrice = order.getFreight_price();
        this.integralPrice = order.getIntegral_price();
    }

    private String getStatusTextByCode(int order_status) {
        String status = null;
        switch (order_status){
            case 101:{
                status = "未付款";
                break;
            }
            case 102:{
                status = "用户取消";
                break;
            }
            case 103:{
                status = "系统取消";
                break;
            }
            case 201:{
                status = "已付款";
                break;
            }
            case 202:{
                status = "申请退款";
                break;
            }
            case 203:{
                status = "已退款";
                break;
            }
            case 301:{
                status = "已发货";
                break;
            }
            case 401:{
                status = "用户收货";
                break;
            }
            case 402:{
                status = "系统收货";
                break;
            }
            default:{
                status = "";
            }
        }
        return status;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public WxOrderHandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(WxOrderHandleOption handleOption) {
        this.handleOption = handleOption;
    }


    public double getIntegralPrice() {
        return integralPrice;
    }

    public void setIntegralPrice(double integralPrice) {
        this.integralPrice = integralPrice;
    }
    @Override
    public String toString() {
        return "WxOrderInfoVo{" +
                "consignee='" + consignee + '\'' +
                ", address='" + address + '\'' +
                ", addTime=" + addTime +
                ", orderSn='" + orderSn + '\'' +
                ", actualPrice=" + actualPrice +
                ", mobile='" + mobile + '\'' +
                ", orderStatusText='" + orderStatusText + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", couponPrice=" + couponPrice +
                ", integralPrice=" + integralPrice +
                ", id=" + id +
                ", freightPrice=" + freightPrice +
                ", handleOption=" + handleOption +
                '}';
    }

}
