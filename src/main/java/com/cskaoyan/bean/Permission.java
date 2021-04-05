package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @version 1.0
 * @ClassName Permission
 * @Description 数据区拿出权限表
 * @Author wangdi
 * @Date 2019/10/4 0:14
 **/

public class Permission {
    private int id;
    private int role_id;
    private String permission;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date add_time;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;
    private int deleted;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", permission='" + permission + '\'' +
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
