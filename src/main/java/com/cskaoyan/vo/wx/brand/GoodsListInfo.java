package com.cskaoyan.vo.wx.brand;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/4
 */

public class GoodsListInfo {
    int count;
    ArrayList filterCategoryList;
    ArrayList goodsList;

    public GoodsListInfo() {
    }

    public GoodsListInfo(ArrayList filterCategoryList, ArrayList goodsList) {
        this.filterCategoryList = filterCategoryList;
        this.goodsList = goodsList;
    }

    public GoodsListInfo(int count, ArrayList filterCategoryList, ArrayList goodsList) {
        this.count = count;
        this.filterCategoryList = filterCategoryList;
        this.goodsList = goodsList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(ArrayList filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }

    public ArrayList getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(ArrayList goodsList) {
        this.goodsList = goodsList;
    }
}
