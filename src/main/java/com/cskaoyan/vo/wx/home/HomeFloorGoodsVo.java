package com.cskaoyan.vo.wx.home;

import com.cskaoyan.vo.goods.GoodsVo;

import java.util.List;

/**
 * @version 1.0
 * @ClassName HomeFloorGoodsVo
 * @Description 显示所有商品
 * @Author wangdi
 * @Date 2019/10/5 0:03
 **/

public class HomeFloorGoodsVo {
    String name;
    List<GoodsVo> goodsList;

    public HomeFloorGoodsVo() {
    }

    public HomeFloorGoodsVo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HomeFloorGoodsVo{" +
                "name='" + name + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVo> goodsList) {
        this.goodsList = goodsList;
    }
}
