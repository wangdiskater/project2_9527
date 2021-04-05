package com.cskaoyan.vo.ad;

import java.util.Arrays;
import java.util.Date;

/**
 * @Classname CouponCreateVo
 * @Author LM
 * @Description
 * @Data 2019/10/2 19:36
 */
public class CouponCreateVo {
    String days;
    String desc;
    String discount;
    String endTime;
    int goodsType;
    String[] goodsValue;
    int limit;
    String min;
    String name;
    String startTime;
    int status;
    String tag;
    int timeType;
    String total;
    int type;

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public String[] getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(String[] goodsValue) {
        this.goodsValue = goodsValue;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CouponCreateVo{" +
                "days='" + days + '\'' +
                ", desc='" + desc + '\'' +
                ", discount='" + discount + '\'' +
                ", endTime=" + endTime +
                ", goodsType=" + goodsType +
                ", goodsValue=" + Arrays.toString(goodsValue) +
                ", limit=" + limit +
                ", min='" + min + '\'' +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", status=" + status +
                ", tag='" + tag + '\'' +
                ", timeType=" + timeType +
                ", total='" + total + '\'' +
                ", type=" + type +
                '}';
    }
}
