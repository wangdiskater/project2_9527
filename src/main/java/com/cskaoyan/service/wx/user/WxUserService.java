package com.cskaoyan.service.wx.user;

import com.cskaoyan.vo.BaseRespVo;

public interface WxUserService {
    //获取用户主页信息
    BaseRespVo userIndex(int userId);
}
