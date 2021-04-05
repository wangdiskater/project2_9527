package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description 查询数据库mall_groupon_rules返回的数据
 * @Date 2019/10/2
 */

public class AdGoodsRules {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date add_time;
    int deleted;
    double discount;
    int discount_member;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date expire_time;
    int goods_id;
    String goods_name;
    int id;
    String pic_url;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date update_time;

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDiscount_member() {
        return discount_member;
    }

    public void setDiscount_member(int discount_member) {
        this.discount_member = discount_member;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
