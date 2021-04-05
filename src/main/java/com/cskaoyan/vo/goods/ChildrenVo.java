package com.cskaoyan.vo.goods;

/**
 * @author GF
 * @description 商品类目的下一级类目
 * @date 2019/10/2
 */

public class ChildrenVo {
   private String value;
   private String label;

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
