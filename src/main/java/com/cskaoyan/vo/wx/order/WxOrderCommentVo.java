package com.cskaoyan.vo.wx.order;

import java.util.Arrays;

/**
 * @version 1.0
 * @ClassName WxOrderCommentVo
 * @Description 接收前端传过来评论的数据
 * @Author wangdi
 * @Date 2019/10/6 22:46
 **/

public class WxOrderCommentVo {
    int orderGoodsId;
    int orderId;
    int goodsId;
    String content;
    int star;
    boolean hasPicture;
    String[] picUrls;

    public int getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(int orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public boolean getHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    @Override
    public String toString() {
        return "WxOrderCommentVo{" +
                "orderGoodsId=" + orderGoodsId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", content='" + content + '\'' +
                ", star=" + star +
                ", hasPicture=" + hasPicture +
                ", picUrls=" + Arrays.toString(picUrls) +
                '}';
    }
}
