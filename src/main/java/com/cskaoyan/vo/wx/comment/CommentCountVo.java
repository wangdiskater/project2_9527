package com.cskaoyan.vo.wx.comment;

/**
 * @version 1.0
 * @ClassName CommentCountVo
 * @Description 返回显示页数
 * @Author wangdi
 * @Date 2019/10/6 0:15
 **/

public class CommentCountVo {
    int hasPicCount;
    int allCount;

    public CommentCountVo() {
    }

    public CommentCountVo(int hasPicCount, int allCount) {
        this.hasPicCount = hasPicCount;
        this.allCount = allCount;
    }

    @Override
    public String toString() {
        return "CommentCountVo{" +
                "hasPicCount=" + hasPicCount +
                ", allCount=" + allCount +
                '}';
    }

    public int getHasPicCount() {
        return hasPicCount;
    }

    public void setHasPicCount(int hasPicCount) {
        this.hasPicCount = hasPicCount;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }
}
