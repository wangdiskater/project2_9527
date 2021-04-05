package com.cskaoyan.vo.wx.foot;

import java.util.List;

/**
 * @Classname FootPrintListVo
 * @Author LM
 * @Description
 * @Data 2019/10/6 13:30
 */
public class FootprintListVo<T> {
    List<T> footprintList;
    long totalPages;

    public List<T> getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List<T> footprintList) {
        this.footprintList = footprintList;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
