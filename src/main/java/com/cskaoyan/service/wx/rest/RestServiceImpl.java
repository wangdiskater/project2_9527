package com.cskaoyan.service.wx.rest;

import com.cskaoyan.mapper.MallManageMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.rest.RegionByIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname RestServiceImpl
 * @Author LM
 * @Description
 * @Data 2019/10/5 19:47
 */
@Service
public class RestServiceImpl implements RestService{

    @Autowired
    MallManageMapper mallManageMapper;

    /**
     * @Description 通过id查询区域列表
     * @Author LM
     * @Date 2019/10/5 20:05
     * @Param pid
     * @Return com.cskaoyan.vo.BaseRespVo
     **/
    @Override
    public BaseRespVo queryRegionListById(int pid) {
        List<RegionByIdVo> regionByIdVoList = mallManageMapper.queryRegionListById(pid);
        return BaseRespVo.success(regionByIdVoList);
    }
}
