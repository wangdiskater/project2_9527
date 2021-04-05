package com.cskaoyan.vo.wx.foot;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.vo.goods.GoodsVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Classname FootPrintVo
 * @Author LM
 * @Description
 * @Data 2019/10/6 13:30
 */
public class FootprintVo {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    int goodsId;
    int id;
    String name;
    String brief;
    String picUrl;
    double retailPrice;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

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

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
