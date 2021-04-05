package com.cskaoyan.service.wx.home;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.Config;
import com.cskaoyan.constant.CacheConstant;
import com.cskaoyan.mapper.AdMapper;
import com.cskaoyan.mapper.ConfigMapper;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.MallManageMapper;
import com.cskaoyan.service.guava.GuavaCacheSerivce;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.ad.AdListVo;
import com.cskaoyan.vo.ad.TopicVo;
import com.cskaoyan.vo.goods.GoodsVo;
import com.cskaoyan.vo.mall.BrandVo;
import com.cskaoyan.vo.wx.home.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @ClassName HomeServiceImpl
 * @Description 主页的业务层逻辑
 * @Author wangdi
 * @Date 2019/10/4 20:48
 **/
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    AdMapper adMapper;

    @Autowired
    MallManageMapper mallManageMapper;

    @Autowired
    ConfigMapper configMapper;

    @Autowired
    GuavaCacheSerivce guavaCacheSerivce;

    /* *
     * 功能描述 显示首页
     * @author wangdi
     * @date 2019/10/4 20:58
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo homeShow() {
        Object RespBody = guavaCacheSerivce.get(CacheConstant.CACHE_HOME.getCacheName());
        if(RespBody != null){
            return BaseRespVo.success(RespBody);
        }

        int page = 1;
        int limit= 10;
        int wxIndexNew = Integer.valueOf(configMapper.queryWxIndexNew());
        int wxIndexBrand = Integer.valueOf(configMapper.queryWxIndexBrand());
        int wxIndexTopic = Integer.valueOf(configMapper.queryWxIndexTopic());
        int wxCatlogGoods = Integer.valueOf(configMapper.queryWxCatlogGoods());
        int wxCatlogList = Integer.valueOf(configMapper.queryWxCatlogList());
        int wxIndexHot = Integer.valueOf(configMapper.queryWxIndexHot());


        //显示新的商品
        PageHelper.startPage(page,wxIndexNew);
        List<GoodsVo> newGoodsList  = goodsMapper.queryAllNewGoods();

        //显示优惠券
        PageHelper.startPage(page,limit);
        List<HomeCouponVo> couponList  = adMapper.queryAllCouponToHome();

        //商品类目显示一级类目  cskaoyan_mall_category
        PageHelper.startPage(page,wxCatlogList);
        List<ChannelVo> channel = mallManageMapper.selectAllFirstCategory();

        //显示所有团购
        PageHelper.startPage(page,limit);
        List<HomeGrouponVo> grouponList = adMapper.queryAllGrouponToHome();

        //cskaoyan_mall_ad
        PageHelper.startPage(page,limit);
        List<AdListVo> banner = adMapper.queryAllAdToHome();

        //brandList
        PageHelper.startPage(page,wxIndexBrand);
        List<BrandVo> brandList = mallManageMapper.selectAllBrandToHome();

        //isHot
        PageHelper.startPage(page,wxIndexHot);
        List<GoodsVo> hotGoodsList = goodsMapper.queryAllHotGoods();

        //mall_topicList
        PageHelper.startPage(page,wxIndexTopic);
        List<TopicVo> topicList = adMapper.queryAllTopicToHome();

        //category下查找所有的商品
        //channel遍历一级标签，然后二级标签找所有goods
        List<HomeFloorGoodsVo> floorGoodsList = new ArrayList<>();
        for (ChannelVo channelVo : channel) {
            HomeFloorGoodsVo homeFloorGoodsVo = new HomeFloorGoodsVo(channelVo.getName());
            PageHelper.startPage(page,wxCatlogGoods);
            List<GoodsVo>goodsList =  goodsMapper.selectGoodsByChannel(channelVo.getId());

            homeFloorGoodsVo.setGoodsList(goodsList);
            floorGoodsList.add(homeFloorGoodsVo);

        }
        HomeVo homeVo = new HomeVo(newGoodsList,couponList,channel,grouponList,banner,brandList,hotGoodsList,
                topicList,floorGoodsList);

        guavaCacheSerivce.set(CacheConstant.CACHE_HOME.getCacheName(),homeVo);

        return BaseRespVo.success(homeVo);
    }
    /* *
     * 功能描述
     * @author wangdi
     * @date 2019/10/5 9:25
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     * {"errno":0,"data":{"goodsCount":304},"errmsg":"成功"}
     */
    @Override
    public BaseRespVo goodsCount() {
        int goodsCount = goodsMapper.queryAllGoodsNum();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("goodsCount",goodsCount);
        return BaseRespVo.success(map);
    }
}
