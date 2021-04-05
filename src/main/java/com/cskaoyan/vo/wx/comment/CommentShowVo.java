package com.cskaoyan.vo.wx.comment;

/**
 * @version 1.0
 * @ClassName CommentShowVo
 * @Description 微信显示评论
 * @Author wangdi
 * @Date 2019/10/5 22:57
 **/

public class CommentShowVo {
    Integer valueId;
    Integer type;
    Integer size;
    Integer page;
    Integer showType;

    public CommentShowVo(Integer valueId, Integer type, Integer size, Integer page, Integer showType) {
        this.valueId = valueId;
        this.type = type;
        this.size = size;
        this.page = page;
        this.showType = showType;
    }

    @Override
    public String toString() {
        return "CommentShowVo{" +
                "valueId=" + valueId +
                ", type=" + type +
                ", size=" + size +
                ", page=" + page +
                ", showType=" + showType +
                '}';
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }
}
