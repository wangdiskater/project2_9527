package com.cskaoyan.vo.system;

import com.cskaoyan.bean.LogList;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/2
 */
public class SystemLogVo {

    private long total;
    private List<LogList> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<LogList> getItems() {
        return items;
    }

    public void setItems(List<LogList> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SystemLogVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
