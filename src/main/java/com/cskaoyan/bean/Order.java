package com.cskaoyan.bean;

/**
 * @version 1.0
 * @ClassName Order
 * @Description 数据库取出的bean
 * @Author wangdi
 * @Date 2019/10/1 16:59
 **/

public class Order {
    int    id;
    int    user_id;
    String order_sn;
    int    order_status;
    String consignee;
    String mobile;
    String address;
    String message;
    double goods_price;
    double freight_price;
    double coupon_price;
    double integral_price;
    double groupon_price;
    double order_price;
    double actual_price;
    String pay_id;
    String pay_time;
    String ship_sn;
    String ship_channel;
    String ship_time;
    String confirm_time;
    int    comments;
    String end_time;
    String add_time;
    String update_time;
    int    deleted;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", order_sn='" + order_sn + '\'' +
                ", order_status=" + order_status +
                ", consignee='" + consignee + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", message='" + message + '\'' +
                ", goods_price=" + goods_price +
                ", freight_price=" + freight_price +
                ", coupon_price=" + coupon_price +
                ", integral_price=" + integral_price +
                ", groupon_price=" + groupon_price +
                ", order_price=" + order_price +
                ", actual_price=" + actual_price +
                ", pay_id='" + pay_id + '\'' +
                ", pay_time='" + pay_time + '\'' +
                ", ship_sn='" + ship_sn + '\'' +
                ", ship_channel='" + ship_channel + '\'' +
                ", ship_time='" + ship_time + '\'' +
                ", confirm_time='" + confirm_time + '\'' +
                ", comments='" + comments + '\'' +
                ", end_time='" + end_time + '\'' +
                ", add_time='" + add_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", deleted=" + deleted +
                '}';
    }

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

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
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

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public double getFreight_price() {
        return freight_price;
    }

    public void setFreight_price(double freight_price) {
        this.freight_price = freight_price;
    }

    public double getCoupon_price() {
        return coupon_price;
    }

    public void setCoupon_price(double coupon_price) {
        this.coupon_price = coupon_price;
    }

    public double getIntegral_price() {
        return integral_price;
    }

    public void setIntegral_price(double integral_price) {
        this.integral_price = integral_price;
    }

    public double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(double groupon_price) {
        this.groupon_price = groupon_price;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public double getActual_price() {
        return actual_price;
    }

    public void setActual_price(double actual_price) {
        this.actual_price = actual_price;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getShip_sn() {
        return ship_sn;
    }

    public void setShip_sn(String ship_sn) {
        this.ship_sn = ship_sn;
    }

    public String getShip_channel() {
        return ship_channel;
    }

    public void setShip_channel(String ship_channel) {
        this.ship_channel = ship_channel;
    }

    public String getShip_time() {
        return ship_time;
    }

    public void setShip_time(String ship_time) {
        this.ship_time = ship_time;
    }

    public String getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(String confirm_time) {
        this.confirm_time = confirm_time;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
