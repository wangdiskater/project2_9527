package com.cskaoyan.service.admin.stat;

import com.cskaoyan.bean.OrderInfoForData;
import com.cskaoyan.bean.StatAllInfo;
import com.cskaoyan.mapper.StatOrderMapper;
import com.cskaoyan.utils.DateConvertor;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.stat.StatOrderRowsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description 统计报表 -- 订单统计
 * @Date 2019/9/30
 */
@Service
public class StatOrderServiceImpl implements StatOrderService {

    @Autowired
    StatOrderMapper statOrderMapper;

    @Override
    public BaseRespVo queryAllOrder(){
        StatAllInfo statAllInfo = new StatAllInfo();
        // 查询订单中所有下单日期时间
        List<Date> dates = statOrderMapper.queryOrderDate();
        Date newDate = null;
        Date addOneOnChangeDate = null;

        List<StatOrderRowsVo> rowsVoList = new ArrayList<>();
        for (Date date : dates) {
            if (date != null){
                // 格式转换'年月日'
                newDate = statOrderMapper.queryChangeDate(date);
                // 日期+1
                addOneOnChangeDate = statOrderMapper.addOneOnChangeDate(newDate);
                // 某一天的下单信息
                List<OrderInfoForData> orderInfoForData = statOrderMapper.queryOrder(newDate, addOneOnChangeDate);
                if (orderInfoForData != null){
                    double sum = 0;
                    ArrayList list = new ArrayList<>();
                    StatOrderRowsVo statOrderRowsVo = new StatOrderRowsVo();
                    statOrderRowsVo.setOrders(orderInfoForData.size());
                    for (OrderInfoForData datum : orderInfoForData) {
                        // 将同一用户id去重
                        if (list.contains(datum.getUser_id())){
                            sum += datum.getActual_price();
                        }else {
                            list.add(datum.getUser_id());
                            sum += datum.getActual_price();
                        }
                    }
                    statOrderRowsVo.setCustomers(list.size());
                    statOrderRowsVo.setAmount(sum);
                    statOrderRowsVo.setPcr(sum);
                    String day = DateConvertor.getCustomConvertDate(date);
                    statOrderRowsVo.setDay(day);
                    rowsVoList.add(statOrderRowsVo);
                }
            }
        }
        statAllInfo.setRows(rowsVoList);
        List list = new ArrayList();
        if (rowsVoList != null){
            list.add("day");
            list.add("orders");
            list.add("customers");
            list.add("amount");
            list.add("pcr");
        }
        statAllInfo.setColumns(list);

        if (statAllInfo != null){
            return BaseRespVo.success(statAllInfo);
        }
        return BaseRespVo.fail();
    }
}
