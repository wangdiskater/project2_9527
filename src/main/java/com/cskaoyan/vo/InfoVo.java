package com.cskaoyan.vo;

import java.util.List;

/**
 * @version 1.0
 * @ClassName InfoVo
 * @Description 登陆传给前端的info请求的vo
 * @Author wangdi
 * @Date 2019/9/30 11:10
 **/

public class InfoVo {
    private List roles;
    private String name;
    private List perms;
    private String avatar;

    public InfoVo() {
    }

    public InfoVo(List roles, String name, List perms, String avatar) {
        this.roles = roles;
        this.name = name;
        this.perms = perms;
        this.avatar = avatar;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPerms() {
        return perms;
    }

    public void setPerms(List perms) {
        this.perms = perms;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "InfoVo{" +
                "roles=" + roles +
                ", name='" + name + '\'' +
                ", perms=" + perms +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
