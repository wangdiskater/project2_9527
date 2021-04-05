package com.cskaoyan.service.wx.collect;

import com.cskaoyan.bean.CollectList;
import com.cskaoyan.bean.CollectOrNot;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.vo.wx.collect.CollectListVo;
import com.cskaoyan.vo.goods.GoodsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author So9rry
 * @description
 * @date 2019/10/4
 */

@Service
public class CollectServiceImpl implements CollectService{

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public CollectOrNot addOrDelete(int type, int valueId) {
        List<Integer> collectOrNot = goodsMapper.queryCollectOrNot(valueId);
        CollectOrNot collect = new CollectOrNot();

        for (Integer integer : collectOrNot) {
            if (integer.equals(valueId)){
                goodsMapper.delete(valueId);
                collect.setType("delete");
                return collect;
            }
        }
        goodsMapper.add(type, valueId);
        collect.setType("add");
        return collect;
    }

    @Override
    public CollectListVo queryCollectList(int page, int size) {
        CollectListVo collectListVo = new CollectListVo();
        PageHelper.startPage(page, size);

        List<CollectList> collectLists = goodsMapper.queryCollectList();
        PageInfo<CollectList> pageInfo = new PageInfo<>(collectLists);

        collectListVo.setTotalPages(pageInfo.getTotal());
        collectListVo.setCollectList(collectLists);
        return collectListVo;
    }
}
