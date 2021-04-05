package com.cskaoyan.mapper;


import com.cskaoyan.bean.CollectList;
import com.cskaoyan.bean.FootPrint;
import com.cskaoyan.vo.comment.CommentVo;
import com.cskaoyan.vo.goods.*;
import com.cskaoyan.vo.comment.CommentSearchVo;
import com.cskaoyan.vo.goods.CategoryListVo;
import com.cskaoyan.vo.goods.GoodsVo;
import com.cskaoyan.vo.goods.GoodsVoList;

import com.cskaoyan.vo.wx.comment.CommentShowVo;
import com.cskaoyan.vo.wx.comment.WxCommentVo;
import com.cskaoyan.vo.wx.comment.WxTopticCommentVo;
import com.cskaoyan.vo.wx.wxgoods.WxCategoryVo;

import com.cskaoyan.vo.wx.wxgoods.*;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *功能描述 商品管理
 *@author GF
 *@date
 *@param
 *@return
 */
public interface GoodsMapper {

    //商品列表管理
    List<GoodsVo> queryAllGoodsList(@Param("goodsSn") String goodsSn,

                                    @Param("name") String name, @Param("sort") String sort, @Param("order") String order);

    //商品评论管理
    List<Object> queryComment(@Param("commentSearch") CommentSearchVo commentSearchVo);

    int deleteCommentById(@Param("id") int id);


    //查询商品的类目和他的子类
    List<CategoryListVo> queryCategoryList();


    //查询商品的品牌
    List<BrandListVo> queryGoodsBrandList();

    //添加商品
    int insertGoods(@Param("goodsVoList") GoodsVoList goodsVoList);

    // <!--添加商品参数-->
    int insertGoodsAttribute(@Param("goodsVoList") GoodsVoList goodsVoList);

    // <!--添加商品规格-->
    int insertGoodsSpecification(@Param("goodsVoList") GoodsVoList goodsVoList);

    //<!--添加商品货品-->
    int insertGoodsProduct(@Param("goodsVoList") GoodsVoList goodsVoList);

    //删除商品
    void deleteGoodsById(@Param("goods") GoodsVo goods);


    //根据id查询商品信息
    GoodsVo queryGoodsById(@Param("id") Integer id);

    //根据商品id查询商品参数
    List<GoodsAttributeVo> queryGoodsGoodsAttributesById(@Param("id") int id);

    //根据商品id查询商品规格
    List<GoodsSpecificationVo> queryGoodsSpecifications(@Param("id") int id);

    //根据商品id查询商品货品信息
    List<ProductSVo> queryProductsById(@Param("id") int id);

    //根据商品中类目子id查询父类商品类目pid
    CategoryVo queryCategoryId(@Param("categoryId") int categoryId);

    //获取所有商品的个数
    int queryGoodsCount();


    //商品的修改
    void updateGoods(@Param("goodsVoList") GoodsVoList goodsVo);

    //<!--根据商品id把规格表进行删除-->
    void deleteSpecificationsById(@Param("id") int id);

    // <!--根据商品id把商品货品删除-->
    void deleteProducts(@Param("id") int id);

    //<!--根据商品id把商品参数删除-->
    void deleteAttribute(@Param("id") int id);

    //获取所有货物的个数
    int queryProductsCount();

    //取消商品收藏
    void delete(@Param("valueId") int valueId);

    //增加商品收藏
    void add(int type, int valueId);

    //收藏功能前检查是否已被收藏
    List<Integer> queryCollectOrNot(int valueId);

    //前台显示收藏商品列表
    List<CollectList> queryCollectList();



    /*---------前端代码-----------------*/
    //统计商品总数接口，复用后台

    //获得商品的分类的数据
    WxCategoryVo queryCurrentCategory(@Param("id") int id);

    //获得brotherCategory的分类数据
    List<WxCategoryVo> queryBrotherCategory(@Param("id") int id);

    //获得parentCategory的分类数据
    WxCategoryVo queryParentCategory(@Param("id") int id);

    //查询所有新品商品
    List<GoodsVo> queryAllNewGoods();

    //查询所有热卖商品
    List<GoodsVo> queryAllHotGoods();

    //查询所有商品
    List<GoodsVo> queryAllGoodsToHome();

    //查找一级类目下的所有商品
    List<GoodsVo> selectGoodsByChannel(@Param("pid") int id);

    //显示所有商品个数
    int queryAllGoodsNum();

    //获得商品列表 queryGoodsList
    List<GoodsVo> queryGoodsList(@Param("keyword") String keywords, @Param("id") int id);

    //获得商品的目录
    List<WxCategoryVo> queryWxCategoryList();


    //查找该商品的所有评论
    List<WxCommentVo> queryUserComment(@Param("comment") CommentShowVo commentSearchVo);

/*********************************/
    //获得商品详情 queryWxGoodsDetail
    GoodsVo queryWxGoodsById(@Param("id") int id);
    //单独查询规格名称queryWxSpecificationNameById
    String queryWxSpecificationNameById(@Param("id") int id);
    //查询规格queryWxSpecification
    List<GoodsSpecificationVo> queryWxSpecification(@Param("id") int id);
    //查询优惠卷
    List<WxGrouponVo> queryWxGroupon(@Param("id") int id);
    //查询问题
    List<WxIssueVo> queryWxIssue();
    //查询商品参数表
    List<WxAttributeVo> queryWxAttribute(@Param("id") int id);
    //查询商品品牌queryWxBrand
    WxBrandVo queryWxBrand(@Param("id") int id);
    //查询商品的货品 queryWxProduct
    List<ProductSVo> queryWxProduct(@Param("id") int id);
    //查询商品评论
   List<WxVGoodsComment> queryGoodsComment(@Param("id") int id);
   //根据商品评论的user_id 查询用户表中的nickname,avatorqueryWxUserById
   WxGoodsUser queryWxUserById(@Param("id") int id);


    //获取有图片的评论个数
    int commentPicCountById(Integer valueId, Integer type);

    //获取所有评论个数
    int commentAllCountById(@Param("valueId") Integer valueId, @Param("type") Integer type);


    //先根据商品id查询出商品分类
    int queryWxGoodsCategoryById(@Param("id") int id);
    //商品详情页的关联商品
    List<GoodsVo> queryWxGoosdRealtedById(@Param("id") int id);

    //插入主题评论
    int insertComment(@Param("comment") CommentVo commentVo);

    //查询标签下的所有商品
    List<GoodsVo> queryWxGoodsByCategoryId(@Param("categoryId") int secondPid);

    //增加足迹
//    int addFootPrint(@Param("footPrint") FootPrint footPrint);
}
