package com.cskaoyan.vo.wx.wxgoods;

import com.cskaoyan.vo.goods.GoodsVo;

import java.util.List;

/**
 * @author GF
 * @description 商品详情页的关联商品的封装
 * @date 2019/10/6
 */

public class WxGoodsRelatedVo {
    List<GoodsVo> goodsList;

    public List<GoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVo> goodsList) {
        this.goodsList = goodsList;
    }
}
