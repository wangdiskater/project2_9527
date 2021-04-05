package com.cskaoyan.service.admin.ad;

import com.cskaoyan.bean.AdRulesAddition;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.ad.*;
import com.cskaoyan.vo.ad.AdGoodsRulesVo;
import org.springframework.web.bind.annotation.RequestBody;
import com.cskaoyan.vo.ad.AdListCreateVo;
import com.cskaoyan.vo.ad.AdListVo;

/**
 * @Classname AdService
 * @Author LM
 * @Description
 * @Data 2019/9/30
 */
public interface AdService {

    //查询所有广告
    BaseRespVo queryAllAd(int page, int limit,String name,String content,String sort,String order);

    //查询所有优惠券
    BaseRespVo queryAllCoupon(int page,int limit,String name,Integer type,Integer status,String sort,String order);

    //查询所有团购规则
    BaseRespVo queryAllGrouponRules(int page, int limit,Integer goodsId, String sort, String order);

    // 查询所有团购活动
    BaseRespVo queryAllGroupon(int page, int limit,Integer goodsId, String sort, String order);

    // 新增一条团购规则
    BaseRespVo createOneRule(@RequestBody AdRulesAddition rule);

    // 更新一条团购规则
    BaseRespVo updateRules(@RequestBody AdGoodsRulesVo rule);

    // 删除一条团购规则
    BaseRespVo deleteRules(@RequestBody AdGoodsRulesVo rule);

    //添加广告
    BaseRespVo insertAd(AdListCreateVo adListCreateVo);

    //编辑广告
    BaseRespVo updateAd(AdListVo adListVo);

    //删除广告
    BaseRespVo deleteAd(AdListVo adListVo);

    //添加优惠券
    BaseRespVo insertCoupon(CouponCreateVo couponCreateVo);

    //删除优惠券
    BaseRespVo deleteCoupon(CouponVo couponVo);

    //编辑优惠券
    BaseRespVo updateCoupon(CouponVo couponVo);

    //查询所有专题
    BaseRespVo queryAllTopic(int page, int limit, String title, String subtitle, String sort, String order);

    //添加专题
    BaseRespVo insertTopic(TopicCreateVo topicCreateVo);

    //删除专题
    BaseRespVo deleteTopic(TopicUpdateVo topicUpdateVo);

    //通过id查询详细优惠券信息
    BaseRespVo readCouponById(int id);

    //编辑优惠券
    BaseRespVo updateTopic(TopicUpdateVo topicUpdateVo);

    //查询优惠券使用信息
    BaseRespVo queryAllListuser(int page, int limit, Integer couponId, Integer userId,Integer status, String sort, String order);
}
