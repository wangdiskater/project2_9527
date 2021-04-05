package com.cskaoyan.bean;

/**
 * @version 1.0
 * @ClassName OrderGoods
 * @Description 数据库order_goods
 * @Author wangdi
 * @Date 2019/10/1 19:11
 **/

public class OrderGoods {
    private int    id;
    private int    order_id;
    private int    goods_id;
    private String goods_name;
    private String goods_sn;
    private int    product_id;
    private int    number;
    private double price;
    private String specifications;
    private String pic_url;
    private int    comment;
    private String add_time;
    private String update_time;
    private int    deleted;

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_sn='" + goods_sn + '\'' +
                ", product_id=" + product_id +
                ", number=" + number +
                ", price=" + price +
                ", specifications='" + specifications + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", comment=" + comment +
                ", add_time='" + add_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public String getGoods_sn() {
        return goods_sn;
    }

    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
