package com.cskaoyan.vo.order;

import com.cskaoyan.vo.user.UserVo;

import java.util.List;

/**
 * @version 1.0
 * @ClassName OrderDetailVo
 * @Description 订单详情最终返回给前端的vo
 * @Author wangdi
 * @Date 2019/10/1 19:32
 **/

public class OrderDetailVo {
    List<OrderGoodsVo> orderGoods;
    UserVo user;
    OrderVo order;

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "orderGoods=" + orderGoods +
                ", user=" + user +
                ", order=" + order +
                '}';
    }

    public List<OrderGoodsVo> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoodsVo> orderGoods) {
        this.orderGoods = orderGoods;
    }


    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public OrderVo getOrder() {
        return order;
    }

    public void setOrder(OrderVo order) {
        this.order = order;
    }
}
