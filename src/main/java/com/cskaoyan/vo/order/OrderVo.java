package com.cskaoyan.vo.order;

import com.cskaoyan.bean.Order;

/**
 * @version 1.0
 * @ClassName OrderVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 17:26
 **/

public class OrderVo {
    int     id;
    int     userId;
    String  orderSn;
    int     orderStatus;
    String  consignee;
    String  mobile;
    String  address;
    String  message;
    double  goodsPrice;
    double  freightPrice;
    double  couponPrice;
    double  integralPrice;
    double  grouponPrice;
    double  orderPrice;
    double  actualPrice;
    int     comments;
    String  endTime;
    String  addTime;
    String  updateTime;
    boolean deleted;
//    String pay_id;
//    String pay_time;
//    String ship_sn;
//    String ship_channel;
//    String ship_time;
//    String confirm_time;
    public OrderVo() {
    }

    public OrderVo(Order order) {
        this.id =  order.getId();
        this.userId = order.getUser_id();
        this.orderSn = order.getOrder_sn();
        this.orderStatus = order.getOrder_status();
        this.consignee = order.getConsignee();
        this.mobile = order.getMobile();
        this.address = order.getAddress();
        this.message = order.getMessage();
        this.goodsPrice = order.getGoods_price();
        this.freightPrice = order.getFreight_price();
        this.couponPrice = order.getCoupon_price();
        this.integralPrice = order.getIntegral_price();
        this.grouponPrice = order.getGroupon_price();
        this.orderPrice = order.getOrder_price();
        this.actualPrice = order.getActual_price();
        this.comments = order.getComments();
        this.endTime = order.getEnd_time();
        this.addTime = order.getAdd_time();
        this.updateTime = order.getUpdate_time();
        if(order.getDeleted() == 0){
            this.deleted = false;
        } else {
            this.deleted = true;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public double getIntegralPrice() {
        return integralPrice;
    }

    public void setIntegralPrice(double integralPrice) {
        this.integralPrice = integralPrice;
    }

    public double getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(double grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderSn='" + orderSn + '\'' +
                ", orderStatus=" + orderStatus +
                ", consignee='" + consignee + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", message='" + message + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", freightPrice=" + freightPrice +
                ", couponPrice=" + couponPrice +
                ", integralPrice=" + integralPrice +
                ", grouponPrice=" + grouponPrice +
                ", orderPrice=" + orderPrice +
                ", actualPrice=" + actualPrice +
                ", comments='" + comments + '\'' +
                ", endTime='" + endTime + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
