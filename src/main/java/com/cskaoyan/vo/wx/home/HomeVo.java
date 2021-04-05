package com.cskaoyan.vo.wx.home;

import com.cskaoyan.vo.ad.AdListVo;
import com.cskaoyan.vo.ad.TopicVo;
import com.cskaoyan.vo.goods.GoodsVo;
import com.cskaoyan.vo.mall.BrandVo;

import java.util.List;

/**
 * @version 1.0
 * @ClassName HomeVo
 * @Description 返回给前端显示的数据
 * @Author wangdi
 * @Date 2019/10/4 20:59
 **/

public class HomeVo {

    //goods isnew
    List<GoodsVo> newGoodsList;

    //cskaoyan_mall_coupon 优惠券
    List<HomeCouponVo> couponList;

    //商品类目显示一级类目  cskaoyan_mall_category
    List<ChannelVo> channel;

    //discountMember == grouponMember
    List<HomeGrouponVo> grouponList;

    //cskaoyan_mall_ad
    List<AdListVo> banner;

    //brandList
    List<BrandVo> brandList;

    //isHot
    List<GoodsVo> hotGoodsList;

    //mall_topicList
    List<TopicVo> topicList;

    //category下查找所有的商品
    List<HomeFloorGoodsVo> floorGoodsList;

    public HomeVo() {
    }

    public HomeVo(List<GoodsVo> newGoodsList, List<HomeCouponVo> couponList, List<ChannelVo> channel,
                  List<HomeGrouponVo> grouponList, List<AdListVo> banner, List<BrandVo> brandList,
                  List<GoodsVo> hotGoodsList, List<TopicVo> topicList, List<HomeFloorGoodsVo> floorGoodsList) {
        this.newGoodsList = newGoodsList;
        this.couponList = couponList;
        this.channel = channel;
        this.grouponList = grouponList;
        this.banner = banner;
        this.brandList = brandList;
        this.hotGoodsList = hotGoodsList;
        this.topicList = topicList;
        this.floorGoodsList = floorGoodsList;
    }

    @Override
    public String toString() {
        return "HomeVo{" +
                "newGoodsList=" + newGoodsList +
                ", couponList=" + couponList +
                ", channel=" + channel +
                ", grouponList=" + grouponList +
                ", banner=" + banner +
                ", brandList=" + brandList +
                ", hotGoodsList=" + hotGoodsList +
                ", topicList=" + topicList +
                ", floorGoodsList=" + floorGoodsList +
                '}';
    }

    public List<GoodsVo> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<GoodsVo> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<HomeCouponVo> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<HomeCouponVo> couponList) {
        this.couponList = couponList;
    }

    public List<ChannelVo> getChannel() {
        return channel;
    }

    public void setChannel(List<ChannelVo> channel) {
        this.channel = channel;
    }

    public List<HomeGrouponVo> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<HomeGrouponVo> grouponList) {
        this.grouponList = grouponList;
    }

    public List<AdListVo> getBanner() {
        return banner;
    }

    public void setBanner(List<AdListVo> banner) {
        this.banner = banner;
    }

    public List<BrandVo> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandVo> brandList) {
        this.brandList = brandList;
    }

    public List<GoodsVo> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<GoodsVo> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<TopicVo> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<TopicVo> topicList) {
        this.topicList = topicList;
    }

    public List<HomeFloorGoodsVo> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(List<HomeFloorGoodsVo> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }
}
