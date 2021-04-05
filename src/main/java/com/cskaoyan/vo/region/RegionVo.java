package com.cskaoyan.vo.region;

import java.util.List;

/**
 * @version 1.0
 * @ClassName RegionVo
 * @Description 区域显示 --- 区或者县城
 * @Author wangdi
 * @Date 2019/9/30 16:18
 **/

public class RegionVo {
    private int id;
    private String name;
    private int type = 3;
    private String code;

    @Override
    public String toString() {
        return "RegionVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code='" + code + '\'' +
                '}';
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
