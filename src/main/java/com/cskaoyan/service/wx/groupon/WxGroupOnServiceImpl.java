package com.cskaoyan.service.wx.groupon;

import com.cskaoyan.mapper.GroupOnMapper;
import com.cskaoyan.vo.wx.groupon.*;
import com.cskaoyan.vo.wx.order.WxOrderInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */
@Service
public class WxGroupOnServiceImpl implements  WxGroupOnService {
    @Autowired
    GroupOnMapper groupOnMapper;

    //团购列表
    @Override
    public WxGroupGoodsData queryWxGroupOnGoodsList(int page,int size) {
        PageHelper.startPage(page,size);
        WxGroupGoodsData wxGroupGoodsData = new WxGroupGoodsData();
        List<WxGroupOnVo> wxGroupOnVos = groupOnMapper.queryWxGroupOnList();
        ArrayList<WxGroupOnVo> wxGroupOnVos1 = new ArrayList<>();
        for (WxGroupOnVo wxGroupOnVo : wxGroupOnVos) {
            WxGroupOnVo wxGroupOnVo1 = new WxGroupOnVo();
            int goodsId = wxGroupOnVo.getGoodsId();
            WxGroupGoodsVo wxGroupGoodsVo = groupOnMapper.queryWxGroupOnGoods(goodsId);
            wxGroupOnVo1.setGoods(wxGroupGoodsVo);
            wxGroupOnVo1.setGroupon_member(wxGroupOnVo.getGroupon_member());
            wxGroupOnVo1.setGroupon_price(wxGroupOnVo.getGroupon_price());
            wxGroupOnVos1.add(wxGroupOnVo1);
        }
        PageInfo<WxGroupOnVo> wxGroupOnVoPageInfo = new PageInfo<>(wxGroupOnVos);
        long total = wxGroupOnVoPageInfo.getTotal();
        wxGroupGoodsData.setCount(total);
        wxGroupGoodsData.setData(wxGroupOnVos1);

        return wxGroupGoodsData;
    }

    //团购API-我的团购
    @Override
    public WxGroupGoodsData queryWxMyGroupList(int showType) {
        WxGroupGoodsData wxGroupGoodsData= new WxGroupGoodsData();
        ArrayList<Object> objects = new ArrayList<>();
        WxMyGrouponVo wxMyGrouponVo = new WxMyGrouponVo();
        //根据用户名查找对应用户id
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String username = (String) session.getAttribute("username");
        // String username="admin";
        if(username==null){
            wxGroupGoodsData.setData(objects);
            return wxGroupGoodsData;
        }
        int userId = groupOnMapper.queryUserIdByName(username);

        //queryMyWxGroupOn---groupon
        WxMyGrouponVoList wxMyGrouponVoList = groupOnMapper.queryMyWxGroupOn(showType, userId);
        wxMyGrouponVo.setGroupon(wxMyGrouponVoList);
        wxMyGrouponVo.setCreator(username);

        int orderId=0;
        if(wxMyGrouponVoList!=null) {
            orderId = wxMyGrouponVoList.getOrderId();
            wxMyGrouponVo.setOrderId(orderId);

            //根据orderId查询orderSn  queryMyOrder
            MyWxOrderVo myWxOrderVo = groupOnMapper.queryMyOrder(orderId);
            wxMyGrouponVo.setOrderSn(myWxOrderVo.getOrderSn());
            wxMyGrouponVo.setActualPrice(myWxOrderVo.getActualPrice());

            //查询拼团人
            int num = groupOnMapper.queryJoinerCount(showType);
            wxMyGrouponVo.setJoinerCount(num);
            wxMyGrouponVo.setId(num);


            //查询商品list
            int rulesId = wxMyGrouponVoList.getRulesId();
            int goodsId = groupOnMapper.queryWxMyGoodsId(rulesId);

            //查询商品--goodsList
            List<MyWxGoodsListVo> myWxGoodsListVos = groupOnMapper.queryWxMyGoodsList(goodsId);
            for (MyWxGoodsListVo myWxGoodsListVo : myWxGoodsListVos) {
                myWxGoodsListVo.setNumber(num);
            }

            wxMyGrouponVo.setGoodsList(myWxGoodsListVos);
            WxMyGoodsRulesVo wxMyGoodsRulesVo = groupOnMapper.queryWxMyRules(rulesId);
            wxMyGrouponVo.setRules(wxMyGoodsRulesVo);
            int orderStatus = myWxOrderVo.getOrderStatus();
            String OrderStatusText="已发货(系统)";
//            if(orderStatus==103 || orderStatus==203 || orderStatus==401){
//                OrderStatusText="已取消(系统)";
//            }
             wxMyGrouponVo.setOrderStatusText(OrderStatusText);

            MyHandleOptionVo myHandleOptionVo = new MyHandleOptionVo(orderStatus);
            wxMyGrouponVo.setHandleOption(myHandleOptionVo);

        objects.add(wxMyGrouponVo);
        wxGroupGoodsData.setData(objects);
        return wxGroupGoodsData ;
        }
        wxGroupGoodsData.setData(objects);
        return wxGroupGoodsData;

    }

    @Override
    public WxGroupOnDetailVo queryWxGroupOnDetail(int id) {
        WxGroupOnDetailVo wxGroupOnDetailVo = new WxGroupOnDetailVo();
        //1、
        WxMyGrouponVoList wxMyGrouponVoList = groupOnMapper.queryWxGrouponDetail(id);
        int userId = wxMyGrouponVoList.getUserId();
        //2、
        WxGroupOnCreator wxGroupOnCreator = groupOnMapper.queryWxCreatorById(userId);
        //3、
        int creatorUserId = wxMyGrouponVoList.getCreatorUserId();
        List<WxGroupOnCreator> wxGroupOnCreators = groupOnMapper.queryWxCreatorListById(creatorUserId);
        //4、
        int orderId = wxMyGrouponVoList.getOrderId();
        WxGroupOnOrderInfoVo wxGroupOnOrderInfoVo = groupOnMapper.queryWxOrderInfoById(orderId);

        //5、
        List<WxOrderGoodsVo> wxOrderGoodsVos = groupOnMapper.queryWxOrderGoods(orderId);
     //6、
        int rulesId = wxMyGrouponVoList.getRulesId();
        WxMyGoodsRulesVo wxMyGoodsRulesVo = groupOnMapper.queryWRulesDetail(rulesId);
    //7、
        WxAddressVo wxAddressVo = groupOnMapper.queryWxAddressDetail(userId);
        //省id
        int province_id = wxAddressVo.getProvince_id();
        //市id
        int city_id = wxAddressVo.getCity_id();
        //区id
        int area_id = wxAddressVo.getArea_id();
    //8、
        //省名
        String province = groupOnMapper.queryWxUserProviceById(province_id);
        //市名
        String city = groupOnMapper.queryWxUserCityById(city_id);
        //区名
        String area = groupOnMapper.queryWxUserAreaById(area_id);
        //具体地址
       // String address = wxAddressVo.getAddress();
        //对地址进行拼接
        String address = wxGroupOnOrderInfoVo.getAddress();
        String address1=province+city+area+address;
        wxGroupOnOrderInfoVo.setAddress(address1);
        wxGroupOnOrderInfoVo.setOrderStatusText("已发货");
        MyHandleOptionVo myHandleOptionVo = new MyHandleOptionVo();
        myHandleOptionVo.setCancel(false);
        myHandleOptionVo.setComment(false);
        myHandleOptionVo.setConfirm(true);
        myHandleOptionVo.setDelete(false);
        myHandleOptionVo.setPay(true);
        myHandleOptionVo.setRefund(false);
        myHandleOptionVo.setRebuy(true);
        wxGroupOnOrderInfoVo.setHandleOption(myHandleOptionVo);
        //对数据进行封装
        wxGroupOnDetailVo.setCreator(wxGroupOnCreator);
        wxGroupOnDetailVo.setGroupon(wxMyGrouponVoList);
        wxGroupOnDetailVo.setJoiners(wxGroupOnCreators);
        wxGroupOnDetailVo.setOrderInfo(wxGroupOnOrderInfoVo);
        wxGroupOnDetailVo.setOrderGoods(wxOrderGoodsVos);
        wxGroupOnDetailVo.setRules(wxMyGoodsRulesVo);
        wxGroupOnDetailVo.setLinkGrouponId(id);
        return wxGroupOnDetailVo;
    }

}
