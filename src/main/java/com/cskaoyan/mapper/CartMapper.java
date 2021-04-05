package com.cskaoyan.mapper;

import com.cskaoyan.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description 购物车
 * @Date 2019/10/5
 */

public interface CartMapper {
    // 查询购物车信息
    List<CartBean> showCarts();

    // 选择或取消购物车商品
    void cancelChecked(@Param("productId") Integer productId);
    // 选择或取消购物车商品
    void Checked(@Param("productId") Integer productId);

    int updateGoodsCount(@Param("id") int id,
                         @Param("number") int number);

    void deleteCart(@Param("productId") Integer productId);

    int queryGoodsAttributeId(@Param("gooodsId") int gooodsId);

    AddDataFromGoods queryGoods(@Param("goodsId") int goodsId);

    AddDataFromProduct queryGoodsProduct(@Param("goodsId") int goodsId);

    int addCarts(@Param("addCarts") AddCarts addCarts);

    CartBean queryCartInfo(@Param("goodsId") int goodsId);


    int updateCarts(@Param("goodsId") int goodsId,
                    @Param("addCarts") AddCarts addCarts);

    int queryGoodsNumber(@Param("goodsId")int goodsId);

    CartBean showCartInfo(@Param("cartId") int cartId);

    AdGoods checkGoodsList(@Param("goodsId") int goodsId);

    Address queryUserAddress(@Param("addressId") int addressId);

    Coupon queryCoupon(@Param("couponId") int couponId);

    GrouponRules queryGrouponRules(@Param("grouponRulesId") int grouponRulesId);

    CartBean queryCart(@Param("cartId") int cartId);

    int AddOrder(@Param("order") AddOrder order);

    int AddOrderGoods(@Param("orderId") int orderId,
                      @Param("cart") CartBean cartBean);

    List<CartBean> queryAllChecked();

    //删除购物车中选中的商品
    int deleteAllchecked();

    //减少库存
    int reduceProductById(@Param("id") int product_id, @Param("number") int number);

    //返回对应的货物库存是否足够
    int queryProductNumById(int product_id);

    //通过cartId拿到cart的商品
    List<CartBean> queryByCartId(@Param("cartId") int cartId);
}
