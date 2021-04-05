package com.cskaoyan.service.wx.search;


import com.cskaoyan.vo.wx.search.SearchGoodsVo;

public interface SearchService {

    //显示搜索页面
    SearchGoodsVo searchIndex();

    //显示搜索关键字？
    String[]  searchHelper(String keyword);

    //清空搜索记录
    void clearHistory();

}
