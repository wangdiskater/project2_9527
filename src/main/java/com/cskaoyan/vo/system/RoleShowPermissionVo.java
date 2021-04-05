package com.cskaoyan.vo.system;

import com.cskaoyan.mapper.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Permission;
import java.util.*;

/**
 * @version 1.0
 * @ClassName RoleShowPermissionVo
 * @Description 传给前端显示该角色的权限
 * @Author wangdi
 * @Date 2019/10/3 19:29
 **/

public class RoleShowPermissionVo {



    List<PermissionsVo> systemPermissions = new ArrayList<>();

    public RoleShowPermissionVo() {
    }

    public RoleShowPermissionVo(List<PermissionsChildVo> lists) {

        HashMap<Integer, PermissionsVo> fmap = new HashMap<>();
        HashMap<Integer, PermissionsVo> smap = new HashMap<>();


        for (PermissionsChildVo list : lists) {
            //如果是最外层
            if(list.getPid() == 0){
                list.setId(list.getLabel());

                PermissionsVo permissionsVo = new PermissionsVo(list);
                fmap.put(list.getIds(),permissionsVo);

            //如果是第二层
            } else if(String.valueOf(list.getIds()).length() == 2) {
                list.setId(list.getLabel());
                PermissionsVo son = new PermissionsVo(list);
                PermissionsVo parent = fmap.get(list.getPid());
                parent.getChildren().add(son);
                smap.put(list.getIds(),son);

            //第三层 包装
            } else{
                PermissionsVo son = new PermissionsVo(list);

                PermissionsVo parent = smap.get(list.getPid());
                int ppid = parent.getPid();
                PermissionsVo permissionsVoP = fmap.get(ppid);

                List<PermissionsVo> children = permissionsVoP.getChildren();
                for (PermissionsVo child : children) {
                    if(child.getIds() == parent.getIds()){
                        child.getChildren().add(son);
                        break;
                    }
                }
            }
        }
        //遍历map拿出所有permission
        Set<Map.Entry<Integer, PermissionsVo>> entries = fmap.entrySet();
        for (Map.Entry<Integer, PermissionsVo> entry : entries) {
            //放在array中
            systemPermissions.add(entry.getValue());
        }

    }

    List<String> assignedPermissions;

    public List<String> getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(List<String> assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public List<PermissionsVo> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List<PermissionsVo> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }
}
