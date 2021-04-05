package com.cskaoyan.mapper;

import com.cskaoyan.bean.*;
import com.cskaoyan.vo.category.SubCategoryVo;
import com.cskaoyan.vo.issue.IssueSearchVo;
import com.cskaoyan.vo.keyword.KeywordSearchVo;
import com.cskaoyan.vo.mall.BrandVo;
import com.cskaoyan.vo.order.OrderSearchVo;
import com.cskaoyan.vo.wx.home.ChannelVo;
import com.cskaoyan.vo.wx.rest.RegionByIdVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallManageMapper {
    List<Region> selectAllRegion();

    List<Brand> selectBrandList(String sort, String order, Integer id, String name);

    int insertBrand(@Param("brand") Brand brand);

    int updateBrandById(@Param("brand") Brand Brand);

    int deleteBrandById(@Param("id")int id);

    List<Category> selectAllCategory();

    int insertCategory(@Param("category") Category category);

    int updateCategoryById(@Param("category") Category category);

    int deleteCategoryById(@Param("id")int id);

    List<Order> selectOrder(@Param("orderSearch") OrderSearchVo orderSearchVo);

    Order selectOrderById(@Param("id")int id);

    List<OrderGoods> selectOrderGoodsByOrderId(int id);

    List<Issue> selectIssue(@Param("issueSearch") IssueSearchVo issueSearchVo);

    int insertIssue(@Param("issue") Issue issue);

    int updateIssueById(@Param("issue") Issue issue);

    int deleteIssueById(@Param("id") int id);

    List<Keyword> selectKeywordList(@Param("keywordSearch") KeywordSearchVo keywordSearchVo);

    int insertKeyword(@Param("keyword") Keyword keyword);

    int updateKeywordById(@Param("keyword") Keyword keyword);

    int deleteKeywordById(@Param("id") int id);

    int updateOrderShipById(@Param("order") Order order);

    int updateOrderRefundById(@Param("order") Order order);

    //查询订单个数
    int queryOrderCount();

    // wx 显示品牌信息
    List<Brand> queryAllBrand();
    // wx 显示品牌详情
    BrandInfo queryBrandDetail(@Param("id") int id);
    // 查询指定商品信息
    List<GoodsInfo> queryGoodsListByBrandId(@Param("brandId") int brandId);
    // 获取指定的category信息
    CategoryInfo queryCategoryInfo(@Param("categoryId") int categoryId);

    //查询所有一级类目
    List<ChannelVo> selectAllFirstCategory();

    //查询所有品牌
    List<BrandVo> selectAllBrandToHome();

    //查询该一级类目下的所有二级类目
    List<SubCategoryVo> selectSubCategoryByPid(@Param("pid") int id);

    //通过id查询一级类目
    SubCategoryVo selectFirstCategoryById(@Param("id") int id);

    //查询所有一级目录给分类
    List<SubCategoryVo> selectAllFirstCategoryToCatalog();

    //前台通过id查询区域列表
    List<RegionByIdVo> queryRegionListById(int pid);


}
