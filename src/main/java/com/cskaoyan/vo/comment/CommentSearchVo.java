package com.cskaoyan.vo.comment;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @ClassName CommentSearchVo
 * @Description 包装搜索的参数
 * @Author wangdi
 * @Date 2019/10/2 14:53
 **/

public class CommentSearchVo {
    private int    page;
    private int    limit;
    private String userId;
    private String valueId;
    private String sort;
    private String order;

    public CommentSearchVo() {
    }

    public CommentSearchVo(int page, int limit, String userId, String valueId, String sort, String order) {
        this.page = page;
        this.limit = limit;
        this.userId = userId;
        this.valueId = valueId;
        this.sort = sort;
        this.order = order;
    }

    @Override
    public String toString() {
        return "CommentSearchVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", userId='" + userId + '\'' +
                ", valueId='" + valueId + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
