package com.cskaoyan.service.wx.home;

import com.cskaoyan.vo.BaseRespVo;

public interface HomeService {
    //显示首页
    BaseRespVo homeShow();

    //显示商品个数
    BaseRespVo goodsCount();
}
