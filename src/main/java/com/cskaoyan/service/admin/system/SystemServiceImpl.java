package com.cskaoyan.service.admin.system;

import com.cskaoyan.bean.*;

import com.cskaoyan.mapper.SystemMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.ListVo;
import com.cskaoyan.vo.system.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author So9rry
 * @description
 * @date 2019/10/2
 */

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemMapper systemMapper;

    @Override
    public SystemAdminVo querySystemAdmin(int page, int limit, String username) {
        SystemAdminVo systemAdminVo = new SystemAdminVo();
        PageHelper.startPage(page, limit);

        List<Admin> adminList1 = systemMapper.querySystemAdmin(username);
        PageInfo<Admin> adminListPageInfo = new PageInfo<>(adminList1);

        systemAdminVo.setTotal(adminListPageInfo.getTotal());
        systemAdminVo.setItems(adminList1);
        return systemAdminVo;
    }

    @Override
    public Admin createSystemAdmin(Admin admin) {
//        Page<Object> admin = PageHelper.startPage(adminList);
        systemMapper.createSystemAdmin(admin);
        return admin;
    }

    @Override
    public Admin updateSystemAdmin(Admin admin) {
        admin.setUpdateTime(new Date());
        systemMapper.updateSystemAdmin(admin);
        return admin;
    }

    @Override
    public List<RoleofAdminVo> queryAdminRole() {
        List<RoleofAdmin> roleList = systemMapper.queryAdminRole();
        List<RoleofAdminVo> roleofAdminVoList = new ArrayList<>();
        for (RoleofAdmin roleofAdmin : roleList) {
            RoleofAdminVo roleofAdminVo = new RoleofAdminVo();
            roleofAdminVo.setValue(roleofAdmin.getId());
            roleofAdminVo.setLabel(roleofAdmin.getName());
            roleofAdminVoList.add(roleofAdminVo);
        }
        return roleofAdminVoList;
    }


    /* *
     * ???????????? ??????????????????
     * @author wangdi
     * @date 2019/10/2 22:55
     * @param roleSearchVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo roleList(RoleSearchVo roleSearchVo) {
        PageHelper.startPage(roleSearchVo.getPage(),roleSearchVo.getLimit());
        List<Role> roles = systemMapper.selectRole(roleSearchVo);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        List<RoleVo> roleVos = new ArrayList<>();
        for (Role role : roles) {
            RoleVo roleVo = new RoleVo(role);
            roleVos.add(roleVo);
        }
        long total = rolePageInfo.getTotal();
        ListVo<RoleVo> objectListVo = new ListVo<>(total,roleVos);
        return BaseRespVo.success(objectListVo);
    }

    /* *
     * ???????????? ???????????????
     * @author wangdi
     * @date 2019/10/2 23:22
     * @param roleMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo roleCreate(Map roleMap) {
        Role role = new Role();
        String name = (String) roleMap.get("name");
        String  desc = (String) roleMap.get("desc");
        role.setName(name);
        role.setDesc(desc);
        role.setAdd_time(new Date());
        role.setUpdate_time(new Date());
        int insert = systemMapper.insertRole(role);
        if(insert == 1){
            RoleVo roleVo = new RoleVo(role);
            return BaseRespVo.success(roleVo);
        }
        return null;
    }

    /* *
     * ???????????? ??????
     * @author wangdi
     * @date 2019/10/2 23:32
     * @param roleVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo roleUpdate(RoleVo roleVo) {
        Role role = new Role(roleVo);
        int update = systemMapper.updateRoleById(role);
        if(update == 1){
            return BaseRespVo.success("");
        }
        return null;
    }

    /* *
     * ???????????? ??????????????????id
     * @author wangdi
     * @date 2019/10/2 23:42
     * @param id
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo roleDeleteById(int id) {
        int delete = systemMapper.deleteRoleById(id);
        if(delete == 1){
            return BaseRespVo.success("");
        }
        return null;
    }

    @Override
    public void deleteSystemAdmin(Admin admin) {
        systemMapper.deleteSystemAdmin(admin);
    }

    @Override
    public SystemLogVo querySystemLog(int page, int limit, String admin) {

        PageHelper.startPage(page, limit);
            LogByNameVo logByNameVo = new LogByNameVo();
//
            SystemLogVo systemLogVo = new SystemLogVo();
            List<LogList> logList = systemMapper.querySystemLog(admin
            );
            PageInfo<LogList> logListPageInfo = new PageInfo<>(logList);
            systemLogVo.setTotal(logListPageInfo.getTotal());
            systemLogVo.setItems(logList);
            return systemLogVo;

    }

    /* *
     * ???????????? ???????????????????????????
     * @author wangdi
     * @date 2019/10/3 19:31
     * @param roleId
     * @return java.lang.String
     */
    @Override
    public BaseRespVo showRolePermissions(int roleId) throws JsonProcessingException {

        //??????????????????
        List<PermissionsChildVo> lists = systemMapper.queryAllPermission();

        RoleShowPermissionVo roleShowPermissionVo = new RoleShowPermissionVo(lists);
        //??????????????????
        List<String>assignedPermissions =  systemMapper.queryRolePermissionByRoleId(roleId);
        if(assignedPermissions.size()!=0  && assignedPermissions.get(0).equals("*")){
            assignedPermissions = systemMapper.queryAllRolePermission();
        }
        roleShowPermissionVo.setAssignedPermissions(assignedPermissions);

        BaseRespVo success = BaseRespVo.success(roleShowPermissionVo);

        return success;
    }

    /* *
     * ???????????? ??????????????????
     * @author wangdi
     * @date 2019/10/3 19:12
     * @param permissionVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo roleUpdatePermissions(RolePermissionVo permissionVo) {
        int roleId = permissionVo.getRoleId();
        List<String> permissions = permissionVo.getPermissions();
        //?????????????????????*
        if(permissions.size() == 89){
            permissions = new ArrayList<>();
            permissions.add("*");
        }
        //?????????????????????
        int delete = systemMapper.deletePermissionsByRoleId(roleId);
        for (String permission : permissions) {
            Permission permissionBean = new Permission();
            permissionBean.setRole_id(roleId);
            permissionBean.setPermission(permission);
            permissionBean.setAdd_time(new Date());
            permissionBean.setUpdate_time(new Date());
            int i = systemMapper.insertRolePermissionsByRoleId(permissionBean);
            if(i != 1){
                return null;
            }
        }
        return BaseRespVo.success("");
    }

}
