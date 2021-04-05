package com.cskaoyan.service.admin.goods;


import com.cskaoyan.vo.goods.BrandListVo;
import com.cskaoyan.vo.goods.CategoryListVo;
import com.cskaoyan.vo.goods.GoodsVo;
import com.cskaoyan.vo.goods.GoodsVoList;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.comment.CommentSearchVo;
import com.cskaoyan.vo.comment.CommentVo;

import com.cskaoyan.vo.user.UserBaseRespVo;

import java.util.List;


public interface GoodsService {

    UserBaseRespVo queryAllGoodsList(int page, int limit, String goodsSn, String name, String sort, String order);

    //查询商品的类目和他的子类
    List<CategoryListVo> queryCategoryList();


    //查询商品的品牌
    List<BrandListVo> queryGoodsBrandList();

    //添加商品
    int insertGoods(GoodsVoList goodsVo);

    //删除商品
    void deleteGoodsById(GoodsVo goodsVo);

    BaseRespVo commentList(CommentSearchVo commentSearchVo);

    BaseRespVo orderReply(CommentVo commentVo);

    BaseRespVo commentDelete(CommentVo commentVo);

    //根据id查询商品的相关信息
    GoodsVoList queryGoodsById(int id);

    void updateGoods(GoodsVoList goodsVo);
}
