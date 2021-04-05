package com.cskaoyan.mapper;

import com.cskaoyan.vo.wx.groupon.*;
import com.cskaoyan.vo.wx.order.WxOrderInfoVo;
import com.sun.xml.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */

public interface GroupOnMapper {

    //查看团购列表 queryWxGroupOnList
    List<WxGroupOnVo> queryWxGroupOnList();

    //查询团购商品信息
   WxGroupGoodsVo queryWxGroupOnGoods(@Param("id")  int id);

   /**********************************************************************/
   //团购API-我的团购
    //首先根据username查询出对应的用户id  queryUserIdByName
    int queryUserIdByName(@Param("username") String username);

    //根据前端传来的showType和用户id 查询GroupOn
    WxMyGrouponVoList queryMyWxGroupOn(@Param("id") int id, @Param("userId") int userId);
    //根据orderId查询orderSn
    MyWxOrderVo queryMyOrder(@Param("id") int id);
    //查询拼团人数 queryJoinerCount
    int queryJoinerCount(@Param("id") int id);

    //查询对应商品的id queryWxMyGoodsId
    int queryWxMyGoodsId(@Param("id") int id);
     //查询商品
    List<MyWxGoodsListVo> queryWxMyGoodsList(@Param("id") int id);

    //查询拼团规则--rules queryWxMyRules
    WxMyGoodsRulesVo queryWxMyRules(@Param("id") int id);

    /************************/
    //团购API--详情

    //1、查询团购详情
    WxMyGrouponVoList queryWxGrouponDetail(@Param("id") int id);
    //2、通过groupon的user_id查询出creator的信息
    WxGroupOnCreator queryWxCreatorById(@Param("id") int id);
    //3、通过groupon的creator_user_id查询出joiners的list信息
    List<WxGroupOnCreator> queryWxCreatorListById(@Param("id") int id);
    //4、通过groupon的order_id查询出orderInfo的信息
    WxGroupOnOrderInfoVo queryWxOrderInfoById(@Param("id") int id);
    //5、通过groupon的order_id查询出orderGoods的List信息
    List <WxOrderGoodsVo> queryWxOrderGoods(@Param("id") int id);
    //6、根据第一步cskaoyan_mall_groupon查询出来的rules_id查询出rules的信息
    WxMyGoodsRulesVo queryWRulesDetail(@Param("id") int id);
    //地址的处理 //7、根据第一次查询的user_id查询
    WxAddressVo queryWxAddressDetail(@Param("id") int id);
    //8、根据上一步查询出来province_id (42),city_id(4201),area_id(420111)
    //9、省
     String  queryWxUserProviceById(@Param("id") int id);
     //10、市
    String queryWxUserCityById(@Param("id") int id);
    //11、区
    String queryWxUserAreaById(@Param("id") int id);












}
