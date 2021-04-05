package com.cskaoyan.bean;

/**
 * @Auther Piter_Liu
 * @Description 此类用于团购活动查出的3个表一块整合
 * @Date 2019/10/2
 */

public class AdMerge {

    AdGoods adGoods;
    AdGoodsRules adGoodsRules;
    AdGroupon adGroupon;

    public AdGoods getAdGoods() {
        return adGoods;
    }

    public void setAdGoods(AdGoods adGoods) {
        this.adGoods = adGoods;
    }

    public AdGoodsRules getAdGoodsRules() {
        return adGoodsRules;
    }

    public void setAdGoodsRules(AdGoodsRules adGoodsRules) {
        this.adGoodsRules = adGoodsRules;
    }

    public AdGroupon getAdGroupon() {
        return adGroupon;
    }

    public void setAdGroupon(AdGroupon adGroupon) {
        this.adGroupon = adGroupon;
    }
}
