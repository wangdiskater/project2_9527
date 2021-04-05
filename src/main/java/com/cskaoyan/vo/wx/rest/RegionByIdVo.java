package com.cskaoyan.vo.wx.rest;

/**
 * @Classname RegionByIdVo
 * @Author LM
 * @Description
 * @Data 2019/10/5 19:59
 */
public class RegionByIdVo {
    int id;
    int pid;
    String name;
    int type;
    int code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegionByIdVo{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code=" + code +
                '}';
    }
}
