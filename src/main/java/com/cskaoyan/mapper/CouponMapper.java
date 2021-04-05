package com.cskaoyan.mapper;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponId;
import com.cskaoyan.bean.CouponList;
import com.cskaoyan.vo.wx.coupon.CouponVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {

    List<CouponList> queryCouponList();

    List<CouponList> queryMyCouponList(int id, int status);

    void receiveCoupon(int id, Integer couponId);

    List<CouponId> checkMyCouponList(@Param("id") int id);

    List<String> exchangeCoupon();

    void setStatus(int couponId, int userId);

    int queryUserIdByUsername(@Param("username") String username);

    int queryCouponIdByCode(@Param("code") String code);

}
