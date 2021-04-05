package com.cskaoyan.vo.wx.comment;

import com.cskaoyan.vo.wx.login.UserInfoVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @ClassName WxCommentVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 23:09
 **/

public class WxCommentVo {
    UserInfoVo userInfo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    String[] picList;
    String content;

    @Override
    public String toString() {
        return "WxCommentVo{" +
                "userInfo=" + userInfo +
                ", addTime=" + addTime +
                ", picList=" + Arrays.toString(picList) +
                ", content='" + content + '\'' +
                '}';
    }

    public UserInfoVo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoVo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String[] getPicList() {
        return picList;
    }

    public void setPicList(String[] picList) {
        this.picList = picList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
