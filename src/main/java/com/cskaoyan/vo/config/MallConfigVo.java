package com.cskaoyan.vo.config;



public class MallConfigVo {

    String cskaoyan_mall_mall_phone;

    String cskaoyan_mall_mall_address;

    String cskaoyan_mall_mall_name;

    String cskaoyan_mall_mall_qq;

    @Override
    public String toString() {
        return "ConfigureVo{" +
                "cskaoyan_mall_mall_phone='" + cskaoyan_mall_mall_phone + '\'' +
                ", cskaoyan_mall_mall_address='" + cskaoyan_mall_mall_address + '\'' +
                ", cskaoyan_mall_mall_name='" + cskaoyan_mall_mall_name + '\'' +
                ", cskaoyan_mall_mall_qq='" + cskaoyan_mall_mall_qq + '\'' +
                '}';
    }

    public String getCskaoyan_mall_mall_phone() {
        return cskaoyan_mall_mall_phone;
    }

    public void setCskaoyan_mall_mall_phone(String cskaoyan_mall_mall_phone) {
        this.cskaoyan_mall_mall_phone = cskaoyan_mall_mall_phone;
    }

    public String getCskaoyan_mall_mall_address() {
        return cskaoyan_mall_mall_address;
    }

    public void setCskaoyan_mall_mall_address(String cskaoyan_mall_mall_address) {
        this.cskaoyan_mall_mall_address = cskaoyan_mall_mall_address;
    }

    public String getCskaoyan_mall_mall_name() {
        return cskaoyan_mall_mall_name;
    }

    public void setCskaoyan_mall_mall_name(String cskaoyan_mall_mall_name) {
        this.cskaoyan_mall_mall_name = cskaoyan_mall_mall_name;
    }

    public String getCskaoyan_mall_mall_qq() {
        return cskaoyan_mall_mall_qq;
    }

    public void setCskaoyan_mall_mall_qq(String cskaoyan_mall_mall_qq) {
        this.cskaoyan_mall_mall_qq = cskaoyan_mall_mall_qq;
    }
}

