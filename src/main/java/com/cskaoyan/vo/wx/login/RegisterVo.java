package com.cskaoyan.vo.wx.login;

/**
 * @version 1.0
 * @ClassName RegisterVo
 * @Description 获取前端用户的注册信息
 * @Author wangdi
 * @Date 2019/10/5 19:25
 **/

public class RegisterVo {
    String code;  //验证码
    String mobile;
    String password;
    String username;
    String wxCode;

    @Override
    public String toString() {
        return "RegisterVo{" +
                "code='" + code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", wxCode='" + wxCode + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }
}
