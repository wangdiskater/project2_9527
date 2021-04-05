package com.cskaoyan.vo.config;

/**
 * @author So9rry
 * @description
 * @date 2019/9/30
 */
public class OrderConfigVo {

    String cskaoyan_mall_order_unpaid;

    String cskaoyan_mall_order_unconfirm;

    String cskaoyan_mall_order_comment;

    public String getCskaoyan_mall_order_unpaid() {
        return cskaoyan_mall_order_unpaid;
    }

    public void setCskaoyan_mall_order_unpaid(String cskaoyan_mall_order_unpaid) {
        this.cskaoyan_mall_order_unpaid = cskaoyan_mall_order_unpaid;
    }

    public String getCskaoyan_mall_order_unconfirm() {
        return cskaoyan_mall_order_unconfirm;
    }

    public void setCskaoyan_mall_order_unconfirm(String cskaoyan_mall_order_unconfirm) {
        this.cskaoyan_mall_order_unconfirm = cskaoyan_mall_order_unconfirm;
    }

    public String getCskaoyan_mall_order_comment() {
        return cskaoyan_mall_order_comment;
    }

    public void setCskaoyan_mall_order_comment(String cskaoyan_mall_order_comment) {
        this.cskaoyan_mall_order_comment = cskaoyan_mall_order_comment;
    }

    @Override
    public String toString() {
        return "OrderConfigVo{" +
                "cskaoyan_mall_order_unpaid='" + cskaoyan_mall_order_unpaid + '\'' +
                ", cskaoyan_mall_order_unconfirm='" + cskaoyan_mall_order_unconfirm + '\'' +
                ", cskaoyan_mall_order_comment='" + cskaoyan_mall_order_comment + '\'' +
                '}';
    }
}
