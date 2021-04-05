package com.cskaoyan.vo.wx.groupon;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */

public class WxMyGrouponVoList {
    int id;
    int orderId;
    int grouponId;
    int rulesId;
    int userId;
    int creatorUserId;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date expireTime;
    boolean payed;

    public boolean getIsDeleted() {
        return deleted;
    }

    boolean deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGrouponId() {
        return grouponId;
    }

    public void setGrouponId(int grouponId) {
        this.grouponId = grouponId;
    }

    public int getRulesId() {
        return rulesId;
    }

    public void setRulesId(int rulesId) {
        this.rulesId = rulesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(int creatorUserId) {
        this.creatorUserId = creatorUserId;
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

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
