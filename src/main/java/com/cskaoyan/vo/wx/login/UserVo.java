package com.cskaoyan.vo.wx.login;

import java.util.Date;

/**
 * @version 1.0
 * @ClassName UserVo
 * @Description 返回给前端的用户的信息
 * @Author wangdi
 * @Date 2019/10/4 20:32
 **/

public class UserVo {
    UserInfoVo userInfo;
    Date tokenExpire;
    String token;
    String ipAddress;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userInfo=" + userInfo +
                ", tokenExpire=" + tokenExpire +
                ", token='" + token + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }

    public UserInfoVo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoVo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Date tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
