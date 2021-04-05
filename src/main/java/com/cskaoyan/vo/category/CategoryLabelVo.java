package com.cskaoyan.vo.category;

/**
 * @version 1.0
 * @ClassName CategoryLabelVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 0:10
 **/

public class CategoryLabelVo {
    private int value;
    private String lable;
//    private String value;
//    private int lable;
    @Override
    public String toString() {
        return "CategoryLabelVo{" +
                "value=" + value +
                ", lable='" + lable + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
