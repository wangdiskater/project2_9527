package com.cskaoyan.controller.admin.config;


import com.cskaoyan.service.admin.config.ConfigService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.config.ExpressConfigVo;
import com.cskaoyan.vo.config.MallConfigVo;
import com.cskaoyan.vo.config.OrderConfigVo;
import com.cskaoyan.vo.config.WxConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin") //窄化请求噢
public class ConfigController {

    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/config/mall", method = RequestMethod.GET)
    public BaseRespVo queryMallConfig(){
        MallConfigVo configureVo = configService.queryMallConfig();
        return BaseRespVo.success(configureVo);
    }

    @RequestMapping(value = "/config/express", method = RequestMethod.GET)
    public BaseRespVo queryExpressConfig(){
        ExpressConfigVo configureVo = configService.queryExpressConfig();
        return BaseRespVo.success(configureVo);
    }

    @RequestMapping(value = "/config/order", method = RequestMethod.GET)
    public BaseRespVo queryOrderConfig(){
        OrderConfigVo configureVo = configService.queryOrderConfig();
        return BaseRespVo.success(configureVo);
    }

    @RequestMapping(value = "/config/wx", method = RequestMethod.GET)
    public BaseRespVo queryWxConfig(){
        WxConfigVo configureVo = configService.queryWxConfig();
        return BaseRespVo.success(configureVo);
    }

//    ***********************************************************************分割线

    @RequestMapping(value = "/config/mall", method = RequestMethod.POST)
    public BaseRespVo updateMallConfig(@RequestBody MallConfigVo mallConfigVo){
        configService.updateMallConfig(mallConfigVo);
        return BaseRespVo.success(null);
    }

    @RequestMapping(value = "/config/express", method = RequestMethod.POST)
    public BaseRespVo updateExpressConfig(@RequestBody ExpressConfigVo expressConfigVo){
        configService.updateExpressConfig(expressConfigVo);
        return BaseRespVo.success(null);
    }

    @RequestMapping(value = "/config/order", method = RequestMethod.POST)
    public BaseRespVo updateOrderConfig(@RequestBody OrderConfigVo orderConfigVo){
        configService.updateOrderConfig(orderConfigVo);
        return BaseRespVo.success(null);
    }

    @RequestMapping(value = "/config/wx", method = RequestMethod.POST)
    public BaseRespVo updateWxConfig(@RequestBody WxConfigVo wxConfigVo){
        configService.updateWxConfig(wxConfigVo);
        return BaseRespVo.success(null);
    }

}
