package com.cskaoyan.bean;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/5
 */

public class GoodsInfo {
    String brief;
    double counter_price;
    int id;
    boolean is_hot;
    boolean is_new;
    String pic_url;
    double retail_price;
    int category_id;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getCounter_price() {
        return counter_price;
    }

    public void setCounter_price(double counter_price) {
        this.counter_price = counter_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(boolean is_hot) {
        this.is_hot = is_hot;
    }

    public boolean getIs_new() {
        return is_new;
    }

    public void setIs_new(boolean is_new) {
        this.is_new = is_new;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }
}
