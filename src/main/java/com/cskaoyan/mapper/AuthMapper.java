package com.cskaoyan.mapper;

import com.cskaoyan.bean.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName AuthMapper
 * @Description todo
 * @Author wangdi
 * @Date 2019/9/30 14:40
 **/

public interface AuthMapper {

    Admin login(@Param("admin") Admin adminsql);

    //通过管理员用户名查找密码
    String queryPasswordByUsername(@Param("username") String principal);

    //通过用户名查找管理员
    Admin queryAdminByUsername(@Param("username")String primaryPrincipal);

    //获取角色可以用的权限
    List<String> queryPermissionsByRoleIds(@Param("roleIds") Integer[] roleIds);

    //获取角色名字
    ArrayList<String> queryRoleByRoleIds(@Param("roleIds")Integer[] roleIds);

    //通过权限寻找api
    List<String> querypermApiByPerms(@Param("perms") List<String> perms);

    //通过用户用户名查找密码
    String queryUserPasswordByUsername(@Param("username") String principal);
}
