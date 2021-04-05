package com.cskaoyan.vo.wx.comment;

import java.util.List;

/**
 * @version 1.0
 * @ClassName WxCommentDataVo
 * @Description 返回前端的数据
 * @Author wangdi
 * @Date 2019/10/5 23:41
 **/

public class WxCommentDataVo {
    List<WxCommentVo> data;
    long count;
    int currentPage;

    public WxCommentDataVo() {
    }

    public WxCommentDataVo(List<WxCommentVo> data, long count, int currentPage) {
        this.data = data;
        this.count = count;
        this.currentPage = currentPage;
    }

    public List<WxCommentVo> getData() {
        return data;
    }

    public void setData(List<WxCommentVo> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "WxCommentDataVo{" +
                "data=" + data +
                ", count=" + count +
                ", currentPage=" + currentPage +
                '}';
    }
}
