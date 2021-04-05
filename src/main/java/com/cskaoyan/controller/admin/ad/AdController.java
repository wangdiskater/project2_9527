package com.cskaoyan.controller.admin.ad;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.admin.ad.AdService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.ad.*;
import com.cskaoyan.vo.ad.AdListCreateVo;
import com.cskaoyan.vo.ad.AdListVo;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname AdController
 * @Author LM
 * @Description
 * @Data 2019/9/30
 */
@RestController
@RequestMapping("/admin")
public class AdController {
    @Autowired
    AdService adService;

    /**
     * @Description 分页查找所有广告信息
     * @Author LM
     * @Date 2019/9/30
     * @Param page
     * @Param limit
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/ad/list",method = RequestMethod.GET)
    public BaseRespVo queryAllAd(int page, int limit,String name,String content,String sort,String order){
        return adService.queryAllAd(page,limit,name,content,sort,order);
    }

    /***
     * @Description 添加广告信息
     * @Author LM
     * @Date 2019/10/2 14:23
     * @Param file
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/ad/create",method = RequestMethod.POST)
    public BaseRespVo insertAd(@RequestBody AdListCreateVo adListCreateVo){
        return adService.insertAd(adListCreateVo);
    }

    /***
     * @Description 更新广告信息
     * @Author LM
     * @Date 2019/10/2 16:22
     * @Param brandVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/ad/update",method = RequestMethod.POST)
    public BaseRespVo updateAd(@RequestBody AdListVo adListVo){
        return adService.updateAd(adListVo);
    }

    /***
     * @Description 删除广告信息
     * @Author LM
     * @Date 2019/10/2 16:45
     * @Param adListVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/ad/delete",method = RequestMethod.POST)
    public BaseRespVo deleteAd(@RequestBody AdListVo adListVo){
        return adService.deleteAd(adListVo);
    }

    /***
     * @Description 显示所有优惠券
     * @Author LM
     * @Date 2019/10/2 16:23
     * @Param page
     * @Param limit
     * @Param name
     * @Param type
     * @Param status
     * @Param sort
     * @Param order
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/coupon/list",method = RequestMethod.GET)
    public BaseRespVo queryAllCoupon(int page,int limit,String name,Integer type,Integer status,String sort,String order){
        return adService.queryAllCoupon(page,limit,name,type,status,sort,order);
    }

    /**
     * @Description 添加优惠券信息
     * @Author LM
     * @Date 2019/10/2 21:45
     * @Param couponCreateVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/coupon/create",method = RequestMethod.POST)
    public BaseRespVo insertCoupon(@RequestBody CouponCreateVo couponCreateVo){
        return adService.insertCoupon(couponCreateVo);
    }

    /**
     * @Description 删除优惠券
     * @Author LM
     * @Date 2019/10/2 21:46
     * @Param couponVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/coupon/delete",method = RequestMethod.POST)
    public BaseRespVo deleteCoupon(@RequestBody CouponVo couponVo){
        return adService.deleteCoupon(couponVo);
    }

    /**
     * @Description 更新优惠券信息
     * @Author LM
     * @Date 2019/10/2 21:48
     * @Param couponVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/coupon/update",method = RequestMethod.POST)
    public BaseRespVo updateCoupon(@RequestBody CouponVo couponVo){
        return adService.updateCoupon(couponVo);
    }

    /**
     * @Description 通过id查询优惠券详细信息
     * @Author LM
     * @Date 2019/10/3 20:04
     * @Param id
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/coupon/read",method = RequestMethod.GET)
    public BaseRespVo readCouponById(int id){
        return adService.readCouponById(id);
    }

    /**
     * @Description 查询优惠券使用信息
     * @Author LM
     * @Date 2019/10/3 20:04
     * @Param page
     * @Param limit
     * @Param couponId
     * @Param sort
     * @Param order
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "coupon/listuser",method = RequestMethod.GET)
    public BaseRespVo queryAllListuser(int page, int limit, Integer couponId, Integer userId,Integer status, String sort, String order){
        return adService.queryAllListuser(page,limit,couponId,userId,status,sort,order);
    }


    /**
     * @Description 分页查询所有专题信息
     * @Author LM
     * @Date 2019/10/2 22:34
     * @Param null
     * @Return
     **/
    @RequestMapping(value = "/topic/list",method = RequestMethod.GET)
    public BaseRespVo queryAllTopic(int page,int limit,String title,String subtitle,String sort,String order){
        return adService.queryAllTopic(page,limit,title,subtitle,sort,order);
    }

    /**
     * @Description 添加专题
     * @Author LM
     * @Date 2019/10/3 20:05
     * @Param topicCreateVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/topic/create",method = RequestMethod.POST)
    public BaseRespVo insertTopic(@RequestBody TopicCreateVo topicCreateVo){
        return adService.insertTopic(topicCreateVo);
    }

    /**
     * @Description 编辑专题
     * @Author LM
     * @Date 2019/10/3 20:05
     * @Param topicUpdateVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/topic/update",method = RequestMethod.POST)
    public BaseRespVo updateTopic(@RequestBody TopicUpdateVo topicUpdateVo){
        return adService.updateTopic(topicUpdateVo);
    }

    /**
     * @Description 删除专题
     * @Author LM
     * @Date 2019/10/3 20:05
     * @Param topicUpdateVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/topic/delete",method = RequestMethod.POST)
    public BaseRespVo deleteTopic(@RequestBody TopicUpdateVo topicUpdateVo){
        return adService.deleteTopic(topicUpdateVo);
    }


    /**
     * @return 查询所有团购规则(包含指定id的查询)
     * @author piter_liu
     * @Date 2019/10/2
     */

    @RequestMapping(value = "/groupon/list",method = RequestMethod.GET)
    public BaseRespVo queryAllGrouponRules(int page, int limit,Integer goodsId, String sort, String order){
        return adService.queryAllGrouponRules(page,limit,goodsId,sort,order);
    }

    /**
     * @return 查询所有团购活动
     * @author piter_liu
     * @Date 2019/10/2
     */
    @RequestMapping(value = "/groupon/listRecord",method = RequestMethod.GET)
    public BaseRespVo queryAllGroupon(int page, int limit,Integer goodsId, String sort, String order){
        return adService.queryAllGroupon(page,limit,goodsId,sort,order);
    }

    /**
     * @param rule 新增一条团购规则数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    @RequestMapping(value = "/groupon/create",method = RequestMethod.POST)
    public BaseRespVo createOneRule(@RequestBody AdRulesAddition rule){
        return adService.createOneRule(rule);
    }
    /**
     * @param rule 更新团购规则数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    @RequestMapping("/groupon/update")
    public BaseRespVo updateRules(@RequestBody AdGoodsRulesVo rule){
        return adService.updateRules(rule);
    }

    /**
     * @param rule 删除团购规则数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    @RequestMapping("groupon/delete")
    public BaseRespVo deleteRules(@RequestBody AdGoodsRulesVo rule){
        return adService.deleteRules(rule);
    }
}
