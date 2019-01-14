package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.ShopUser;
import com.seasonsfood.mall.business.api.domain.ShopUserBankInfo;
import com.seasonsfood.mall.business.api.domain.ShopWithdrawRecord;
import com.seasonsfood.mall.business.api.model.WithdrawCashModel;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.constant.ResponseCode;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author ron
 */
public interface ShopUserService extends BaseService<ShopUser> {
    /**
     * 商家提现.
     *
     * @param model
     * @param shopId
     * @return com.seasonsfood.mall.util.constant.ResponseCode
     */
    ResponseCode shopWithdrawCash(ShopWithdrawRecord model, Long shopId);

    /**
     * 通过商户用户名查找商户.
     *
     * @param username
     * @return com.seasonsfood.mall.business.api.domain.ShopUser
     */
    ShopUser findByName(String username);

    /**
     * 添加商户
     *
     * @param shopUser
     * @return
     */
    ResponseCode addUser(ShopUser shopUser);

    /**
     * 通过用户id修改用户密码
     *
     * @param id
     * @param password
     * @return
     */
    ResponseCode updatePasswordById(Long id, String password);

    /**
     * 通过用户id删除用户(假删除)
     *
     * @param id
     * @return
     */
    ResponseCode deleteById(Long id);

    /**
     * 通过用户名查找角色名称.
     *
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
}