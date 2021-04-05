package com.cskaoyan.service.wx.auth;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.shiro.CustomToken;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.login.RegisterVo;
import com.cskaoyan.vo.wx.login.UserInfoVo;
import com.cskaoyan.vo.wx.login.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName UserAuthServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/5 17:38
 **/

@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    UserMapper userMapper;
    /* *
     * 功能描述 用户登录验证
     * @author wangdi
     * @date 2019/10/5 17:40
     * @param userMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo userLogin(Map userMap, String ipAddress) {
        String username = (String) userMap.get("username");//也可以是电话
        String password = (String) userMap.get("password");
        CustomToken token = new CustomToken(username, password,"wx");
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Serializable id = session.getId();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail();
        }
        int update = userMapper.updateIp(username,ipAddress);

        //验证该用户是否登录中
/*        int userLogin = userMapper.queryUserLoginByUserName(username);
        if(userLogin == 1){
            return BaseRespVo.fail(100,"该用户已经登录");
        }
        int update = userMapper.updateUserLoginStatus(username);*/

        //验证成功去数据库查找用户信息
        User user =  userMapper.queryUserByUsernamePsw(username,password);

        UserInfoVo userInfoVo = new UserInfoVo(user.getNickname(),user.getAvatar());
        UserVo userVo = new UserVo();

        userVo.setUserInfo(userInfoVo);
        userVo.setTokenExpire(new Date());
        userVo.setToken((String) id);
        userVo.setIpAddress(ipAddress);
        //在session存放用户的账号和密码
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("userId",user.getId());
        session.setAttribute("ipAddress",ipAddress);

        return BaseRespVo.success(userVo);
    }

    /* *
     * 功能描述  ---- 生成验证码作为相应头返回
     * @author wangdi
     * @date 2019/10/5 18:09
     * @param phoneMap
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo regCaptcha(Map phoneMap) {
        String code = (int)((Math.random()*9+1)*100000) +"";
        String mobile = (String) phoneMap.get("mobile");
        //发送短信开关
//        boolean flag = SmsUtils.sendMessage(code, mobile);
//        if(!flag){
//            return BaseRespVo.fail();
//        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("code",code);
        Serializable sessionId = session.getId();
        System.out.println("验证码为:" + code);
        System.out.println("sessionId1为   " + sessionId);
        HashMap<String, Object> datamap = new HashMap<>();
        datamap.put("data",sessionId);
        datamap.put("code",code);
        return BaseRespVo.success(datamap);

    }

    /* *
     * 功能描述  用户注册
     * @author wangdi
     * @date 2019/10/5 19:32
     * @param registerVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo register(RegisterVo registerVo) {
        String userCode = registerVo.getCode();
        Session session = SecurityUtils.getSubject().getSession();
        String genCode = (String) session.getAttribute("code");
        if(!userCode.equals(genCode)){
            return BaseRespVo.fail(500,"验证码不正确");
        }
        //判断用户名是否重复
        int exist = userMapper.existUser(registerVo.getUsername(),registerVo.getMobile());
        if(exist !=0){
            return BaseRespVo.fail(500,"用户名或手机已注册");
        }
        //插入用户
        int insert = userMapper.inserUser(registerVo);
        if(insert != 1){
            return null;
        }

        UserInfoVo userInfoVo = new UserInfoVo(registerVo.getUsername(),"");
        UserVo userVo = new UserVo();
        userVo.setUserInfo(userInfoVo);
        userVo.setTokenExpire(new Date());
        userVo.setToken((String) session.getId());
        return BaseRespVo.success(userVo);
    }

    /* *
     * 功能描述 重置账号密码
     * @author wangdi
     * @date 2019/10/5 21:27
     * @param registerVo
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo reset(RegisterVo registerVo) {
        String userCode = registerVo.getCode();
        Session session = SecurityUtils.getSubject().getSession();
        String genCode = (String) session.getAttribute("code");
        System.out.println("sessionId2为   " + session.getId());

        if(!userCode.equals(genCode)){
            return BaseRespVo.fail(500,"验证码不正确");
        }
        int update = userMapper.updateUserPassword(registerVo);

        return BaseRespVo.success("重置成功，请登录");
    }
}
