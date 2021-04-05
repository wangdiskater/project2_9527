package com.cskaoyan.service.admin.config;

import com.cskaoyan.vo.config.ExpressConfigVo;
import com.cskaoyan.vo.config.MallConfigVo;
import com.cskaoyan.vo.config.OrderConfigVo;
import com.cskaoyan.vo.config.WxConfigVo;

public interface ConfigService {

    MallConfigVo queryMallConfig();

    ExpressConfigVo queryExpressConfig();

    OrderConfigVo queryOrderConfig();

    WxConfigVo queryWxConfig();

    void updateMallConfig(MallConfigVo mallConfigVo);

    void updateExpressConfig(ExpressConfigVo expressConfigVo);

    void updateOrderConfig(OrderConfigVo orderConfigVo);

    void updateWxConfig(WxConfigVo wxConfigVo);

}
