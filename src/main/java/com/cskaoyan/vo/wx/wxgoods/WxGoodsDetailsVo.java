package com.cskaoyan.vo.wx.wxgoods;

import com.cskaoyan.vo.goods.GoodsVo;
import com.cskaoyan.vo.goods.ProductSVo;

import java.util.List;

/**
 * @author GF
 * @description 商品详情封装、
 * @date 2019/10/5
 */

public class WxGoodsDetailsVo {
   List<WxSpecifiacationListVo> specificationList;
   List<WxGrouponVo> groupon;
   List<WxIssueVo> issue;
   int userHasCollect;
   String shareImage;
   WxCommentVo comment;
   List<WxAttributeVo> attribute;
    WxBrandVo brand;
    List<ProductSVo> productList;
    GoodsVo info;

    public List<WxSpecifiacationListVo> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<WxSpecifiacationListVo> specificationList) {
        this.specificationList = specificationList;
    }

    public List<WxGrouponVo> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<WxGrouponVo> groupon) {
        this.groupon = groupon;
    }

    public List<WxIssueVo> getIssue() {
        return issue;
    }

    public void setIssue(List<WxIssueVo> issue) {
        this.issue = issue;
    }

    public int getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(int userHasCollect) {
        this.userHasCollect = userHasCollect;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public WxCommentVo getComment() {
        return comment;
    }

    public void setComment(WxCommentVo comment) {
        this.comment = comment;
    }

    public List<WxAttributeVo> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<WxAttributeVo> attribute) {
        this.attribute = attribute;
    }

    public WxBrandVo getBrand() {
        return brand;
    }

    public void setBrand(WxBrandVo brand) {
        this.brand = brand;
    }

    public List<ProductSVo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductSVo> productList) {
        this.productList = productList;
    }

    public GoodsVo getInfo() {
        return info;
    }

    public void setInfo(GoodsVo info) {
        this.info = info;
    }
}
