package com.cskaoyan.vo.region;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName CityVo
 * @Description 区域显示 --- 城市
 * @Author wangdi
 * @Date 2019/9/30 16:18
 **/

public class CityVo {
    private int id;
    private String name;
    private int type = 2;
    private String code;
    private int pid;
    private List<RegionVo> children = new ArrayList<>();

    @Override
    public String toString() {
        return "CityVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", pid=" + pid +
                ", children=" + children +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public List<RegionVo> getChildren() {
        return children;
    }

    public void setChildren(List<RegionVo> children) {
        this.children = children;
    }
}
