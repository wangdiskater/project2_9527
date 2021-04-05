package com.cskaoyan.vo.wx.topic;

/**
 * @Classname TopicVo
 * @Author LM
 * @Description
 * @Data 2019/10/4 21:41
 */
public class TopicListVo {
    int id;
    String title;
    String subtitle;
    double price;
    String readCount;
    String picUrl;

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

    @Override
    public String toString() {
        return "TopicVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", price=" + price +
                ", readCount='" + readCount + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
