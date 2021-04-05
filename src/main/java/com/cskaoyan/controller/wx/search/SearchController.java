package com.cskaoyan.controller.wx.search;

import com.cskaoyan.service.wx.search.SearchService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.search.SearchGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author So9rry
 * @description
 * @date 2019/10/5
 */

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;


    @RequestMapping(value = "wx/search/index", method = RequestMethod.GET)
    public BaseRespVo searchIndex(){
        SearchGoodsVo searchGoodsVo = searchService.searchIndex();
        return BaseRespVo.success(searchGoodsVo);
    }

    @RequestMapping(value = "wx/search/helper", method = RequestMethod.GET)
    public BaseRespVo searchHelper(String keyword){
        String[] strings = searchService.searchHelper(keyword);
        return BaseRespVo.success(strings);
    }


    @RequestMapping(value = "/wx/search/clearhistory", method = RequestMethod.POST)
    public BaseRespVo clearHistory(){
        searchService.clearHistory();
        return BaseRespVo.success(null);
    }
}
