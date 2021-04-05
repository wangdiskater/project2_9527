package com.cskaoyan.controller.wx.order;

import com.cskaoyan.service.wx.order.WxOrderService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.order.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName WxOrderController
 * @Description 小程序订单控制
 * @Author wangdi
 * @Date 2019/10/6 11:31
 **/

@RequestMapping("/wx")
@RestController
public class WxOrderController {

    @Autowired
    WxOrderService wxOrderService;

    /* *
     * 功能描述 显示用户的订单
     * @author wangdi
     * @date 2019/10/6 16:21
     * @param showType 0是所有1 是未付款 2 是未发货 3 未收货 4待评价  大类
     * @param page
     * @param size
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/list",method = RequestMethod.GET)
    public BaseRespVo orderList(Integer showType,Integer page, Integer size) throws ParseException {
        WxOrderSearchVo orderSearchVo = new WxOrderSearchVo(showType, page, size);
        Session session = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session.getAttribute("userId");
//        Integer userId = 1;
        if(userId == null){
            return BaseRespVo.fail(100,"登陆过期，请登陆");
        }
        return wxOrderService.orderList(orderSearchVo,userId);
    }

    /* *
     * 功能描述 订单详情
     * @author wangdi
     * @date 2019/10/6 20:30
     * @param orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/detail",method = RequestMethod.GET)
    public BaseRespVo orderDetail(int orderId) throws ParseException {
        return wxOrderService.orderDetail(orderId);
    }
    /* *
     * 功能描述 用户取消订单
     * @author wangdi
     * @date 2019/10/6 21:02
     * @param orderMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/cancel",method = RequestMethod.POST)
    public  BaseRespVo orderCancel(@RequestBody Map orderMap){
        int orderId = (int) orderMap.get("orderId");
        return wxOrderService.orderCancel(orderId);
    }
    /* *
     * 功能描述  申请退款
     * @author wangdi
     * @date 2019/10/6 21:13
     * @param orderMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/refund",method = RequestMethod.POST)
    public BaseRespVo orderRefund(@RequestBody Map orderMap){
        int orderId = (int) orderMap.get("orderId");
        return wxOrderService.orderRefund(orderId);
    }

    /* *
     * 功能描述  用户显示删除订单按钮  在,用户取消，系统取消、已退款 、系统收货|用户收货过后
     * @author wangdi
     * @date 2019/10/6 21:14
     * @param null
     * @return
     */
    @RequestMapping(value = "/order/delete",method = RequestMethod.POST)
    public BaseRespVo orderDelete(@RequestBody Map orderMap){
        int orderId = (int) orderMap.get("orderId");
        return wxOrderService.orderDelete(orderId);
    }
    /* *
     * 功能描述  确认收货
     * @author wangdi
     * @date 2019/10/6 22:07
     * @param orderMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/confirm",method = RequestMethod.POST)
    public BaseRespVo orderConfirm(@RequestBody Map orderMap){
        int orderId = (int) orderMap.get("orderId");
        return wxOrderService.orderConfrim(orderId);
    }
    /* *
     * 功能描述 显示评价商品
     * @author wangdi
     * @date 2019/10/6 22:41
     * @param orderId
     * @param goodsId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "order/goods",method = RequestMethod.GET)
    public BaseRespVo orderGoods(int orderId, int goodsId){

        return wxOrderService.orderGoods(orderId,goodsId);
    }
    /* *
     * 功能描述 商品评论，我修改了前端，添加了订单的id，更方便一些
     *
     * @author wangdi
     * @date 2019/10/6 22:44
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/comment",method = RequestMethod.POST)
    public BaseRespVo orderComment(@RequestBody WxOrderCommentVo wxOrderCommentVo){
        return wxOrderService.orderComment(wxOrderCommentVo);
    }

    /* *
     * 功能描述 团购的物流信息   先写死
     * @author wangdi
     * @date   2019/10/7 16:55
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "express/query",method = RequestMethod.POST)
    public BaseRespVo expressQuery(@RequestBody WxGrouponExpressVo wxGrouponExpressVo){
        WxGrouponExpressTraces traces1 = new WxGrouponExpressTraces("北京", new Date());
        WxGrouponExpressTraces traces2 = new WxGrouponExpressTraces("太原", new Date());
        WxGrouponExpressTraces traces3= new WxGrouponExpressTraces("武汉", new Date());
        WxGrouponExpressTraces traces4 = new WxGrouponExpressTraces("花山", new Date());
        List<WxGrouponExpressTraces> traces = new ArrayList<>();
        traces.add(traces1);
        traces.add(traces2);
        traces.add(traces3);
        traces.add(traces4);
        WxGrouponExpressShowVo expressShowVo = new WxGrouponExpressShowVo("京东", "今晚打老虎", traces);
        return BaseRespVo.success(expressShowVo);
    }

    /* *
     * 功能描述 订单提交
     * @author wangdi
     * @date   2019/10/7 23:29
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/submit",method = RequestMethod.POST)
    public BaseRespVo orderSubmit(@RequestBody WxOrderSubmitVo wxOrderSubmitVo){

        return wxOrderService.orderSubmit(wxOrderSubmitVo);
    }

    @RequestMapping(value = "/order/prepay",method = RequestMethod.POST)
    public BaseRespVo orderPrepay(@RequestBody Map orderMap){
        Object orderId = orderMap.get("orderId");
        //前端传过来可能字符串也可能是int
        if(orderId instanceof String){
            orderId = Integer.valueOf((String)orderMap.get("orderId"));
        } else {
            orderId = (Integer)orderMap.get("orderId");
        }

        return wxOrderService.orderPrepay((Integer) orderId);
    }

}
