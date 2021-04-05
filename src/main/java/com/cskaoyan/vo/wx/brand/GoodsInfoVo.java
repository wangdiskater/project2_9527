package com.cskaoyan.vo.wx.brand;

import com.cskaoyan.bean.GoodsInfo;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/5
 */

public class GoodsInfoVo {
    String brief;
    double counterPrice;
    int id;
    boolean isHot;
    boolean isNew;
    String picUrl;
    double retailPrice;

    public GoodsInfoVo() {
    }
    public GoodsInfoVo(GoodsInfo goodsInfo) {
        this.brief = goodsInfo.getBrief();
        this.picUrl = goodsInfo.getPic_url();
        this.counterPrice = goodsInfo.getCounter_price();
        this.retailPrice = goodsInfo.getRetail_price();
        this.isNew = goodsInfo.getIs_new();
        this.isHot = goodsInfo.getIs_hot();
        this.id = goodsInfo.getId();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(double counterPrice) {
        this.counterPrice = counterPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean getNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
