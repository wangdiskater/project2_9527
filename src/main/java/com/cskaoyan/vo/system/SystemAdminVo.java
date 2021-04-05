package com.cskaoyan.vo.system;


import com.cskaoyan.bean.Admin;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/2
 */
public class SystemAdminVo {

    private long total;

    private List<Admin> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Admin> getItems() {
        return items;
    }

    public void setItems(List<Admin> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SystemAdminLog{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
