package com.cskaoyan.controller.wx.address;

import com.cskaoyan.service.wx.address.AddressService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.address.AddressIdVo;
import com.cskaoyan.vo.wx.address.AddressSaveVo;
import com.cskaoyan.vo.wx.address.BaseRespTwoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AddressController
 * @Author LM
 * @Description
 * @Data 2019/10/4 23:33
 */
@RestController
@RequestMapping("wx")
public class AddressController {

    @Autowired
    AddressService addressService;

    /**
     * @Description 查询所有收货地址
     * @Author LM
     * @Date 2019/10/5 15:42
     * @Param
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/address/list",method = RequestMethod.GET)
    public BaseRespVo queryAllAddress(){
        return addressService.queryAllAddress();
    }

    /**
     * @Description 通过id查询收货地址详情
     * @Author LM
     * @Date 2019/10/5 15:44
     * @Param id
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/address/detail",method = RequestMethod.GET)
    public BaseRespVo queryAddressDetail(int id){
        return addressService.queryAddressDetail(id);
    }

    /**
     * @Description 新增收货地址
     * @Author LM
     * @Date 2019/10/5 16:18
     * @Param addSaveVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/address/save",method = RequestMethod.POST)
    public BaseRespVo insertAddress(@RequestBody AddressSaveVo addressSaveVo){
        return addressService.insertAddress(addressSaveVo);
    }

    /**
     * @Description 删除地址
     * @Author LM
     * @Date 2019/10/5 17:02
     * @Param addressListVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @RequestMapping(value = "/address/delete",method = RequestMethod.POST)
    public BaseRespTwoVo deleteAddress(@RequestBody AddressIdVo addressIdVo){
        return addressService.deleteAddress(addressIdVo);
    }



}
