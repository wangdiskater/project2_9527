package com.cskaoyan.service.wx.goods;

import com.cskaoyan.bean.FootPrint;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.vo.goods.GoodsSpecificationVo;
import com.cskaoyan.vo.goods.GoodsVo;
import com.cskaoyan.vo.goods.ProductSVo;
import com.cskaoyan.vo.user.FootPrintVo;
import com.cskaoyan.vo.wx.wxgoods.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GF
 * @description 前台的商品相关功能的实现
 * @date 2019/10/4
 */

@Service
public class WxGoodsServiceImpl implements WxGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    /*
    *功能描述 统计商品的个数
    *@author GF
    *@date
    *@param
    *@return
    */
    @Override
    public int queryGoodsCount() {
        return goodsMapper.queryGoodsCount();
    }

    /*
    *功能描述 获得商品分类数据
    *@author GF
    *@date
    *@param
    *@return
    */
    @Override
    public WxCategoryListVo queryCategory(int id) {
        //找到当前Id
        WxCategoryVo wxCategoryVo = goodsMapper.queryCurrentCategory(id);

        //找到兄弟标签
        int pid = wxCategoryVo.getPid();
        List<WxCategoryVo> brotherCategory = goodsMapper.queryBrotherCategory(pid);
        //拿到所有二级标签
        List<WxCategoryVo> childCategoryVos = goodsMapper.queryBrotherCategory(id);

        //拿到所有二级标签的商品
        List<GoodsVo> goodsList = new ArrayList<>();
        for (WxCategoryVo childCategoryVo : childCategoryVos) {
            int secondPid = childCategoryVo.getId();
            List<GoodsVo>goods =  goodsMapper.queryWxGoodsByCategoryId(secondPid);
            //全部加入
            for (GoodsVo good : goods) {
                goodsList.add(good);
            }
            //最多显示20
            if(goodsList.size() > 20){
                break;
            }
        }

        WxCategoryVo parentCategory = goodsMapper.queryParentCategory(pid);

        WxCategoryListVo wxCategoryListVo = new WxCategoryListVo();
        wxCategoryListVo.setGoodsList(goodsList);
        wxCategoryListVo.setCurrentCategory(wxCategoryVo);
        wxCategoryListVo.setBrotherCategory(brotherCategory);
        wxCategoryListVo.setParentCategory(parentCategory);

        return wxCategoryListVo;
    }

    @Override
    public WxGoodsListVo queryWxGoodsList(String keyword,int id, int page, int size) {
        List<GoodsVo> goodsVoList = goodsMapper.queryGoodsList(keyword,id);
        PageHelper.startPage(page,size);
        List<WxCategoryVo> wxCategoryVos = goodsMapper.queryWxCategoryList();
        PageInfo<GoodsVo> goodsVoPageInfo = new PageInfo<>(goodsVoList);
        long total = goodsVoPageInfo.getTotal();
        WxGoodsListVo wxGoodsListVo = new WxGoodsListVo();
        wxGoodsListVo.setCount(total);
        wxGoodsListVo.setFilterCategoryList(wxCategoryVos);
        wxGoodsListVo.setGoodsList(goodsVoList);
        return wxGoodsListVo;
    }

    //查询商品详情表
    /* *
     * 功能描述  如果用户登录，把查看商品详情加入， 如果用户没有登录就是直接显示。
     * @author wangdi
     * @date   2019/10/26 21:59
     * @param id
     * @return com.cskaoyan.vo.wx.wxgoods.WxGoodsDetailsVo
     */
    @Override
    public WxGoodsDetailsVo queryWxGoodsDetail(int id) {
        WxGoodsDetailsVo wxGoodsDetailsVo = new WxGoodsDetailsVo();
        //查询商品
        GoodsVo goodsVo = goodsMapper.queryWxGoodsById(id);
        int brandId = goodsVo.getBrandId();
        //查询商品规格名
      //  String name = goodsMapper.queryWxSpecificationNameById(id);

       //查询规格list
        List<GoodsSpecificationVo> goodsSpecificationVos = goodsMapper.queryWxSpecification(id);
        ArrayList<WxSpecifiacationListVo> wxSpecifiacationListVos = new ArrayList<>();
        for (GoodsSpecificationVo goodsSpecificationVo : goodsSpecificationVos) {
            WxSpecifiacationListVo wxSpecifiacationListVo = new WxSpecifiacationListVo();
            wxSpecifiacationListVo.setName(goodsSpecificationVo.getSpecification());
            List<GoodsSpecificationVo> goodsSpecificationVos1 = new ArrayList<>();
            goodsSpecificationVos1.add(goodsSpecificationVo);
            wxSpecifiacationListVo.setValueList(goodsSpecificationVos1);
            wxSpecifiacationListVos.add(wxSpecifiacationListVo);
        }
       // wxSpecifiacationListVo.setName(name);

        //添加商品足迹
        //拿到用户id
        Integer sessionUserId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(sessionUserId != null){
            FootPrint footPrint = new FootPrint();
            footPrint.setUser_id(sessionUserId);
            footPrint.setGoods_id(id);
            footPrint.setAdd_time(new Date());
            footPrint.setUpdate_time(new Date());
            //判断一下是否之前有浏览过这个商品
            int goodsFootPrint = userMapper.existGoodsFootPrint(id);
            if(goodsFootPrint == 0){
                int insert = userMapper.addFootPrint(footPrint);
            } else {
                //删除旧的插入新的---为了保持顺序
                int delete = userMapper.deleteFootPrint(footPrint);
                int insert = userMapper.addFootPrint(footPrint);

            }
        }

        //查询优惠券
        List<WxGrouponVo> wxGrouponVos = goodsMapper.queryWxGroupon(id);
        //查询问题
        List<WxIssueVo> wxIssueVos = goodsMapper.queryWxIssue();
        //查询商品参数
        List<WxAttributeVo> wxAttributeVos = goodsMapper.queryWxAttribute(id);
        //查询商品品牌
        WxBrandVo wxBrandVo = goodsMapper.queryWxBrand(brandId);
        //查询商品的货品
        List<ProductSVo> productSVos = goodsMapper.queryWxProduct(id);

        //查询评论
        List<WxVGoodsComment> wxVGoodsComments = goodsMapper.queryGoodsComment(id);
        for (WxVGoodsComment wxVGoodsComment : wxVGoodsComments) {
            int userId = wxVGoodsComment.getUserId();
            WxGoodsUser wxGoodsUser = goodsMapper.queryWxUserById(userId);
            wxVGoodsComment.setNickname(wxGoodsUser.getNickname());
            wxVGoodsComment.setAvatar(wxGoodsUser.getAvatar());
        }
        PageInfo<WxVGoodsComment> wxVGoodsCommentPageInfo = new PageInfo<>(wxVGoodsComments);
        long total = wxVGoodsCommentPageInfo.getTotal();
        WxCommentVo wxCommentVo = new WxCommentVo();
        wxCommentVo.setCount(total);
        wxCommentVo.setData(wxVGoodsComments);

        //进行封装
        wxGoodsDetailsVo.setAttribute(wxAttributeVos);
        wxGoodsDetailsVo.setBrand(wxBrandVo);
        wxGoodsDetailsVo.setGroupon(wxGrouponVos);
        wxGoodsDetailsVo.setIssue(wxIssueVos);
        wxGoodsDetailsVo.setProductList(productSVos);
        wxGoodsDetailsVo.setInfo(goodsVo);
        wxGoodsDetailsVo.setSpecificationList(wxSpecifiacationListVos);
        wxGoodsDetailsVo.setComment(wxCommentVo);
        return wxGoodsDetailsVo;
    }

      // 商品详情页的关联商品
    @Override
    public WxGoodsRelatedVo queryWxGoosdRealtedById(int id) {
        int categoryId = goodsMapper.queryWxGoodsCategoryById(id);
        List<GoodsVo> goodsVoList = goodsMapper.queryWxGoosdRealtedById(categoryId);
        WxGoodsRelatedVo wxGoodsRelatedVo = new WxGoodsRelatedVo();
        wxGoodsRelatedVo.setGoodsList(goodsVoList);
        return wxGoodsRelatedVo;
    }
}
