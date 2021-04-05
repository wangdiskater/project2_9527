package com.cskaoyan.vo.user;

import java.util.List;

/**
 * @author GF
 * @description 全部会员管理信息的管理
 * @date 2019/9/30
 */

public class UserBaseRespVo<T> {
       long total;
       List<T> items;


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
