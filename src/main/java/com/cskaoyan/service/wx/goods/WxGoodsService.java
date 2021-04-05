package com.cskaoyan.service.wx.goods;

import com.cskaoyan.vo.goods.GoodsVo;
import com.cskaoyan.vo.wx.wxgoods.*;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Var;

import java.util.List;

public interface WxGoodsService {


    //统计商品总数
    int queryGoodsCount();

    // 获得商品分类数据
    WxCategoryListVo queryCategory(int id);


    //获得前台商品列表
    WxGoodsListVo queryWxGoodsList(String keyword,int id,int page,int size);

    //查询商品详情
    WxGoodsDetailsVo queryWxGoodsDetail(int id);

    // 商品详情页的关联商品
    WxGoodsRelatedVo queryWxGoosdRealtedById(int id);



}
