package com.cskaoyan.vo.wx.foot;

import java.util.Arrays;

/**
 * @Classname FeedBack
 * @Author LM
 * @Description
 * @Data 2019/10/5 22:03
 */
public class FeedBackVo {
    String content;
    String feedType;
    boolean hasPicture;
    String mobile;
    String[] picUrls;
    String addTime;
    String updateTime;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
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
        return "FeedBackVo{" +
                "content='" + content + '\'' +
                ", feedType='" + feedType + '\'' +
                ", hasPicture=" + hasPicture +
                ", mobile='" + mobile + '\'' +
                ", picUrls=" + Arrays.toString(picUrls) +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
