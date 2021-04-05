package com.cskaoyan.vo.wx.groupon;

import com.cskaoyan.vo.wx.order.WxOrderInfoVo;

import java.util.List;

/**
 * @author GF
 * @description
 * @date 2019/10/7
 */

public class WxGroupOnDetailVo {
    WxGroupOnCreator creator;
    WxMyGrouponVoList groupon;
   List<WxGroupOnCreator>  joiners;
    WxGroupOnOrderInfoVo orderInfo;
    List<WxOrderGoodsVo> orderGoods;
    WxMyGoodsRulesVo rules;
    int linkGrouponId;

    public WxGroupOnCreator getCreator() {
        return creator;
    }

    public void setCreator(WxGroupOnCreator creator) {
        this.creator = creator;
    }

    public WxMyGrouponVoList getGroupon() {
        return groupon;
    }

    public void setGroupon(WxMyGrouponVoList groupon) {
        this.groupon = groupon;
    }

    public List<WxGroupOnCreator> getJoiners() {
        return joiners;
    }

    public void setJoiners(List<WxGroupOnCreator> joiners) {
        this.joiners = joiners;
    }

    public WxGroupOnOrderInfoVo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(WxGroupOnOrderInfoVo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<WxOrderGoodsVo> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<WxOrderGoodsVo> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public WxMyGoodsRulesVo getRules() {
        return rules;
    }

    public void setRules(WxMyGoodsRulesVo rules) {
        this.rules = rules;
    }

    public int getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(int linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }
}

