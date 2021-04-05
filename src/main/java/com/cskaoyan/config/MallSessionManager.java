package com.cskaoyan.config;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @version 1.0
 * @ClassName MallSessionManager
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/4 15:52
 **/

public class MallSessionManager extends DefaultWebSessionManager {
    @Override
    protected Serializable getSessionId(ServletRequest servletRequest, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String header = request.getHeader("X-cskaoyanmall-Admin-Token");
        if (header != null && !"".equals(header)){
            return header;
        }
        return super.getSessionId(servletRequest, response);
    }
}
