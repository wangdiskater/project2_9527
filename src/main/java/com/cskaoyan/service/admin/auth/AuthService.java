package com.cskaoyan.service.admin.auth;

import com.cskaoyan.vo.BaseRespVo;

import java.util.Map;


public interface AuthService {

    //登陆
    BaseRespVo login(Map map);

    BaseRespVo password(Map passwordMap);

    BaseRespVo dashboard();

    //通过token找到登陆管理员的权限返回
    BaseRespVo info(String token);
}
