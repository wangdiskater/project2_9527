package com.cskaoyan.service.admin.mallManage;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.MallManageMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.category.CategoryLabelVo;
import com.cskaoyan.vo.category.CategoryVo;
import com.cskaoyan.vo.category.SubCategoryVo;
import com.cskaoyan.vo.issue.IssueSearchVo;
import com.cskaoyan.vo.issue.IssueVo;
import com.cskaoyan.vo.keyword.KeywordSearchVo;
import com.cskaoyan.vo.keyword.KeywordVo;
import com.cskaoyan.vo.mall.BrandCreateVo;
import com.cskaoyan.vo.mall.BrandVo;
import com.cskaoyan.vo.ListVo;
import com.cskaoyan.vo.order.OrderDetailVo;
import com.cskaoyan.vo.order.OrderGoodsVo;
import com.cskaoyan.vo.order.OrderSearchVo;
import com.cskaoyan.vo.order.OrderVo;
import com.cskaoyan.vo.region.CityVo;
import com.cskaoyan.vo.region.ProvinceVo;
import com.cskaoyan.vo.region.RegionVo;
import com.cskaoyan.vo.user.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version 1.0
 * @ClassName MallManageServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/9/30 15:56
 **/

@Service
public class MallManageServiceImpl implements MallManageService {

    @Autowired
    MallManageMapper mallManageMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public BaseRespVo regionList() {
//        List<Region> regionss = mallManageMapper.selectAllRegionWithResultMap();

        List<Region> regions = mallManageMapper.selectAllRegion();
        //存放城市和省份
        Map<Integer, ProvinceVo> provinceMap = new HashMap<>();
        Map<Integer, CityVo> cityMap = new HashMap<>();
        for (Region region : regions) {
            int type = region.getType();
            switch (type){
                case 1:{
                    ProvinceVo provinceVo = new ProvinceVo();
                    provinceVo.setCode(region.getCode());
                    provinceVo.setId(region.getId());
                    provinceVo.setName(region.getName());
                    provinceMap.put(region.getId(),provinceVo);
                    break;
                }
                case 2: {
                    int pid = region.getPid();
                    CityVo cityVo = new CityVo();
                    cityVo.setCode(region.getCode());
                    cityVo.setId(region.getId());
                    cityVo.setName(region.getName());
                    cityVo.setPid(region.getPid());
                    //从map中找出来
                    ProvinceVo province = provinceMap.get(pid);
                    province.getChildren().add(cityVo);
                    //存放city信息
                    cityMap.put(region.getId(),cityVo);
                    break;
                }
                case 3: {
                    int pid = region.getPid();
                    RegionVo regionVo = new RegionVo();
                    regionVo.setCode(region.getCode());
                    regionVo.setId(region.getId());
                    regionVo.setName(region.getName());
                    //去找城市
                    CityVo cityVo = cityMap.get(pid);
                    int pid1 = cityVo.getPid();
                    //去找省份
                    ProvinceVo province = provinceMap.get(pid1);
                    List<CityVo> children = province.getChildren();
                    for (CityVo city : children) {
                        int cityId = city.getId();
                        if(cityId == pid){
                            city.getChildren().add(regionVo);
                        }
                    }
                    break;
                }
            }
        }
        ArrayList<ProvinceVo> provinceVos = new ArrayList<>();
        Set<Map.Entry<Integer, ProvinceVo>> entries = provinceMap.entrySet();
        for (Map.Entry<Integer, ProvinceVo> entry : entries) {
            provinceVos.add(entry.getValue());
        }
        return BaseRespVo.success(provinceVos);
    }

    /* *
     * 功能描述 显示和查找品牌制造商
     * @author wangdi
     * @date 2019/9/30 17:28
     * @param brandMap
     * @return com.cskaoyan.vo.BaseRespVo
     */

    @Override
    public BaseRespVo brandList(Integer page, Integer limit, Integer id, String name, String sort, String order) {

        PageHelper.startPage(page,limit);
        List<Brand> brands = mallManageMapper.selectBrandList(sort,order,id,name);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        long total = brandPageInfo.getTotal();
        List<Object> brandVos = new ArrayList<>();
        for (Brand brand : brands) {
            BrandVo brandVo = new BrandVo(brand);
            brandVos.add(brandVo);
        }

        ListVo listVo = new ListVo();
        listVo.setItems(brandVos);
        listVo.setTotal(total);
        return BaseRespVo.success(listVo);

    }

    /* *
     * 功能描述 添加品牌
     * @author wangdi
     * @date 2019/9/30 21:22
     * @param brandCreateVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo createBrand(BrandCreateVo brandCreateVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(new Date());
        Brand brand = new Brand();
        brand.setName(brandCreateVo.getName());
        brand.setDesc(brandCreateVo.getDesc());
        brand.setPic_url(brandCreateVo.getPicUrl());
//        brand.setSort_order();//先不写了
        brand.setFloor_price(brandCreateVo.getFloorPrice());
        brand.setAdd_time(now);
        brand.setUpdate_time(now);
        brand.setDeleted(0);
        int insert = mallManageMapper.insertBrand(brand);
        BrandVo brandVo = new BrandVo(brand);

//        brandVo.setDeleted();
        return BaseRespVo.success(brandVo);
    }

    /* *
     * 功能描述 更新brand
     * @author wangdi
     * @date 2019/9/30 22:14
     * @param brandVo
     * @return com.cskaoyan.vo.BaseRespVo
     * 返回
     * {"errno":0,"data":{"id":1046008,"name":"阿迪王中王","desc":"跑鞋就穿阿迪王","picUrl":"http://192.168.2.100:8081/wx/storage/fetch/ukskcugqj50ghvsgmx6l.JPEG","sortOrder":50,"floorPrice":998,"addTime":"2019-09-30 08:42:14","updateTime":"2019-09-30 10:15:06","deleted":false},"errmsg":"成功"}
     */
    @Override
    public BaseRespVo updateBrand(BrandVo brandVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        brandVo.setUpdateTime(simpleDateFormat.format(new Date()));
        Brand brand = new Brand();
        brand.setId(brandVo.getId());
        brand.setName(brandVo.getName());
        brand.setDesc(brandVo.getDesc());
        brand.setPic_url(brandVo.getPicUrl());
        brand.setSort_order(brandVo.getSortOrder());
        brand.setFloor_price(brandVo.getFloorPrice());
        brand.setAdd_time(brandVo.getAddTime());
        brand.setUpdate_time(brandVo.getUpdateTime());
        if(brandVo.isDeleted()){
            brand.setDeleted(1);
        } else {
            brand.setDeleted(0);
        }

        int update = mallManageMapper.updateBrandById(brand);

        return BaseRespVo.success(brandVo);
    }

    /* *
     * 功能描述 删除品牌
     * @author wangdi
     * @date 2019/9/30 22:52
     * @param brandVo
     * @return com.cskaoyan.vo.BaseRespVo
     * {"errno":0,"errmsg":"成功"}
     */
    @Override
    public BaseRespVo deleteBrand(BrandVo brandVo) {
        int delete = mallManageMapper.deleteBrandById(brandVo.getId());
        if(delete == 1){
            return BaseRespVo.success("");
        } else {
            return null;
        }
    }

    /* *
     * 功能描述 显示商品类目
     * @author wangdi
     * @date 2019/9/30 23:18
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo categoryList() {
        List<Category> categories = mallManageMapper.selectAllCategory();
        HashMap<Integer, CategoryVo> map = new HashMap<>();
        //为了解决pid > id 儿子找不到父亲先缓存起来
        List<Category> cache = new ArrayList<>();

        for (Category category : categories) {
            if(category.getPid() == 0){
                int id = category.getId();
                //隐藏转换
                CategoryVo categoryVo = new CategoryVo(category);
                map.put(id,categoryVo);
            }else {
                int pid = category.getPid();
                if(pid > category.getId()){
                    cache.add(category);
                    continue;
                }
                SubCategoryVo subCategoryVo = new SubCategoryVo(category);
                //去找父类
                CategoryVo categoryVo1 = map.get(pid);
                categoryVo1.getChildren().add(subCategoryVo);
            }
        }
        //把缓存的子数据拿出来
        if(cache.size() > 0){
            for (Category category : cache) {
                int pid = category.getPid();
                SubCategoryVo subCategoryVo = new SubCategoryVo(category);
                CategoryVo categoryVo1 = map.get(pid);
                categoryVo1.getChildren().add(subCategoryVo);
            }
        }

        Set<Map.Entry<Integer, CategoryVo>> entries = map.entrySet();
        List<CategoryVo> categoryList = new ArrayList<>();
        for (Map.Entry<Integer, CategoryVo> entry : entries) {
            categoryList.add(entry.getValue());
        }

        return BaseRespVo.success(categoryList);
    }

    /* *
     * 功能描述 显示类目名 --- 为添加使用
     * @author wangdi
     * @date 2019/10/1 0:05
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo categoryLabel() {
        List<Category> categories = mallManageMapper.selectAllCategory();
        ArrayList<CategoryLabelVo> categoryLabelVo = new ArrayList<>();
        for (Category category : categories) {
            CategoryLabelVo categoryLabel = new CategoryLabelVo();

            categoryLabel.setValue(category.getId());
            categoryLabel.setLable(category.getName() +"  "+ category.getId());

            categoryLabelVo.add(categoryLabel);
        }
        return BaseRespVo.success(categoryLabelVo);
    }

    /* *
     * 功能描述 新建商品
     * @author wangdi
     * @date 2019/10/1 14:46
     * @param categoryVo
     * {"name":"阿迪达斯","keywords":"鞋","level":"L2","pid":1010000,"desc":"阿迪王无敌","iconUrl":"http://192.168.2.100:8081/wx/storage/fetch/jmz99xn1o03gujhi9l54.JPEG","picUrl":"http://192.168.2.100:8081/wx/storage/fetch/9qb699j4ciwma0a10vns.JPEG"}
        {"errno":0,"data":{"id":1036020,"name":"阿迪达斯","keywords":"鞋","desc":"阿迪王无敌","pid":1010000,"iconUrl":"http://192.168.2.100:8081/wx/storage/fetch/jmz99xn1o03gujhi9l54.JPEG","picUrl":"http://192.168.2.100:8081/wx/storage/fetch/9qb699j4ciwma0a10vns.JPEG","level":"L2","addTime":"2019-10-01 02:43:51","updateTime":"2019-10-01 02:43:51"},"errmsg":"成功"}
     * @return com.cskaoyan.vo.BaseRespVo
     */

    @Override
    public BaseRespVo categoryCreate(SubCategoryVo categoryVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Category category = new Category(categoryVo);
        category.setAdd_time(simpleDateFormat.format(new Date()));
        category.setUpdate_time(simpleDateFormat.format(new Date()));
        int insert = mallManageMapper.insertCategory(category);
        SubCategoryVo subCategoryVo = new SubCategoryVo(category);
        return BaseRespVo.success(subCategoryVo);
    }

    /* *
     * 功能描述 更新商品 --- 不更新 deleted 和 sort_order
     * @author wangdi
     * @date 2019/10/1 15:51
     * @param categoryVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo categoryUpdate(CategoryVo categoryVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        categoryVo.setUpdateTime(simpleDateFormat.format(new Date()));
        Category category = new Category(categoryVo);
        int update = mallManageMapper.updateCategoryById(category);
        if(update == 1){
            return BaseRespVo.success("");
        }
        return null;
    }
    /* *
     * 功能描述 删除
     * @author wangdi
     * @date 2019/10/1 16:20
     * @param categoryVo
     * @return com.cskaoyan.vo.BaseRespVo
     * {"errno":0,"errmsg":"成功"}
     */
    @Override
    public BaseRespVo categoryDelete(CategoryVo categoryVo) {
        int delete = mallManageMapper.deleteCategoryById(categoryVo.getId());
        if(delete == 1){
            return BaseRespVo.success("");
        }
        return null;
    }

    /* *
     * 功能描述 显示orderList  还没测试
     * @author wangdi
     * @date 2019/10/1 16:56
     * @param orderSearchVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderList(OrderSearchVo orderSearchVo) {
        PageHelper.startPage(orderSearchVo.getPage(),orderSearchVo.getLimit());
        //使用foreach来判断
        List<Order> orders = mallManageMapper.selectOrder(orderSearchVo);

        List<Object> orderVoList = new ArrayList<>();
        PageInfo<Order> brandPageInfo = new PageInfo<>(orders);
        long total = brandPageInfo.getTotal();
        for (Order order : orders) {
            OrderVo orderVo = new OrderVo(order);
            orderVoList.add(orderVo);
        }
        ListVo listVo = new ListVo();
        listVo.setItems(orderVoList);
        listVo.setTotal(total);
        return BaseRespVo.success(listVo);
    }

    /* *
     * 功能描述 发货
     * @author wangdi
     * @date 2019/10/2 12:28
     * @param orderMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderShip(Map orderMap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int orderId = (int) orderMap.get("orderId");
        String shipChannel = (String) orderMap.get("shipChannel"); //快递类型
        String shipSn = (String) orderMap.get("shipSn"); //快递编号
        Order order = new Order();
        order.setId(orderId);
        order.setShip_channel(shipChannel);
        order.setShip_sn(shipSn);
        order.setOrder_status(301);
        order.setShip_time(simpleDateFormat.format(new Date()));
        order.setUpdate_time(simpleDateFormat.format(new Date()));
        int update = mallManageMapper.updateOrderShipById(order);
        return BaseRespVo.success("");
    }

    /* *
     * 功能描述 退款，需要退款给用户 设置订单关闭时间
     * @author wangdi
     * @date 2019/10/2 14:10
     * @param orderMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo orderRefund(Map orderMap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int orderId = (int) orderMap.get("orderId");
        int refundMoney = (int) orderMap.get("refundMoney");
        Order order = new Order();
        order.setId(orderId);
        order.setOrder_status(203);
        order.setUpdate_time(simpleDateFormat.format(new Date()));
        order.setEnd_time(simpleDateFormat.format(new Date()));
        int update = mallManageMapper.updateOrderRefundById(order);
        return BaseRespVo.success("");
    }

    @Override
    public BaseRespVo orderDetail(int id) {
        Order order = mallManageMapper.selectOrderById(id);
        OrderVo orderVo = new OrderVo(order);
        List<OrderGoods> orderGoods = mallManageMapper.selectOrderGoodsByOrderId(orderVo.getId());
        List<OrderGoodsVo> orderGoodsVoList = new ArrayList<>();
        for (OrderGoods orderGood : orderGoods) {
            OrderGoodsVo orderGoodsVo = new OrderGoodsVo(orderGood);
            orderGoodsVoList.add(orderGoodsVo);
        }

        //User
        UserVo userVo = userMapper.queryUserById(orderVo.getUserId());

        OrderDetailVo orderDetailVo = new OrderDetailVo();
        orderDetailVo.setOrder(orderVo);
        orderDetailVo.setOrderGoods(orderGoodsVoList);
        orderDetailVo.setUser(userVo);
        return BaseRespVo.success(orderDetailVo);
    }

    /* *
     * 功能描述 通用问题显示
     * @author wangdi
     * @date 2019/10/1 20:31
     * @param issueSearchVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo issueList(IssueSearchVo issueSearchVo) {
        PageHelper.startPage(issueSearchVo.getPage(),issueSearchVo.getLimit());
        List<Issue> issues = mallManageMapper.selectIssue(issueSearchVo);
        PageInfo<Issue> issuePageInfo = new PageInfo<>(issues);
        long total = issuePageInfo.getTotal();

        ArrayList<Object> issueVoList = new ArrayList<>();
        for (Issue issue : issues) {
            IssueVo issueVo = new IssueVo(issue);
            issueVoList.add(issueVo);
        }
        ListVo listVo = new ListVo(total,issueVoList);

        return BaseRespVo.success(listVo);
    }

    @Override
    public BaseRespVo issueCreate(Map issueMap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String question = (String) issueMap.get("question");
        String answer = (String) issueMap.get("answer");
        Issue issue = new Issue();
        issue.setQuestion(question);
        issue.setAnswer(answer);
        issue.setAdd_time(simpleDateFormat.format(new Date()));
        issue.setUpdate_time(simpleDateFormat.format(new Date()));
        int insert = mallManageMapper.insertIssue(issue);
        if(insert == 1){
            IssueVo issueVo = new IssueVo(issue);
            return BaseRespVo.success(issueVo);
        }
        return null;
    }

    @Override
    public BaseRespVo issueUpdate(IssueVo issueVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        issueVo.setUpdateTime(simpleDateFormat.format(new Date()));
        Issue issue = new Issue(issueVo);
        int i = mallManageMapper.updateIssueById(issue);

        return BaseRespVo.success(issueVo);
    }

    @Override
    public BaseRespVo issueDelete(IssueVo issueVo) {
        int delete = mallManageMapper.deleteIssueById(issueVo.getId());
        if(delete == 1){
            return BaseRespVo.success("");
        }
        return null;
    }

    @Override
    public BaseRespVo keywordList(KeywordSearchVo keywordSearchVo) {
        PageHelper.startPage(keywordSearchVo.getPage(),keywordSearchVo.getLimit());
        List<Keyword> keywords = mallManageMapper.selectKeywordList(keywordSearchVo);
        PageInfo<Keyword> keywordPageInfo = new PageInfo<>(keywords);
        long total = keywordPageInfo.getTotal();

        List<Object> keywordVos = new ArrayList<>();
        for (Keyword keyword : keywords) {
            KeywordVo keywordVo = new KeywordVo(keyword); //返回是boolean
            keywordVos.add(keywordVo);
        }
        ListVo listVo = new ListVo(total, keywordVos);
        return BaseRespVo.success(listVo);
    }

    @Override
    public BaseRespVo keywordCreate(KeywordVo keywordVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Keyword keyword = new Keyword(keywordVo);
        keyword.setAdd_time(simpleDateFormat.format(new Date()));
        keyword.setUpdate_time(simpleDateFormat.format(new Date()));
        int insert = mallManageMapper.insertKeyword(keyword);
        KeywordVo keywordVoout = new KeywordVo(keyword);
        return BaseRespVo.success(keywordVoout);
    }

    @Override
    public BaseRespVo keywordUpdate(KeywordVo keywordVo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Keyword keyword = new Keyword(keywordVo);
        keyword.setUpdate_time(simpleDateFormat.format(new Date()));
        int update = mallManageMapper.updateKeywordById(keyword);
        if(update == 1){
            return BaseRespVo.success(keywordVo);
        }
        return null;
    }

    @Override
    public BaseRespVo keywordDelete(KeywordVo keywordVo) {
        int delete = mallManageMapper.deleteKeywordById(keywordVo.getId());
        if(delete == 1){
            return BaseRespVo.success("");
        }
        return null;
    }
}
