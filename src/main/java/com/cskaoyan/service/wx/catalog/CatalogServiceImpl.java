package com.cskaoyan.service.wx.catalog;

import com.cskaoyan.bean.Category;
import com.cskaoyan.mapper.MallManageMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.catalog.CatalogVo;
import com.cskaoyan.vo.category.SubCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName CatalogServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 12:07
 **/
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    MallManageMapper mallManageMapper;
    /* *
     * 功能描述 显示所有分类
     * @author wangdi
     * @date 2019/10/5 12:08
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */

    @Override
    public BaseRespVo catalogShow() {
        List<SubCategoryVo> categoryList = mallManageMapper.selectAllFirstCategoryToCatalog();
//        for (Category category : categories) {
//            SubCategoryVo subCategoryVo = new SubCategoryVo(category);
//            categoryList.add(subCategoryVo);
//        }
        List<SubCategoryVo> currentSubCategory = mallManageMapper.selectSubCategoryByPid(categoryList.get(0).getId());
        CatalogVo catalogVo = new CatalogVo(categoryList.get(0),categoryList,currentSubCategory);


        return BaseRespVo.success(catalogVo);
    }

    /* *
     * 功能描述 显示当前id 二级目录
     * @author wangdi
     * @date 2019/10/5 14:14
     * @param id
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo catalogCurrent(int id) {
        SubCategoryVo currentCategory = mallManageMapper.selectFirstCategoryById(id);
        List<SubCategoryVo> currentSubCategory = mallManageMapper.selectSubCategoryByPid(id);
        CatalogVo catalogVo = new CatalogVo(currentCategory,currentSubCategory);
        return BaseRespVo.success(catalogVo);
    }
}
