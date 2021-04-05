package com.cskaoyan.vo.wx.home;

/**
 * @version 1.0
 * @ClassName ChannelVo
 * @Description 显示的是category的一级标签
 * @Author wangdi
 * @Date 2019/10/4 22:40
 **/

public class ChannelVo {
    private int    id;
    private String name;
    private String iconUrl;

    @Override
    public String toString() {
        return "ChannelVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
