package com.seasonsfood.mall.web.all.admin.shiro.realm;


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

    /**
     * o获取授权信息：PrincipalCollection是一个身份集合，
     * 因为我们现在就一个Realm，所以直接调用getPrimaryPrincipal得到之前传入的用户名即可；
     * 然后根据用户名调用UserService接口获取角色及权限信息。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取角色字符串信息
        authorizationInfo.setRoles(shopUserService.findRoleNames(username));
        //获取权限字符串信息
        authorizationInfo.setStringPermissions(shopUserService.findPermission(username));
        return authorizationInfo;
    }

    /**
     *获取身份验证相关信息：首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
     * 如果user找到但锁定了抛出锁定异常LockedAccountException；
     * 最后生成AuthenticationInfo信息，交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
     * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
     * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
     * 在组装SimpleAuthenticationInfo信息时，需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
     * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
     * @param authenticationToken 用于收集用户提交的身份（如用户名）及凭据（如密码）
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //身份（如用户名）
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
