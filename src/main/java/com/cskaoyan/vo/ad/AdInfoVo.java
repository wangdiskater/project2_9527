package com.cskaoyan.vo.ad;

import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description 推广管理数据返回模板
 * @Date 2019/10/2
 */

public class AdInfoVo<T> {

    long total;
    List<T> items;

    @Override
    public String toString() {
        return "AdInfoVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
