package com.cskaoyan.vo.keyword;

import com.cskaoyan.bean.Keyword;

/**
 * @version 1.0
 * @ClassName KeywordVo 传给前端的keyword
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 21:41
 **/

public class KeywordVo {
    private int     id;
    private String  keyword;
    private String  url;
    private boolean isHot;  //有问题
    private boolean isDefault;
    private int     sortOrder;
    private String  addTime;
    private String  updateTime;
    private boolean deleted;

    public KeywordVo() {
    }

    public KeywordVo(Keyword keyword) {
        this.id = keyword.getId();
        this.keyword = keyword.getKeyword();
        this.url = keyword.getUrl();
        if(keyword.getIs_hot() == 0){
            this.isHot = false;
        } else {
            this.isHot = true;
        }
        if(keyword.getIs_default() == 0){
            this.isDefault = false;
        } else {
            this.isDefault = true;
        }
        this.sortOrder = keyword.getSort_order();
        this.addTime = keyword.getAdd_time();
        this.updateTime = keyword.getUpdate_time();
        if(keyword.getDeleted() == 0){
            this.deleted = false;
        } else {
            this.deleted = true;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //get set要手写
    public boolean getIsHot(){
        return isHot;
    }
    public void setIsHot(boolean isHot){
        this.isHot = isHot;
    }
    public boolean getIsDefault(){
        return isDefault;
    }
    public void setIsDefault(boolean isDefault){
        this.isDefault = isDefault;
    }


    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
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
