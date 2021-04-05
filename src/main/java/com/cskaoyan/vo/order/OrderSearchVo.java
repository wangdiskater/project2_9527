package com.cskaoyan.vo.order;

import java.util.Arrays;

/**
 * @version 1.0
 * @ClassName WxOrderSearchVo
 * @Description 接收前端传过来显示订单的参数
 * @Author wangdi
 * @Date 2019/10/1 16:51
 **/

public class OrderSearchVo {
    Integer page;
    Integer limit;
    Integer[] orderStatusArray;
    String sort;
    String order;
    String userId;
    String orderSn;  //订单编号

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer[] getOrderStatusArray() {
        return orderStatusArray;
    }

    public void setOrderStatusArray(Integer[] orderStatusArray) {
        this.orderStatusArray = orderStatusArray;
    }

    @Override
    public String toString() {
        return "WxOrderSearchVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", orderStatusArray=" + Arrays.toString(orderStatusArray) +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", userId='" + userId + '\'' +
                ", orderSn='" + orderSn + '\'' +
                '}';
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
}
