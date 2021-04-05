package com.cskaoyan.vo.ad;

import com.cskaoyan.bean.Coupon;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Classname CouponVo
 * @Author LM
 * @Description
 * @Data 2019/9/30
 */
public class CouponVo {
    int id;
    String name;
    String desc;//优惠券介绍
    String tag;//优惠券标签，例如新人专用
    int total;
    double discount;
    double min;
    int limit;
    int type;//优惠券类型
    int status;
    String code;
    int goodsType;
    String[] goodsValue;
    int timeType;
    int days;
    String startTime;
    String endTime;
    String addTime;
    String updateTime;
    boolean deleted;
    int daysTime;

    public CouponVo() {
    }

    public CouponVo(CouponCreateVo couponCreateVo) {
      this.days= Integer.parseInt(couponCreateVo.getDays());
      this.desc = couponCreateVo.getDesc();
      this.discount = Double.parseDouble(couponCreateVo.getDiscount());
      this.endTime = couponCreateVo.getEndTime();
      this.goodsType = couponCreateVo.getGoodsType();
      this.goodsValue = couponCreateVo.getGoodsValue();
      this.limit = couponCreateVo.getLimit();
      this.min = Double.parseDouble(couponCreateVo.getMin());
      this.name = couponCreateVo.getName();
      this.startTime = couponCreateVo.getStartTime();
      this.status = couponCreateVo.getStatus();
      this.tag = couponCreateVo.getTag();
      this.timeType = couponCreateVo.getTimeType();
      this.total = Integer.parseInt(couponCreateVo.getTotal());
      this.type = couponCreateVo.getType();
    }

    public CouponVo(Coupon coupon) {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getAddTime(String date) {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime(String date) {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getDaysTime() {
        return daysTime;
    }

    public void setDaysTime(int daysTime) {
        this.daysTime = daysTime;
    }

    @Override
    public String toString() {
        return "CouponVo{" +
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
                ", code='" + code + '\'' +
                ", goodsType=" + goodsType +
                ", goodsValue=" + Arrays.toString(goodsValue) +
                ", timeType=" + timeType +
                ", days=" + days +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                ", daysTime=" + daysTime +
                '}';
    }
}
