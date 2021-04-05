package com.cskaoyan.service.wx.brand;

import com.cskaoyan.bean.Brand;
import com.cskaoyan.bean.BrandInfo;
import com.cskaoyan.bean.CategoryInfo;
import com.cskaoyan.bean.GoodsInfo;
import com.cskaoyan.mapper.MallManageMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.brand.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/5
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    MallManageMapper mallManageMapper;

    /**
     * @param page
     * @param size
     * @return  显示所有品牌
     */
    @Override
    public BaseRespVo showBrands(int page, int size) {
        PageHelper.startPage(page, size);
        List<Brand> brands = mallManageMapper.queryAllBrand();
        ArrayList<ShowBrandVo> brandList = new ArrayList<>();
        if (brands != null){
            for (Brand brand : brands) {
                ShowBrandVo brandVo = new ShowBrandVo(brand);
                brandList.add(brandVo);
            }
        }
        BrandMerge merge = new BrandMerge();
        merge.setBrandList(brandList);
        merge.setTotalPages(5);
        return BaseRespVo.success(merge);
    }

    /**
     * @param id
     * @return 显示品牌的详情1
     */
    @Override
    public BaseRespVo showBrandDetail(int id) {
        BrandInfo brandInfo = mallManageMapper.queryBrandDetail(id);
        BrandDetailVo brandDetailVo = null;
        if (brandInfo != null){
            brandDetailVo = new BrandDetailVo(brandInfo);
        }
        BrandInfoVo vo = new BrandInfoVo();
        vo.setBrand(brandDetailVo);
        return BaseRespVo.success(vo);
    }

    /**
     * @param brandId
     * @param page
     * @param size
     * @return  显示商品详情信息2
     */
    @Override
    public BaseRespVo showGoods(int brandId, int page, int size) {
        PageHelper.startPage(page, size);
        List<GoodsInfo> goodsList = mallManageMapper.queryGoodsListByBrandId(brandId);
        List<CategoryInfoVo> categoryInfoVoList = new ArrayList<>();
        List<GoodsInfoVo> goodsInfoVoList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        GoodsMerge merge = new GoodsMerge();
        if (goodsList != null){
            for (GoodsInfo goods : goodsList) {
                GoodsInfoVo goodsInfoVo = new GoodsInfoVo(goods);
                goodsInfoVoList.add(goodsInfoVo);
                goodsInfoVoList.add(goodsInfoVo);
                int categoryId = goods.getCategory_id();
                CategoryInfo categoryInfo = mallManageMapper.queryCategoryInfo(categoryId);
                int id = categoryInfo.getId();
                if (id != 0 && !list.contains(id)){
                    list.add(id);
                    CategoryInfoVo categoryInfoVo = null;
                    if (categoryInfo != null){
                        categoryInfoVo = new CategoryInfoVo(categoryInfo);
                    }
                    if (categoryInfoVoList.contains(categoryInfoVo)){
                        continue;
                    }
                    categoryInfoVoList.add(categoryInfoVo);
                }
            }
            merge.setCount(goodsList.size());
            merge.setFilterCategoryList(categoryInfoVoList);
            merge.setGoodsList(goodsInfoVoList);
        }
        return BaseRespVo.success(merge);
    }
}
