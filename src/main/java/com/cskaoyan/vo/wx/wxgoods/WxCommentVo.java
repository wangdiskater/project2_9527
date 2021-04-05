package com.cskaoyan.vo.wx.wxgoods;

import java.util.List;

/**
 * @author GF
 * @description
 * @date 2019/10/5
 */

public class WxCommentVo {
    List<WxVGoodsComment> data;
    long count;

    public List<WxVGoodsComment> getData() {
        return data;
    }

    public void setData(List<WxVGoodsComment> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
