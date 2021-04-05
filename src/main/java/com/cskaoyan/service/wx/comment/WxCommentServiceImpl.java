package com.cskaoyan.service.wx.comment;

import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.comment.CommentSearchVo;
import com.cskaoyan.vo.comment.CommentVo;
import com.cskaoyan.vo.wx.comment.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @ClassName WxCommentServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 23:01
 **/

@Service
public class WxCommentServiceImpl implements WxCommentService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    /* *
     * 功能描述 获取该商品的所有评论
     * @author wangdi
     * @date 2019/10/5 23:18
     * @param commentSearchVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo commentList(CommentShowVo commentSearchVo) {
        PageHelper.startPage(commentSearchVo.getPage(),commentSearchVo.getSize());
        List<WxCommentVo> commentVo = goodsMapper.queryUserComment(commentSearchVo);
        PageInfo<WxCommentVo> pageInfo = new PageInfo<>(commentVo);
        long total = pageInfo.getTotal();

        WxCommentDataVo wxCommentDataVo = new WxCommentDataVo(commentVo, total, commentSearchVo.getPage());

        return BaseRespVo.success(wxCommentDataVo);
    }

    /* *
     * 功能描述 获取评论个数
     * @author wangdi
     * @date 2019/10/6 0:12
     * @param valueId
     * @param type
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo commentCount(Integer valueId, Integer type) {

        int picCount = goodsMapper.commentPicCountById(valueId,type);
        int allCount = goodsMapper.commentAllCountById(valueId,type);
        CommentCountVo commentCountVo = new CommentCountVo(picCount, allCount);
        return BaseRespVo.success(commentCountVo);
    }

    /* *
     * 功能描述 主题评论
     * @author wangdi
     * @date   2019/10/7 10:12
     * @param wxTopticCommentVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo commentPost(WxTopticCommentVo wxTopticCommentVo) {
        CommentVo commentVo = new CommentVo(wxTopticCommentVo);
        int insert = goodsMapper.insertComment(commentVo);
        if(insert == 1){
            return BaseRespVo.success("");
        }
        return null;
    }
}
