package com.cskaoyan.vo.wx.brand;

import com.cskaoyan.bean.Brand;

/**
 * @Auther Piter_Liu
 * @Description 显示商品信息javabean
 * @Date 2019/10/4
 */

public class ShowBrandVo {
    String desc;
    double floorPrice;
    int id;
    String name;
    String picUrl;

    public ShowBrandVo() {
    }

    /**
     * @param brand 封装数据传给wx前端
     */
    public ShowBrandVo(Brand brand) {
        this.desc = brand.getDesc();
        this.floorPrice = brand.getFloor_price();
        this.id = brand.getId();
        this.name = brand.getName();
        this.picUrl = brand.getPic_url();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
