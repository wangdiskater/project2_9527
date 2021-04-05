package com.cskaoyan.vo.wx.groupon;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */

public class WxMyGoodsListVo {
    int id;
    int number;//商品数量
    String goodsName;
    String picUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
}
