package com.cskaoyan.vo.mall;

import com.cskaoyan.bean.Brand;

/**
 * @version 1.0
 * @ClassName BrandVo
 * @Description brandvo 传给前端
 * @Author wangdi
 * @Date 2019/9/30 19:49
 **/

public class BrandVo {
    private int id;
    private String name;
    private String desc;
    private String picUrl;
    private int sortOrder;
    private double floorPrice;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public BrandVo() {
    }

    /* *
     * 功能描述 sqlbean 转换成vo
     * @author wangdi
     * @date 2019/10/1 14:38
     * @param brand
     * @return
     */
    public BrandVo(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
        this.desc = brand.getDesc();
        this.picUrl = brand.getPic_url();
        this.floorPrice = brand.getFloor_price();
        this.addTime = brand.getAdd_time();
        this.updateTime = brand.getUpdate_time();
        if(brand.getDeleted() == 0){
            this.deleted = false;
        }else {
            this.deleted = true;
        }
    }


    @Override
    public String toString() {
        return "BrandVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", sortOrder=" + sortOrder +
                ", floorPrice=" + floorPrice +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
