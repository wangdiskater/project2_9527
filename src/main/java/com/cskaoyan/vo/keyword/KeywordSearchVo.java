package com.cskaoyan.vo.keyword;

/**
 * @version 1.0
 * @ClassName KeywordSearchVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 21:26
 **/

public class KeywordSearchVo {
    private Integer page;
    private Integer limit;
    private String  keyword;
    private String  url;
    private String  sort;
    private String  order;

    public KeywordSearchVo() {
        this.page = page;
    }

    public KeywordSearchVo(Integer page, Integer limit, String keyword, String url, String sort, String order) {
        this.page = page;
        this.limit = limit;
        this.keyword = keyword;
        this.url = url;
        this.sort = sort;
        this.order = order;
    }

    @Override
    public String toString() {
        return "KeywordSearchVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", keyword='" + keyword + '\'' +
                ", url='" + url + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
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
