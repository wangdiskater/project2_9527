package com.cskaoyan.vo;

/**
 * @version 1.0
 * @ClassName DashBoardVo
 * @Description DashBoardVo
 * @Author wangdi
 * @Date 2019/9/30 11:47
 **/

public class DashBoardVo {
    private int goodsTotal;
    private int userTotal;
    private int productTotal;
    private int orderTotal;

    @Override
    public String toString() {
        return "DashBoardVo{" +
                "goodsTotal=" + goodsTotal +
                ", userTotal=" + userTotal +
                ", productTotal=" + productTotal +
                ", orderTotal=" + orderTotal +
                '}';
    }

    public int getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(int goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public int getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(int userTotal) {
        this.userTotal = userTotal;
    }

    public int getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(int productTotal) {
        this.productTotal = productTotal;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }
}
