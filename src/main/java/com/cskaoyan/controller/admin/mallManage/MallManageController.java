package com.cskaoyan.controller.admin.mallManage;

import com.cskaoyan.service.admin.mallManage.MallManageService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @version 1.0
 * @ClassName MallManageController 商场管理
 * @Description todo
 * @Author wangdi
 * @Date 2019/9/30 15:53
 **/

@RestController
@RequestMapping("/admin")
public class MallManageController {
    @Autowired
    MallManageService mallManageService;

    /* *
     * 功能描述 显示区域
     * @author wangdi
     * @date 2019/9/30 16:00
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/region/list",method = RequestMethod.GET)
    public BaseRespVo regionList(){
        return mallManageService.regionList();
    }

    /* *
     * 功能描述 显示和查找品牌制造商
     * @author wangdi
     * @date 2019/9/30 17:25
     * @param brandMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/brand/list",method = RequestMethod.GET)
    public BaseRespVo brandList(Integer page,Integer limit,Integer id, String name, String sort, String order){
        return mallManageService.brandList(page,limit,id,name,sort,order);
    }


    /* *
     * 功能描述 上传品牌
     * @author wangdi
     * @date 2019/9/30 21:15
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */

    @RequestMapping(value = "/brand/create",method = RequestMethod.POST)
    public BaseRespVo createBrand(@RequestBody BrandCreateVo brandCreateVo){
        return mallManageService.createBrand(brandCreateVo);
    }
    /* *
     * 功能描述 更新品牌
     * @author wangdi
     * @date 2019/9/30 22:49
     * @param brandVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/brand/update",method = RequestMethod.POST)
    public BaseRespVo updateBrand(@RequestBody BrandVo brandVo){
        return mallManageService.updateBrand(brandVo);
    }

    /* *
     * 功能描述 删除品牌
     * @author wangdi
     * @date 2019/9/30 22:49
     * @param null
     * @return
     *
     */
     @RequestMapping(value = "/brand/delete",method = RequestMethod.POST)
     public BaseRespVo deleteBrand(@RequestBody BrandVo brandVo){
        return mallManageService.deleteBrand(brandVo);
     }

     /* *
      * 功能描述 显示商品类目
      * @author wangdi
      * @date 2019/9/30 23:17
      * @param
      * @return com.cskaoyan.vo.BaseRespVo
      */
     @RequestMapping(value = "/category/list",method = RequestMethod.GET)
     public BaseRespVo categoryList(){
         return mallManageService.categoryList();
     }

     /* *
      * 功能描述 显示类目名
      * @author wangdi
      * @date 2019/10/1 0:04
      * @param
      * @return com.cskaoyan.vo.BaseRespVo
      */
     @RequestMapping(value = "/category/l1",method = RequestMethod.GET)
     public BaseRespVo categoryl1(){
        return mallManageService.categoryLabel();
     }

     /* *
      * 功能描述 新建商品
      * @author wangdi
      * @date 2019/10/1 14:46
      * @param categoryVo
      * @return com.cskaoyan.vo.BaseRespVo
      */
    @RequestMapping(value = "/category/create",method = RequestMethod.POST)
    public BaseRespVo categoryCreate(@RequestBody SubCategoryVo categoryVo){
         return mallManageService.categoryCreate(categoryVo);
    }

    /* *
     * 功能描述 修改商品
     * @author wangdi
     * @date 2019/10/1 15:41
     * @param null
     * @return
     * {"errno":0,"errmsg":"成功"}
     */
    @RequestMapping(value = "/category/update",method = RequestMethod.POST)
    public BaseRespVo categoryUpdate(@RequestBody CategoryVo categoryVo){
        return mallManageService.categoryUpdate(categoryVo);
    }
    /* *
     * 功能描述 删除商品
     * @author wangdi
     * @date 2019/10/1 16:19
     * @param categoryVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/category/delete",method = RequestMethod.POST)
    public BaseRespVo categoryDelete(@RequestBody CategoryVo categoryVo){
        return mallManageService.categoryDelete(categoryVo);

    }

    /* *
     * 功能描述 显示订单 --- 需要用String 接收UserId，前端没有判断，直接过来id不是整数会报错。
     * @author wangdi
     * @date 2019/10/1 16:50
     * @param page
     * @param limit
     * @param orderStatusArray
     * @param sort
     * @param order
     * @param userId
     * @param orderSn
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/list",method = RequestMethod.GET)
    public BaseRespVo orderList(Integer page, Integer limit, Integer[] orderStatusArray, String sort,String order,
                                String userId,String orderSn){

        OrderSearchVo orderSearchVo = new OrderSearchVo();
        orderSearchVo.setLimit(limit);
        orderSearchVo.setPage(page);
        orderSearchVo.setOrderStatusArray(orderStatusArray);
        orderSearchVo.setSort(sort);
        orderSearchVo.setOrder(order);
        orderSearchVo.setUserId(userId);
        orderSearchVo.setOrderSn(orderSn);
        return mallManageService.orderList(orderSearchVo);
    }

    /* *
     * 功能描述 显示商品具体信息
     * @author wangdi
     * @date 2019/10/1 19:02
     * @param id orderId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/detail",method = RequestMethod.GET)
    public BaseRespVo orderDetail(int id){
        return mallManageService.orderDetail(id);
    }
    /* *
     * 功能描述 发货
     * @author wangdi
     * @date 2019/10/2 14:06
     * @param orderMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/ship",method = RequestMethod.POST)
    public BaseRespVo orderShip(@RequestBody Map orderMap){
        return mallManageService.orderShip(orderMap);
    }

    /* *
     * 功能描述 退货
     * @author wangdi
     * @date 2019/10/2 14:06
     * @param orderMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/order/refund",method = RequestMethod.POST)
    public BaseRespVo orderRefund(@RequestBody Map orderMap){
        return mallManageService.orderRefund(orderMap);
    }


    /* *
     * 功能描述 显示通用问题
     * @author wangdi
     * @date 2019/10/1 20:23
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/issue/list",method = RequestMethod.GET)
    public BaseRespVo issueList(Integer page, Integer limit, String question, String sort, String order){
        IssueSearchVo issueSearchVo = new IssueSearchVo(page,limit,question,sort,order);

        return mallManageService.issueList(issueSearchVo);
    }
    /* *
     * 功能描述 添加问题
     * @author wangdi
     * @date 2019/10/1 20:54
     * @param issueMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/issue/create",method = RequestMethod.POST)
    public BaseRespVo issueCreate(@RequestBody Map issueMap){
        return mallManageService.issueCreate(issueMap);
    }
    /* *
     * 功能描述 更新问题
     * @author wangdi
     * @date 2019/10/1 21:07
     * @param issueVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/issue/update",method = RequestMethod.POST)
    public BaseRespVo issueUpdate(@RequestBody IssueVo issueVo){
        return mallManageService.issueUpdate(issueVo);
    }
    /* *
     * 功能描述 删除问题
     * @author wangdi
     * @date 2019/10/1 21:20
     * @param issueVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/issue/delete",method = RequestMethod.POST)
    public BaseRespVo issueDelete(@RequestBody IssueVo issueVo){
        return mallManageService.issueDelete(issueVo);
    }
    /* *
     * 功能描述 显示--搜索关键词
     * @author wangdi
     * @date 2019/10/1 21:51
     * @param page
     * @param limit
     * @param keyword
     * @param url
     * @param sort
     * @param order
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/keyword/list",method = RequestMethod.GET)
    public BaseRespVo keywordList(Integer page, Integer limit, String keyword, String url, String sort, String order){
       KeywordSearchVo keywordSearchVo = new KeywordSearchVo(page,limit,keyword,url,sort, order);
       return mallManageService.keywordList(keywordSearchVo);
    }
    /* *
     * 功能描述 新建新的关键词
     * @author wangdi
     * @date 2019/10/1 22:24
     * @param keywordVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/keyword/create",method = RequestMethod.POST)
    public BaseRespVo keywordCreate(@RequestBody KeywordVo keywordVo){
        return mallManageService.keywordCreate(keywordVo);
    }
    /* *
     * 功能描述 更新关键词
     * @author wangdi
     * @date 2019/10/1 23:38
     * @param keywordVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/keyword/update",method = RequestMethod.POST)
    public BaseRespVo keywordUpdate(@RequestBody KeywordVo keywordVo){
        return mallManageService.keywordUpdate(keywordVo);
    }
    /* *
     * 功能描述 删除关键词
     * @author wangdi
     * @date 2019/10/1 23:38
     * @param keywordVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/keyword/delete",method = RequestMethod.POST)
    public BaseRespVo keywordDelete(@RequestBody KeywordVo keywordVo){
        return mallManageService.keywordDelete(keywordVo);
    }


}
