package com.cskaoyan.service.wx.order;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.order.WxOrderCommentVo;
import com.cskaoyan.vo.wx.order.WxOrderSearchVo;
import com.cskaoyan.vo.wx.order.WxOrderSubmitVo;

import java.text.ParseException;

public interface WxOrderService {
    //显示订单
    BaseRespVo orderList(WxOrderSearchVo orderSearchVo, int userId) throws ParseException;

    //显示订单详情
    BaseRespVo orderDetail(int orderId) throws ParseException;

    //订单取消
    BaseRespVo orderCancel(int orderId);

    //订单退款
    BaseRespVo orderRefund(int orderId);

    //删除订单
    BaseRespVo orderDelete(int orderId);

    //确认收货
    BaseRespVo orderConfrim(int orderId);

    //获取评论的商品
    BaseRespVo orderGoods(int orderId, int goodsId);

    //写入评论
    BaseRespVo orderComment(WxOrderCommentVo wxOrderCommentVo);

    //订单提交
    BaseRespVo orderSubmit(WxOrderSubmitVo wxOrderSubmitVo);

    //支付订单
    BaseRespVo orderPrepay(Integer orderId);
}
