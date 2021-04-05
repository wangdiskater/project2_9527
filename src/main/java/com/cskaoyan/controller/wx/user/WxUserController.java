package com.cskaoyan.controller.wx.user;

import com.cskaoyan.service.wx.user.WxUserService;
import com.cskaoyan.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName WxUserController
 * @Description 小程序显示
 * @Author wangdi
 * @Date 2019/10/6 10:40
 **/
@RestController
@RequestMapping("/wx")
public class WxUserController {

    @Autowired
    WxUserService wxUserService;

    @RequestMapping(value = "/user/index",method = RequestMethod.GET)
    public BaseRespVo userIndex(){
        Session session = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        if(userId == null){
            return BaseRespVo.fail(100,"登陆过期，请登陆");
        }
        return wxUserService.userIndex(userId);
    }


}
