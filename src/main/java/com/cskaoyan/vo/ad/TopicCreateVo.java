package com.cskaoyan.vo.ad;

import java.util.Arrays;

/**
 * @Classname TopicCreateVo
 * @Author LM
 * @Description
 * @Data 2019/10/2 23:26
 */
public class TopicCreateVo {
    String content;
    String[] goods;
    String picUrl;
    String price;
    String readCount;
    String subtitle;
    String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getGoods() {
        return goods;
    }

    public void setGoods(String[] goods) {
        this.goods = goods;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
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

    @Override
    public String toString() {
        return "TopicCreateVo{" +
                "content='" + content + '\'' +
                ", wxgoods=" + Arrays.toString(goods) +
                ", picUrl='" + picUrl + '\'' +
                ", price='" + price + '\'' +
                ", readCount='" + readCount + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
