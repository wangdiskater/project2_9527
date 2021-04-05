package com.cskaoyan.vo;

import com.cskaoyan.bean.Ad;

import java.util.List;

/**
 * @Classname AdListVo
 * @Author LM
 * @Description 返回给前端的广告管理json
 * @Data 2019/9/30
 */
public class ListVo<T> {
    private long total;
    private List<T> items;

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

    @Override
    public String toString() {
        return "AdListVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
    /* *
     * 功能描述 增加两个构造方法，减少使用setXXX
     * @author wangdi
     * @date 2019/10/1 20:51
     * @param
     * @return
     */
    public ListVo() {
    }

    public ListVo(long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
