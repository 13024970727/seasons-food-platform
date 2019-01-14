package com.seasonsfood.mall.business.mapper;

import com.seasonsfood.mall.business.api.domain.ShopUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

/**
 * @author ron
 */
public interface ShopUserMapper extends Mapper<ShopUser> {
    /**
     * 通过用户名查找角色
     * @param username
     * @return
     */
    Set<String> findRoleNames(String username);
    /**
     * 通过用户名查找角色权限.
     *
     * @param username
     * @return
     */
    Set<String> findPermission(String username);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    ShopUser findByName(String username);
}