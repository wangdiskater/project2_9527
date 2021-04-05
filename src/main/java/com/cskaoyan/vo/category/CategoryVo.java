package com.cskaoyan.vo.category;

import com.cskaoyan.bean.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName CategoryVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/9/30 23:30
 **/

public class CategoryVo {
    private int id;
    private String name;
    private String keywords;
    private String desc;
    private int pid;
    private String iconUrl;
    private String picUrl;
    private String level;
    private String addTime;
    private String updateTime;
    private String deleted;
    private List<SubCategoryVo> children = new ArrayList<>();

    public CategoryVo() {
    }
    public CategoryVo(Category sqlBean) {
        this.id = sqlBean.getId();
        this.name = sqlBean.getName();
        this.keywords = sqlBean.getKeywords();
        this.desc = sqlBean.getDesc();
        this.iconUrl = sqlBean.getIcon_url();
        this.picUrl = sqlBean.getPic_url();
        this.level = sqlBean.getLevel();
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", desc='" + desc + '\'' +
                ", pid=" + pid +
                ", iconUrl='" + iconUrl + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", level='" + level + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted='" + deleted + '\'' +
                ", children=" + children +
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

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public List<SubCategoryVo> getChildren() {
        return children;
    }

    public void setChildren(List<SubCategoryVo> children) {
        this.children = children;
    }
}
