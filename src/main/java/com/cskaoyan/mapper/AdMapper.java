package com.cskaoyan.mapper;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.vo.ad.*;
import com.cskaoyan.bean.*;
import com.cskaoyan.vo.ad.AdGoodsRulesVo;
import com.cskaoyan.vo.wx.topic.TopicByIdVo;
import com.cskaoyan.vo.wx.topic.TopicListVo;
import com.cskaoyan.vo.wx.home.HomeCouponVo;
import com.cskaoyan.vo.wx.home.HomeGrouponVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author LM
 * @Date 2019/9/30
 * @Param null
 * @Return
 **/
public interface AdMapper {

    //查询所有广告
    List<Object> queryAllAd(String name, String content,String sort,String order);

    //查询所有优惠券
    List<Object> queryAllCoupon(String name, Integer type, Integer status, String sort, String order);

    /**
     * @return 查询所有团购规则
     * @author piter_liu
     * @Date 2019/10/2
     */
    List<AdGoodsRules> queryAllGrouponRules(@Param("goodsId") Integer goodsId,
                                            @Param("sort") String sort,
                                            @Param("order") String order);

    /**
     * @param rule 根据goodsId 去查询部分需要的数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    AdRulesAddition queryGoodsForAddRule(@Param("rule") AdRulesAddition rule);

    /**
     * @param rule 新增一条团购规则数据
     * @return
     * @author piter_liu
     * @Date 2019/10/2
     */
    int addOneRule(@Param("rule") AdRulesAddition rule);

    /**
     * @return 查询所有团购活动
     * @author piter_liu
     * @Date 2019/10/2
     */
    List<AdGroupon> queryAllGroupon();

    /**
     * @param id
     * @return 查询mall_groupon_rules表中的一个数据
     * @author piter_liu
     * @Date 2019/10/2
     */
    AdGoodsRules queryOneRules(@Param("rulesId") int id);

    /**
     * @param id
     * @return 查询mall_goods表中的一个数据
     * @author piter_liu
     * @Date 2019/10/2
     */
    AdGoods queryOneGoods(@Param("goodsId") int id);

    /**
     * @param rule 更新团购规则数据
     * @author piter_liu
     * @Date 2019/10/2
     */
    int updateRules(@Param("rule") AdGoodsRulesVo rule);

    /**
     * @param rule 删除团购规则数据
     * @author piter_liu
     * @Date 2019/10/2
     */
    int deleteRules(@Param("rule") AdGoodsRulesVo rule);

    //添加广告
    int insertAd(@Param("ad") Ad ad);

    //编辑广告
    int updateAd(@Param("ad") Ad ad);

    //删除广告
    int deleteAd(@Param("id") int id);

    //添加优惠券
    void insertCoupon(@Param("cv") CouponVo couponVo);

    //编辑优惠券
    void updateCoupon(@Param("cv") CouponVo couponVo);

    //删除优惠券
    int deleteCoupon(@Param("id") int id);

    //查询所有专题
    List<TopicVo> queryAllTopic(String title, String subtitle, String sort, String order);

    //添加专题
    void insertTopic(@Param("tv") TopicVo topicVo);

    //编辑专题
    void updateTopic(@Param("tuv") TopicUpdateVo topicUpdateVo);

    //删除专题
    int deleteTopic(@Param("id") int id);

    //通过id查询优惠券详细信息
    Coupon queryCouponById(int id);

    //查询优惠券使用信息
    List<Object> queryAllListuser( @Param("couponId") Integer couponId,
                                   @Param("userId") Integer userId,
                                   @Param("status") Integer status,
                                   @Param("sort") String sort,
                                   @Param("order") String order);

    //前台查询所有专题
    List<TopicListVo> queryTopicList();

    //前台关联专题信息
    List<TopicListVo> queryTopicRelated();

    //前台通过id查询专题信息
    TopicByIdVo queryTopicById(int id);

    //查询所有优惠券给前端主页显示
    List<HomeCouponVo> queryAllCouponToHome();

    //查询所有团购
    List<HomeGrouponVo> queryAllGrouponToHome();

    //查询所有广告
    List<AdListVo> queryAllAdToHome();

    //查询所有主题
    List<TopicVo> queryAllTopicToHome();

    List<AdGroupon> querySomeGroupon(@Param("rules_id") int rules_id);
}

