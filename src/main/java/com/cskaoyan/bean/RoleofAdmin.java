package com.cskaoyan.bean;

/**
 * @author So9rry
 * @description
 * @date 2019/10/2
 */
public class RoleofAdmin {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleofAdmin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
