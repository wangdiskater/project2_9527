package com.cskaoyan.service.wx.brand;

import com.cskaoyan.vo.BaseRespVo;

public interface BrandService {

    BaseRespVo showBrands(int page, int size);

    BaseRespVo showBrandDetail(int id);

    BaseRespVo showGoods(int brandId, int page, int size);
}
