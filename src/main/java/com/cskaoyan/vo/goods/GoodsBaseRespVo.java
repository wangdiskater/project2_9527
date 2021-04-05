package com.cskaoyan.vo.goods;


import java.util.List;

/**
 * @author GF
 * @description 对品牌和商品分类的封装
 * @date 2019/10/2
 */

public class GoodsBaseRespVo {

    private List<CategoryListVo> categoryList;
    private List<BrandListVo> brandList;

    public List<BrandListVo> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandListVo> brandList) {
        this.brandList = brandList;
    }

    public List<CategoryListVo> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryListVo> categoryList) {
        this.categoryList = categoryList;
    }
}
