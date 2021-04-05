package com.cskaoyan.vo.wx.order;

import java.util.List;

/**
 * @version 1.0
 * @ClassName WxOrderDetailShowVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/6 17:32
 **/

public class WxOrderDetailShowVo {
    WxOrderInfoVo orderInfo;
    List<WxOrderDetailGoods> orderGoods;
    WxOrderExpressVo expressInfo;

    public WxOrderDetailShowVo() {
    }

    public WxOrderDetailShowVo(WxOrderInfoVo orderInfo, List<WxOrderDetailGoods> orderGoods,
                               WxOrderExpressVo expressInfo) {
        this.orderInfo = orderInfo;
        this.orderGoods = orderGoods;
        this.expressInfo = expressInfo;
    }

    @Override
    public String toString() {
        return "WxOrderDetailShowVo{" +
                "orderInfo=" + orderInfo +
                ", orderGoods=" + orderGoods +
                '}';
    }

    public WxOrderExpressVo getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(WxOrderExpressVo expressInfo) {
        this.expressInfo = expressInfo;
    }

    public WxOrderInfoVo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(WxOrderInfoVo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<WxOrderDetailGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<WxOrderDetailGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }
}
