package com.cskaoyan.service.admin.stat;

import com.cskaoyan.bean.StatAllInfo;
import com.cskaoyan.vo.BaseRespVo;

/**
 * @Auther Piter_Liu
 * @Description 统计报表 -- 用户统计
 * @Date 2019/9/30
 */

public interface StatUserService {
    /**
     * @return 用户统计：day users
     */
    BaseRespVo statUser();
}
