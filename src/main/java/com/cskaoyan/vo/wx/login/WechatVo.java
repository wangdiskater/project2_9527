package com.cskaoyan.vo.wx.login;

/**
 * @version 1.0
 * @ClassName 微信登陆从前端获取数据
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 15:39
 **/

public class WechatVo {
    String code;
    WechatUserInfo userInfo;

    @Override
    public String toString() {
        return "WechatVo{" +
                "code='" + code + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public WechatUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WechatUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
