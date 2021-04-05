package com.cskaoyan.vo.system;

import com.cskaoyan.bean.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @version 1.0
 * @ClassName RoleVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/2 22:59
 **/

public class RoleVo {
    private int id;
    private String name;
    private String desc;
    private boolean enabled;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private boolean deleted;

    public RoleVo() {
    }

    public RoleVo(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.desc = role.getDesc();
        if(role.getEnabled() == 0){
            this.enabled = false;
        } else {
            this.enabled = true;
        }
        this.addTime = role.getAdd_time();
        this.updateTime = role.getUpdate_time();
        if(role.getDeleted() == 0){
            this.deleted = false;
        } else {
            this.deleted = true;
        }
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", enabled=" + enabled +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
