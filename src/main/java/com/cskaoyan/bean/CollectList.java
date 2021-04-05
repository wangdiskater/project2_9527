package com.cskaoyan.bean;

/**
 * @author So9rry
 * @description
 * @date 2019/10/4
 */
public class CollectList {

    private String brief;

    private String picUrl;

    private int valueId;

    private String name;

    private int id;

    private int type;

    private double retailPrice;

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "CollectList{" +
                "brief='" + brief + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", valueId=" + valueId +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", type=" + type +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
