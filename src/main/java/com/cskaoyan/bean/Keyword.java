package com.cskaoyan.bean;

import com.cskaoyan.vo.keyword.KeywordVo;

/**
 * @version 1.0
 * @ClassName Keyword mall_keyword
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 21:32
 **/

public class Keyword {
    private int    id;
    private String keyword;
    private String url;
    private int    is_hot;
    private int    is_default;
    private int    sort_order;
    private String add_time;
    private String update_time;
    private int    deleted;

    public Keyword() {
    }

    public Keyword(KeywordVo keywordVoIn) {
        this.id = keywordVoIn.getId();
        this.keyword = keywordVoIn.getKeyword();
        this.url = keywordVoIn.getUrl();
        if(keywordVoIn.getIsHot()){
            this.is_hot = 1;
        } else {
            this.is_hot = 0;
        }
        if(keywordVoIn.getIsDefault()){
            this.is_default = 1;
        } else {
            this.is_default = 0;
        }
        this.sort_order = keywordVoIn.getSortOrder();
        this.add_time = keywordVoIn.getAddTime();
        this.update_time = keywordVoIn.getUpdateTime();
        if(keywordVoIn.isDeleted()){
            this.deleted = 1;
        }
        this.deleted = 0;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", url='" + url + '\'' +
                ", is_hot=" + is_hot +
                ", is_default=" + is_default +
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

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
