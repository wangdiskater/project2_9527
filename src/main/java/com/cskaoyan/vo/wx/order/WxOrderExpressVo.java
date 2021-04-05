package com.cskaoyan.vo.wx.order;

import com.cskaoyan.bean.Order;

/**
 * @version 1.0
 * @ClassName WxOrderExpressVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/7 16:39
 **/

public class WxOrderExpressVo {
    String shipperName;
    String logisticCode;

    public WxOrderExpressVo() {
    }

    public WxOrderExpressVo(Order order) {
        this.shipperName = order.getShip_channel();
        this.logisticCode = order.getShip_sn();
    }


    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    @Override
    public String toString() {
        return "WxOrderExpressVo{" +
                "shipperName='" + shipperName + '\'' +
                ", logisticCode='" + logisticCode + '\'' +
                '}';
    }
}
