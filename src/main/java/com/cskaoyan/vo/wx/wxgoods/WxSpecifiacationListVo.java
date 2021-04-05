package com.cskaoyan.vo.wx.wxgoods;

import com.cskaoyan.vo.goods.GoodsSpecificationVo;

import java.util.List;

/**
 * @author GF
 * @description 前台商品规格封装
 * @date 2019/10/5
 */

public class WxSpecifiacationListVo {
    String name;
    List<GoodsSpecificationVo> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpecificationVo> getValueList() {
        return valueList;
    }

    public void setValueList(List<GoodsSpecificationVo> valueList) {
        this.valueList = valueList;
    }
}
