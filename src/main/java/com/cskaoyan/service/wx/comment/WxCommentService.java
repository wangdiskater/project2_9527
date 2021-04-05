package com.cskaoyan.service.wx.comment;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.comment.CommentShowVo;
import com.cskaoyan.vo.wx.comment.WxTopticCommentVo;

public interface WxCommentService {
    //显示所有评论
    BaseRespVo commentList(CommentShowVo commentSearchVo);

    //显示该商品的评论个数
    BaseRespVo commentCount(Integer valueId, Integer type);

    //添加主题的评论
    BaseRespVo commentPost(WxTopticCommentVo wxTopticCommentVo);
}
