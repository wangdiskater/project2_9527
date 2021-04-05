package com.cskaoyan.mapper;

import com.cskaoyan.bean.Order;
import com.cskaoyan.vo.comment.CommentVo;
import com.cskaoyan.vo.wx.order.WxOrderCommentGoodsVo;
import com.cskaoyan.vo.wx.order.WxOrderDetailGoods;
import com.cskaoyan.vo.wx.order.WxOrderGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @ClassName WxOrderMapper
 * @Description 微信订单相关的
 * @Author wangdi
 * @Date 2019/10/6 11:21
 **/

public interface WxOrderMapper {

    //获取所有Order信息
    List<Order> queryOrderByUserId(@Param("userId") int userId,@Param("statusType")int showType);

    //通过OrderId 查找订单商品
    List<WxOrderGoodsVo> queryOrderGoodsByOrderId(@Param("orderId") int id);

    //通过订单id查找订单
    Order queryOrderById(@Param("orderId") int orderId);

    //通过订单Id 查找详细订单商品
    List<WxOrderDetailGoods> queryOrderDetailGoodsByOrderId(@Param("orderId") int orderId);

    //更新订单状态---取消订单
    int updateOrderStateCancelById(@Param("orderId") int orderId,
                                     @Param("orderStatus") int orderStatus,
                                     @Param("updateTime") Date updateTime);

    int updateOrderStateRefundById(@Param("orderId") int orderId,
                                   @Param("orderStatus") int orderStatus,
                                   @Param("updateTime") Date updateTime);
    //删除订单
    int deleteOrderById(@Param("orderId")int orderId);

    //删除订单里的商品
    int deleteOrderGoodsByOrderId(@Param("orderId")int orderId);

    //获取订单商品个数
    int queryOrderGoodsCountByOrderId(@Param("orderId") int orderId);

    //用户确认收货
    int updateOrderStateConfrimById(@Param("orderId") int orderId,
                                    @Param("goodsNum") int goodsNum,
                                    @Param("orderStatus") int orderStatus,
                                    @Param("updateTime") Date updateTime);
    //查询单个商品
    WxOrderCommentGoodsVo queryOrderSingleGoods(@Param("orderId") int orderId,
                                                @Param("goodsId") int goodsId);
    //插入评论信息
    int insertComment(@Param("comment") CommentVo commentVo);

    //给商品添加comment信息
    int updateOrderGoodsComment(@Param("orderGoodsId") int orderGoodsId,
                                @Param("commentId") int id);
    //修改订单comments
    int updateOrderComment(@Param("orderId") int orderId);

    //库存增加
    int updateGoodsProductNum(@Param("goodsId") int goodsId, @Param("number") int number);

    //删除购物车
    int deleteCartById(@Param("cartId") int cartId);

    //更新用户提交信息
    int updateOrderMessageById(@Param("message") String message, @Param("orderId") int orderId);

    //更新用户支付后的状态
    int updateOrderStateById(@Param("order") Order order);

    //更新时间超时订单状态103
    int updateOrderStatusToCancelById(@Param("orderId")int id);

    //取消评论设comments等于0
    int queryOrderStatusCancelComments(@Param("orderId") int orderId);
}
