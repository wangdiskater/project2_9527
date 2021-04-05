package com.cskaoyan.vo.wx.order;

import java.util.List;

/**
 * @version 1.0
 * @ClassName WxGrouponExpressShowVo
 * @Description 返货给团过的信息
 * @Author wangdi
 * @Date 2019/10/7 17:02
 **/

public class WxGrouponExpressShowVo {
    String shipperName;
    String logisticCode;
    List<WxGrouponExpressTraces>Traces;

    public WxGrouponExpressShowVo(String shipperName, String logisticCode, List<WxGrouponExpressTraces> traces) {
        this.shipperName = shipperName;
        this.logisticCode = logisticCode;
        Traces = traces;
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

    public List<WxGrouponExpressTraces> getTraces() {
        return Traces;
    }

    public void setTraces(List<WxGrouponExpressTraces> traces) {
        Traces = traces;
    }
}
