package com.cskaoyan.controller.wx.groupon;

import com.cskaoyan.service.wx.groupon.WxGroupOnService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.groupon.WxGroupGoodsData;
import com.cskaoyan.vo.wx.groupon.WxGroupOnDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GF
 * @description
 * @date 2019/10/6
 */

@RestController
@RequestMapping("/wx") // 团购列表 WxGroupGoodsData
public class WxGrouponController {
    @Autowired
    WxGroupOnService wxGroupOnService;

    @RequestMapping("/groupon/list")
    public BaseRespVo WxGoodsDetailsVo(int page,int size){
        WxGroupGoodsData wxGroupGoodsData = wxGroupOnService.queryWxGroupOnGoodsList(page,size);
        BaseRespVo success = BaseRespVo.success(wxGroupGoodsData);
        return success;
    }

    @RequestMapping("/groupon/my")
    public BaseRespVo queryWxMyGoodsGroupOn(int showType ){
        WxGroupGoodsData wxGroupGoodsData = wxGroupOnService.queryWxMyGroupList(showType);
        BaseRespVo success = BaseRespVo.success(wxGroupGoodsData);
        return success;
    }

    @RequestMapping("/groupon/detail")
    public BaseRespVo queryWxMyGoodsGroupDetail(int grouponId ){
        WxGroupOnDetailVo wxGroupOnDetailVo = wxGroupOnService.queryWxGroupOnDetail(grouponId);
        BaseRespVo success = BaseRespVo.success(wxGroupOnDetailVo);
        return success;
    }
}
