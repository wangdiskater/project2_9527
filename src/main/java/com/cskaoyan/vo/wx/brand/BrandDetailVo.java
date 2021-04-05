package com.cskaoyan.vo.wx.brand;

import com.cskaoyan.bean.BrandInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description  显示品牌的详情信息
 * @Date 2019/10/4
 */

public class BrandDetailVo {
    private int id;
    private String name;
    private String desc;
    private String picUrl;
    private int sortOrder;
    private double floorPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private boolean deleted;

    public BrandDetailVo() {
    }
    public BrandDetailVo(BrandInfo brandInfo) {
        this.id = brandInfo.getId();
        this.name = brandInfo.getName();
        this.desc = brandInfo.getDesc();
        this.picUrl = brandInfo.getPic_url();
        this.floorPrice = brandInfo.getFloor_price();
        this.addTime = brandInfo.getAdd_time();
        this.updateTime = brandInfo.getUpdate_time();
        this.sortOrder = brandInfo.getSort_order();
        if(brandInfo.getDeleted() == 0){
            this.deleted = false;
        }else {
            this.deleted = true;
        }
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
