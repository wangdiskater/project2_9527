package com.cskaoyan.vo.wx.groupon;

import java.util.List;

/**
 * @author GF
 * @description 我的团购
 * @date 2019/10/6
 */

public class WxMyGrouponVo {
    int id;
    String orderStatusText;
    String creator;
    int orderId;
    String orderSn;
    double actualPrice;
    int joinerCount;
    boolean isCreator;

    //团购
    WxMyGrouponVoList groupon;
    //商品
    List<MyWxGoodsListVo> goodsList;

    //rules
    WxMyGoodsRulesVo rules;

    MyHandleOptionVo handleOption;

    public boolean isCreator() {
        return isCreator;
    }

    public WxMyGrouponVoList getGroupon() {
        return groupon;
    }

    public void setGroupon(WxMyGrouponVoList groupon) {
        this.groupon = groupon;
    }

    public List<MyWxGoodsListVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<MyWxGoodsListVo> goodsList) {
        this.goodsList = goodsList;
    }

    public WxMyGoodsRulesVo getRules() {
        return rules;
    }

    public void setRules(WxMyGoodsRulesVo rules) {
        this.rules = rules;
    }

    public MyHandleOptionVo getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(MyHandleOptionVo handleOption) {
        this.handleOption = handleOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(int joinerCount) {
        this.joinerCount = joinerCount;
    }

    public boolean getIsCreator() {
        return isCreator;
    }

    public void setIsCreator(boolean creator) {
        isCreator = creator;
    }
}
