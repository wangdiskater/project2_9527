package com.cskaoyan.service.wx.address;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.address.AddressIdVo;
import com.cskaoyan.vo.wx.address.AddressSaveVo;
import com.cskaoyan.vo.wx.address.BaseRespTwoVo;

public interface AddressService {

    //查询所有收货地址
    BaseRespVo queryAllAddress();

    //通过id查询收货地址详情
    BaseRespVo queryAddressDetail(int id);

    //新增收货地址
    BaseRespVo insertAddress(AddressSaveVo addSaveVo);

    //删除收货地址
    BaseRespTwoVo deleteAddress(AddressIdVo addressIdVo);
}
