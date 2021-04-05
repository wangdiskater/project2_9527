package com.cskaoyan.controller.wx.topic;

import com.cskaoyan.service.wx.topic.TopicService;
import com.cskaoyan.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TopicController
 * @Author LM
 * @Description
 * @Data 2019/10/4 20:55
 */
@RestController
@RequestMapping("wx")
public class TopicController {

    @Autowired
    TopicService topicService;

    /**
     * @Description 前台获取所有专题
     * @Author LM
     * @Date 2019/10/4 21:55
     * @Param page
     * @Param size
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/topic/list",method = RequestMethod.GET)
    public BaseRespVo queryTopicList(int page,int size){
        return topicService.queryTopicList(page,size);
    }

    /**
     * @Description 显示关联专题推荐
     * @Author LM
     * @Date 2019/10/4 22:44
     * @Param id
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/topic/related",method = RequestMethod.GET)
    public BaseRespVo queryTopicRelated(){
        return topicService.queryTopicRelated();
    }

    /**
     * @Description 通过id查询专题信息
     * @Author LM
     * @Date 2019/10/4 22:52
     * @Param id
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/topic/detail",method = RequestMethod.GET)
    public BaseRespVo queryTopicById(int id){
        return topicService.queryTopicById(id);
    }



}
