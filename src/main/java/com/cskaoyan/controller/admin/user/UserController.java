package com.cskaoyan.controller.admin.user;

import com.cskaoyan.service.admin.user.UserService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.user.UserBaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName UserController
 * @Description 用户管理模块功能模块
 * @Author GF
 * @Date 2019/9/30 14:14
 **/

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

/*
*功能描述 查询全部的会员信息还有条件查询
*@author GF
*@date
*@param
*@return
*/
    @RequestMapping("/user/list")
    public BaseRespVo queryAllUser(int page,int limit,String username,String mobile){
        UserBaseRespVo userBaseRespVo = userService.queryAllUser(page, limit,username,mobile);
        BaseRespVo success = BaseRespVo.success(userBaseRespVo);
      return success;
    }

    //用户收藏功能实现
    @RequestMapping("/collect/list")
    public BaseRespVo queryAllUserCollect(int page,int limit,String userId,String valueId){
       // UserBaseRespVo userBaseRespVo = userService.queryAllUserCollect(page, limit, userld, valueld);
        UserBaseRespVo userBaseRespVo = userService.queryAllUserCollect(page, limit,userId,valueId);
        BaseRespVo success = BaseRespVo.success(userBaseRespVo);
        return success;
    }

  //会员足迹功能实现
    @RequestMapping("/footprint/list")
    public BaseRespVo queryAllUserFootPrint(int page,int limit,String userId,String goodsId){
        UserBaseRespVo userBaseRespVo = userService.queryAllUserFootPrint(page, limit,userId,goodsId);
        BaseRespVo success = BaseRespVo.success(userBaseRespVo);
        return success;
    }

    //搜索历史功能实现
    @RequestMapping("/history/list")
    public  BaseRespVo queryUserHistory(int page,int limit,String keyword,String userId){
        UserBaseRespVo userBaseRespVo = userService.queryUserHistory(page, limit, keyword,userId);
        BaseRespVo success = BaseRespVo.success((userBaseRespVo));
        return  success;
    }

    //会员足迹功能实现
    @RequestMapping("/feedback/list")
    public BaseRespVo queryUserFeedBack(int page,int limit,String username,String id){
        UserBaseRespVo userBaseRespVo = userService.queryUserFeedBack(page, limit, username,id);
        BaseRespVo success = BaseRespVo.success(userBaseRespVo);
        return success;
    }

    //收货地址功能实现
    @RequestMapping("/address/list")
    public BaseRespVo queryUserAddress(int page,int limit,String userId,String name){
        UserBaseRespVo userBaseRespVo = userService.queryUserAddress(page, limit,userId,name);
        BaseRespVo success = BaseRespVo.success(userBaseRespVo);
        return success;
    }

}
