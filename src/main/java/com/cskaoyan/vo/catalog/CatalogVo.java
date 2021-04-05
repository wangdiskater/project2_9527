package com.cskaoyan.vo.catalog;

import com.cskaoyan.vo.category.SubCategoryVo;

import java.util.List;

/**
 * @version 1.0
 * @ClassName CatalogVo
 * @Description 前端分类显示vo
 * @Author wangdi
 * @Date 2019/10/5 12:12
 **/

public class CatalogVo {
    SubCategoryVo currentCategory;
    //显示种类list
    List<SubCategoryVo> categoryList;
    //显示目前的二级类目
    List<SubCategoryVo> currentSubCategory;

    public CatalogVo() {
    }

    public CatalogVo(SubCategoryVo currentCategory, List<SubCategoryVo> currentSubCategory) {
        this.currentCategory = currentCategory;
        this.currentSubCategory = currentSubCategory;
    }

    public CatalogVo(SubCategoryVo currentCategory, List<SubCategoryVo> categoryList,
                     List<SubCategoryVo> currentSubCategory) {
        this.currentCategory = currentCategory;
        this.categoryList = categoryList;
        this.currentSubCategory = currentSubCategory;
    }

    @Override
    public String toString() {
        return "CatalogVo{" +
                "currentCategory=" + currentCategory +
                ", categoryList=" + categoryList +
                ", currentSubCategory=" + currentSubCategory +
                '}';
    }

    public SubCategoryVo getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(SubCategoryVo currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<SubCategoryVo> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<SubCategoryVo> categoryList) {
        this.categoryList = categoryList;
    }

    public List<SubCategoryVo> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<SubCategoryVo> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }
}
