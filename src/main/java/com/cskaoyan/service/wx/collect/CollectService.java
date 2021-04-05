package com.cskaoyan.service.wx.collect;


import com.cskaoyan.bean.CollectOrNot;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.vo.wx.collect.CollectListVo;
import com.cskaoyan.vo.goods.GoodsVo;

public interface CollectService {

    //前台收藏/取消收藏
    CollectOrNot addOrDelete(int type, int valueId);

    //前台显示收藏列表
    CollectListVo queryCollectList(int page, int size);

}
