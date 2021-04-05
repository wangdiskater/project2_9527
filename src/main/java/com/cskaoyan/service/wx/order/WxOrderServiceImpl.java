package com.cskaoyan.service.wx.order;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.CartMapper;
import com.cskaoyan.mapper.ConfigMapper;
import com.cskaoyan.mapper.WxOrderMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.cart.CartAddressVo;
import com.cskaoyan.vo.comment.CommentVo;
import com.cskaoyan.vo.wx.order.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version 1.0
 * @ClassName WxOrderServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/6 11:37
 **/

@Service
public class WxOrderServiceImpl implements WxOrderService {

    @Autowired
    WxOrderMapper wxOrderMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    ConfigMapper configMapper;
    /* *
     * 功能描述 显示订单
     * @author wangdi
     * @date 2019/10/6 11:41
     * @param orderSearchVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderList(WxOrderSearchVo orderSearchVo, int userId) throws ParseException {

        int orderUnpaid = Integer.valueOf(configMapper.queryOrderUnpaid());//下单超时分钟
        int orderUnconfirm = Integer.valueOf(configMapper.queryOrderUnconfirm());//订单发货后超期天数
        int orderComment = Integer.valueOf(configMapper.queryOrderComment());//确认收货后可以评论过期天数

        Integer showType = orderSearchVo.getShowType();
        //先查数据
        List<Order> orders = wxOrderMapper.queryOrderByUserId(userId,showType);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //查询订单是否有过期问题
        for (Order order : orders) {
            int order_status = order.getOrder_status();
            int orderId = order.getId();
            //判断订单是否过期
            if(order_status == 101){
                String add_time = order.getAdd_time();
                Date now = new Date();
                Date parse = simpleDateFormat.parse(add_time);
                long micsecond = now.getTime() - parse.getTime();
                if(micsecond > orderUnpaid*60*1000){

                   int updateStatus =  wxOrderMapper.updateOrderStatusToCancelById(orderId);

                }
            }
            //判断订单是否自动收货 ---- 自动收货后开启评论
            if(order_status == 301){
                String ship_time = order.getShip_time();
                Date now = new Date();
                Date parse = simpleDateFormat.parse(ship_time);
                long micsecond = now.getTime() - parse.getTime();
                if(micsecond > orderUnconfirm*24*60*60*1000){
                    //自动收货 获取商品数量
                    int orderStatus = 402;
                    Date updateTime = new Date();
                    int goodsNum = wxOrderMapper.queryOrderGoodsCountByOrderId(orderId);
                    int update = wxOrderMapper.updateOrderStateConfrimById(orderId,goodsNum,orderStatus,updateTime);
                }
            }

            //判断订单是否超时 关闭评论
            if(order_status == 401 || order_status == 402){
                String confirm_time = order.getConfirm_time();
                Date now = new Date();
                Date parse = simpleDateFormat.parse(confirm_time);
                long micsecond = now.getTime() - parse.getTime();
                if(micsecond > orderComment*24*60*60*1000){
                    //收货后超时 不可评价
                   int updateComment = wxOrderMapper.queryOrderStatusCancelComments(orderId);

                }
            }

        }


        //再次查询 进行操作
        PageHelper.startPage(orderSearchVo.getPage(),orderSearchVo.getSize());
        orders = wxOrderMapper.queryOrderByUserId(userId,showType);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        //获取总数
        int total = (int) orderPageInfo.getTotal();
        //获取页数
        int pages = orderPageInfo.getPages();

        List<WxOrderListVo> data = new ArrayList<>();
        for (Order order : orders) {
            WxOrderListVo wxOrderListVo = new WxOrderListVo();
            int order_status = order.getOrder_status();
            wxOrderListVo.setOrderStatusText(getStatusTextByCode(order_status));

            //通过是否有团购的优惠价格来判断是否有团购
            if(order.getGroupon_price() == 0.0){
                wxOrderListVo.setGroupin(false);
            }else {
                wxOrderListVo.setGroupin(true);
            }
            wxOrderListVo.setOrderSn(order.getOrder_sn());
            wxOrderListVo.setActualPrice(order.getActual_price());
            List<WxOrderGoodsVo> goodsList = wxOrderMapper.queryOrderGoodsByOrderId(order.getId());
            wxOrderListVo.setGoodsList(goodsList);
            wxOrderListVo.setId(order.getId());
            WxOrderHandleOption wxOrderHandleOption = new WxOrderHandleOption(order);
            wxOrderListVo.setHandleOption(wxOrderHandleOption);

            data.add(wxOrderListVo);


        }

        WxOrderShowVo wxOrderShowVo = new WxOrderShowVo(data,total,pages);

        return BaseRespVo.success(wxOrderShowVo);
    }

    /* *
     * 功能描述 显示订单详情
     * @author wangdi
     * @date 2019/10/6 16:23
     * @param orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderDetail(int orderId) throws ParseException {
        Order order = wxOrderMapper.queryOrderById(orderId);
        WxOrderInfoVo wxOrderInfoVo = new WxOrderInfoVo(order);
        List<WxOrderDetailGoods> orderGoods = wxOrderMapper.queryOrderDetailGoodsByOrderId(orderId);
        WxOrderHandleOption wxOrderHandleOption = new WxOrderHandleOption(order);
        wxOrderInfoVo.setHandleOption(wxOrderHandleOption);
        WxOrderExpressVo wxOrderExpressVo = new WxOrderExpressVo(order);

        WxOrderDetailShowVo wxOrderDetailShowVo = new WxOrderDetailShowVo(wxOrderInfoVo,orderGoods,wxOrderExpressVo);

        return BaseRespVo.success(wxOrderDetailShowVo);
    }
    /* *
     * 功能描述 订单取消
     * 1.修改状态
     * 2.修改库存
     *
     * @author wangdi
     * @date 2019/10/6 20:38
     * @param orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderCancel(int orderId) {
        int orderStatus = 102;
        Date updateTime = new Date();
        //1.修改状态
        int update = wxOrderMapper.updateOrderStateCancelById(orderId,orderStatus,updateTime);
        if(update != 1){
            return BaseRespVo.fail();
        }
        //2.库存增加
        boolean flag = updateProduct(orderId);

        if(flag){

            return BaseRespVo.success("");
        }
        return BaseRespVo.fail();
    }

    /* *
     * 功能描述 订单退款
     * @author wangdi
     * @date 2019/10/6 21:05
     * @param orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderRefund(int orderId) {
        int orderStatus = 202;
        Date updateTime = new Date();
        //1.修改状态
        int update = wxOrderMapper.updateOrderStateRefundById(orderId,orderStatus,updateTime);
        if(update != 1){
            return BaseRespVo.fail();
        }
        //2.库存增加
        boolean flag = updateProduct(orderId);
        if(flag){

            return BaseRespVo.success("");
        }
        return BaseRespVo.fail();
    }

    /* *
     * 功能描述  订单删除 --- 订单商品也要删除
     * @author wangdi
     * @date 2019/10/6 21:15
     * @param orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderDelete(int orderId) {

        int delete = wxOrderMapper.deleteOrderById(orderId);
        int goodsDelete = wxOrderMapper.deleteOrderGoodsByOrderId(orderId);

        if(delete == 1 && goodsDelete == 1){
            return BaseRespVo.success("");
        }
//        return BaseRespVo.fail(100,"删个香蕉船，本来就没数据了") ;
        return BaseRespVo.fail();
    }

    /* *
     * 功能描述  确认收货 --- 确认收货之后，查看订单商品的数量。修改comments可以评论商品的数量
     * @author wangdi
     * @date 2019/10/6 21:27
     * @param orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderConfrim(int orderId) {
        int orderStatus = 401;
        Date updateTime = new Date();
        int goodsNum = wxOrderMapper.queryOrderGoodsCountByOrderId(orderId);
        int update = wxOrderMapper.updateOrderStateConfrimById(orderId,goodsNum,orderStatus,updateTime);
        if(update == 1){
            return BaseRespVo.success("");
        }
        return null;
    }

    /* *
     * 功能描述 返回订单中的商品
     * @author wangdi
     * @date 2019/10/6 22:16
     * @param orderId
     * @param goodsId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderGoods(int orderId, int goodsId) {
        WxOrderCommentGoodsVo orderGoods = wxOrderMapper.queryOrderSingleGoods(orderId,goodsId);
        return BaseRespVo.success(orderGoods);
    }

    /* *
     * 功能描述 商品评论 --- 需要修改：
     * 1.comment表插入值   ---  注意valueId是 goodsId
     * 2.order_goods comment = comment表中的Id
     * 3.order comments -1
     *
     * @author wangdi
     * @date 2019/10/6 22:50
     * @param wxOrderCommentVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderComment(WxOrderCommentVo wxOrderCommentVo) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
//        Integer userId = 1 ;
        if(userId == null){
            return BaseRespVo.fail(100,"登陆过期，请登陆");
        }

        int orderId = wxOrderCommentVo.getOrderId();
        int orderGoodsId = wxOrderCommentVo.getOrderGoodsId();

        //1.comment表中插入值
        CommentVo commentVo = new CommentVo(wxOrderCommentVo,userId);
        int insert = wxOrderMapper.insertComment(commentVo);
        //2.修改order_goods中的comment
        int update = wxOrderMapper.updateOrderGoodsComment(orderGoodsId,commentVo.getId());
       //3.修改order 的comments 减一
        int updateOrder = wxOrderMapper.updateOrderComment(orderId);

        if(insert ==1 && update==1 && updateOrder==1 ){
            return BaseRespVo.success("");
        }
        return null;
    }

    /* *
     * 功能描述 提交订单
     * @author wangdi
     * @date   2019/10/7 23:38
     * @param wxOrderSubmitVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderSubmit(WxOrderSubmitVo wxOrderSubmitVo) {
        String freightMin = configMapper.queryFreightMin();//包邮最低订单费用
        String freightValue = configMapper.queryFreightValue();//不包邮的订单费用

        //有优惠卷
        int couponId = wxOrderSubmitVo.getCouponId();
        if(couponId > 0){
        }
        //如果有团购
        int grouponLinkId = wxOrderSubmitVo.getGrouponLinkId();
        int grouponRulesId= wxOrderSubmitVo.getGrouponRulesID();
        if(grouponLinkId >0){

        }

        int orderId =0;
        String message = wxOrderSubmitVo.getMessage();
        int addressId = wxOrderSubmitVo.getAddressId();


        //添加订单信息---订单状态101
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(date);
        String uu = time + (int)(Math.random() * 9 + 1) * 1000;
        int i = 0;
        int j = 0;

        Session session2 = SecurityUtils.getSubject().getSession();
        Integer userId = (int) session2.getAttribute("userId");
        if(userId == null){
            return BaseRespVo.fail(100,"登陆过期");
        }
        double goodsTotalPrice = 0;
        double actualPrice = 0;
        double orderTotalPrice = 0;
        double freightPrice = 0;  // 设置为0 ， 默认包邮
        double couponPrice = 0;
        double grouponPrice = 0;

        Address addressinfo = null;

        int cartId = wxOrderSubmitVo.getCartId();
        List<CartBean> cartBeans = null;
        //从购物车选择多个商品下单
        if(cartId == 0){
            cartBeans = cartMapper.queryAllChecked();
            int delete = cartMapper.deleteAllchecked();

        //直接下单
        } else {
            cartBeans = cartMapper.queryByCartId(cartId);
            int delete = wxOrderMapper.deleteCartById(cartId);

        }
        for (CartBean cartBean : cartBeans) {

            //判断库存是否足够
            int dbNum = cartMapper.queryProductNumById(cartBean.getProduct_id());
            if(dbNum < cartBean.getNumber()){
                //返回库存不足
                return BaseRespVo.fail();
            }

            //对应的商品的库存减少
            int update = cartMapper.reduceProductById(cartBean.getProduct_id(),cartBean.getNumber());
            if(update != 1){
                return BaseRespVo.fail(20,"商品库存有问题");
            }


            goodsTotalPrice += cartBean.getNumber() * cartBean.getPrice();
            orderTotalPrice = goodsTotalPrice;


            if (addressId > 0){
                addressinfo = cartMapper.queryUserAddress(addressId);
            }

            if (couponId > 0){
                Coupon coupon = cartMapper.queryCoupon(couponId);
                couponPrice = coupon.getDiscount();
            }
            if (grouponRulesId > 0){
                GrouponRules rules = cartMapper.queryGrouponRules(grouponRulesId);
                grouponPrice = rules.getDiscount();
            }
            if (actualPrice < Integer.valueOf(freightMin)){
                freightPrice = Integer.valueOf(freightValue);
            }
            actualPrice = orderTotalPrice + freightPrice;
            AddOrder order = new AddOrder();
            order.setUser_id(userId);
            order.setOrder_sn(uu);
            order.setOrder_status(101);  // 写死101状态
            order.setConsignee(addressinfo.getName());
            order.setMobile(addressinfo.getMobile());
            order.setAddress(addressinfo.getAddress());
//            order.setMessage("空");  // 写死了
            order.setMessage(message);
            order.setGoods_price(goodsTotalPrice);
            order.setFreight_price(freightPrice);
            order.setCoupon_price(couponPrice);
            order.setIntegral_price(0);  // 积分减免默认0
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
        if (i == 0 || j == 0){
            return BaseRespVo.fail();
        }
        HashMap<Object, Object> map = new HashMap<>();
        map.put("orderId",orderId);
        return BaseRespVo.success(map);

    }

    /* *
     * 功能描述 订单支付
     * @author wangdi
     * @date   2019/10/8 0:22
     * @param orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderPrepay(Integer orderId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String random = (Math.random() * 9 + 1) * 1000 + "";
        Order order = new Order();
        //用户支付更新状态
        order.setId(orderId);
        order.setOrder_status(201);
        order.setUpdate_time(simpleDateFormat.format(new Date()));
        order.setPay_time(simpleDateFormat.format(new Date()));
        order.setPay_id(simpleDateFormat.format(new Date()) + random);

        int update = wxOrderMapper.updateOrderStateById(order);
        WxOrderPayVo wxOrderPayVo = new WxOrderPayVo();
        wxOrderPayVo.setTimeStamp("20190713");
        wxOrderPayVo.setNonceStr("q23123123");
        wxOrderPayVo.setPackageValue("q23123123");
        wxOrderPayVo.setPaySign("q23123123");
        wxOrderPayVo.setSignType("q23123123");



        return BaseRespVo.success(wxOrderPayVo);
    }

    /* *
     * 功能描述  订单取消，退货，库存增加
     * @author wangdi
     * @date 2019/10/7 9:51
     * @param orderId
     * @return boolean
     */
    private boolean updateProduct(int orderId) {
        List<WxOrderGoodsVo> wxOrderGoodsVos = wxOrderMapper.queryOrderGoodsByOrderId(orderId);

        //2.库存增加
        for (WxOrderGoodsVo wxOrderGoodsVo : wxOrderGoodsVos) {

            int updateProduct = wxOrderMapper.updateGoodsProductNum(wxOrderGoodsVo.getGoodsId(),wxOrderGoodsVo.getNumber());
            if(updateProduct != 1){
                return false;
            }
        }
        return true;
    }

    /* *
     * 功能描述  通过数据的订单状态码返回不同的订单状态
     * @author wangdi
     * @date 2019/10/6 13:10
     * @param order_status
     * @return java.lang.String
     */
    private String getStatusTextByCode(int order_status) {
        String status = null;
        switch (order_status){
            case 101:{
                status = "未付款";
                break;
            }
            case 102:{
                status = "用户取消";
                break;
            }
            case 103:{
                status = "系统取消";
                break;
            }
            case 201:{
                status = "已付款";
                break;
            }
            case 202:{
                status = "申请退款";
                break;
            }
            case 203:{
                status = "已退款";
                break;
            }
            case 301:{
                status = "已发货";
                break;
            }
            case 401:{
                status = "用户收货";
                break;
            }
            case 402:{
                status = "系统收货";
                break;
            }
            default:{
                status = "";
            }
        }
        return status;
    }
}
