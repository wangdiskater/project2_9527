package com.cskaoyan.vo.wx.address;

/**
 * @Classname AddressDetailVo
 * @Author LM
 * @Description
 * @Data 2019/10/5 15:56
 */
public class AddressDetailVo {
    boolean isDefault;
    int areaId;
    String address;
    String cityName;
    String areaName;
    String name;
    String mobile;
    int id;
    int cityId;
    String provinceName;
    int provinceId;

    public boolean getisDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "AddressDetailVo{" +
                "isDefault=" + isDefault +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", id=" + id +
                ", cityId=" + cityId +
                ", provinceName='" + provinceName + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}
