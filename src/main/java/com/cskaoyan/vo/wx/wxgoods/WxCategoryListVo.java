package com.cskaoyan.vo.wx.wxgoods;

import com.cskaoyan.vo.goods.GoodsVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author GF
 * @description 商品类目表的封装
 * @date 2019/10/5
 */

public class WxCategoryListVo{
    WxCategoryVo currentCategory;
    List<WxCategoryVo> brotherCategory;
    WxCategoryVo parentCategory;
    List<GoodsVo> goodsList;

    public WxCategoryVo getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(WxCategoryVo currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<WxCategoryVo> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<WxCategoryVo> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }

    public WxCategoryVo getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(WxCategoryVo parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<GoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVo> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "WxCategoryListVo{" +
                "currentCategory=" + currentCategory +
                ", brotherCategory=" + brotherCategory +
                ", parentCategory=" + parentCategory +
                ", goodsList=" + goodsList +
                '}';
    }
}
