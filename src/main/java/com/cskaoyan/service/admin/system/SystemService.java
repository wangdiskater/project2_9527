package com.cskaoyan.service.admin.system;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.system.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface SystemService {

    //查询管理员
    SystemAdminVo querySystemAdmin(int page, int limit, String username);

    //增加管理员
    Admin createSystemAdmin(Admin admin);

    //删除管理员
    void deleteSystemAdmin(Admin admin);

    //更新管理员信息
    Admin updateSystemAdmin(Admin admin);

    //显示管理员角色
    List<RoleofAdminVo> queryAdminRole();


    //显示角色管理
    BaseRespVo roleList(RoleSearchVo roleSearchVo);

    //创建新的权限
    BaseRespVo roleCreate(Map roleMap);

    //修改基本信息
    BaseRespVo roleUpdate(RoleVo roleVo);

    //删除角色
    BaseRespVo roleDeleteById(int id);

    //查询所有操作记录
    SystemLogVo querySystemLog(int page, int limit, String admin);

    //更新角色权限
    BaseRespVo roleUpdatePermissions(RolePermissionVo permissionVo);

    //显示该角色有的权限
    BaseRespVo showRolePermissions(int roleId) throws JsonProcessingException;
}
