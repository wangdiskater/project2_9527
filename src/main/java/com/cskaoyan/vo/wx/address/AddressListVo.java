package com.cskaoyan.vo.wx.address;

import com.cskaoyan.vo.user.AddressVo;

/**
 * @Classname AddressListVo
 * @Author LM
 * @Description
 * @Data 2019/10/4 23:51
 */
public class AddressListVo {
    boolean isDefault;
    String detailedAddress;
    String name;
    String mobile;
    int id;

    public AddressListVo(AddressVo addressVo) {
        this.detailedAddress = addressVo.getProvince()+addressVo.getCity()+addressVo.getArea()+" "+addressVo.getAddress();
        this.id = addressVo.getId();
        this.mobile = addressVo.getMobile();
        this.isDefault = addressVo.getisDefault();
        this.name = addressVo.getName();
    }

    public boolean getisDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
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

    @Override
    public String toString() {
        return "AddressListVo{" +
                "isDefault=" + isDefault +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", id=" + id +
                '}';
    }
}
