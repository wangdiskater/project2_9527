package com.cskaoyan.service.wx.search;

import com.cskaoyan.bean.DefaultKeyword;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.HistoryKeywordList;
import com.cskaoyan.bean.HotKeywordList;
import com.cskaoyan.mapper.SearchMapper;
import com.cskaoyan.vo.wx.search.SearchGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/5
 */

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchMapper searchMapper;

    @Override
    public SearchGoodsVo searchIndex() {
        DefaultKeyword defaultKeyword = new DefaultKeyword();
        ArrayList<HotKeywordList> hotKeywordList = new ArrayList<>();

        //转换默认关键字的bean返回给前端
        Goods searchDefaultKeyword = searchMapper.searchDefaultKeyword();
        defaultKeyword.setId(searchDefaultKeyword.getId());
        defaultKeyword.setKeyword(searchDefaultKeyword.getKeyword());
        defaultKeyword.setUrl(searchDefaultKeyword.getUrl());
        if (searchDefaultKeyword.getIs_hot() == 1){
            defaultKeyword.setHot(true);
        }else {
            defaultKeyword.setHot(false);
        }
        if (searchDefaultKeyword.getIs_default() == 1){
            defaultKeyword.setDefault(true);
        }else {
            defaultKeyword.setDefault(false);;
        }
        defaultKeyword.setAddTIme(searchDefaultKeyword.getAddTime());
        defaultKeyword.setUpdateTime(searchDefaultKeyword.getUpdateTime());
        defaultKeyword.setDeleted(false);

        //转换热门关键字的bean返回给前端
        List<Goods> searchHotKeywordList = searchMapper.searchHotKeywordList();
        for (Goods goods : searchHotKeywordList) {
            HotKeywordList hotList = new HotKeywordList();
            hotList.setId(goods.getId());
            hotList.setKeyword(goods.getKeyword());
            hotList.setUrl(goods.getUrl());
            if (goods.getIs_hot() == 1){
                hotList.setHot(true);
            }else {
                hotList.setHot(false);
            }
            if (goods.getIs_default() == 1) {
                hotList.setDefault(true);
            }else {
                hotList.setDefault(false);
            }
            hotList.setAddTime(goods.getAddTime());
            hotList.setUpdateTime(goods.getUpdateTime());
            hotList.setDeleted(false);
            hotKeywordList.add(hotList);
        }

        //返回关键字搜索历史
        List<HistoryKeywordList> historyKeywordLists = searchMapper.searchHistoryKeywordList();
        SearchGoodsVo searchGoodsVo = new SearchGoodsVo();
        searchGoodsVo.setDefaultKeyword(defaultKeyword);
        searchGoodsVo.setHotKeywordList(hotKeywordList);
        searchGoodsVo.setHistoryKeywordList(historyKeywordLists);
        return searchGoodsVo;
    }

    @Override
    public String[] searchHelper(String keyword) {
        searchMapper.searchHelper(keyword);
        String[] strings = searchMapper.queryHistoryByKeyword(keyword);
        return strings;
    }

    @Override
    public void clearHistory() {
        searchMapper.clearHistory();
    }
}
