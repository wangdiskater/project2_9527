package com.cskaoyan.vo.wx.groupon;



/**
 * @author GF
 * @description 团购的封装
 * @date 2019/10/6
 */

public class WxGroupOnVo {
    double groupon_price;
    int groupon_member;
    int goodsId;
    WxGroupGoodsVo goods;

    public double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(double groupon_price) {
        this.groupon_price = groupon_price;
    }

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }

    public WxGroupGoodsVo getGoods() {
        return goods;
    }

    public void setGoods(WxGroupGoodsVo goods) {
        this.goods = goods;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}
