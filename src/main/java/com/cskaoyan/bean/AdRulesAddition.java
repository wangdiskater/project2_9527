package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description 添加团购规则，接受前端传来的数据
 * @Date 2019/10/2
 */

public class AdRulesAddition {

    double discount;
    int discountMember;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date expireTime;
    int goodsId;
    int deleted;
    int id; // 此id是执行insert语句后要封装的变量

    // 下方是mall_goods表中的部分字段属性
    String name;
    String pic_url;

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
