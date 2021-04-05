package com.cskaoyan.vo.ad;

import com.cskaoyan.bean.AdGoodsRules;

import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/2
 */

public class AdMergeVo {

    AdGoodsVo goods;
    AdGrouponVo groupon;
    AdGoodsRulesVo rules;
    List<Object> subGroupons;

    public List<Object> getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(List<Object> subGroupons) {
        this.subGroupons = subGroupons;
    }

    public AdGoodsVo getGoods() {
        return goods;
    }

    public void setGoods(AdGoodsVo goods) {
        this.goods = goods;
    }

    public AdGrouponVo getGroupon() {
        return groupon;
    }

    public void setGroupon(AdGrouponVo groupon) {
        this.groupon = groupon;
    }

    public AdGoodsRulesVo getRules() {
        return rules;
    }

    public void setRules(AdGoodsRulesVo rules) {
        this.rules = rules;
    }
}
