package com.cskaoyan.vo.wx.order;

import java.util.Date;

/**
 * @version 1.0
 * @ClassName WxOrderPayVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/8 0:48
 **/

public class WxOrderPayVo {
   String timeStamp;
   String nonceStr;
   String packageValue;
   String signType;
   String paySign;

    @Override
    public String toString() {
        return "WxOrderPayVo{" +
                "timeStamp=" + timeStamp +
                ", nonceStr='" + nonceStr + '\'' +
                ", packageValue='" + packageValue + '\'' +
                ", signType='" + signType + '\'' +
                ", paySign='" + paySign + '\'' +
                '}';
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }
}
