package com.cskaoyan.service.wx.topic;

import com.cskaoyan.vo.BaseRespVo;

/**
 * @Classname TopicService
 * @Author LM
 * @Description
 * @Data 2019/10/4 21:38
 */
public interface TopicService {

    //查询所有专题
    BaseRespVo queryTopicList(int page, int size);

    //关联专题推荐
    BaseRespVo queryTopicRelated();

    //通过id查询专题信息
    BaseRespVo queryTopicById(int id);
}
