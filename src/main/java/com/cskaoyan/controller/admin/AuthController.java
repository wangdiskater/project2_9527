package com.cskaoyan.controller.admin;

import com.cskaoyan.service.admin.auth.AuthService;
import com.cskaoyan.shiro.CustomRealm;
import com.cskaoyan.shiro.CustomToken;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.InfoVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName AuthController
 * @Description todo
 * @Author wangdi
 * @Date 2019/9/30 10:57
 **/

@RestController
@RequestMapping("/admin")//窄化请求
public class AuthController {

    @Autowired
    AuthService authService;


    /* *
     * 功能描述 简单登陆，后期还要修改
     * @author wangdi
     * @date
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/login",method = RequestMethod.POST)
    public BaseRespVo login(@RequestBody Map adminMap){

        return authService.login(adminMap);
    }

    /* *
     * 功能描述 显示信息
     * @author wangdi
     * @date
     * @param token
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/info",method = RequestMethod.GET)
    public BaseRespVo info(String token){
        return authService.info(token);
    }
    /* *
     * 功能描述 显示dashBoard
     * @author wangdi
     * @date
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
//    @RequiresPermissions("admin:order:list")
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public BaseRespVo dashboard(){
        return authService.dashboard();
    }

    /* *
     * 功能描述 退出
     * @author wangdi
     * @date
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/logout",method = RequestMethod.POST)
    public BaseRespVo logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseRespVo.success("");
    }

    /* *
     * 功能描述 修改密码
     * @author wangdi
     * @date
     * @param passwordMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/profile/password",method = RequestMethod.POST)
    public BaseRespVo password(@RequestBody Map passwordMap){
        return authService.password(passwordMap);
    }

}
