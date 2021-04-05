package com.cskaoyan.vo.system;

import java.util.List;

/**
 * @version 1.0
 * @ClassName RolePermissionVo
 * @Description 从前端拿到用户可以授权的信息
 * @Author wangdi
 * @Date 2019/10/3 19:09
 **/

public class RolePermissionVo {
    private int roleId;
    private List<String> permissions;

    @Override
    public String toString() {
        return "RolePermissionVo{" +
                "roleId=" + roleId +
                ", permissions=" + permissions +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
