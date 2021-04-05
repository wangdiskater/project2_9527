package com.cskaoyan.controller.wx.comment;

import com.cskaoyan.service.wx.comment.WxCommentService;
import com.cskaoyan.vo.wx.comment.CommentShowVo;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.comment.WxTopticCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @ClassName WxCommentController
 * @Description 前台微信评论控制器
 * @Author wangdi
 * @Date 2019/10/5 22:50
 **/

@RestController
@RequestMapping("/wx")
public class WxCommentController {
    @Autowired
    WxCommentService wxCommentService;

    /* *
     * 功能描述
     * @author wangdi
     * @date 2019/10/5 23:58
     * @param valueId
     * @param type
     * @param size
     * @param page
     * @param showType 表示是否有图 showType = 1表示只显示有图
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/comment/list",method = RequestMethod.GET)
    public BaseRespVo commentList(Integer valueId,Integer type,Integer size,Integer page,Integer showType) {
        CommentShowVo commentSearchVo = new CommentShowVo(valueId, type, size, page, showType);
        return wxCommentService.commentList(commentSearchVo);

    }
    /* *
     * 功能描述
     * @author wangdi
     * @date 2019/10/6 0:06
     * @param null
     * @return
     */
    @RequestMapping(value = "/comment/count",method = RequestMethod.GET)
    public BaseRespVo commentCount(Integer valueId, Integer type){
        return wxCommentService.commentCount(valueId,type);

    }

    @RequestMapping(value = "/comment/post",method = RequestMethod.POST)
    public BaseRespVo commentPost(@RequestBody WxTopticCommentVo wxTopticCommentVo){
        return wxCommentService.commentPost(wxTopticCommentVo);
    }
}
