package com.cskaoyan.service.wx.foot;

import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.address.BaseRespTwoVo;
import com.cskaoyan.vo.wx.foot.FeedBackVo;
import com.cskaoyan.vo.wx.foot.FootprintListVo;
import com.cskaoyan.vo.wx.foot.FootprintVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname FootServiceImpl
 * @Author LM
 * @Description
 * @Data 2019/10/5 21:56
 */
@Service
public class FootServiceImpl implements FootService{

    @Autowired
    UserMapper userMapper;

    /**
     * @Description 添加反馈信息
     * @Author LM
     * @Date 2019/10/6 13:28
     * @Param feedBackVo
     * @Return com.cskaoyan.vo.wx.address.BaseRespTwoVo
     **/
    @Override
    public BaseRespTwoVo feedBackSubmit(FeedBackVo feedBackVo,Integer userId,String username) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(new Date());
        feedBackVo.setAddTime(now);
        feedBackVo.setUpdateTime(now);
        userMapper.feedBackSubmit(feedBackVo,userId,username);
        return BaseRespTwoVo.success();
    }

    /**
     * @Description 显示足迹列表
     * @Author LM
     * @Date 2019/10/6 13:28
     * @Param page
     * @Param size
     * @Return com.cskaoyan.vo.wx.address.BaseRespTwoVo
     **/
    @Override
    public BaseRespVo queryFootPrint(int page, int size) {
        PageHelper.startPage(page,size);
        List<FootprintVo> footPrintVos = userMapper.queryFootPrint();
        PageInfo<FootprintVo> pageInfo = new PageInfo<>();
        long total = pageInfo.getTotal();
        FootprintListVo<FootprintVo> footPrintListVo = new FootprintListVo<>();
        footPrintListVo.setFootprintList(footPrintVos);
        footPrintListVo.setTotalPages(total);
        return BaseRespVo.success(footPrintListVo);
    }
}
