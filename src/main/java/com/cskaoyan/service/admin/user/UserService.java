package com.cskaoyan.service.admin.user;

import com.cskaoyan.vo.user.UserBaseRespVo;

public interface UserService {
    //查询全部的会员信息还有条件查询
    UserBaseRespVo queryAllUser(int page, int limit, String username, String mobile);

    UserBaseRespVo queryAllUserCollect(int page, int limit,String userId,String valueId);

    UserBaseRespVo queryAllUserFootPrint(int page, int limit,String userId,String goodsId);

    UserBaseRespVo queryUserHistory(int page, int limit,String keyword,String userId);

    UserBaseRespVo queryUserFeedBack(int page,int limit,String username,String id);

    UserBaseRespVo queryUserAddress(int page,int limit,String userId,String name);


}
