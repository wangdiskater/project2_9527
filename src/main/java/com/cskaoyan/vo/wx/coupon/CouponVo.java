package com.cskaoyan.vo.wx.coupon;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponList;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/5
 */
public class CouponVo {

    private List<CouponList> data;

    private long count;

    public List<CouponList> getData() {
        return data;
    }

    public void setData(List<CouponList> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CouponVo{" +
                "data=" + data +
                ", count=" + count +
                '}';
    }
}
