package com.cskaoyan.mapper;

import com.cskaoyan.bean.DefaultKeyword;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.HistoryKeywordList;
import com.cskaoyan.bean.HotKeywordList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/5
 */
public interface SearchMapper {

    List<Goods> searchHotKeywordList();

    List<HistoryKeywordList> searchHistoryKeywordList();

    Goods searchDefaultKeyword();

    void searchHelper(@Param("keyword") String keyword);

    void clearHistory();

    String[] queryHistoryByKeyword(@Param("keyword") String keyword);
}
