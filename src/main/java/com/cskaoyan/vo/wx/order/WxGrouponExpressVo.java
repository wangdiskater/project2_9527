package com.cskaoyan.vo.wx.order;

/**
 * @version 1.0
 * @ClassName WxGrouponExpressVo
 * @Description 获取前端传过来查找物流的信息
 * @Author wangdi
 * @Date 2019/10/7 16:59
 **/

public class WxGrouponExpressVo {
    String expCode;
    String expNo;

    @Override
    public String toString() {
        return "WxGrouponExpressVo{" +
                "expCode='" + expCode + '\'' +
                ", expNo='" + expNo + '\'' +
                '}';
    }

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    public String getExpNo() {
        return expNo;
    }

    public void setExpNo(String expNo) {
        this.expNo = expNo;
    }
}
