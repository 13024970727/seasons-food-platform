package com.seasonsfood.mall.web.shop.admin.shiro;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.service.SysResourceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//import com.seasonsfood.mall.core.cache.redis.RedisCache;

/**
 * @author ron
 */
@Component
public class ShiroAuthorizationHelper {

    /**
     * shiro 配置的cacheManager， 需要使用Spring bean进行注入
     */
//    @Reference(version = "1.0.0")
//    private RedisCache redisCache;

    @Resource
    ShiroFilterFactoryBean shiroFilterFactoryBean;

    @Reference
    SysResourceService sysResourceService;


    private static Logger logger = LoggerFactory.getLogger(ShiroAuthorizationHelper.class);

    /**
     * 清除用户的权限
     *
     * @param principal
     */
    public  void clearAuthorizationInfo(SimplePrincipalCollection principal) {
        logger.info("clear the user: " + principal.toString() + "'s authorizationInfo");
        String permissionKey = principal.toString() + ":com.zyark.champion.service.impl.SysUserServiceImpl.findPermission";
        String roleKey = principal.toString() + ":com.zyark.champion.service.impl.SysUserServiceImpl.findRoleNames";
//        redisCache.cleanData(permissionKey);
//        redisCache.cleanData(roleKey);
    }

    /**
     * 清除当前用户的权限
     */
    public void clearAuthorizationInfo() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            Subject subject = SecurityUtils.getSubject();
            String username = subject.getPrincipal().toString();
            String realmName = subject.getPrincipals().getRealmNames().iterator().next();
            SimplePrincipalCollection principalCollection = new SimplePrincipalCollection(username,realmName);

            // 调用清理用户权限
            clearAuthorizationInfo(principalCollection);
        }
    }

}
