package com.cskaoyan.vo.wx.order;

/**
 * @version 1.0
 * @ClassName WxOrderSearchVo
 * @Description 接收前端传过来的搜索的数据
 * @Author wangdi
 * @Date 2019/10/6 11:38
 **/

public class WxOrderSearchVo {
    Integer showType;
    Integer page;
    Integer size;

    public WxOrderSearchVo() {
    }

    public WxOrderSearchVo(Integer showType, Integer page, Integer size) {
        this.showType = showType;
        this.page = page;
        this.size = size;
    }

    @Override
    public String toString() {
        return "WxOrderSearchVo{" +
                "showType=" + showType +
                ", page=" + page +
                ", size=" + size +
                '}';
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
