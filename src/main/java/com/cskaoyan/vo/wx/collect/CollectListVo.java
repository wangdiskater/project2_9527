package com.cskaoyan.vo.wx.collect;

import com.cskaoyan.bean.CollectList;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/4
 */
public class CollectListVo {

    private long totalPages;

    private List<CollectList> collectList;

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List<CollectList> getCollectList() {
        return collectList;
    }

    public void setCollectList(List<CollectList> collectList) {
        this.collectList = collectList;
    }

    @Override
    public String toString() {
        return "CollectListVo{" +
                "totalPages=" + totalPages +
                ", collectList=" + collectList +
                '}';
    }
}
