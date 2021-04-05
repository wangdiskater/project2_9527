package com.cskaoyan.service.admin.ad;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.AdMapper;
import com.cskaoyan.utils.AdDataToFront;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.ListVo;
import com.cskaoyan.vo.ad.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * @Classname AdServiceImpl
 * @Author LM
 * @Description
 * @Data 2019/9/30
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper;

    /**
     * @Description 查询所有广告信息
     * @Author LM
     * @Date 2019/9/30
     * @Param page
     * @Param limit
     * @Return com.cskaoyan.vo.ListVo
     **/
    @Override
    public BaseRespVo queryAllAd(int page, int limit, String name, String content, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<Object> adListVos = adMapper.queryAllAd(name, content, sort, order);
        PageInfo<Object> adPageInfo = new PageInfo<>(adListVos);

        long total = adPageInfo.getTotal();
        ListVo listVo = new ListVo();
        listVo.setTotal(total);
        listVo.setItems(adListVos);
        return BaseRespVo.success(listVo);
    }

    /***
     * @Description 添加广告信息
     * @Author LM
     * @Date 2019/10/2 14:33
     * @Param adListVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo insertAd(AdListCreateVo adListCreateVo) {
        Date date = new Date();
        Ad ad = new Ad();
        ad.setContent(adListCreateVo.getContent());
        ad.setEnabled(adListCreateVo.getEnabled());
        ad.setLink(adListCreateVo.getLink());
        ad.setName(adListCreateVo.getName());
        ad.setPosition(adListCreateVo.getPosition());
        ad.setUrl(adListCreateVo.getUrl());
        ad.setStart_time(date);
        ad.setEnd_time(date);
        ad.setAdd_time(date);
        ad.setUpdate_time(date);
        ad.setDeleted(0);
        int insert = adMapper.insertAd(ad);
        AdListVo adListVo = new AdListVo(ad);
        return BaseRespVo.success(adListVo);
    }

    /**
     * @Description 更新广告信息
     * @Author LM
     * @Date 2019/10/2 16:24
     * @Param adListVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo updateAd(AdListVo adListVo) {
        Date date = new Date();
        adListVo.setUpdateTime(date);
        Ad ad = new Ad();
        ad.setId(adListVo.getId());
        ad.setName(adListVo.getName());
        ad.setLink(adListVo.getLink());
        ad.setUrl(adListVo.getUrl());
        ad.setPosition(adListVo.getPosition());
        ad.setContent(adListVo.getContent());
        ad.setEnabled(adListVo.isEnabled());
        ad.setUpdate_time(adListVo.getUpdateTime());
        ad.setDeleted(0);
        int insert = adMapper.updateAd(ad);
        return BaseRespVo.success(adListVo);
    }

    /**
     * @Description 删除商品信息
     * @Author LM
     * @Date 2019/10/2 16:47
     * @Param adListVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo deleteAd(AdListVo adListVo) {
        int delete = adMapper.deleteAd(adListVo.getId());
        if (delete == 1) {
            return BaseRespVo.success("");
        } else {
            return null;
        }
    }


    /**
     * @Description 分页查询优惠券信息
     * @Author LM
     * @Date 2019/9/30
     * @Param page
     * @Param limit
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override

    public BaseRespVo queryAllCoupon ( int page, int limit, String name, Integer type, Integer status, String
    sort, String order){
        PageHelper.startPage(page, limit);
        List<Object> couponVos = adMapper.queryAllCoupon(name, type, status, sort, order);
        PageInfo<Object> couponPageInfo = new PageInfo<>(couponVos);
        long total = couponPageInfo.getTotal();
        ListVo ListVo = new ListVo();
        ListVo.setTotal(total);
        ListVo.setItems(couponVos);
        return BaseRespVo.success(ListVo);
    }

        /**
         * @Description 添加优惠券信息
         * @Author LM
         * @Date 2019/10/2 17:19
         * @Param couponVo
         * @Return com.cskaoyan.vo.BaseRespVo
         **/
        @Override
        public BaseRespVo insertCoupon (CouponCreateVo couponCreateVo){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int type = couponCreateVo.getType();
            int length = 8;
            String allChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuffer append = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            CouponVo couponVo = new CouponVo(couponCreateVo);
            if (type == 2){
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    append = sb.append(allChar.charAt(random.nextInt(allChar.length())));
                }
                couponVo.setCode(append.toString());
            }
            couponVo.setStartTime(simpleDateFormat.format(new Date()));
            couponVo.setEndTime(simpleDateFormat.format(new Date()));

            adMapper.insertCoupon(couponVo);
            return BaseRespVo.success(couponVo);
        }


    /**
     * @Description 优惠券详情
     * @Author LM
     * @Date 2019/10/3 19:39
     * @Param id
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo readCouponById(int id) {
        Coupon coupon = adMapper.queryCouponById(id);
        CouponVo couponVo = new CouponVo();
        couponVo.setId(coupon.getId());
        couponVo.setName(coupon.getName());
        couponVo.setDesc(coupon.getDesc());
        couponVo.setTag(coupon.getTag());
        couponVo.setDiscount(coupon.getDiscount());
        couponVo.setMin(coupon.getMin());
        couponVo.setLimit(coupon.getLimit());
        couponVo.setType(coupon.getType());
        couponVo.setStatus(coupon.getStatus());
        couponVo.setGoodsType(coupon.getGoods_type());
        couponVo.setGoodsValue(new String[]{coupon.getGoods_value()});
        couponVo.setCode(coupon.getCode());
        couponVo.setTimeType(coupon.getTime_type());
        couponVo.setDays(coupon.getDays());
        couponVo.setAddTime(String.valueOf(coupon.getAdd_time()));
        couponVo.setUpdateTime(String.valueOf(coupon.getUpdate_time()));
        couponVo.setDeleted(coupon.getDeleted());
        return BaseRespVo.success(couponVo);
    }

    /**
     * @Description 优惠券详情信息
     * @Author LM
     * @Date 2019/10/3 19:40
     * @Param page
     * @Param limit
     * @Param couponId
     * @Param sort
     * @Param order
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo queryAllListuser(int page, int limit, Integer couponId, Integer userId,Integer status, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Object> listuser = adMapper.queryAllListuser(couponId, userId, status, sort, order);
        PageInfo<Object> listuserPageInfo = new PageInfo<>(listuser);
        long total = listuserPageInfo.getTotal();
        ListVo ListVo = new ListVo();
        ListVo.setTotal(total);
        ListVo.setItems(listuser);
        return BaseRespVo.success(ListVo);
    }

        /**
         * @Description 删除优惠券信息
         * @Author LM
         * @Date 2019/10/2 21:42
         * @Param couponVo
         * @Return com.cskaoyan.vo.BaseRespVo
         **/
        @Override
        public BaseRespVo deleteCoupon (CouponVo couponVo){
            int delete = adMapper.deleteCoupon(couponVo.getId());
            if (delete == 1) {
                return BaseRespVo.success("");
            }
            return null;
        }

        /**
         * @Description 更新优惠券信息
         * @Author LM
         * @Date 2019/10/2 21:49
         * @Param couponVo
         * @Return com.cskaoyan.vo.BaseRespVo
         **/
        @Override
        public BaseRespVo updateCoupon (CouponVo couponVo){
            int type = couponVo.getType();
            int length = 8;
            String allChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuffer append = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            if (type == 2){
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    append = sb.append(allChar.charAt(random.nextInt(allChar.length())));
                }
                couponVo.setCode(append.toString());
            }
            adMapper.updateCoupon(couponVo);
            return BaseRespVo.success(couponVo);
        }

        /**
         * @Description 分页查询所有专题信息
         * @Author LM
         * @Date 2019/10/2 22:38
         * @Param page
         * @Param limit
         * @Param title
         * @Param subtitle
         * @Param sort
         * @Param order
         * @Return com.cskaoyan.vo.BaseRespVo
         **/
        @Override
        public BaseRespVo queryAllTopic ( int page, int limit, String title, String subtitle, String sort, String order)
        {
            PageHelper.startPage(page, limit);
            List<TopicVo> topicVos = adMapper.queryAllTopic(title, subtitle, sort, order);
            PageInfo<TopicVo> topicPageInfo = new PageInfo<>(topicVos);
            long total = topicPageInfo.getTotal();
            ListVo<TopicVo> ListVo = new ListVo<>();
            ListVo.setTotal(total);
            ListVo.setItems(topicVos);
            return BaseRespVo.success(ListVo);
        }

    /**
     * @Description 添加专题信息
     * @Author LM
     * @Date 2019/10/3 19:40
     * @Param topicCreateVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo insertTopic(TopicCreateVo topicCreateVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TopicVo topicVo = new TopicVo(topicCreateVo);
        topicVo.setAddTime(simpleDateFormat.format(new Date()));
        topicVo.setUpdateTime(simpleDateFormat.format(new Date()));
        adMapper.insertTopic(topicVo);
        return BaseRespVo.success(topicVo);
    }

    /**
     * @Description 更新专题信息
     * @Author LM
     * @Date 2019/10/3 19:40
     * @Param topicUpdateVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo updateTopic(TopicUpdateVo topicUpdateVo) {
        adMapper.updateTopic(topicUpdateVo);
        return BaseRespVo.success(topicUpdateVo);
    }

    /**
     * @Description 删除专题信息
     * @Author LM
     * @Date 2019/10/3 19:41
     * @Param topicUpdateVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo deleteTopic(TopicUpdateVo topicUpdateVo) {
        int delete = adMapper.deleteTopic(topicUpdateVo.getId());
        if (delete == 1) {
            return BaseRespVo.success("");
        }
        return null;
    }

    /**
     * @return 查询所有团购规则
     * @author piter_liu
     * @Date 2019/10/2
     */
    @Override
    public BaseRespVo queryAllGrouponRules ( int page, int limit, Integer goodsId, String sort, String order){

        PageHelper.startPage(page, limit);
        List<AdGoodsRules> adGoodsRules = adMapper.queryAllGrouponRules(goodsId, sort, order);
        List<AdGoodsRulesVo> adGoodsRulesVos = new ArrayList<>();
        if (adGoodsRules != null) {
            for (AdGoodsRules adGoodsRule : adGoodsRules) {
                AdGoodsRulesVo adGoodsRulesVo = AdDataToFront.ConvertAdGoodsRulesVo(adGoodsRule);
                adGoodsRulesVos.add(adGoodsRulesVo);
            }
        }
        PageInfo<AdGoodsRules> pageInfo = new PageInfo<>(adGoodsRules);
        long total = pageInfo.getTotal();
        AdInfoVo infoVo = new AdInfoVo();
        infoVo.setTotal(total);
        infoVo.setItems(adGoodsRulesVos);
        return BaseRespVo.success(infoVo);
    }

    /**
     * @param rule 新增一条团购规则数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    @Override
    public BaseRespVo createOneRule (AdRulesAddition rule){
        AdRulesAddition adRulesAddition = adMapper.queryGoodsForAddRule(rule);
        rule.setName(adRulesAddition.getName());
        rule.setPic_url(adRulesAddition.getPic_url());
        rule.setDeleted(0);
        System.out.println(111);
        int id = adMapper.addOneRule(rule);
        AdGoodsRules adGoodsRules = adMapper.queryOneRules(rule.getId());
        AdGoodsRulesVo adGoodsRulesVo = AdDataToFront.ConvertAdGoodsRulesVo(adGoodsRules);
        return BaseRespVo.success(adGoodsRulesVo);
    }

    /**
     * @param rule 更新一条团购规则数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    @Override
    public BaseRespVo updateRules (AdGoodsRulesVo rule){
        int goodsId = rule.getGoodsId();
        // 如果修改了商品的id 则对应修改数据库中的商品名称
        AdGoods adGoods = adMapper.queryOneGoods(goodsId);
        rule.setGoodsName(adGoods.getName());
        rule.setPicUrl(adGoods.getPic_url());
        BaseRespVo baseRespVo = new BaseRespVo();
        int i = adMapper.updateRules(rule);
        if (i == 0) {
            return null;
        }
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }

    /**
     * @param rule 删除一条团购规则数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    @Override
    public BaseRespVo deleteRules (AdGoodsRulesVo rule){
        BaseRespVo baseRespVo = new BaseRespVo();
        int i = adMapper.deleteRules(rule);
        if (i == 0) {
            return null;
        }
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }

    /**
     * @return 查询所有团购活动
     * @author piter_liu
     * @Date 2019/10/2
     */
    @Override
    public BaseRespVo queryAllGroupon (int page, int limit, Integer goodsId, String sort, String order){

        PageHelper.startPage(page, limit);
        List<AdGoodsRules> rules = null;
        if (goodsId != null){
            rules = adMapper.queryAllGrouponRules(goodsId, sort, order);
        }
        List<AdGroupon> adGroupons = null;
        if (rules != null){
            for (AdGoodsRules rule : rules) {
                int id = rule.getId();
                adGroupons = adMapper.querySomeGroupon(id);
            }
        }else {
            adGroupons = adMapper.queryAllGroupon();
        }
        List<Object> list = new ArrayList<>();
        if (adGroupons != null) {
            for (AdGroupon adGroupon : adGroupons) {
                AdMergeVo adMergeVo = new AdMergeVo();
                AdGrouponVo adGrouponVo = AdDataToFront.ConvertAdGroupon(adGroupon);
                int rulesId = adGroupon.getRules_id();
                AdGoodsRules adGoodsRules = adMapper.queryOneRules(rulesId);
                AdGoodsRulesVo adGoodsRulesVo = AdDataToFront.ConvertAdGoodsRulesVo(adGoodsRules);
                AdGoodsVo adGoodsVo = null;
                if (adGoodsRulesVo != null){
                    int goodsid = adGoodsRules.getGoods_id();
                    // 查找对应的商品
                    AdGoods adGoods = adMapper.queryOneGoods(goodsid);
                    adGoodsVo = AdDataToFront.ConvertAdGoodsVo(adGoods);
                }
                adMergeVo.setRules(adGoodsRulesVo);
                adMergeVo.setGoods(adGoodsVo);
                adMergeVo.setGroupon(adGrouponVo);
                if (adMergeVo.getSubGroupons() != null) {
                    adMergeVo.setSubGroupons(adMergeVo.getSubGroupons());
                }
                adMergeVo.setSubGroupons(new ArrayList<>());
                list.add(adMergeVo);
            }
        }else {
            return BaseRespVo.fail();
        }
        PageInfo<AdGroupon> pageInfo = new PageInfo<>(adGroupons);
        long total = pageInfo.getTotal();
        AdInfoVo infoVo = new AdInfoVo();
        infoVo.setTotal(total);
        infoVo.setItems(list);
        return BaseRespVo.success(infoVo);
    }
}

