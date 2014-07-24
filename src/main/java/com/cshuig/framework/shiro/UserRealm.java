package com.cshuig.framework.shiro;

import com.cshuig.scm.service.Interface.IUserSerice;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;

/**
 * Created by Administrator on 2014/7/24 0024.
 */
public class UserRealm extends AuthorizingRealm{
    @Inject
    private IUserSerice userSerice;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //设置用户的角色
        authorizationInfo.setRoles(userSerice.getRolesByUsername(userName));
        //设置用户的权限
        authorizationInfo.setStringPermissions();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
