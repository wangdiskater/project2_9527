package com.cskaoyan.vo.wx.wxgoods;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author GF
 * @description 商品优惠封装
 * @date 2019/10/5
 */

public class WxGrouponVo {
    int id;
    int goodsId;
    String goodsName;
    String picUrl;
    int discount;
    int discountMember;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date expireTime;
    boolean deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscountMember() {
        return discountMember;
    }

    public void setDiscountMember(int discountMember) {
        this.discountMember = discountMember;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
