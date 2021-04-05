package com.cskaoyan.vo.order;

import com.cskaoyan.bean.OrderGoods;

/**
 * @version 1.0
 * @ClassName OrderGoodsVo
 * @Description 返回前端orderGoodsVo
 * @Author wangdi
 * @Date 2019/10/1 19:28
 **/

public class OrderGoodsVo {
    private int    id;
    private int    orderId;
    private int    goodsId;
    private String goodsName;
    private String goodsSn;
    private int    productId;
    private int    number;
    private double price;
    private String specifications;
    private String picUrl;
    private int    comment;
    private String addTime;
    private String updateTime;
    private int    deleted;

    public OrderGoodsVo() {
    }

    public OrderGoodsVo(OrderGoods orderGoods) {
        this.id = orderGoods.getId();
        this.orderId = orderGoods.getOrder_id();
        this.goodsId = orderGoods.getGoods_id();
        this.goodsName = orderGoods.getGoods_name();
        this.goodsSn = orderGoods.getGoods_sn();
        this.productId = orderGoods.getProduct_id();
        this.number = orderGoods.getNumber();
        this.price = orderGoods.getPrice();
        this.specifications = orderGoods.getSpecifications();
        this.picUrl = orderGoods.getPic_url();
        this.comment = orderGoods.getComment();
        this.addTime = orderGoods.getAdd_time();
        this.updateTime = orderGoods.getUpdate_time();
        this.deleted = orderGoods.getDeleted();
    }

    @Override
    public String toString() {
        return "OrderGoodsVo{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSn='" + goodsSn + '\'' +
                ", productId=" + productId +
                ", number=" + number +
                ", price=" + price +
                ", specifications='" + specifications + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", comment=" + comment +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
