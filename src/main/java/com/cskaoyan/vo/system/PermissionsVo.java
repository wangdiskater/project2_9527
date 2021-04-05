package com.cskaoyan.vo.system;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName PermissionsVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/3 20:03
 **/

public class PermissionsVo {
    String id;
    String label;
    String api;
    int pid;
    int ids;
    List<PermissionsVo> children = new ArrayList<>();

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public PermissionsVo(PermissionsChildVo permissionsChildVo) {
        this.id = permissionsChildVo.getId() ;
        this.label = permissionsChildVo.getLabel() ;
        this.api = permissionsChildVo.getApi();
        this.pid = permissionsChildVo.getPid();
        this.ids = permissionsChildVo.getIds();
    }

    public PermissionsVo(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public PermissionsVo(String id, String label, List<PermissionsVo> children) {
        this.id = id;
        this.label = label;
        this.children = children;
    }

    public PermissionsVo(String id, String label, String api) {
        this.id = id;
        this.label = label;
        this.api = api;
    }

    @Override
    public String toString() {
        return "PermissionsVo{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", api='" + api + '\'' +
                ", children=" + children +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public List<PermissionsVo> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionsVo> children) {
        this.children = children;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
