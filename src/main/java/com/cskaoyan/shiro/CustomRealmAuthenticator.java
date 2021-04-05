package com.cskaoyan.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version 1.0
 * @ClassName CustomRealmAuthenticator
 * @Description 需要去重写ModularRealmAuthenticator的方法来分发realm，还需要注册这个类
 * @Author wangdi
 * @Date 2019/10/5 15:55
 **/

public class CustomRealmAuthenticator extends ModularRealmAuthenticator {
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
       /*父类这样写的我们需要改写
       this.assertRealmsConfigured();
        Collection<Realm> realms = this.getRealms();
        return realms.size() == 1 ? this.doSingleRealmAuthentication((Realm)realms.iterator().next(), authenticationToken) : this.doMultiRealmAuthentication(realms, authenticationToken);*/

       this.assertRealmsConfigured();
        Collection<Realm> allRealms = this.getRealms();
        //对realm进行筛选，筛选的标准是token中的type
        CustomToken token = (CustomToken) authenticationToken;
        String type = token.getType();//获取customToken的type

        Collection<Realm> realms = new ArrayList<>();
        //进行分发
        for (Realm realm : allRealms) {
            //admin AdminRealm || wx  WxRealm
            if (realm.getName().toLowerCase().contains(type)){
                realms.add(realm);
            }
        }
        return realms.size() == 1 ? this.doSingleRealmAuthentication((Realm)realms.iterator().next(), authenticationToken) : this.doMultiRealmAuthentication(realms, authenticationToken);
    }
}
