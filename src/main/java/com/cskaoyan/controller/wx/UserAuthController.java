package com.cskaoyan.controller.wx;

import com.cskaoyan.service.admin.auth.AuthService;
import com.cskaoyan.service.wx.auth.UserAuthService;
import com.cskaoyan.shiro.CustomToken;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.login.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName UserAuthController
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/4 20:29
 **/
@RestController
@RequestMapping("/wx")
public class UserAuthController {

    @Autowired
    UserAuthService userAuthService;
    /* *
     * 功能描述 用户登录
     * @author wangdi
     * @date 2019/10/5 15:24
     * @param userMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/login",method = RequestMethod.POST)
    public BaseRespVo login(@RequestBody Map userMap, HttpServletRequest request){
//        String ipAddress = request.getHeader("x-forwarded-for");
//        System.out.println(ipAddress);
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        System.out.println(ipAddress);

        return userAuthService.userLogin(userMap,ipAddress);
    }

    /* *
     * 功能描述 微信登陆  --- 这里有问题，如何让微信登陆的用户通过验证
     * @author wangdi
     * @date 2019/10/5 15:44
     * @param wechatVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/login_by_weixin",method = RequestMethod.POST)
    public  BaseRespVo loginByWechat(@RequestBody WechatVo wechatVo){
        WechatUserInfo userInfo = wechatVo.getUserInfo();
        UserInfoVo userInfoVo = new UserInfoVo(userInfo.getNickName(),userInfo.getAvatarUrl());
        UserVo userVo = new UserVo();
        userVo.setUserInfo(userInfoVo);
        userVo.setTokenExpire(new Date());
        userVo.setToken("xznfht9a30vsip6smaslfz5z399959qd");
        return BaseRespVo.success(userVo);

    }


    /* *
     * 功能描述 用户退出
     * @author wangdi
     * @date 2019/10/5 15:29
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/logout",method = RequestMethod.POST)
    public BaseRespVo logout(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        if(userId == null){
            return BaseRespVo.fail(200,"登陆过期重新登陆");
        }
        subject.logout();
        return BaseRespVo.fail(501,"请登录");
    }

    /* *
     * 功能描述 获取验证码
     * @author wangdi
     * @date 2019/10/5 18:06
     * @param null
     * @return
     */
    @RequestMapping(value = "/auth/regCaptcha",method = RequestMethod.POST)
    public BaseRespVo regCaptcha(@RequestBody Map phoneMap){
        return userAuthService.regCaptcha(phoneMap);
    }

    /* *
     * 功能描述 前端用户注册
     * @author wangdi
     * @date 2019/10/5 21:32
     * @param registerVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/register",method = RequestMethod.POST)
    public BaseRespVo register(@RequestBody RegisterVo registerVo){

        return userAuthService.register(registerVo);
    }

    /* *
     * 功能描述 重置密码
     * @author wangdi
     * @date   2019/10/7 17:41
     * @param registerVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/auth/reset",method = RequestMethod.POST)
    public BaseRespVo reset(@RequestBody RegisterVo registerVo){
        return userAuthService.reset(registerVo);
    }

    /* *
     * 功能描述
     * @author wangdi
     * @date   2019/10/7 17:41
     * @param null
     * @return
     */
    @RequestMapping(value = "/auth/bindPhone",method = RequestMethod.POST)
    public BaseRespVo bindPhone(@RequestBody Map bindMap){
        String encryptedData = (String) bindMap.get("encryptedData");
        String iv = (String) bindMap.get("iv");
        return null;
    }

}
