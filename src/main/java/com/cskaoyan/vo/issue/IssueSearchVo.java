package com.cskaoyan.vo.issue;

/**
 * @version 1.0
 * @ClassName IssueSearchVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 20:27
 **/

public class IssueSearchVo {
    private Integer page;
    private Integer limit;
    private String question;
    private String sort;
    private String order;

    public IssueSearchVo() {
    }

    public IssueSearchVo(Integer page, Integer limit, String question, String sort, String order) {
        this.page = page;
        this.limit = limit;
        this.question = question;
        this.sort = sort;
        this.order = order;
    }

    @Override
    public String toString() {
        return "IssueSearchVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", question='" + question + '\'' +
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
