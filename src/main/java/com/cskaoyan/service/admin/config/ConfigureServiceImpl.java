package com.cskaoyan.service.admin.config;

import com.cskaoyan.mapper.ConfigMapper;
import com.cskaoyan.vo.config.ExpressConfigVo;
import com.cskaoyan.vo.config.MallConfigVo;
import com.cskaoyan.vo.config.OrderConfigVo;
import com.cskaoyan.vo.config.WxConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConfigureServiceImpl implements ConfigService {

    @Autowired
    ConfigMapper configMapper;

    @Override
    public MallConfigVo queryMallConfig() {
        MallConfigVo mallConfigureVo = new MallConfigVo();

        mallConfigureVo.setCskaoyan_mall_mall_phone(configMapper.queryMallPhone());
        mallConfigureVo.setCskaoyan_mall_mall_address(configMapper.queryMallAddress());
        mallConfigureVo.setCskaoyan_mall_mall_name(configMapper.queryMallName());
        mallConfigureVo.setCskaoyan_mall_mall_qq(configMapper.queryMallqq());
        return mallConfigureVo;
    }

    @Override
    public ExpressConfigVo queryExpressConfig() {
        ExpressConfigVo expressconfigureVo = new ExpressConfigVo();

        expressconfigureVo.setCskaoyan_mall_express_freight_min(configMapper.queryFreightMin());
        expressconfigureVo.setCskaoyan_mall_express_freight_value(configMapper.queryFreightValue());
        return expressconfigureVo;
    }

    @Override
    public OrderConfigVo queryOrderConfig() {
        OrderConfigVo orderconfigureVo = new OrderConfigVo();

        orderconfigureVo.setCskaoyan_mall_order_unpaid(configMapper.queryOrderUnpaid());
        orderconfigureVo.setCskaoyan_mall_order_unconfirm(configMapper.queryOrderUnconfirm());
        orderconfigureVo.setCskaoyan_mall_order_comment(configMapper.queryOrderComment());
        return orderconfigureVo;
    }

    @Override
    public WxConfigVo queryWxConfig() {
        WxConfigVo wxConfigVo = new WxConfigVo();
        wxConfigVo.setCskaoyan_mall_wx_index_new(configMapper.queryWxIndexNew());
        wxConfigVo.setCskaoyan_mall_wx_share(configMapper.queryWxShare());
        wxConfigVo.setCskaoyan_mall_wx_index_hot(configMapper.queryWxIndexHot());
        wxConfigVo.setCskaoyan_mall_wx_catlog_goods(configMapper.queryWxCatlogGoods());
        wxConfigVo.setCskaoyan_mall_wx_catlog_list(configMapper.queryWxCatlogList());
        wxConfigVo.setCskaoyan_mall_wx_index_brand(configMapper.queryWxIndexBrand());
        wxConfigVo.setCskaoyan_mall_wx_index_topic(configMapper.queryWxIndexTopic());
        return wxConfigVo;
    }

    @Override
    public void updateMallConfig(MallConfigVo mallConfigVo) {
        configMapper.updateMallPhone(mallConfigVo);
        configMapper.updateMallName(mallConfigVo);
        configMapper.updateMallAddress(mallConfigVo);
        configMapper.updateMallqq(mallConfigVo);
    }

    @Override
    public void updateExpressConfig(ExpressConfigVo expressConfigVo) {
        configMapper.updateExpressFreightMin(expressConfigVo);
        configMapper.updateExpressFreightValue(expressConfigVo);
    }

    @Override
    public void updateOrderConfig(OrderConfigVo orderConfigVo) {
        configMapper.updateOrderUnpaid(orderConfigVo);
        configMapper.updateOrderUnconfirm(orderConfigVo);
        configMapper.updateOrderComment(orderConfigVo);
    }

    @Override
    public void updateWxConfig(WxConfigVo wxConfigVo) {
        configMapper.updateWxIndexNew(wxConfigVo);
        configMapper.updateWxShare(wxConfigVo);
        configMapper.updateWxIndexHot(wxConfigVo);
        configMapper.updateWxCatlogGoods(wxConfigVo);
        configMapper.updateWxCatlogList(wxConfigVo);
        configMapper.updateWxIndexBrand(wxConfigVo);
        configMapper.updateWxIndexTopic(wxConfigVo);
    };
}
