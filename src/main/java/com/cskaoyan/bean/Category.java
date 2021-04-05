package com.cskaoyan.bean;

import com.cskaoyan.vo.category.CategoryVo;
import com.cskaoyan.vo.category.SubCategoryVo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @ClassName Category
 * @Description 数据库拿出 cskaoyan_mall_category
 * @Author wangdi
 * @Date 2019/9/30 23:19
 **/

public class Category {
    int id;
    String name;
    String keywords;
    String desc;
    int pid;
    String icon_url;
    String pic_url;
    String level;
    int sort_order;
    String add_time;
    String update_time;
    boolean deleted;

    public Category() {
    }


    //父Vo转sqlBean
    public Category(CategoryVo categoryVo) {
        this.id = categoryVo.getId();
        this.name = categoryVo.getName();
        this.keywords = categoryVo.getKeywords();
        this.desc = categoryVo.getDesc();
        this.pid = categoryVo.getPid();
        this.icon_url = categoryVo.getIconUrl();
        this.pic_url = categoryVo.getPicUrl();
        this.level = categoryVo.getLevel();
        this.add_time = categoryVo.getAddTime();
        this.update_time = categoryVo.getUpdateTime();
//        this.deleted = categoryVo.getDeleted(); //不转了
    }

    //子VO转sqlBean
    public Category(SubCategoryVo categoryVo) {

        this.name = categoryVo.getName();
        this.keywords = categoryVo.getKeywords();
        this.level = categoryVo.getLevel();
        this.pid = categoryVo.getPid();
        this.desc = categoryVo.getDesc();
        this.icon_url = categoryVo.getIconUrl();
        this.pic_url = categoryVo.getPicUrl();
    }



    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", desc='" + desc + '\'' +
                ", pid=" + pid +
                ", icon_url='" + icon_url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", level='" + level + '\'' +
                ", sort_order=" + sort_order +
                ", add_time='" + add_time + '\'' +
                ", update_time='" + update_time + '\'' +
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

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
