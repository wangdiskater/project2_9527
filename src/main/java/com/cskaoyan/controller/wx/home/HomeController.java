package com.cskaoyan.controller.wx.home;

import com.cskaoyan.service.wx.home.HomeService;
import com.cskaoyan.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName HomeController
 * @Description 主页的controller
 * @Author wangdi
 * @Date 2019/10/4 20:46
 **/

@RequestMapping("/wx")
@RestController
public class HomeController {

    @Autowired
    HomeService homeService;
    /* *
     * 功能描述 显示主页
     * @author wangdi
     * @date 2019/10/5 12:02
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/home/index",method = RequestMethod.GET)
    public BaseRespVo homeShow(){
        return homeService.homeShow();
    }

    /* *
     * 功能描述 显示商品个数
     * @author wangdi
     * @date 2019/10/5 12:02
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/goods/count",method = RequestMethod.GET)
    public BaseRespVo goodsCount(){
        return homeService.goodsCount();
    }

}
