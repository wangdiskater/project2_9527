package com.cskaoyan.vo.wx.brand;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/4
 */

public class GoodsMerge<T> {
    int count;
    T filterCategoryList;
    T goodsList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(T filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }

    public T getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(T goodsList) {
        this.goodsList = goodsList;
    }
}
