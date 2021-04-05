package com.cskaoyan.vo.wx.login;

/**
 * @version 1.0
 * @ClassName WechatUserInfo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 15:40
 **/

public class WechatUserInfo {
    String nickName;
    String avatarUrl;
    int gender;
    String province;
    String city;

    @Override
    public String toString() {
        return "WechatUserInfo{" +
                "nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
