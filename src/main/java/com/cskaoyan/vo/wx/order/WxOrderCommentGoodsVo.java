package com.cskaoyan.vo.wx.order;

import java.util.Arrays;

/**
 * @version 1.0
 * @ClassName WxOrderCommentGoodsVo
 * @Description 订单评价商品vo
 * @Author wangdi
 * @Date 2019/10/6 22:17
 **/

public class WxOrderCommentGoodsVo {
    int id;
    String picUrl;
    String goodsName;
    int number;
    String[] goodsSpecificationValues;

    @Override
    public String toString() {
        return "WxOrderCommentGoodsVo{" +
                "id=" + id +
                ", picUrl='" + picUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", number=" + number +
                ", goodsSpecificationValues=" + Arrays.toString(goodsSpecificationValues) +
                '}';
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String[] getGoodsSpecificationValues() {
        return goodsSpecificationValues;
    }

    public void setGoodsSpecificationValues(String[] goodsSpecificationValues) {
        this.goodsSpecificationValues = goodsSpecificationValues;
    }
}
