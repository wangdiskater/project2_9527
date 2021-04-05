package com.cskaoyan.vo.cart;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/6
 */

public class CheckoutVo<T> {
    double actualPrice;
    int addressId;
    int availableCouponLength; // 优惠券数量
    T checkedAddress;
    T checkedGoodsList;
    int couponId;
    double couponPrice;
    double freightPrice;
    double goodsTotalPrice;
    double grouponPrice;
    int grouponRulesId;
    double orderTotalPrice;

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(int availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public T getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(T checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public T getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(T checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public double getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(double grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }


}
