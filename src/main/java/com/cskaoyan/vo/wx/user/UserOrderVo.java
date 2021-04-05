package com.cskaoyan.vo.wx.user;

/**
 * @version 1.0
 * @ClassName UserOrderVo
 * @Description 显示用户的订单
 * @Author wangdi
 * @Date 2019/10/6 11:06
 **/

public class UserOrderVo {

    int unrecv;
    int uncomment;
    int unpaid;
    int unship;

    public UserOrderVo(int unrecv, int uncomment, int unpaid, int unship) {
        this.unrecv = unrecv;
        this.uncomment = uncomment;
        this.unpaid = unpaid;
        this.unship = unship;
    }

    @Override
    public String toString() {
        return "UserOrderVo{" +
                "unrecv=" + unrecv +
                ", uncomment=" + uncomment +
                ", unpaid=" + unpaid +
                ", unship=" + unship +
                '}';
    }

    public int getUnrecv() {
        return unrecv;
    }

    public void setUnrecv(int unrecv) {
        this.unrecv = unrecv;
    }

    public int getUncomment() {
        return uncomment;
    }

    public void setUncomment(int uncomment) {
        this.uncomment = uncomment;
    }

    public int getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(int unpaid) {
        this.unpaid = unpaid;
    }

    public int getUnship() {
        return unship;
    }

    public void setUnship(int unship) {
        this.unship = unship;
    }
}
