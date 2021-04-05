package com.cskaoyan.vo.wx.search;

import com.cskaoyan.bean.DefaultKeyword;
import com.cskaoyan.bean.HistoryKeywordList;
import com.cskaoyan.bean.HotKeywordList;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/4
 */
public class SearchGoodsVo {

    private DefaultKeyword defaultKeyword;

    private List<HotKeywordList> hotKeywordList;

    private List<HistoryKeywordList> historyKeywordList;

    public List<HistoryKeywordList> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<HistoryKeywordList> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public DefaultKeyword getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(DefaultKeyword defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<HotKeywordList> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<HotKeywordList> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }

    @Override
    public String toString() {
        return "SearchGoodsVo{" +
                "defaultKeyword=" + defaultKeyword +
                ", hotKeywordList=" + hotKeywordList +
                ", historyKeywordList=" + historyKeywordList +
                '}';
    }
}
