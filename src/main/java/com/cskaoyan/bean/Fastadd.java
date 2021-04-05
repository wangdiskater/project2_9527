package com.cskaoyan.bean;

/**
 * @Auther Piter_Liu
 * @Description   快速购买商品 -- 接收前端传入的数据
 * @Date 2019/10/5
 */

public class Fastadd {
    int goodsId;
    int number;
    int productId;

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
