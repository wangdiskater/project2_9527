package com.cskaoyan.vo.wx.groupon;

/**
 * @author GF
 * @description
 * @date 2019/10/7
 */

public class WxOrderGoodsVo {
    int number;
    String picUrl;
    int orderId;
    int goodsId;
    String[] goodsSpecificationValues;
    int id;
    String goodsName;
    double retailPrice;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    public String[] getGoodsSpecificationValues() {
        return goodsSpecificationValues;
    }

    public void setGoodsSpecificationValues(String[] goodsSpecificationValues) {
        this.goodsSpecificationValues = goodsSpecificationValues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
