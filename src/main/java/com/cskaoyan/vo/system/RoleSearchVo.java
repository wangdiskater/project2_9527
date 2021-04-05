package com.cskaoyan.vo.system;

/**
 * @version 1.0
 * @ClassName RoleSearchVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/2 22:51
 **/

public class RoleSearchVo {
    private int page;
    private int limit;
    private String name;
    private String sort;
    private String order;

    public RoleSearchVo() {
    }

    public RoleSearchVo(int page, int limit, String name, String sort, String order) {
        this.page = page;
        this.limit = limit;
        this.name = name;
        this.sort = sort;
        this.order = order;
    }

    @Override
    public String toString() {
        return "RoleSearchVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
