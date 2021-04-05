package com.cskaoyan.service.wx.address;

import com.cskaoyan.bean.Address;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.user.AddressVo;
import com.cskaoyan.vo.wx.address.*;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname AddressServiceImpl
 * @Author LM
 * @Description
 * @Data 2019/10/4 23:48
 */
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    UserMapper userMapper;

    /**
     * @Description 查询所有地址信息
     * @Author LM
     * @Date 2019/10/5 15:48
     * @Param
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo queryAllAddress() {
        List<AddressVo> addressVos = userMapper.queryAllAddress();
        List<Object> list = new ArrayList<>();
        for (AddressVo addressVo : addressVos) {
            AddressListVo addressListVo = new AddressListVo(addressVo);
            list.add(addressListVo);
        }
        return BaseRespVo.success(list);
    }


    /**
     * @Description 通过id查询收货地址详情
     * @Author LM
     * @Date 2019/10/5 15:48
     * @Param id
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo queryAddressDetail(int id) {
        AddressDetailVo addressDetailVo = userMapper.queryAddressDetail(id);
        return BaseRespVo.success(addressDetailVo);
    }

    /**
     * @Description 新增收货地址
     * @Author LM
     * @Date 2019/10/5 16:18
     * @Param addSaveVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo insertAddress(AddressSaveVo addressSaveVo) {
        int ids = addressSaveVo.getId();
        int id = userMapper.queryAddressCount();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String now = simpleDateFormat.format(new Date());
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        Address addressId = userMapper.queryAddressId();
        if (addressSaveVo.getIsDefault() == true){
            userMapper.updateIsDefault();
        }
        if (userId == null){
            return BaseRespVo.fail(100,"登录过期，请登录");
        }
        if (ids == 0){
            addressSaveVo.setAddTime(now);
            addressSaveVo.setUpdateTime(now);
            userMapper.insertAddress(addressSaveVo,userId);
        }else {
            addressSaveVo.setUpdateTime(now);
            userMapper.updateAddress(addressSaveVo);
        }
        return BaseRespVo.success(addressId.getId());
    }


    /**
     * @Description 删除收货地址
     * @Author LM
     * @Date 2019/10/5 17:03
     * @Param addressListVo
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespTwoVo deleteAddress(AddressIdVo addressIdVo) {
        userMapper.deleteAddress(addressIdVo.getId());
        return BaseRespTwoVo.success();
    }
}
