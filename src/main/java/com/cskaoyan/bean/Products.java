package com.cskaoyan.bean;

import java.util.List;
import java.util.Map;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/5
 */

public class Products {
    List<Integer> productIds;
    int isChecked;

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }
}
