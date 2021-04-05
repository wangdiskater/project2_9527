package com.cskaoyan.vo.cart;

import com.cskaoyan.bean.CartBean;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/5
 */

public class CartsBeanVo {
    int id;
    int userId;
    int goodsId;
    int productId;
    int number;
    double price;
    String goodsSn;
    String goodsName;
    String picUrl;
    String[] specifications;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;
    boolean checked;
    boolean deleted;

    public CartsBeanVo() {
    }
    public CartsBeanVo(CartBean cartBean) {
        this.id = cartBean.getId();
        this.userId = cartBean.getUser_id();
        this.goodsId = cartBean.getGoods_id();
        this.productId = cartBean.getProduct_id();
        this.number = cartBean.getNumber();
        this.price = cartBean.getPrice();
        this.goodsSn = cartBean.getGoods_sn();
        this.goodsName = cartBean.getGoods_name();
        this.picUrl = cartBean.getPic_url();
        this.specifications = cartBean.getSpecifications();
        this.addTime = cartBean.getAdd_time();
        this.updateTime = cartBean.getUpdate_time();
        this.checked = cartBean.getChecked();
        this.deleted = cartBean.getDeleted();
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getDeleted() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String[] specifications) {
        this.specifications = specifications;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
