package com.cskaoyan.controller.admin.stat;

import com.cskaoyan.service.admin.stat.StatGoodsService;
import com.cskaoyan.service.admin.stat.StatOrderService;
import com.cskaoyan.service.admin.stat.StatUserService;
import com.cskaoyan.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/9/30
 */
@RestController
@RequestMapping("admin")
public class StatController {

    @Autowired
    StatUserService userService;

    /**
     *  获取用户统计数据
     */
    @RequestMapping("stat/user")
    public BaseRespVo statUser(){
        return userService.statUser();
    }

    @Autowired
    StatOrderService statOrderService;

    /**
     * 获取订单统计数据
     */
    @RequestMapping("stat/order")
    public BaseRespVo statOrder(){
        return statOrderService.queryAllOrder();
    }

    @Autowired
    StatGoodsService statGoodsService;
    @RequestMapping("stat/goods")
    public BaseRespVo statGoods(){
        return statGoodsService.queryAllGoods();
    }
}
