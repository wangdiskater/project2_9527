package com.cskaoyan.vo.system;

import com.cskaoyan.bean.Log;
import com.cskaoyan.bean.LogList;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/3
 */
public class LogByNameVo {

    private long total;
    private List<Log> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Log> getItems() {
        return items;
    }

    public void setItems(List<Log> items) {
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
