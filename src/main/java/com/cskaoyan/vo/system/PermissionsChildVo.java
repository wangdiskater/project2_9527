package com.cskaoyan.vo.system;

/**
 * @version 1.0
 * @ClassName PermissionsChildVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/3 20:19
 **/

public class PermissionsChildVo {
    int ids;
    String id = "";
    String label;
    int pid;
    String api;

    public PermissionsChildVo(int ids, String id, String label, int pid, String api) {
        this.id = id;
        this.ids = ids;
        this.label = label;
        this.pid = pid;
        this.api = api;
    }

    public PermissionsChildVo(int ids, String label, int pid, String api) {
        this.ids = ids;
        this.label = label;
        this.pid = pid;
        this.api = api;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
