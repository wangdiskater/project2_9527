package com.cskaoyan.bean;

/**
 * @version 1.0
 * @ClassName Brand
 * @Description 品牌制造商---从数据库拿出接收的bean
 * @Author wangdi
 * @Date 2019/9/30 17:48
 **/

public class Brand {
    private int id;
    private String name;
    private String desc;
    private String pic_url;
    private int sort_order;
    private double floor_price;
    private String add_time;
    private String update_time;
    private int deleted;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", sort_order=" + sort_order +
                ", floor_price=" + floor_price +
                ", add_time='" + add_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", deleted=" + deleted +
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public double getFloor_price() {
        return floor_price;
    }

    public void setFloor_price(double floor_price) {
        this.floor_price = floor_price;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
