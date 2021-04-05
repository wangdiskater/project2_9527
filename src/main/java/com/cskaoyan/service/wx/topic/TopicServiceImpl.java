package com.cskaoyan.service.wx.topic;

import com.cskaoyan.mapper.AdMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.topic.TopicByIdVo;
import com.cskaoyan.vo.wx.topic.TopicDataVo;
import com.cskaoyan.vo.wx.topic.TopicListVo;
import com.cskaoyan.vo.wx.topic.TopicTopicVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TopicServiceImpl
 * @Author LM
 * @Description
 * @Data 2019/10/4 21:40
 */
@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    AdMapper adMapper;

    /**
     * @Description 查询所有专题
     * @Author LM
     * @Date 2019/10/4 22:53
     * @Param page
     * @Param size
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo queryTopicList(int page, int size) {
        PageHelper.startPage(page,size);
        List<TopicListVo> topicVos = adMapper.queryTopicList();
        PageInfo<TopicListVo> topicListVoPageInfo = new PageInfo<>(topicVos);
        long total = topicListVoPageInfo.getTotal();
        TopicDataVo topicDataVo = new TopicDataVo();
        topicDataVo.setData(topicVos);
        topicDataVo.setCount(total);
        return BaseRespVo.success(topicDataVo);
    }

    /**
     * @Description 关联专题信息
     * @Author LM
     * @Date 2019/10/4 22:55
     * @Param
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo queryTopicRelated() {
        List<TopicListVo> topicListVos = adMapper.queryTopicRelated();
        return BaseRespVo.success(topicListVos);
    }

    /**
     * @Description 通过id查询专题信息
     * @Author LM
     * @Date 2019/10/5 19:01
     * @Param id
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo queryTopicById(int id) {
        TopicByIdVo topicByIdVo = adMapper.queryTopicById(id);
        TopicTopicVo topicTopicVo = new TopicTopicVo();
        topicTopicVo.setTopic(topicByIdVo);
        return BaseRespVo.success(topicTopicVo);
    }
}
