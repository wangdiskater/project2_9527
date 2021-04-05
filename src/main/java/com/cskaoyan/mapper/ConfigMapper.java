package com.cskaoyan.mapper;

import com.cskaoyan.vo.config.ExpressConfigVo;
import com.cskaoyan.vo.config.MallConfigVo;
import com.cskaoyan.vo.config.OrderConfigVo;
import com.cskaoyan.vo.config.WxConfigVo;

public interface ConfigMapper {

    String queryMallName();

    String queryMallAddress();

    String queryMallPhone();

    String queryMallqq();

    String queryFreightMin();

    String queryFreightValue();

    String queryOrderUnpaid();

    String queryOrderUnconfirm();

    String queryOrderComment();

    String queryWxIndexNew();

    String queryWxShare();

    String queryWxIndexHot();

    String queryWxCatlogGoods();

    String queryWxCatlogList();

    String queryWxIndexBrand();

    String queryWxIndexTopic();

    void updateMallPhone(MallConfigVo mallConfigVo);

    void updateMallName(MallConfigVo mallConfigVo);

    void updateMallAddress(MallConfigVo mallConfigVo);

    void updateMallqq(MallConfigVo mallConfigVo);

    void updateExpressFreightMin(ExpressConfigVo expressConfigVo);

    void updateExpressFreightValue(ExpressConfigVo expressConfigVo);

    void updateOrderUnpaid(OrderConfigVo orderConfigVo);

    void updateOrderUnconfirm(OrderConfigVo orderConfigVo);

    void updateOrderComment(OrderConfigVo orderConfigVo);

    void updateWxIndexNew(WxConfigVo wxConfigVo);

    void updateWxShare(WxConfigVo wxConfigVo);

    void updateWxIndexHot(WxConfigVo wxConfigVo);

    void updateWxCatlogGoods(WxConfigVo wxConfigVo);

    void updateWxCatlogList(WxConfigVo wxConfigVo);

    void updateWxIndexBrand(WxConfigVo wxConfigVo);

    void updateWxIndexTopic(WxConfigVo wxConfigVo);

}
