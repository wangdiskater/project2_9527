package com.cskaoyan.vo.wx.brand;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/4
 */

public class BrandMerge<T> {
    T brandList;
    int totalPages;

    public T getBrandList() {
        return brandList;
    }

    public void setBrandList(T brandList) {
        this.brandList = brandList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
