package com.cskaoyan.vo.region;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName ProvinceVo
 * @Description 区域显示 --- 省份
 * @Author wangdi
 * @Date 2019/9/30 16:18
 **/

public class ProvinceVo {
    private int id;
    private String name;
    private int type = 1;
    private String code;
    private List<CityVo> children = new ArrayList<>();

    @Override
    public String toString() {
        return "ProvinceVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", children=" + children +
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

    public List<CityVo> getChildren() {
        return children;
    }

    public void setChildren(List<CityVo> children) {
        this.children = children;
    }
}
