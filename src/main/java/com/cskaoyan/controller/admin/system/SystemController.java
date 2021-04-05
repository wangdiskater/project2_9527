package com.cskaoyan.controller.admin.system;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.service.admin.system.SystemService;
import com.cskaoyan.vo.BaseRespVo;

import com.cskaoyan.vo.system.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.cskaoyan.vo.system.RoleSearchVo;
import com.cskaoyan.vo.system.RoleVo;
import com.cskaoyan.vo.system.RoleofAdminVo;
import com.cskaoyan.vo.system.SystemAdminVo;
import com.cskaoyan.vo.system.SystemLogVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author So9rry
 * @description
 * @date 2019/10/2
 */

@RestController
@RequestMapping("/admin")
public class SystemController {

    @Autowired
    SystemService systemService;

    /*
     *功能描述 使用条件查询来获取所有的管理员信息
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping(value = "/admin/list", method = RequestMethod.GET)
    public BaseRespVo querySystemAdmin(int page,int limit,String username){
        SystemAdminVo systemAdminVo = systemService.querySystemAdmin(page,limit,username);
        return BaseRespVo.success(systemAdminVo);
    }

    /*
     *功能描述 使用条件查询来获取所有的管理员信息
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public BaseRespVo updateSystemAdmin(@RequestBody Admin admin){
        systemService.updateSystemAdmin(admin);
        return BaseRespVo.success(admin);
    }

    /*
     *功能描述 使用条件查询来获取所有的管理员信息
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public BaseRespVo createSystemAdmin(@RequestBody Admin admin){
        systemService.createSystemAdmin(admin);
        return BaseRespVo.success(admin);
    }

    /*
     *功能描述 使用条件查询来获取所有的管理员信息
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public BaseRespVo deleteSystemAdmin(@RequestBody Admin admin){
       systemService.deleteSystemAdmin(admin);
        return BaseRespVo.success(null);
    }

    /*
     *功能描述 使用条件查询来获取所有的管理员信息
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping(value = "/role/options", method = RequestMethod.GET)
    public BaseRespVo queryAdminRole(){
        List<RoleofAdminVo> roleListVo = systemService.queryAdminRole();
        return BaseRespVo.success(roleListVo);
    }

    /*
     *功能描述 使用条件查询来获取所有日志操作信息
     *@author GF
     *@date
     *@param
     *@return
     */
    @RequestMapping(value = "/log/list", method = RequestMethod.GET)
    public BaseRespVo querySystemLog(int page, int limit, String name){
        SystemLogVo systemLogVo = systemService.querySystemLog(page, limit, name);
        return BaseRespVo.success(systemLogVo);
    }




    /* *
     * 功能描述 显示，查询角色管理
     * @author wangdi
     * @date 2019/10/2 22:53
     * @param page
     * @param limit
     * @param name
     * @param sort
     * @param order
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/role/list",method = RequestMethod.GET)
    public BaseRespVo roleList(int page, int limit, String name, String sort, String order){
        RoleSearchVo roleSearchVo = new RoleSearchVo(page, limit, name, sort, order);
        return systemService.roleList(roleSearchVo);
    }
    /* *
     * 功能描述 新建角色
     * @author wangdi
     * @date 2019/10/2 23:30
     * @param roleMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/role/create",method = RequestMethod.POST)
    public BaseRespVo roleCreate(@RequestBody Map roleMap){
        return systemService.roleCreate(roleMap);
    }
    /* *
     * 功能描述 修改角色
     * @author wangdi
     * @date 2019/10/2 23:30
     * @param null
     * @return
     */
    @RequestMapping(value = "/role/update",method = RequestMethod.POST)
    public BaseRespVo roleUpdate(@RequestBody RoleVo roleVo){
         return systemService.roleUpdate(roleVo);
     }
     /* *
      * 功能描述 删除
      * @author wangdi
      * @date 2019/10/2 23:45
      * @param roleVo
      * @return com.cskaoyan.vo.BaseRespVo
      */
    @RequestMapping(value = "/role/delete",method = RequestMethod.POST)
    public BaseRespVo roleDelete(@RequestBody RoleVo roleVo){
        return systemService.roleDeleteById(roleVo.getId());
    }

    /* *
     * 功能描述 获取该角色想拥有的权限
     * @author wangdi
     * @date 2019/10/3 19:07
     * @param roleId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/role/permissions",method = RequestMethod.GET)
    public BaseRespVo rolePermissions(int roleId) throws JsonProcessingException {
        return systemService.showRolePermissions(roleId);
    }
    /* *
     * 功能描述 修改角色权限
     * @author wangdi
     * @date 2019/10/4 15:43
     * @param permissionVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/role/permissions",method = RequestMethod.POST)
    public BaseRespVo roleUpdatePermissions(@RequestBody RolePermissionVo permissionVo){
        return systemService.roleUpdatePermissions(permissionVo);
    }

}
