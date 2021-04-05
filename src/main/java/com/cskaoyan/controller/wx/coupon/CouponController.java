package com.cskaoyan.controller.wx.coupon;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponId;
import com.cskaoyan.service.wx.coupon.CouponService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.coupon.CouponVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author So9rry
 * @description
 * @date 2019/10/5
 */

@RestController
public class CouponController {

    @Autowired
    CouponService couponService;

    //显示商城优惠券列表
    @RequestMapping(value = "wx/coupon/list", method = RequestMethod.GET)
    public BaseRespVo queryCouponList(int page, int size){
        CouponVo couponVo = couponService.queryCouponList(page, size);
        return BaseRespVo.success(couponVo);
    }

    //显示用户优惠券列表
    @RequestMapping(value = "wx/coupon/mylist", method = RequestMethod.GET)
    public BaseRespVo queryMyCouponList(int page, int size, int status){
        CouponVo couponVo = couponService.queryMyCouponList(page, size, status);
        return BaseRespVo.success(couponVo);
    }

    //获取优惠券
    @RequestMapping(value = "wx/coupon/receive", method = RequestMethod.POST)
    public BaseRespVo receiveCoupon(@RequestBody CouponId couponId){
        BaseRespVo baseRespVo = new BaseRespVo();
        boolean flag = couponService.receiveCoupon(couponId.getCouponId());
        if (!flag){
            baseRespVo.setErrmsg("领取成功");
            baseRespVo.setErrno(0);
        }else {
            baseRespVo.setErrmsg("喂领取过啦！");
            baseRespVo.setErrno(740);
        }
        return baseRespVo;
    }

    //兑换用户优惠券
    @RequestMapping(value = "wx/coupon/exchange", method = RequestMethod.POST)
    public BaseRespVo exchangeCoupon(@RequestBody Coupon coupon){
        BaseRespVo baseRespVo = new BaseRespVo();
        boolean flag = couponService.exchangeCoupon(coupon.getCode());
        if (flag){
            baseRespVo.setErrmsg("dnmd你兑换成功了！");
            baseRespVo.setErrno(0);

//            return BaseRespVo.fail(1,"dnmd你兑换成功了！" );
        } else {
            baseRespVo.setErrmsg("优惠码错啦！真的嗷！");
            baseRespVo.setErrno(742);
//            return BaseRespVo.fail(742,"优惠码错啦！！" );

        }
        return baseRespVo;
    }

    //用户下单选择优惠券
    @RequestMapping(value = "wx/coupon/selectlist", method = RequestMethod.GET)
    public BaseRespVo receiveCoupon(int cartId, int grouponRulesId){
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(502);
        baseRespVo.setErrmsg("System Error!");
        return baseRespVo;
    }

}
