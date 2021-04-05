package com.cskaoyan.service.admin.stat;

import com.cskaoyan.bean.StatAllInfo;
import com.cskaoyan.bean.StatUserRows;
import com.cskaoyan.mapper.StatUserMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.stat.StatUserRowsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description 统计报表 -- 用户统计
 * @Date 2019/9/30
 */
@Service
public class StatUserServiceImpl implements StatUserService {

    @Autowired
    StatUserMapper statUserMapper;

    @Override
    public BaseRespVo statUser(){
        List<Date> dates = statUserMapper.queryRegistrationDate();
        Date newDate = null;
        Date addOneOnChangeDate = null;
        List<StatUserRowsVo> statUserRowsVos = new ArrayList<>();
        for (Date date : dates) {
            if (date != null){
                newDate = statUserMapper.queryChangeDate(date);
                addOneOnChangeDate = statUserMapper.addOneOnChangeDate(newDate);
                List<StatUserRows> rows = statUserMapper.queryStatUser(newDate,addOneOnChangeDate);
                if (rows != null){
                    StatUserRowsVo statUserRowsVo = new StatUserRowsVo();
                    for (StatUserRows statUserRows : rows) {
                        statUserRowsVo.setDay(statUserRows.getDay());
                        statUserRowsVo.setUsers(statUserRows.getUsers());
                        statUserRowsVos.add(statUserRowsVo);
                    }
                }
            }
        }
        StatAllInfo statAllInfo = new StatAllInfo();
        List list = new ArrayList();
        list.add("day");
        list.add("users");
        statAllInfo.setColumns(list);
        statAllInfo.setRows(statUserRowsVos);
        if (statAllInfo == null){
            return BaseRespVo.fail();
        }
        return BaseRespVo.success(statAllInfo);
    }
}
