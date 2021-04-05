package com.cskaoyan.vo.wx.foot;

/**
 * @Classname FootprintGoodsVo
 * @Author LM
 * @Description
 * @Data 2019/10/6 22:15
 */
public class FootprintGoodsVo {
    String name;
    String picUrl;
    String brief;
    double retailPrice;

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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
