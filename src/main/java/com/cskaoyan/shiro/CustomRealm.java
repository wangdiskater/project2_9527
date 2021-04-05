package com.cskaoyan.shiro;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.mapper.AuthMapper;
import com.cskaoyan.mapper.SystemMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName CustomRealm
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/4 15:46
 **/

@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    AuthMapper authMapper;

    @Autowired
    SystemMapper systemMapper;
    /* *
     * 功能描述 认证
     * @author wangdi
     * @date 2019/10/4 15:46
     * @param authenticationToken
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //subject执行login时传入的usernamePasswordToken中的username
        String principal = (String) authenticationToken.getPrincipal();
        //根据principle也就是用户名去数据库查询用户名所对应的密码信息
        String passwordFromDb = authMapper.queryPasswordByUsername(principal);
        //第一个参数在处理授权信息时可以获得
        //第二个参数 该用户正确的密码（来源于数据库的）
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, passwordFromDb, this.getName());
        System.out.println(authenticationInfo);
        return authenticationInfo;

    }


    /* *
     * 功能描述 授权
     * @author wangdi
     * @date 2019/10/4 15:46
     * @param principalCollection
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获得doGetAuthenticationInfo方法的返回值的第一个参数
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //权限信息时根据认证时的用户信息去数据库中查询获得的
//        List<String> permissions = new ArrayList<>();
//        permissions.add("admin:order:list");

        //查找管理员获取管理员的角色数组
        Admin admin = authMapper.queryAdminByUsername(primaryPrincipal);
        Integer[] roleIds = admin.getRoleIds();
        //获取管理员角色的权限
        List<String> permissions = authMapper.queryPermissionsByRoleIds(roleIds);
        //如果是超级管理员，拉取所有的权限
        if(permissions.contains("*")){
            permissions = systemMapper.queryAllRolePermission();
        }

        authorizationInfo.addStringPermissions(permissions);
//        authorizationInfo.addRole("utilMan");还可以添加角色
        return authorizationInfo;

    }


}
