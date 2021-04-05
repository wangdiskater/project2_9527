package com.cskaoyan.controller.wx.brand;

import com.cskaoyan.mapper.MallManageMapper;
import com.cskaoyan.service.wx.brand.BrandService;
import com.cskaoyan.service.wx.goods.WxGoodsService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.wxgoods.WxGoodsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther Piter_Liu
 * @Description  关于品牌的接口 oooook
 * @Date 2019/10/4
 */
@RestController
@RequestMapping("wx")
public class BrandController {

    @Autowired
    BrandService brandService;
    @Autowired
    WxGoodsService wxGoodsService;

    /**
     * @param page
     * @param size
     * @return  显示所有品牌
     */
    @RequestMapping("brand/list")
    public BaseRespVo showBrands(int page, int size){
        return brandService.showBrands(page,size);
    }

    /**
     * @param id
     * @return 显示品牌的详情1
     */
    @RequestMapping("brand/detail")
    public BaseRespVo showBrandDetail(int id){
        return brandService.showBrandDetail(id);
    }

    /**
     * @param brandId
     * @param page
     * @param size
     * @return  显示商品详情信息2
     */
    @RequestMapping("goods/list")
    public BaseRespVo showGoods(String keyword,Integer categoryId,Integer brandId, int page, int size){
        if(brandId != null){
            return brandService.showGoods(brandId,page,size);
        }
        else if (keyword !=null||categoryId !=null){
            WxGoodsListVo wxGoodsListVo = wxGoodsService.queryWxGoodsList(keyword ,categoryId, page, size);
            BaseRespVo success = BaseRespVo.success(wxGoodsListVo);
            return success;

        }
        return  null;
    }

}
