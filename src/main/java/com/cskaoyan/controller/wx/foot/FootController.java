package com.cskaoyan.controller.wx.foot;

import com.cskaoyan.service.wx.foot.FootService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.address.BaseRespTwoVo;
import com.cskaoyan.vo.wx.foot.FeedBackVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname FootController
 * @Author LM
 * @Description
 * @Data 2019/10/5 21:55
 */
@RestController
@RequestMapping("wx")
public class FootController {

    @Autowired
    FootService footService;

    /**
     * @Description 前台添加意见反馈
     * @Author LM
     * @Date 2019/10/5 22:19
     * @Param feedBackVo
     * @Return com.cskaoyan.vo.wx.address.BaseRespTwoVo
     **/
    @RequestMapping(value = "/feedback/submit",method = RequestMethod.POST)
    public BaseRespTwoVo feedBackSubmit(@RequestBody FeedBackVo feedBackVo){
        Session session = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        String username = (String) session.getAttribute("username");
        if (userId == null || username == null){
            return BaseRespTwoVo.fail( 100 , "登录过期，请登录");
        }
        return footService.feedBackSubmit(feedBackVo,userId,username);
    }

    /**
     * @Description 显示全部足迹列表
     * @Author LM
     * @Date 2019/10/6 13:24
     * @Param page
     * @Param size
     * @Return com.cskaoyan.vo.wx.address.BaseRespTwoVo
     **/
    @RequestMapping(value = "/footprint/list",method = RequestMethod.GET)
    public BaseRespVo queryFootPrint(int page,int size){
        return footService.queryFootPrint(page,size);
    }
}
