package com.cskaoyan.vo.wx.groupon;


import com.cskaoyan.bean.Order;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */

public class MyHandleOptionVo {
    boolean cancel; //用户显示取消订单按钮 订单状态101
    boolean delete; //用户显示删除订单按钮  在系统取消、已退款 、系统收货|用户收货过后
    boolean pay;    //用户显示支付订单按钮  订单状态101
    boolean comment; //用户显示评价按钮，订单表中字段表示可以评论商品的个数， 如果comment >0 就开启
    // 订单商品评论，如果是-1，则超期不能评价；如果是0，则可以评价；如果其他值，则是comment表里面的评论ID。
    //设置默认收货超过7天不可以评价

    boolean confirm; //用户显示确认收货按钮  订单状态 301显示
    boolean refund;  //用户显示退款按钮     订单状态 201 301
    boolean rebuy;   //用户显示再次购买   订单状态401 | 402



    public MyHandleOptionVo(int order_status) {
        if(order_status == 101){
            this.cancel = true;
            this.pay = true;
        }//
        if(order_status == 103||order_status == 203 || order_status == 401 || order_status == 402){
            this.delete = true;
        }
        //商品可以评论个数大于0开启评论
        /*if(order.getComments() > 0){
            this.comment = true;
        }*/
        if(order_status == 301){
            this.confirm = true;
        }
        if(order_status == 201 || order_status == 301){
            this.refund = true;
        }
        if(order_status == 401 || order_status == 402){
            this.rebuy = true;
        }

    }

    public MyHandleOptionVo() {
    }

    @Override
    public String toString() {
        return "WxOrderHandleOption{" +
                "cancel=" + cancel +
                ", delete=" + delete +
                ", pay=" + pay +
                ", comment=" + comment +
                ", confirm=" + confirm +
                ", refund=" + refund +
                ", rebuy=" + rebuy +
                '}';
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public boolean isRebuy() {
        return rebuy;
    }

    public void setRebuy(boolean rebuy) {
        this.rebuy = rebuy;
    }
}
