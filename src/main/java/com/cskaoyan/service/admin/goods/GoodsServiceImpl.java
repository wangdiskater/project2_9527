package com.cskaoyan.service.admin.goods;

import com.cskaoyan.mapper.GoodsMapper;

import com.cskaoyan.vo.ListVo;
import com.cskaoyan.vo.goods.*;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.comment.CommentSearchVo;
import com.cskaoyan.vo.comment.CommentVo;

import com.cskaoyan.vo.user.UserBaseRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GF
 * @description 商品管理
 * @date 2019/10/2
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    //查询所有的商品
    @Override
    public UserBaseRespVo queryAllGoodsList(int page, int limit, String goodsSn, String name,String sort,String order) {
        PageHelper.startPage(page, limit);
        List<GoodsVo> goodsVos = goodsMapper.queryAllGoodsList(goodsSn, name, sort, order);
        PageInfo<GoodsVo> goodsVosPageInfo = new PageInfo<>(goodsVos);
        long total = goodsVosPageInfo.getTotal();
        UserBaseRespVo<GoodsVo> goodsVoUserBaseRespVo = new UserBaseRespVo<>();
        goodsVoUserBaseRespVo.setItems(goodsVos);
        goodsVoUserBaseRespVo.setTotal(total);
        return goodsVoUserBaseRespVo;
    }


    //查询商品的类目和他的子类
    @Override
    public List<CategoryListVo> queryCategoryList() {
        List<CategoryListVo> categoryListVos = goodsMapper.queryCategoryList();
        return categoryListVos;
    }

    //查询商品的品牌
    @Override
    public List<BrandListVo> queryGoodsBrandList() {
        List<BrandListVo> brandListVos = goodsMapper.queryGoodsBrandList();
        return brandListVos;
    }


    //添加商品
    @Override
    public int insertGoods(GoodsVoList goodsVo) {
        int num = goodsMapper.insertGoods(goodsVo);
        List<GoodsAttributeVo> attributes = goodsVo.getAttributes();
        goodsMapper.insertGoodsAttribute(goodsVo);//goodsVoList
       goodsMapper.insertGoodsProduct(goodsVo);
         goodsMapper.insertGoodsSpecification(goodsVo);
        return num;
    }

    //删除商品
    @Override
    public void deleteGoodsById(GoodsVo goodsVo) {

        goodsMapper.deleteGoodsById(goodsVo);
    }




    /* *
     * 功能描述
     * @author wangdi
     * @date 2019/10/2 15:11
     * @param commentSearchVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo commentList(CommentSearchVo commentSearchVo) {
        PageHelper.startPage(commentSearchVo.getPage(),commentSearchVo.getLimit());
        List<Object> commentVos = goodsMapper.queryComment(commentSearchVo);
        PageInfo<Object> commentVoPageInfo = new PageInfo<>(commentVos);
        long total = commentVoPageInfo.getTotal();
        ListVo listVo = new ListVo(total, commentVos);

        return BaseRespVo.success(listVo);
    }

    /* *
     * 功能描述 商品回复 --- 找不到回复表
     * @author wangdi
     * @date 2019/10/2 15:48
     * @param commentVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderReply(CommentVo commentVo) {

        return BaseRespVo.success("");
    }

    @Override
    public BaseRespVo commentDelete(CommentVo commentVo) {
        int delete = goodsMapper.deleteCommentById(commentVo.getId());
        if(delete == 1){
            return BaseRespVo.success("");
        }
        return null;
    }



    //根据商品id查询商品的信息
    @Override
    public GoodsVoList queryGoodsById(int id) {
        GoodsVoList goodsVoList = new GoodsVoList();
        //查询商品信息
        GoodsVo goodsVo = goodsMapper.queryGoodsById(id);

        // 查询商品货品信息
        List<ProductSVo> productSVos = goodsMapper.queryProductsById(id);
        //查询商品参数
        List<GoodsAttributeVo> goodsAttributeVos = goodsMapper.queryGoodsGoodsAttributesById(id);
        //查询商品规格
        List<GoodsSpecificationVo> goodsSpecificationVos = goodsMapper.queryGoodsSpecifications(id);

        //查询商品类目
        int categoryId = goodsVo.getCategoryId();
        CategoryVo categoryVo = goodsMapper.queryCategoryId(categoryId);

        //进行封装
        goodsVoList.setAttributes(goodsAttributeVos);
        goodsVoList.setProducts(productSVos);
        goodsVoList.setSpecifications(goodsSpecificationVos);
        goodsVoList.setGoods(goodsVo);
        goodsVoList.setCategoryIds(new Integer[]{categoryVo.getId(),categoryVo.getPid()});
        return goodsVoList;
    }

    @Override
    public void updateGoods(GoodsVoList goodsVoList) {
        //修改商品
        goodsMapper.updateGoods(goodsVoList);
        int id = goodsVoList.getGoods().getId();
        //删除商品相关信息
        goodsMapper.deleteAttribute(id);
        goodsMapper.deleteProducts(id);
        goodsMapper.deleteSpecificationsById(id);

        //重新对商品信息添加
        goodsMapper.insertGoodsAttribute(goodsVoList);
        goodsMapper.insertGoodsProduct(goodsVoList);
        goodsMapper.insertGoodsSpecification(goodsVoList);


    }

}
