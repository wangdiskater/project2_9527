package com.cskaoyan.bean;

import com.cskaoyan.vo.system.RoleVo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @version 1.0
 * @ClassName Role
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/2 23:01
 **/

public class Role {
    private int id;
    private String name;
    private String desc;
    private int enabled;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date add_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;
    private int deleted;

    public Role() {
    }

    public Role(RoleVo roleVo) {
        this.id = roleVo.getId();
        this.name = roleVo.getName();
        this.desc = roleVo.getDesc();
        if (roleVo.isEnabled()){
            this.enabled = 1;
        } else {
            this.enabled = 0;
        }
        this.add_time = roleVo.getAddTime();
        this.update_time = roleVo.getUpdateTime();
        if(roleVo.isDeleted()){
            this.deleted = 1;
        } else {
            this.deleted = 0;
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", enabled=" + enabled +
                ", add_time=" + add_time +
                ", update_time=" + update_time +
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
