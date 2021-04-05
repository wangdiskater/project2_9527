package com.cskaoyan.vo.wx.home;

/**
 * @version 1.0
 * @ClassName GrouponGoodsVo
 * @Description 团购商品显示
 * @Author wangdi
 * @Date 2019/10/4 22:53
 **/

public class GrouponGoodsVo {
    int id;
    String name;
    String brief;
    String picUrl;
    double counterPrice;
    double retailPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(double counterPrice) {
        this.counterPrice = counterPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
