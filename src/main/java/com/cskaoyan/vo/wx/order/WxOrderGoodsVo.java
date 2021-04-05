package com.cskaoyan.vo.wx.order;

/**
 * @version 1.0
 * @ClassName WxOrderGoodsVo
 * @Description 订单商品显示
 * @Author wangdi
 * @Date 2019/10/6 11:52
 **/

public class WxOrderGoodsVo {
    int number;
    String picUrl;
    int id;
    String goodsName;
    int goodsId;

    @Override
    public String toString() {
        return "WxOrderGoodsVo{" +
                "number=" + number +
                ", picUrl='" + picUrl + '\'' +
                ", id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsId=" + goodsId +
                '}';
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

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
}
