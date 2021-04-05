package com.cskaoyan.vo.wx.order;

import java.util.List;

/**
 * @version 1.0
 * @ClassName WxOrderShowVo
 * @Description 返回给前端显示的Vo
 * @Author wangdi
 * @Date 2019/10/6 13:07
 **/

public class WxOrderShowVo {
    List<WxOrderListVo> data;
    int count;
    int totalPages;

    public WxOrderShowVo(List<WxOrderListVo> data, int count, int totalPages) {
        this.data = data;
        this.count = count;
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "WxOrderShowVo{" +
                "data=" + data +
                ", count=" + count +
                ", totalPages=" + totalPages +
                '}';
    }

    public List<WxOrderListVo> getData() {
        return data;
    }

    public void setData(List<WxOrderListVo> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
