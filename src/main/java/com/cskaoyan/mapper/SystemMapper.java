package com.cskaoyan.mapper;

import com.cskaoyan.bean.*;


import com.cskaoyan.vo.system.PermissionsChildVo;
import com.cskaoyan.vo.system.RolePermissionVo;

import com.cskaoyan.vo.system.RoleSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMapper {

    List<Admin> querySystemAdmin(@Param("username") String username);

    void createSystemAdmin(Admin admin);

    List<RoleofAdmin> queryAdminRole();


    List<Role> selectRole(@Param("roleSearch") RoleSearchVo roleSearchVo);

    int insertRole(@Param("role") Role role);

    int updateRoleById(@Param("role") Role role);

    int deleteRoleById(@Param("id") int id);

    void updateSystemAdmin(Admin admin);

    void deleteSystemAdmin(Admin admin);

    List<LogList> querySystemLog(@Param("admin") String admin);


    List<String> queryRolePermissionByRoleId(@Param("role_id") int roleId);

//    void insertPermission(@Param("permission") PermissionsChildVo list);

    //查找所有的权限
    List<String> queryAllRolePermission();

    //删除用户的权限
    int deletePermissionsByRoleId(int roleId);

    //插入用户权限
    int insertRolePermissionsByRoleId(@Param("permission")Permission permissionBean);

    //显示所有的权限
    List<PermissionsChildVo> queryAllPermission();

//    int insertRolePermissionsByRoleId(@Param("permission")  permissionBean);

}
