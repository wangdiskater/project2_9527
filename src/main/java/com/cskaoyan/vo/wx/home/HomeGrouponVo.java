package com.cskaoyan.vo.wx.home;

/**
 * @version 1.0
 * @ClassName HomeGrouponVo
 * @Description 主页显示团购信息
 * @Author wangdi
 * @Date 2019/10/4 22:52
 **/

public class HomeGrouponVo {
    double groupon_price;
    GrouponGoodsVo goods;
    int groupon_member;

    public double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(double groupon_price) {
        this.groupon_price = groupon_price;
    }

    public GrouponGoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GrouponGoodsVo goods) {
        this.goods = goods;
    }

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }

    @Override
    public String toString() {
        return "HomeGrouponVo{" +
                "groupon_price=" + groupon_price +
                ", goods=" + goods +
                ", groupon_member=" + groupon_member +
                '}';
    }
}
