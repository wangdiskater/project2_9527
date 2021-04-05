package com.cskaoyan.vo.wx.comment;

import java.util.Arrays;

/**
 * @version 1.0
 * @ClassName WxTopticCommentVo
 * @Description 接收前端的留言信息
 * @Author wangdi
 * @Date 2019/10/7 10:09
 **/

public class WxTopticCommentVo {
    String   content;
    boolean  hasPicture;
    String[] picUrls;
    int      star;
    int      type = 1; //1
    int      valueId;

    @Override
    public String toString() {
        return "WxTopticCommentVo{" +
                "content='" + content + '\'' +
                ", hasPicture=" + hasPicture +
                ", picUrls=" + Arrays.toString(picUrls) +
                ", star=" + star +
                ", type=" + type +
                ", valueId=" + valueId +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }
}
