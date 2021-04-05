package com.cskaoyan.vo.comment;

import com.cskaoyan.vo.wx.comment.WxTopticCommentVo;
import com.cskaoyan.vo.wx.order.WxOrderCommentVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @ClassName CommentVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/2 15:18
 **/

public class CommentVo {
    private int id;
    private int valueId; //商品id
    private int type;
    private String content;
    private int userId;
    private int hasPicture;
    private String[] picUrls;
    private int star;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private int deleted;

    public CommentVo() {
    }
    //订单评论
    public CommentVo(WxOrderCommentVo wxOrderCommentVo, int userId) {
        this.valueId = wxOrderCommentVo.getGoodsId();//这里是goodsId的id
        //订单商品评论
        this.type = 3;
        this.content = wxOrderCommentVo.getContent();
        this.userId = userId;
        if(wxOrderCommentVo.getHasPicture()){
            this.hasPicture = 1;
            //默认是0
        }
        this.picUrls = wxOrderCommentVo.getPicUrls();
        this.star = wxOrderCommentVo.getStar();
        this.addTime = new Date();
        this.updateTime = new Date();
    }

    //主题评论
    public CommentVo(WxTopticCommentVo wxTopticCommentVo) {
        this.valueId = wxTopticCommentVo.getValueId();
        this.type = wxTopticCommentVo.getType();
        this.content = wxTopticCommentVo.getContent();
        if(wxTopticCommentVo.getHasPicture()){
            this.hasPicture = 1;
        }
        this.picUrls = wxTopticCommentVo.getPicUrls();
        this.star = wxTopticCommentVo.getStar();
        this.addTime = new Date();
        this.updateTime = new Date();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(int hasPicture) {
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "id=" + id +
                ", valueId=" + valueId +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", hasPicture=" + hasPicture +
                ", picUrls=" + Arrays.toString(picUrls) +
                ", star=" + star +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

}
