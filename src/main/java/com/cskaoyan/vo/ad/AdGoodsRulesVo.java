package com.cskaoyan.vo.ad;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description 查询数据库mall_groupon_rules返回的数据
 * @Date 2019/10/2
 */

public class AdGoodsRulesVo {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    boolean deleted;
    double discount;
    int discountMember;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date expireTime;
    int goodsId;
    String goodsName;
    int id;
    String picUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDiscountMember() {
        return discountMember;
    }

    public void setDiscountMember(int discountMember) {
        this.discountMember = discountMember;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
