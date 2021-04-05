package com.cskaoyan.vo.wx.wxgoods;

import com.cskaoyan.vo.goods.GoodsVo;

import java.util.List;

/**
 * @author GF
 * @description 商品列表的整体封装
 * @date 2019/10/5
 */

public class WxGoodsListVo {
    long count;
    List<GoodsVo> goodsList;
    List<WxCategoryVo> filterCategoryList;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<GoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVo> goodsList) {
        this.goodsList = goodsList;
    }

    public List<WxCategoryVo> getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(List<WxCategoryVo> filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }
}
