package com.cskaoyan.utils;

import com.cskaoyan.bean.AdGoods;
import com.cskaoyan.bean.AdGoodsRules;
import com.cskaoyan.bean.AdGroupon;
import com.cskaoyan.vo.ad.AdGoodsRulesVo;
import com.cskaoyan.vo.ad.AdGoodsVo;
import com.cskaoyan.vo.ad.AdGrouponVo;

/**
 * @Auther Piter_Liu
 * @Description 此类用于处理将数据库返回的bean做相应的变动，传给前端所需的数据类型
 * @Date 2019/10/2
 */

public class AdDataToFront {

    public static AdGoodsVo ConvertAdGoodsVo(AdGoods adGoods){
        AdGoodsVo adGoodsVo = new AdGoodsVo();
        if (adGoods == null) {
            return null;
        }
        adGoodsVo.setAddTime(adGoods.getAdd_time());
        adGoodsVo.setBrandId(adGoods.getBrand_id());
        adGoodsVo.setBrief(adGoods.getBrief());
        adGoodsVo.setCategoryId(adGoods.getCategory_id());
        adGoodsVo.setCounterPrice(adGoods.getCounter_price());
        if (adGoods.getDeleted() != 0){
            adGoodsVo.setDeleted(true);
        }
        adGoodsVo.setDeleted(false);
        adGoodsVo.setDetail(adGoods.getDetail());
        adGoodsVo.setGallery(adGoods.getGallery());
        adGoodsVo.setGoodsSn(adGoods.getGoods_sn());
        adGoodsVo.setId(adGoods.getId());
        if (adGoods.getIs_hot() != 0){
            adGoodsVo.setHot(true);
        }
        if (adGoods.getIs_new() != 0){
            adGoodsVo.setNew(true);
        }
        if (adGoods.getIs_on_sale() != 0){
            adGoodsVo.setOnSale(true);
        }
        adGoodsVo.setKeywords(adGoods.getKeywords());
        adGoodsVo.setName(adGoods.getName());
        adGoodsVo.setPicUrl(adGoods.getPic_url());
        adGoodsVo.setRetailPrice(adGoods.getRetail_price());
        adGoodsVo.setShareUrl(adGoods.getShare_url());
        adGoodsVo.setSortOrder(adGoods.getSort_order());
        adGoodsVo.setUnit(adGoods.getUnit());
        adGoodsVo.setUpdateTime(adGoods.getUpdate_time());
        return adGoodsVo;
    }

    public static AdGoodsRulesVo ConvertAdGoodsRulesVo(AdGoodsRules adGoodsRules){
        AdGoodsRulesVo adGoodsRulesVo = new AdGoodsRulesVo();
        if (adGoodsRules == null){
            return null;
        }
        adGoodsRulesVo.setAddTime(adGoodsRules.getAdd_time());
        if (adGoodsRules.getDeleted() != 0){
            adGoodsRulesVo.setDeleted(true);
        }
        adGoodsRulesVo.setDeleted(false);
        adGoodsRulesVo.setDiscount(adGoodsRules.getDiscount());
        adGoodsRulesVo.setDiscountMember(adGoodsRules.getDiscount_member());
        adGoodsRulesVo.setExpireTime(adGoodsRules.getExpire_time());
        adGoodsRulesVo.setGoodsId(adGoodsRules.getGoods_id());
        adGoodsRulesVo.setGoodsName(adGoodsRules.getGoods_name());
        adGoodsRulesVo.setId(adGoodsRules.getId());
        adGoodsRulesVo.setPicUrl(adGoodsRules.getPic_url());
        adGoodsRulesVo.setUpdateTime(adGoodsRules.getUpdate_time());
        return adGoodsRulesVo;
    }

    public static AdGrouponVo ConvertAdGroupon(AdGroupon adGroupon){
        AdGrouponVo adGrouponVo = new AdGrouponVo();
        if (adGroupon == null){
            return null;
        }
        adGrouponVo.setAddTime(adGroupon.getAdd_time());
        adGrouponVo.setCreatorUserId(adGroupon.getCreator_user_id());
        if (adGroupon.getDeleted() != 0){
            adGrouponVo.setDeleted(true);
        }
        adGrouponVo.setDeleted(false);
        adGrouponVo.setGrouponId(adGroupon.getGroupon_id());
        adGrouponVo.setId(adGroupon.getId());
        adGrouponVo.setOrderId(adGroupon.getOrder_id());
        adGrouponVo.setPayed(adGroupon.getPayed());
        adGrouponVo.setRulesId(adGroupon.getRules_id());
        adGrouponVo.setShareUrl(adGroupon.getShare_url());
        adGrouponVo.setUpdateTime(adGroupon.getUpdate_time());
        adGrouponVo.setUserId(adGroupon.getUser_id());
        return adGrouponVo;
    }
}
