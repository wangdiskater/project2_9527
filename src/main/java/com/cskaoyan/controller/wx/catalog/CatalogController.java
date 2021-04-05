package com.cskaoyan.controller.wx.catalog;

import com.cskaoyan.service.wx.catalog.CatalogService;
import com.cskaoyan.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName CatalogController
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 12:03
 **/
@RestController
@RequestMapping("/wx")
public class CatalogController {
    @Autowired
    CatalogService catalogService;
    /* *
     * 功能描述 显示分类
     * @author wangdi
     * @date 2019/10/5 14:13
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping("catalog/index")
    public BaseRespVo catalogShow(){
        return catalogService.catalogShow();
    }

    /* *
     * 功能描述 显示当前一级目录下的所有二级目录
     * @author wangdi
     * @date 2019/10/5 14:13
     * @param id
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/catalog/current",method = RequestMethod.GET)
    public BaseRespVo catalogCurrent(int id){
        return catalogService.catalogCurrent(id);
    }
}
