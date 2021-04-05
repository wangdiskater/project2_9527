package com.cskaoyan.vo.ad;

import java.util.Arrays;

/**
 * @Classname TopicUpdateVo
 * @Author LM
 * @Description
 * @Data 2019/10/3 17:18
 */
public class TopicUpdateVo {
    String addTime;
    String content;
    boolean deleted;
    int id;
    String picUrl;
    double price;
    String readCount;
    int sortOrder;
    String subtitle;
    String title;
    String updateTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picurl) {
        this.picUrl = picUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TopicUpdateVo{" +
                "addTime='" + addTime + '\'' +
                ", content='" + content + '\'' +
                ", deleted=" + deleted +
                ", id=" + id +
                ", picUrl='" + picUrl + '\'' +
                ", price=" + price +
                ", readCount='" + readCount + '\'' +
                ", sortOrder=" + sortOrder +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
