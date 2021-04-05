package com.cskaoyan.service.admin.user;

import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.vo.user.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @ClassName UserServiceImpl
 * @Description 用户管理模块的接口实现
 * @Author GF
 * @Date 2019/9/30 14:15
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /*
     *功能描述 用户管理下的会员管理
     *@author GF
     *@date
     *@param
     *@return
     */
    @Override
    public UserBaseRespVo queryAllUser(int page, int limit, String username, String mobile) {
        PageHelper.startPage(page, limit);
        List<UserVo> userVos = userMapper.queryAllUser(username, mobile);
        PageInfo<UserVo> userListVoPageInfo = new PageInfo<>(userVos);
        UserBaseRespVo<UserVo> userListVoUserBaseRespVo = new UserBaseRespVo<>();
        long total = userListVoPageInfo.getTotal();

        userListVoUserBaseRespVo.setTotal(total);
        userListVoUserBaseRespVo.setItems(userVos);
        return userListVoUserBaseRespVo;
    }

    /*
     *功能描述:会员收藏功能的实现
     *@author GF
     *@date
     *@param 用户id,商品id
     *@return
     */
    @Override
    public UserBaseRespVo queryAllUserCollect(int page, int limit, String userId, String valueId) {
        PageHelper.startPage(page, limit);
        List<UserCollectVo> userCollectVos = userMapper.queryAllUserCollect(userId, valueId);
        PageInfo<UserCollectVo> userCollectVoPageInfo = new PageInfo<>(userCollectVos);
        UserBaseRespVo<UserCollectVo> userListVoUserBaseRespVo = new UserBaseRespVo<>();
        long total = userCollectVoPageInfo.getTotal();

        userListVoUserBaseRespVo.setItems(userCollectVos);
        userListVoUserBaseRespVo.setTotal(total);
        return userListVoUserBaseRespVo;
    }

    /**
    *功能描述：会员足迹功能的实现
    *@author GF
    *@date
    *@param
    *@return
     */
    @Override
    public UserBaseRespVo queryAllUserFootPrint(int page, int limit, String userId, String goodsId) {
        PageHelper.startPage(page, limit);
        List<FootPrintVo> footPrintVos = userMapper.queryAllUserFootPrint(userId, goodsId);
        UserBaseRespVo<FootPrintVo> footPrintVoUserBaseRespVo = new UserBaseRespVo<>();
        PageInfo<FootPrintVo> footPrintVoPageInfo = new PageInfo<>(footPrintVos);
        footPrintVoUserBaseRespVo.setItems(footPrintVos);
        long total = footPrintVoPageInfo.getTotal();
        footPrintVoUserBaseRespVo.setTotal(total);
        return footPrintVoUserBaseRespVo;
    }

    @Override
    public UserBaseRespVo queryUserHistory(int page, int limit, String keyword, String userId) {
        PageHelper.startPage(page, limit);
        List<HistoryVo> historyVos = userMapper.queryUserHistory(keyword, userId);
        PageInfo<HistoryVo> historyVoPageInfo = new PageInfo<>(historyVos);
        long total = historyVoPageInfo.getTotal();
        UserBaseRespVo<HistoryVo> historyVoUserBaseRespVo = new UserBaseRespVo<>();
        historyVoUserBaseRespVo.setTotal(total);
        historyVoUserBaseRespVo.setItems(historyVos);
        return historyVoUserBaseRespVo;
    }

    @Override
    public UserBaseRespVo queryUserFeedBack(int page, int limit, String username, String id) {
        PageHelper.startPage(page, limit);
        List<FeedbackVo> feedbackVos = userMapper.queryUserFeedBack(username, id);
        PageInfo<FeedbackVo> feedbackVoPageInfo = new PageInfo<>(feedbackVos);
        long total = feedbackVoPageInfo.getTotal();
        UserBaseRespVo<FeedbackVo> feedbackVoUserBaseRespVo = new UserBaseRespVo<>();
        feedbackVoUserBaseRespVo.setItems(feedbackVos);
        feedbackVoUserBaseRespVo.setTotal(total);
        return feedbackVoUserBaseRespVo;
    }

    @Override
    public UserBaseRespVo queryUserAddress(int page, int limit, String userId, String name) {
        List<AddressVo> addressVos = userMapper.queryUserAddress(userId, name);
        PageInfo<AddressVo> addressVoPageInfo = new PageInfo<>(addressVos);
        PageHelper.startPage(page, limit);
        UserBaseRespVo<AddressVo> addressVoUserBaseRespVo = new UserBaseRespVo<>();
        long total = addressVoPageInfo.getTotal();
        addressVoUserBaseRespVo.setItems(addressVos);
        addressVoUserBaseRespVo.setTotal(total);
        return addressVoUserBaseRespVo;

    }


}
