package com.cskaoyan.vo.wx.groupon;

import com.cskaoyan.vo.wx.wxgoods.WxGrouponVo;

import java.util.List;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */

public class WxGroupGoodsData <T>{
    List<T> data;
    long count;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
