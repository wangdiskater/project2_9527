package com.cskaoyan.service.admin.stat;

import com.cskaoyan.bean.GoodsInfoForData;
import com.cskaoyan.bean.StatAllInfo;
import com.cskaoyan.mapper.StatGoodsMapper;
import com.cskaoyan.utils.DateConvertor;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.stat.StatGoodsRowsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther Piter_Liu
 * @Description 统计报表 -- 商品统计
 * @Date 2019/10/1
 */
@Service
public class StatGoodsServiceImpl implements StatGoodsService {

    @Autowired
    StatGoodsMapper statGoodsMapper;

    /**
     * 获取商品统计数据
     */
    @Override
    public BaseRespVo queryAllGoods(){
        StatAllInfo statAllInfo = new StatAllInfo();
        // 查询订单中所有下单日期时间
        List<Date> dates = statGoodsMapper.queryGoodsDate();
        Date newDate = null;
        Date addOneOnChangeDate = null;

        List<StatGoodsRowsVo> rowsVoList = new ArrayList<>();
        for (Date date : dates) {
            if (date != null){
                // 格式转换'年月日'
                newDate = statGoodsMapper.queryChangeDate(date);
                // 日期+1
                addOneOnChangeDate = statGoodsMapper.addOneOnChangeDate(newDate);
                // 某一天的下单信息
                List<GoodsInfoForData> goodsInfoForData = statGoodsMapper.queryGoods(newDate, addOneOnChangeDate);
                if (goodsInfoForData != null){
                    int sum = 0;
                    double total = 0;
                    ArrayList orderList = new ArrayList<>();
                    StatGoodsRowsVo statGoodsRowsVo = new StatGoodsRowsVo();
                    for (GoodsInfoForData datum : goodsInfoForData) {
                        // 将同一订单id去重
                        if (orderList.contains(datum.getOrder_id())){
                            total = datum.getNumber() * datum.getPrice();
                            sum += datum.getNumber();
                        }else {
                            orderList.add(datum.getOrder_id());
                            total = datum.getNumber() * datum.getPrice();
                            sum += datum.getNumber();
                        }
                    }
                    statGoodsRowsVo.setOrders(orderList.size());
                    statGoodsRowsVo.setAmount(total);
                    statGoodsRowsVo.setProducts(sum);
                    String day = DateConvertor.getCustomConvertDate(date);
                    statGoodsRowsVo.setDay(day);
                    rowsVoList.add(statGoodsRowsVo);
                }
            }
        }

        statAllInfo.setRows(rowsVoList);
        List list = new ArrayList();
        if (rowsVoList != null){
            list.add("day");
            list.add("orders");
            list.add("products");
            list.add("amount");
        }
        statAllInfo.setColumns(list);

        if (statAllInfo != null){
            return BaseRespVo.success(statAllInfo);
        }
        return BaseRespVo.fail();
    }
}
