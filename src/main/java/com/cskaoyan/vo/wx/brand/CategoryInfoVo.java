package com.cskaoyan.vo.wx.brand;

import com.cskaoyan.bean.CategoryInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/4
 */

public class CategoryInfoVo {
    private int id;
    private String name;
    private String keywords;
    private String desc;
    private int pid;
    private String iconUrl;
    private String picUrl;
    private String level;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private int sortOrder;
    private boolean deleted;

    public CategoryInfoVo() {
    }
    public CategoryInfoVo(CategoryInfo categoryInfo) {
         this.addTime = categoryInfo.getAdd_time();
        this.deleted = categoryInfo.getDeleted();
        this.desc = categoryInfo.getDesc();
        this.iconUrl = categoryInfo.getIcon_url();
        this.id = categoryInfo.getId();
        this.keywords = categoryInfo.getKeywords();
        this.level = categoryInfo.getLevel();
        this.name = categoryInfo.getName();
        this.picUrl = categoryInfo.getPic_url();
        this.pid = categoryInfo.getPid();
        this.sortOrder = categoryInfo.getSort_order();
        this.updateTime = categoryInfo.getUpdate_time();
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
