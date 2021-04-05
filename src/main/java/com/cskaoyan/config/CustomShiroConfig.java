package com.cskaoyan.config;

import com.cskaoyan.shiro.AdminRealm;
import com.cskaoyan.shiro.CustomRealm;
import com.cskaoyan.shiro.CustomRealmAuthenticator;
import com.cskaoyan.shiro.WxRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

@Configuration
public class CustomShiroConfig {
    /*shiroFilter*/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //如果访问url没有通过认证，会重定向到loginUrl -- fail
        shiroFilterFactoryBean.setLoginUrl("/fail");
        //安全控制器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器配置
        //请求的url
        //anon匿名的
        //authc认证
        //perms权限
        //为了顺序使用linkedHashMap
        HashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //后台需要放行
        filterChainDefinitionMap.put("/admin/auth/login","anon");

        //后台需要拦截
        filterChainDefinitionMap.put("/admin/**","authc");

        //小程序需要放行
        filterChainDefinitionMap.put("/wx/auth/login","anon");
        filterChainDefinitionMap.put("/wx/home/index","anon");
        filterChainDefinitionMap.put("/wx/goods/count","anon");
        filterChainDefinitionMap.put("/wx/catalog/index","anon");
        filterChainDefinitionMap.put("/wx/auth/login_by_weixin","anon");

        //小程序需要拦截
//        filterChainDefinitionMap.put("/wx/**","authc");//开发放行

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        return shiroFilterFactoryBean;
    }

    /*securityManager*/
    @Bean
    public DefaultWebSecurityManager securityManager(CustomRealm realm,
                                                     @Qualifier("adminRealm") AdminRealm adminRealm,
                                                     @Qualifier("wxRealm") WxRealm wxRealm,
                                                     CustomRealmAuthenticator customRealmAuthenticator,
                                                     DefaultSessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(realm);
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(adminRealm);
        realms.add(wxRealm);
        securityManager.setRealms(realms);
        securityManager.setAuthenticator(customRealmAuthenticator);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }
    /*自定义Authenticator*/
    @Bean
    public CustomRealmAuthenticator customRealmAuthenticator(@Qualifier("adminRealm") AdminRealm adminRealm,
                                                             @Qualifier("wxRealm") WxRealm wxRealm){
        CustomRealmAuthenticator customRealmAuthenticator = new CustomRealmAuthenticator();
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(adminRealm);
        realms.add(wxRealm);
        customRealmAuthenticator.setRealms(realms);
        return customRealmAuthenticator;
    }
    /*声明式使用鉴权注解的开关*/
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /*通过异常类型，映射到不同的请求上*/
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("org.apache.shiro.authz.AuthorizationException","/fail");
        simpleMappingExceptionResolver.setExceptionMappings(mappings);
        return simpleMappingExceptionResolver;
    }
    /*自定义的sessionManager*/
    @Bean
    public DefaultWebSessionManager webSessionManager(){
//        MallSessionManager mallSessionManager = new MallSessionManager();
        MallSessionManager mallSessionManager = new MallSessionManager();
        return mallSessionManager;
    }
}
