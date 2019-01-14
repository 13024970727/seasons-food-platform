package com.seasonsfood.mall.web.marketing.shiro.realm;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.ShopUser;
import com.seasonsfood.mall.business.api.service.ShopUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.aop.SpringProxy;


/**
 * @author ron
 */
public class UserRealm extends AuthorizingRealm implements SpringProxy {

    @Reference(check = false)
    ShopUserService shopUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(shopUserService.findRoleNames(username));
        authorizationInfo.setStringPermissions(shopUserService.findPermission(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        ShopUser shopUser = shopUserService.findByName(username);

        //没找到帐号
        if (shopUser == null) {
            throw new UnknownAccountException();
        }
        //帐号被锁定
        if (shopUser.getLocked()) {
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo simpleAuthorizationInfo = new SimpleAuthenticationInfo(
                shopUser.getUsername(),
                shopUser.getPassword(),
                ByteSource.Util.bytes(shopUser.getCredentialsSalt()),
                getName()
        );
        return simpleAuthorizationInfo;
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
