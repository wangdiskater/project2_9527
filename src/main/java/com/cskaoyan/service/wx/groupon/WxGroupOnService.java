package com.cskaoyan.service.wx.groupon;

import com.cskaoyan.mapper.GroupOnMapper;
import com.cskaoyan.vo.wx.groupon.WxGroupGoodsData;
import com.cskaoyan.vo.wx.groupon.WxGroupOnDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GF
 * @description 团购
 * @date 2019/10/6
 */

@Service
public interface WxGroupOnService {
    //团购列表
    WxGroupGoodsData queryWxGroupOnGoodsList(int page,int size);

    //团购API-我的团购
    WxGroupGoodsData queryWxMyGroupList(int showType);

    //团购API-详情
    WxGroupOnDetailVo queryWxGroupOnDetail(int id);


}
