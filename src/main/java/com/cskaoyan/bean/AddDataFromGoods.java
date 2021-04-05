package com.cskaoyan.bean;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/6
 */

public class AddDataFromGoods {
    String goods_sn;
    String name;
    double retail_price;
    String pic_url;

    public String getGoods_sn() {
        return goods_sn;
    }

    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
