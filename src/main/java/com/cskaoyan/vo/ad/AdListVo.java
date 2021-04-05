package com.cskaoyan.vo.ad;

import com.cskaoyan.bean.Ad;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Classname AdListVo
 * @Author LM
 * @Description
 * @Data 2019/9/30
 */
public class AdListVo {
    private int id;
    private String name;
    private String link;
    private String url;
    private int position;
    private String content;
    private boolean enabled;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private int deleted;

    public AdListVo() {
    }

    public AdListVo(Ad ad) {
        this.id = ad.getId();
        this.name = ad.getName();
        this.link = ad.getLink();
        this.url = ad.getUrl();
        this.position = ad.getPosition();
        this.content = ad.getContent();
        this.enabled = ad.getEnabled();
        this.addTime = ad.getAdd_time();
        this.updateTime = ad.getUpdate_time();
        this.deleted = ad.getDeleted();
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean  enabled) {
        this.enabled = enabled;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int  deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "AdListVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", url='" + url + '\'' +
                ", position=" + position +
                ", content='" + content + '\'' +
                ", enabled=" + enabled +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
