package com.cskaoyan.controller.wx.collect;

import com.cskaoyan.bean.CollectList;
import com.cskaoyan.bean.CollectOrNot;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.service.wx.collect.CollectService;
import com.cskaoyan.service.wx.search.SearchService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.collect.CollectListVo;
import com.cskaoyan.vo.goods.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author So9rry
 * @description
 * @date 2019/10/4
 */

@RestController
public class CollectController {

    @Autowired
    CollectService collectService;


    //增加/取消收藏
    @RequestMapping(value = "/wx/collect/addordelete", method = RequestMethod.POST)
    public BaseRespVo addOrDelete(@RequestBody CollectList collectList){
        int valueId = collectList.getValueId();
        int type = collectList.getType();
        CollectOrNot collectOrNot = collectService.addOrDelete(type, valueId);
        return BaseRespVo.success(collectOrNot);
    }



    @RequestMapping(value = "wx/collect/list", method = RequestMethod.GET)
    public BaseRespVo queryCollectList(int page, int size){
        CollectListVo collectListVo = collectService.queryCollectList(page, size);
        return BaseRespVo.success(collectListVo);
    }
}
