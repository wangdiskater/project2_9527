package com.cskaoyan.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @version 1.0
 * @ClassName 继承usernamePasswordToken 为了分发shiro
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 15:50
 **/

public class CustomToken extends UsernamePasswordToken {
    String type;

    public CustomToken(String username, String password, String type) {
        super(username, password);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
