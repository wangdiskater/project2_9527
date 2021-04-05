package com.cskaoyan.vo.storage;

/**
 * @version 1.0
 * @ClassName StorageSearchVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/2 17:42
 **/

public class StorageSearchVo {
    private int page;
    private int limit;
    private String key;
    private String name;
    private String sort;
    private String order;

    public StorageSearchVo() {
    }

    public StorageSearchVo(int page, int limit, String key, String name, String sort, String order) {
        this.page = page;
        this.limit = limit;
        this.key = key;
        this.name = name;
        this.sort = sort;
        this.order = order;
    }

    @Override
    public String toString() {
        return "StorageSearchVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", key='" + key + '\'' +
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
