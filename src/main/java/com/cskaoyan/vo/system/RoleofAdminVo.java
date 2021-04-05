package com.cskaoyan.vo.system;

/**
 * @author So9rry
 * @description
 * @date 2019/10/2
 */
public class RoleofAdminVo {

    private int value;

    private String label;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "RoleofAdminVo{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
