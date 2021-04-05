package com.cskaoyan.vo.wx.order;

/**
 * @version 1.0
 * @ClassName WxOrderSubmitVo
 * @Description 获取订单提交的参数
 * @Author wangdi
 * @Date 2019/10/7 23:30
 **/

public class WxOrderSubmitVo {

    int addressId;
    int cartId; //不等于0把商品从购物车删除
    int couponId;
    int grouponLinkId;
    int grouponRulesID;
    String message;
    int orderId;


    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getGrouponLinkId() {
        return grouponLinkId;
    }

    public void setGrouponLinkId(int grouponLinkId) {
        this.grouponLinkId = grouponLinkId;
    }

    public int getGrouponRulesID() {
        return grouponRulesID;
    }

    public void setGrouponRulesID(int grouponRulesID) {
        this.grouponRulesID = grouponRulesID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "WxOrderSubmitVo{" +
                "addressId=" + addressId +
                ", cartId=" + cartId +
                ", couponId=" + couponId +
                ", grouponLinkId=" + grouponLinkId +
                ", grouponRulesID=" + grouponRulesID +
                ", message='" + message + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
