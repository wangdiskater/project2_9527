package com.cskaoyan.service.wx.cart;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.CartMapper;
import com.cskaoyan.mapper.ConfigMapper;
import com.cskaoyan.utils.AdDataToFront;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.ad.AdGoodsVo;
import com.cskaoyan.vo.cart.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/5
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    ConfigMapper configMapper;
    /**
     * @return 显示加载购物车信息
     */
    @Override
    public BaseRespVo showAllCartGoods() {
        List<CartBean> cartBeans = cartMapper.showCarts();
        List<CartsBeanVo> list = new ArrayList<>();
        CartsInfo cartsInfo = new CartsInfo();
        CartTotalVo cartTotalVo = new CartTotalVo();
        double goodsAmount = 0;
        int goodsCount = 0;
        double uncheckAmount = 0;
        int uncheckCount = 0;
        if (cartBeans != null){
            for (CartBean cartBean : cartBeans) {
                if (! cartBean.getDeleted()){
                    CartsBeanVo cartsBeanVo = new CartsBeanVo(cartBean);
                    list.add(cartsBeanVo);
                    int number = cartBean.getNumber();
                    double price = cartBean.getPrice();
                    if (cartBean.getChecked()){
                        goodsAmount += (number * price);
                        goodsCount += number;
                    }
                    uncheckAmount += (number * price);
                    uncheckCount += number;
                }
            }
        }
        cartTotalVo.setGoodsAmount(uncheckAmount);
        cartTotalVo.setGoodsCount(uncheckCount);
        cartTotalVo.setCheckedGoodsAmount(goodsAmount);
        cartTotalVo.setCheckedGoodsCount(goodsCount);
        cartsInfo.setCartList(list);
        cartsInfo.setCartTotal(cartTotalVo);
        return BaseRespVo.success(cartsInfo);
    }

    /**
     * @param products 选择或取消购物车商品
     * @return
     */
    @Override
    public BaseRespVo cartChecked(Products products) {
        List<Integer> productIds = products.getProductIds();
        int checked = products.getIsChecked();
        if (checked == 0 && productIds != null){
            for (Integer productId : productIds) {
                cartMapper.cancelChecked(productId);
            }
        }else {
            for (Integer productId : productIds) {
                cartMapper.Checked(productId);
            }
        }
        return showAllCartGoods();
    }

    /**
     * @param product 更新购物车商品
     * @return
     */
    @Override
    public BaseRespVo updateGoodsCount(UpdateProduct product) {
        int id = product.getId();
        int number = product.getNumber();
        int count = cartMapper.updateGoodsCount(id, number);
        if (count != 0){
            return showAllCartGoods();
        }
        return BaseRespVo.fail();
    }

    /**
     * @param products 删除购物车商品
     * @return
     */
    @Override
    public BaseRespVo deleteCart(Products products) {
        List<Integer> productIds = products.getProductIds();
        if (productIds != null){
            for (Integer productId : productIds) {
                cartMapper.deleteCart(productId);
            }
        }
        return showAllCartGoods();
    }

    /**
     * @return 加载显示购物车中的数量
     */
    @Override
    public BaseRespVo goodscount() {
        List<CartBean> cartBeans = cartMapper.showCarts();
        int uncheckCount = 0;
        if (cartBeans != null){
            for (CartBean cartBean : cartBeans) {
                int number = cartBean.getNumber();
                uncheckCount += number;
            }
        }
        return BaseRespVo.success(uncheckCount);
    }

    /**
     * @param addGoods
     * @param userId
     * @return  添加购物商品
     */
    @Override
    public BaseRespVo addCart(Fastadd addGoods, int userId) {
        int goodsId = addGoods.getGoodsId();
        int number = addGoods.getNumber();
        int productId = addGoods.getProductId();
        AddCarts addCarts = new AddCarts(userId,goodsId,productId,number);
        if (addGoods.getProductId() != 0){
            AddDataFromGoods addDataFromGoods = cartMapper.queryGoods(goodsId);
            AddDataFromProduct specifications = cartMapper.queryGoodsProduct(goodsId);
            addCarts.setGoods_sn(addDataFromGoods.getGoods_sn());
            addCarts.setName(addDataFromGoods.getName());
            addCarts.setRetail_price(addDataFromGoods.getRetail_price());
            addCarts.setPic_url(addDataFromGoods.getPic_url());
            addCarts.setSpecifications(specifications.getSpecifications());
            addCarts.setChecked(1);
        }
        int goods_id = addCarts.getGoods_id();
        CartBean info = cartMapper.queryCartInfo(goods_id);
        if (info == null && addCarts != null){
            cartMapper.addCarts(addCarts);
        }else {
            // 如果之前已经有同一商品，修改其数量，和时间
            int goodsNumber = cartMapper.queryGoodsNumber(goods_id);
            int cartsNumber = addCarts.getNumber();
            addCarts.setNumber(goodsNumber + cartsNumber);
            cartMapper.updateCarts(goods_id,addCarts);
        }
        List<CartBean> cartBeans = cartMapper.showCarts();
        int uncheckCount = 0;
        if (cartBeans != null){
            for (CartBean cartBean : cartBeans) {
                int cartNumber = cartBean.getNumber();
                uncheckCount += cartNumber;
            }
        }
        return BaseRespVo.success(uncheckCount);
    }

    /**
     * @param addGoods
     * @param userId
     * @return  快速购买商品
     */
    @Override
    public BaseRespVo fastadd(Fastadd addGoods, int userId) {
        int goodsId = addGoods.getGoodsId();
        int number = addGoods.getNumber();
        int productId = addGoods.getProductId();
        AddCarts addCarts = new AddCarts(userId,goodsId,productId,number);
        if (addGoods.getProductId() != 0){
            AddDataFromGoods addDataFromGoods = cartMapper.queryGoods(goodsId);
            AddDataFromProduct specifications = cartMapper.queryGoodsProduct(goodsId);
            addCarts.setGoods_sn(addDataFromGoods.getGoods_sn());
            addCarts.setName(addDataFromGoods.getName());
            addCarts.setRetail_price(addDataFromGoods.getRetail_price());
            addCarts.setPic_url(addDataFromGoods.getPic_url());
            addCarts.setSpecifications(specifications.getSpecifications());
            addCarts.setChecked(1);
        }
        int goods_id = addCarts.getGoods_id();
        CartBean info = cartMapper.queryCartInfo(goods_id);
        int id = 0;
        if (info == null && addCarts != null){
            cartMapper.addCarts(addCarts);
             id = addCarts.getId();
        }else {
            // 如果之前已经有同一商品，修改其数量，和时间
//            int goodsNumber = cartMapper.queryGoodsNumber(goods_id);
            int cartsNumber = addCarts.getNumber();
            addCarts.setNumber(cartsNumber);
            cartMapper.updateCarts(goods_id,addCarts);
            CartBean cartBean = cartMapper.queryCartInfo(goods_id);
            id = cartBean.getId();
        }
        return BaseRespVo.success(id);
    }

    /**
     * @param cartId
     * @param addressId
     * @param couponId
     * @param grouponRulesId
     * @return  下单前信息确认
     */
    @Override
    public BaseRespVo checkout(int cartId, int addressId, int couponId, int grouponRulesId) {
        String freightMin = configMapper.queryFreightMin();//包邮最低订单费用
        String freightValue = configMapper.queryFreightValue();//不包邮的订单费用
        int orderId = 0;

        Session session2 = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session2.getAttribute("userId");
        if(userId == null){
            return BaseRespVo.fail(100,"登陆过期");
        }

        double goodsTotalPrice = 0;
        double actualPrice = 0;
        double orderTotalPrice = 0;
        double freightPrice = 0;  // 设置为0 ， 默认包邮
        double couponPrice = 0;
        double grouponPrice = 0;
        int availableCouponLenth = 0;
        ArrayList<AdGoodsVo> list = new ArrayList<>();
        Address addressinfo = null;
        CheckoutVo vo = new CheckoutVo();

        // 这里是购物车中下单的逻辑
        if (cartId == 0) {
            List<CartBean> cartBeans = cartMapper.queryAllChecked();
            //删除购物车所有选中商品
//            int delete = cartMapper.deleteAllchecked();

            if (cartBeans != null){
                for (CartBean bean : cartBeans) {

                    goodsTotalPrice += bean.getNumber() * bean.getPrice();
                    orderTotalPrice = goodsTotalPrice;
                    AdGoods goods = cartMapper.checkGoodsList(bean.getGoods_id());
                    AdGoodsVo goodsVo = AdDataToFront.ConvertAdGoodsVo(goods);
                    goodsVo.setGoodsName(bean.getGoods_name());
                    goodsVo.setNumber(bean.getNumber());
                    goodsVo.setSpecifications(bean.getSpecifications());
                    goodsVo.setPrice(bean.getPrice());
                    list.add(goodsVo);


                }
            }
            if (addressId != 0){
                addressinfo = cartMapper.queryUserAddress(addressId);
                CartAddressVo checkedAddress = new CartAddressVo(addressinfo);
                vo.setCheckedAddress( checkedAddress);
            }else {
                vo.setCheckedAddress(new CartAddressVo());
            }
            if (couponId > 0){
                Coupon coupon = cartMapper.queryCoupon(couponId);
                availableCouponLenth = coupon.getTotal();
                couponPrice = coupon.getDiscount();
            }
            if (grouponRulesId > 0){
                GrouponRules rules = cartMapper.queryGrouponRules(grouponRulesId);
                grouponPrice = rules.getDiscount();
            }
            //商品本来的价格是否包邮，然后再减
            if (orderTotalPrice < Integer.valueOf(freightMin)){
                freightPrice = Integer.valueOf(freightValue);
            }
            actualPrice = orderTotalPrice + freightPrice - grouponPrice;

            vo.setCheckedGoodsList(list);
            vo.setAvailableCouponLength(availableCouponLenth);
            vo.setActualPrice(actualPrice);
            vo.setCouponPrice(couponPrice);
            vo.setGrouponPrice(grouponPrice);
            vo.setFreightPrice(freightPrice);
            vo.setGoodsTotalPrice(goodsTotalPrice);
            vo.setOrderTotalPrice(orderTotalPrice);
            vo.setAddressId(addressId);
            vo.setCouponId(couponId);
            vo.setGrouponRulesId(grouponRulesId);
//            return BaseRespVo.success(vo);

            // 下方开始插入order表和order_goods表信息
/*            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = format.format(date);
            String uu = time + (int)(Math.random() * 9 + 1) * 1000;
            int i = 0;
            int j = 0;
            for (CartBean cartBean : cartBeans) {
                AddOrder order = new AddOrder();
                order.setUser_id(userId);
                order.setOrder_sn(uu);
                order.setOrder_status(101);  // 写死101状态
                order.setConsignee(addressinfo.getName());
                order.setMobile(addressinfo.getMobile());
                order.setAddress(addressinfo.getAddress());
                order.setMessage("空");  // 写死了
                order.setGoods_price(goodsTotalPrice);
                order.setFreight_price(freightPrice);
                order.setCoupon_price(couponPrice);
                order.setIntegral_price(0);  // 写死了
                order.setGroupon_price(grouponPrice);
                order.setOrder_price(orderTotalPrice);
                order.setActual_price(actualPrice);
                if (i == 0){
                    // order表中只插入一次下单记录
                    i = cartMapper.AddOrder(order);
                    orderId = order.getId();
                }
                 j = cartMapper.AddOrderGoods(orderId, cartBean);
            }
            if (i == 0 && j == 0){
                return BaseRespVo.fail();
            }*/

            return BaseRespVo.success(vo);


        //点击快速购买
        }else {
            // 这里是点击快速购买时的逻辑
            CartBean cartBean = cartMapper.showCartInfo(cartId);
            CartBean cart = cartMapper.queryCart(cartId);


            if (cartBean != null){


                goodsTotalPrice = cartBean.getNumber() * cartBean.getPrice();
                orderTotalPrice = goodsTotalPrice;
                AdGoods goods = cartMapper.checkGoodsList(cartBean.getGoods_id());
                AdGoodsVo goodsVo = AdDataToFront.ConvertAdGoodsVo(goods);
                goodsVo.setGoodsName(cart.getGoods_name());
                goodsVo.setNumber(cart.getNumber());
                goodsVo.setSpecifications(cart.getSpecifications());
                goodsVo.setPrice(cart.getPrice());
                list.add(goodsVo);
            }
            if (addressId != 0){
                addressinfo = cartMapper.queryUserAddress(addressId);
                CartAddressVo checkedAddress = new CartAddressVo(addressinfo);
                vo.setCheckedAddress( checkedAddress);
            }else {
                vo.setCheckedAddress(new CartAddressVo());
            }
            if (couponId > 0){
                Coupon coupon = cartMapper.queryCoupon(couponId);
                availableCouponLenth = coupon.getTotal();
                couponPrice = coupon.getDiscount();
            }
            if (grouponRulesId > 0){
                GrouponRules rules = cartMapper.queryGrouponRules(grouponRulesId);
                grouponPrice = rules.getDiscount();
            }
            //商品本来的价格是否包邮，然后再减
            if (orderTotalPrice < Integer.valueOf(freightMin)){
                freightPrice = Integer.valueOf(freightValue);
            }
            actualPrice = orderTotalPrice + freightPrice - grouponPrice;

            vo.setCheckedGoodsList(list);
            vo.setAvailableCouponLength(availableCouponLenth);
            vo.setActualPrice(actualPrice);
            vo.setCouponPrice(couponPrice);
            vo.setGrouponPrice(grouponPrice);
            vo.setFreightPrice(freightPrice);
            vo.setGoodsTotalPrice(goodsTotalPrice);
            vo.setOrderTotalPrice(orderTotalPrice);
            vo.setAddressId(addressId);
            vo.setCouponId(couponId);
            vo.setGrouponRulesId(grouponRulesId);


            return BaseRespVo.success(vo);
        }
//        return null;
    }

}
