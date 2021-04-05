package com.cskaoyan.service.wx.catalog;

import com.cskaoyan.vo.BaseRespVo;

public interface CatalogService {

    BaseRespVo catalogShow();

    BaseRespVo catalogCurrent(int id);
}
