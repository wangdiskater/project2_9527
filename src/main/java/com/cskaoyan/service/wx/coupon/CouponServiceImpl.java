package com.cskaoyan.service.wx.coupon;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponId;
import com.cskaoyan.bean.CouponList;
import com.cskaoyan.mapper.CouponMapper;
import com.cskaoyan.vo.wx.coupon.CouponVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/5
 */

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    @Override
    public CouponVo queryCouponList(int page, int size) {
        CouponVo couponVo = new CouponVo();
        PageHelper.startPage(page, size);

        List<CouponList> coupons = couponMapper.queryCouponList();
        PageInfo<CouponList> couponPageInfo = new PageInfo<>(coupons);

        couponVo.setCount(couponPageInfo.getTotal());
        couponVo.setData(coupons);
        return couponVo;
    }

    @Override
    public CouponVo queryMyCouponList(int page, int size, int status) {
        CouponVo couponVo = new CouponVo();
        PageHelper.startPage(page, size);

        String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
        int id = couponMapper.queryUserIdByUsername(username);
        List<CouponList> coupons = couponMapper.queryMyCouponList(id, status);
        PageInfo<CouponList> couponPageInfo = new PageInfo<>(coupons);

        couponVo.setCount(couponPageInfo.getTotal());
        couponVo.setData(coupons);
        return couponVo;
    }

    @Override
    public boolean receiveCoupon(int couponId) {
        String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
        int id = couponMapper.queryUserIdByUsername(username);
        List<CouponId> coupons = couponMapper.checkMyCouponList(id);

        for (CouponId coupon : coupons) {
            if (coupon.getCouponId() == couponId){
                return true;
            }
        }
        couponMapper.receiveCoupon(id, couponId);
        return false;
    }

    @Override
    public boolean exchangeCoupon(String code) {
        List<String> coupons = couponMapper.exchangeCoupon();
        String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
        int userId = couponMapper.queryUserIdByUsername(username);
        int couponId = couponMapper.queryCouponIdByCode(code);
        for (String vo : coupons) {
            if (vo.equals(code)){
                couponMapper.setStatus(couponId, userId);
                return true;
            }
        }
        return false;
    }
}
