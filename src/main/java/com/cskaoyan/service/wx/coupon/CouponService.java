package com.cskaoyan.service.wx.coupon;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.vo.wx.coupon.CouponVo;

import java.util.List;

public interface CouponService {

    CouponVo queryCouponList(int page, int size);

    CouponVo queryMyCouponList(int page, int size, int id);

    boolean receiveCoupon(int couponId);

    boolean exchangeCoupon(String code);

}
