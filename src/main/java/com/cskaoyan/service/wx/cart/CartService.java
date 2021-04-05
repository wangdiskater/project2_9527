package com.cskaoyan.service.wx.cart;

import com.cskaoyan.bean.Fastadd;
import com.cskaoyan.bean.Products;
import com.cskaoyan.bean.UpdateProduct;
import com.cskaoyan.vo.BaseRespVo;
import org.springframework.web.bind.annotation.RequestBody;

public interface CartService {

    BaseRespVo showAllCartGoods();

    BaseRespVo cartChecked(@RequestBody Products products);

    BaseRespVo deleteCart(Products products);

    BaseRespVo updateGoodsCount(UpdateProduct product);

    BaseRespVo goodscount();

    BaseRespVo addCart(@RequestBody Fastadd addGoods, int userId);

    BaseRespVo fastadd(Fastadd addGoods, int userId);

    BaseRespVo checkout(int cartId, int addressId, int couponId, int grouponRulesId);
}
