package com.cskaoyan.bean;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description  统计报表模板
 * @Date 2019/9/30
 */

public class StatAllInfo<T> {

    List columns;
    List<T> rows;

    @Override
    public String toString() {
        return "StatAllInfo{" +
                "columns=" + columns +
                ", rows=" + rows +
                '}';
    }

    public List getColumns() {
        return columns;
    }

    public void setColumns(List columns) {
        this.columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
