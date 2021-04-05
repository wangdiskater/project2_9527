package com.cskaoyan.bean;

import com.cskaoyan.vo.ad.CouponVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Classname Coupon
 * @Author LM
 * @Description
 * @Data 2019/9/30
 */
public class Coupon {
    int id;
    String name;
    String desc;//优惠券介绍
    String tag;//优惠券标签，例如新人专用
    int total;
    double discount;
    double min;
    int limit;
    int type;
    int status;
    int goods_type;
    String goods_value;
    String code;
    int time_type;
    int days;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date end_time;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(int goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_value() {
        return goods_value;
    }

    public void setGoods_value(String goods_value) {
        this.goods_value = goods_value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTime_type() {
        return time_type;
    }

    public void setTime_type(int time_type) {
        this.time_type = time_type;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", tag='" + tag + '\'' +
                ", total=" + total +
                ", discount=" + discount +
                ", min=" + min +
                ", limit=" + limit +
                ", type=" + type +
                ", status=" + status +
                ", goods_type=" + goods_type +
                ", goods_value='" + goods_value + '\'' +
                ", code='" + code + '\'' +
                ", time_type=" + time_type +
                ", days=" + days +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", add_time=" + add_time +
                ", update_time=" + update_time +
                ", deleted=" + deleted +
                '}';
    }
}
