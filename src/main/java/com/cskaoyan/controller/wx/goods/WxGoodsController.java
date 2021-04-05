package com.cskaoyan.controller.wx.goods;

import com.cskaoyan.service.wx.goods.WxGoodsService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.goods.GoodsCount;
import com.cskaoyan.vo.wx.wxgoods.WxCategoryListVo;
import com.cskaoyan.vo.wx.wxgoods.WxGoodsDetailsVo;
import com.cskaoyan.vo.wx.wxgoods.WxGoodsListVo;
import com.cskaoyan.vo.wx.wxgoods.WxGoodsRelatedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GF
 * @description 前台商品管理的相关功能
 * @date 2019/10/4
 */


@RequestMapping("/wx")
@RestController
public class WxGoodsController {

    @Autowired
    WxGoodsService wxGoodsService;



    @RequestMapping("/goods/count")
    public BaseRespVo queryGoodsCount(){
        int i = wxGoodsService.queryGoodsCount();
        GoodsCount goodsCount = new GoodsCount();
        goodsCount.setGoodsCount(i);
        return BaseRespVo.success(goodsCount);
    }

    //获得分类数据
    @RequestMapping("/goods/category")
    public BaseRespVo queryCategory(int id){
        WxCategoryListVo wxCategoryListVo = wxGoodsService.queryCategory(id);
        BaseRespVo success = BaseRespVo.success(wxCategoryListVo);
        return success;
    }


   /* //获得商品列表
    @RequestMapping("/goods/list")
    public BaseRespVo queryWxxGoodsList(int categoryId,int page,int size){
        WxGoodsListVo wxGoodsListVo = wxGoodsService.queryWxGoodsList(categoryId, page, size);
        BaseRespVo success = BaseRespVo.success(wxGoodsListVo);
        return success;
    }
*/

//查询商品详情
    @RequestMapping("/goods/detail")
    public BaseRespVo WxGoodsDetailsVo(int id){
        WxGoodsDetailsVo wxGoodsDetailsVo = wxGoodsService.queryWxGoodsDetail(id);
        BaseRespVo success = BaseRespVo.success(wxGoodsDetailsVo);
        return success;
    }

    //商品详情页的关联商品
    @RequestMapping("/goods/related")
    public BaseRespVo WxGoodsRelatedVo(int id){
        WxGoodsRelatedVo wxGoodsRelatedVo = wxGoodsService.queryWxGoosdRealtedById(id);
        BaseRespVo success = BaseRespVo.success(wxGoodsRelatedVo);
        return success;
    }

}
