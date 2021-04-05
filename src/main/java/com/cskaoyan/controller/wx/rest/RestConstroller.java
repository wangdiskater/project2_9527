package com.cskaoyan.controller.wx.rest;

import com.cskaoyan.service.wx.rest.RestService;
import com.cskaoyan.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RestConstroller
 * @Author LM
 * @Description
 * @Data 2019/10/5 19:39
 */
@RestController
@RequestMapping("wx")
public class RestConstroller {

    @Autowired
    RestService restService;

    @RequestMapping(value = "/region/list",method = RequestMethod.GET)
    public BaseRespVo queryRegionListById(int pid){
        return restService.queryRegionListById(pid);
    }
}
