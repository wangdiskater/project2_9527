package com.cskaoyan.vo.goods;

import java.util.List;

/**
 * @author GF
 * @description 商品类目
 * @date 2019/10/2
 */

public class CategoryListVo {
    String value;
    String label;
    List<ChildrenVo> children;

    @Override
    public String toString() {
        return "CategoryListVo{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ChildrenVo> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenVo> children) {
        this.children = children;
    }
}
