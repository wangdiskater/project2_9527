package com.cskaoyan.vo.ad;

import java.util.Arrays;

/**
 * @Classname TopicVo
 * @Author LM
 * @Description
 * @Data 2019/10/2 22:47
 */
public class TopicVo {
    int id;
    String title;
    String subtitle;
    double price;
    String readCount;
    String picUrl;
    int sortOrder;
    String[] goods;
    String addTime;
    String updateTime;
    boolean deleted;

    @Override
    public String toString() {
        return "TopicVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", price=" + price +
                ", readCount='" + readCount + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", sortOrder=" + sortOrder +
                ", wxgoods=" + Arrays.toString(goods) +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                ", content='" + content + '\'' +
                '}';
    }

    String content;

    public TopicVo() {
    }

    public TopicVo(TopicCreateVo topicCreateVo) {
        this.content = topicCreateVo.getContent();
        this.goods = topicCreateVo.getGoods();
        this.picUrl = topicCreateVo.getPicUrl();
        this.price = Double.valueOf(topicCreateVo.getPrice());
        this.readCount = topicCreateVo.getReadCount();
        this.subtitle = topicCreateVo.getSubtitle();
        this.title = topicCreateVo.getTitle();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

    public String[] getGoods() {
        return goods;
    }

    public void setGoods(String[] goods) {
        this.goods = goods;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
