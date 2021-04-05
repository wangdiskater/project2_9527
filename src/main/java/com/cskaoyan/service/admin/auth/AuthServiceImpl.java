package com.cskaoyan.service.admin.auth;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.mapper.*;
import com.cskaoyan.shiro.CustomToken;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.DashBoardVo;
import com.cskaoyan.vo.InfoVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName AuthServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/9/30 14:35
 **/

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MallManageMapper mallManageMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    SystemMapper systemMapper;


    /* *
     * 功能描述 弃用
     * @author wangdi
     * @date
     * @param map
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo login(Map map) {
        String username = (String) map.get("username");
        String password = (String) map.get("password");
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        CustomToken token = new CustomToken(username, password,"admin");
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail();
        }
        Session session = subject.getSession();
        Serializable id = session.getId();
        //保存token信息给info使用
        session.setAttribute(id,map);

        //保存登陆信息进入login
//        new L
//        systemMapper.insertLogin()

        return BaseRespVo.success(id);

    }

    /* *
     * 功能描述 管理员信息返回
     * @author wangdi
     * @date 2019/10/5 16:23
     * @param token
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo info(String token) {
        Session session = SecurityUtils.getSubject().getSession();
        Map adminMap = (Map) session.getAttribute(token);
        String username = (String) adminMap.get("username");
        String password = (String) adminMap.get("password");
        //查找管理员获取管理员的角色数组
        Admin admin = authMapper.queryAdminByUsername(username);
        //获取管理员的角色数组
        Integer[] roleIds = admin.getRoleIds();
        //获取管理员权限名字
        ArrayList<String> roles = authMapper.queryRoleByRoleIds(roleIds);

        //获取管理员角色的权限
        List<String> perms = authMapper.queryPermissionsByRoleIds(roleIds);
        List<String> permsAPI = null;
        if(perms.contains("*")){
            InfoVo infoVo = new InfoVo(roles,username,perms,admin.getAvatar());
            return BaseRespVo.success(infoVo);
        }

        //通过权限，寻找API
        //如果没有权限着直接返回空权限
        if(perms.size()==0){
            InfoVo infoVo = new InfoVo(roles,username,perms,admin.getAvatar());
            return BaseRespVo.success(infoVo);
        }
        permsAPI = authMapper.querypermApiByPerms(perms);

        if(permsAPI!= null && permsAPI.size()!= perms.size()){
            return BaseRespVo.fail(500,"权限管理错误，请联系管理员");
        }else if (permsAPI != null){
            perms = permsAPI;
        }
        InfoVo infoVo = new InfoVo(roles,username,perms,admin.getAvatar());
        return BaseRespVo.success(infoVo);

    }

    /* *
     * 功能描述 修改密码
     * @author wangdi
     * @date 2019/9/30 15:47
     * @param passwordMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo password(Map passwordMap) {

        return BaseRespVo.success("");
    }

    @Override
    public BaseRespVo dashboard() {
        DashBoardVo dashBoardVo = new DashBoardVo();
        int userTotal = userMapper.queryUserCount();
        int orderTotal = mallManageMapper.queryOrderCount();
        int goodsTotal = goodsMapper.queryGoodsCount();
        int productsTotal = goodsMapper.queryProductsCount();

        dashBoardVo.setGoodsTotal(goodsTotal);
        dashBoardVo.setUserTotal(userTotal);
        dashBoardVo.setProductTotal(productsTotal);
        dashBoardVo.setOrderTotal(orderTotal);
        return BaseRespVo.success(dashBoardVo);
    }
}
