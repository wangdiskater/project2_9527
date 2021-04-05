package com.cskaoyan.vo.wx.address;

/**
 * @Classname AddSaveVo
 * @Author LM
 * @Description
 * @Data 2019/10/5 16:16
 */
public class AddressSaveVo{
    String address;
    int areaId;
    int cityId;
    int id;
    boolean isDefault;
    String mobile;
    String name;
    int provinceId;
    String addTime;
    String updateTime;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsDefault(){
        return isDefault;
    }

    public void setIsDefault(boolean isDefault){
        this.isDefault = isDefault;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
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

    @Override
    public String toString() {
        return "AddressSaveVo{" +
                "address='" + address + '\'' +
                ", areaId=" + areaId +
                ", cityId=" + cityId +
                ", id=" + id +
                ", isDefault=" + isDefault +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
