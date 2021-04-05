package com.cskaoyan.vo.user;

import java.util.Date;

/**
 * @author GF
 * @description 会员收藏模块的功能实现
 * @date 2019/9/30
 */

public class UserCollectVo {
    int id;
    int userId;
    int valueId;
    int type;
    String addTime;
    String updateTime;
    boolean deleted;

    @Override
    public String toString() {
        return "UserCollectVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", valueId=" + valueId +
                ", type=" + type +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
