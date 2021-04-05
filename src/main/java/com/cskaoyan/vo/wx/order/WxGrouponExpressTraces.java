package com.cskaoyan.vo.wx.order;

import java.util.Date;

/**
 * @version 1.0
 * @ClassName WxGrouponExpressTraces
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/7 17:04
 **/

public class WxGrouponExpressTraces {
    String AcceptStation;
    Date AcceptTime;

    public WxGrouponExpressTraces() {
    }

    public WxGrouponExpressTraces(String acceptStation, Date acceptTime) {
        AcceptStation = acceptStation;
        AcceptTime = acceptTime;
    }

    @Override
    public String toString() {
        return "WxGrouponExpressTraces{" +
                "AcceptStation='" + AcceptStation + '\'' +
                ", AcceptTime=" + AcceptTime +
                '}';
    }

    public String getAcceptStation() {
        return AcceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        AcceptStation = acceptStation;
    }

    public Date getAcceptTime() {
        return AcceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        AcceptTime = acceptTime;
    }
}
