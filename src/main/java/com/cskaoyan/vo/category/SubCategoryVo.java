package com.cskaoyan.vo.category;

import com.cskaoyan.bean.Category;

/**
 * @version 1.0
 * @ClassName SubCategoryVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/9/30 23:30
 **/

public class SubCategoryVo {
    private int id;
    private String name;
    private String keywords;
    private String desc;
    private String iconUrl;
    private String picUrl;
    private String level;
    private int pid;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public SubCategoryVo() {
    }

    public SubCategoryVo(Category sqlBean) {
        this.id = sqlBean.getId();
        this.name = sqlBean.getName();
        this.keywords = sqlBean.getKeywords();
        this.desc = sqlBean.getDesc();
        this.pid = sqlBean.getPid();
        this.iconUrl = sqlBean.getIcon_url();
        this.picUrl = sqlBean.getPic_url();
        this.level = sqlBean.getLevel();
        this.addTime = sqlBean.getAdd_time();
        this.updateTime = sqlBean.getUpdate_time();
        this.deleted = sqlBean.getDeleted();
    }

    @Override
    public String toString() {
        return "SubCategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", desc='" + desc + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", level='" + level + '\'' +
                ", pid=" + pid +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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
}
