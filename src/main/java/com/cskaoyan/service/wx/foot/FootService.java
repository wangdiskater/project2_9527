package com.cskaoyan.service.wx.foot;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.address.BaseRespTwoVo;
import com.cskaoyan.vo.wx.foot.FeedBackVo;

/**
 * @Classname FootService
 * @Author LM
 * @Description
 * @Data 2019/10/5 21:56
 */
public interface FootService {

    //添加反馈意见
    BaseRespTwoVo feedBackSubmit(FeedBackVo feedBackVo,Integer userId,String username);

    //显示足迹列表
    BaseRespVo queryFootPrint(int page, int size);
}
