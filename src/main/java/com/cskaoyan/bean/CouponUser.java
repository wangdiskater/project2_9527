package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Classname CouponUser
 * @Author LM
 * @Description
 * @Data 2019/10/3 13:18
 */
public class CouponUser {
    int id;
    int user_id;
    int coupon_id;
    int status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date used_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date end_time;
    int order_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUsed_time() {
        return used_time;
    }

    public void setUsed_time(Date used_time) {
        this.used_time = used_time;
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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
        return "CouponUser{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", coupon_id=" + coupon_id +
                ", status=" + status +
                ", used_time=" + used_time +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", order_id=" + order_id +
                ", add_time=" + add_time +
                ", update_time=" + update_time +
                ", deleted=" + deleted +
                '}';
    }
}
