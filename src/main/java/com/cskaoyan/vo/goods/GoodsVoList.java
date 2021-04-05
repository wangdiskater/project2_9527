package com.cskaoyan.vo.goods;

import java.util.Arrays;
import java.util.List;

/**
 * @author GF
 * @description 商品管理模块的VO
 * @date 2019/10/1
 */

public class GoodsVoList {


    private  Integer [] categoryIds;
    private GoodsVo goods;
   private List<GoodsSpecificationVo> specifications;
   private List<ProductSVo> products;
   private List<GoodsAttributeVo> attributes;

    public List<GoodsSpecificationVo> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<GoodsSpecificationVo> specifications) {
        this.specifications = specifications;
    }

    public List<ProductSVo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSVo> products) {
        this.products = products;
    }

    public List<GoodsAttributeVo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GoodsAttributeVo> attributes) {
        this.attributes = attributes;
    }

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public Integer[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Integer[] categoryIds) {
        this.categoryIds = categoryIds;
    }
}
