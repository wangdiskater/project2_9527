package com.cskaoyan.vo.mall;

/**
 * @version 1.0
 * @ClassName BrandCreateVo
 * @Description 接收前端创建品牌时传给后端的字段
 * @Author wangdi
 * @Date 2019/9/30 21:19
 **/

public class BrandCreateVo {
    private String name;
    private String desc;
    private double floorPrice;
    private String picUrl;

    @Override
    public String toString() {
        return "BrandCreateVo{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", floorPrice=" + floorPrice +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
