package com.cskaoyan.vo.cart;

import com.cskaoyan.bean.Address;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/7
 */

public class CartAddressVo {

    int id;
    String name;
    int userId;
    int provinceId;
    int cityId;
    int areaId;
    String address;
    String mobile;
    boolean isDefault;
    boolean deleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;

    public CartAddressVo() {
    }

    public CartAddressVo(Address addressinfo) {
        this.id = addressinfo.getId();
        this.userId = addressinfo.getUser_id();
        this.provinceId = addressinfo.getProvince_id();
        this.cityId = addressinfo.getCity_id();
        this.areaId = addressinfo.getArea_id();
       this.name = addressinfo.getName();
       this.mobile = addressinfo.getMobile();
       this.address = addressinfo.getAddress();
        this.deleted = addressinfo.getDeleted();
        this.isDefault = addressinfo.getIs_default();
      this.addTime = addressinfo.getAdd_time();
      this.updateTime = addressinfo.getUpdate_time();
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean getDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
}
