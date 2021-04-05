package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther Piter_Liu
 * @Description 查询 mall_groupon  表中的数据返回封装给bean
 * @Date 2019/10/2
 */

public class AdGroupon {

    int id;
    int order_id;
    int groupon_id;
    int rules_id;
    int user_id;
    int creator_user_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date add_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date update_time;
    String share_url;
    int payed;
    int deleted;

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGroupon_id() {
        return groupon_id;
    }

    public void setGroupon_id(int groupon_id) {
        this.groupon_id = groupon_id;
    }

    public int getRules_id() {
        return rules_id;
    }

    public void setRules_id(int rules_id) {
        this.rules_id = rules_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCreator_user_id() {
        return creator_user_id;
    }

    public void setCreator_user_id(int creator_user_id) {
        this.creator_user_id = creator_user_id;
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

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }
}
