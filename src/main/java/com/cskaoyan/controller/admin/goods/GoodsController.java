package com.cskaoyan.controller.admin.goods;

import com.cskaoyan.service.admin.goods.GoodsService;
import com.cskaoyan.vo.BaseRespVo;

import com.cskaoyan.vo.goods.*;

import com.cskaoyan.vo.comment.CommentSearchVo;
import com.cskaoyan.vo.comment.CommentVo;

import com.cskaoyan.vo.user.UserBaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GF
 * @description 商品管理
 * @date 2019/10/2
 */
@RequestMapping("/admin")
@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /*
     *功能描述 查询全部商品和商品的条件的查询
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping("/goods/list")
    public BaseRespVo queryAllGoodsList(int page, int limit, String goodsSn, String name, String sort, String order) {
        UserBaseRespVo userBaseRespVo = goodsService.queryAllGoodsList(page, limit, goodsSn, name, sort, order);
        return BaseRespVo.success(userBaseRespVo);
    }

    /*
     *功能描述 商品的分类和品牌信息的添加显示
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping("/goods/catAndBrand")
    public BaseRespVo queryCategoryList() {
        List<CategoryListVo> categoryListVos = goodsService.queryCategoryList();
        List<BrandListVo> brandListVos = goodsService.queryGoodsBrandList();
        GoodsBaseRespVo goodsBaseRespVo = new GoodsBaseRespVo();
        goodsBaseRespVo.setBrandList(brandListVos);
        goodsBaseRespVo.setCategoryList(categoryListVos);
        BaseRespVo success = BaseRespVo.success(goodsBaseRespVo);
        return success;

    }

    /*
     *功能描述商品信息的添加
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping(value = "/goods/create", method = RequestMethod.POST)
    public BaseRespVo insertGoods(@RequestBody GoodsVoList goodsVo) {
        goodsService.insertGoods(goodsVo);
        return BaseRespVo.success(null);
    }

    /*
     *功能描述商品信息的删除
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping("/goods/delete")
    public BaseRespVo deleteGoodsById(@RequestBody GoodsVo goodsVo) {
        goodsService.deleteGoodsById(goodsVo);
        return BaseRespVo.success(null);
    }


    /* *
     * 功能描述  显示商品评论
     * @author wangdi
     * @date 2019/10/2 14:49
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/comment/list", method = RequestMethod.GET)
    public BaseRespVo commentList(int page, int limit, String userId, String valueId, String sort, String order) {
        CommentSearchVo commentSearchVo = new CommentSearchVo(page, limit, userId, valueId, sort, order);
        return goodsService.commentList(commentSearchVo);
    }

    /* *
     * 功能描述 回复商品评论
     * @author wangdi
     * @date 2019/10/2 15:50
     * @param commentVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/reply", method = RequestMethod.POST)
    public BaseRespVo orderReply(@RequestBody CommentVo commentVo) {
        return goodsService.orderReply(commentVo);
    }

    /* *
     * 功能描述 评论删除
     * @author wangdi
     * @date 2019/10/2 15:51
     * @param commentVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/comment/delete", method = RequestMethod.POST)
    public BaseRespVo commentDelete(@RequestBody CommentVo commentVo) {
        return goodsService.commentDelete(commentVo);
    }


    //根据商品id查询商品信息
    @RequestMapping("/goods/detail")
    public BaseRespVo queryGoodsById(int id) {
        GoodsVoList goodsVoList = goodsService.queryGoodsById(id);
        BaseRespVo success = BaseRespVo.success(goodsVoList);
        return success;
    }

    //根据商品id修改商品信息
    @RequestMapping("/goods/update")
    public BaseRespVo updateGoods(@RequestBody GoodsVoList goodsVo) {
        goodsService.updateGoods(goodsVo);
        return BaseRespVo.success(null);
    }


}

