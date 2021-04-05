package com.cskaoyan.bean;

import com.cskaoyan.vo.ad.TopicCreateVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Classname Topic
 * @Author LM
 * @Description
 * @Data 2019/10/2 22:27
 */
public class Topic {
    int id;
    String title;
    String subtitle;
    String content;
    double price;
    String read_count;
    String pic_url;
    int sort_order;
    String goods;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date add_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date update_time;
    boolean deleted;



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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRead_count() {
        return read_count;
    }

    public void setRead_count(String read_count) {
        this.read_count = read_count;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", read_count='" + read_count + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", sort_order=" + sort_order +
                ", wxgoods='" + goods + '\'' +
                ", add_time=" + add_time +
                ", update_time=" + update_time +
                ", deleted=" + deleted +
                '}';
    }
}
