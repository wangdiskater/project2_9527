package com.cskaoyan.service.admin.mallManage;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.category.CategoryVo;
import com.cskaoyan.vo.category.SubCategoryVo;
import com.cskaoyan.vo.issue.IssueSearchVo;
import com.cskaoyan.vo.issue.IssueVo;
import com.cskaoyan.vo.keyword.KeywordSearchVo;
import com.cskaoyan.vo.keyword.KeywordVo;
import com.cskaoyan.vo.mall.BrandCreateVo;
import com.cskaoyan.vo.mall.BrandVo;
import com.cskaoyan.vo.order.OrderSearchVo;

import java.util.Map;

public interface MallManageService {
    BaseRespVo regionList();

    BaseRespVo brandList(Integer page, Integer limit, Integer id, String name, String sort, String order);


    BaseRespVo createBrand(BrandCreateVo brandCreateVo);

    BaseRespVo updateBrand(BrandVo brandVo);

    BaseRespVo deleteBrand(BrandVo brandVo);

    BaseRespVo categoryList();

    BaseRespVo categoryLabel();

    BaseRespVo categoryCreate(SubCategoryVo categoryVo);

    BaseRespVo categoryUpdate(CategoryVo categoryVo);

    BaseRespVo categoryDelete(CategoryVo categoryVo);

    BaseRespVo orderList(OrderSearchVo orderSearchVo);

    BaseRespVo orderDetail(int id);

    BaseRespVo issueList(IssueSearchVo issueSearchVo);

    BaseRespVo issueCreate(Map issueMap);

    BaseRespVo issueUpdate(IssueVo issueVo);

    BaseRespVo issueDelete(IssueVo issueVo);

    BaseRespVo keywordList(KeywordSearchVo keywordSearchVo);

    BaseRespVo keywordCreate(KeywordVo keywordVo);

    BaseRespVo keywordUpdate(KeywordVo keywordVo);

    BaseRespVo keywordDelete(KeywordVo keywordVo);

    BaseRespVo orderShip(Map orderMap);

    BaseRespVo orderRefund(Map orderMap);

}
