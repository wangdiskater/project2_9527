package com.cskaoyan.service.wx.auth;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.login.RegisterVo;

import java.util.Map;

public interface UserAuthService {
    //用户登录
    BaseRespVo userLogin(Map userMap, String ipAddress);

    //获取验证码
    BaseRespVo regCaptcha(Map phoneMap);

    //注册用户
    BaseRespVo register(RegisterVo registerVo);

    //重置用户密码
    BaseRespVo reset(RegisterVo registerVo);

}
