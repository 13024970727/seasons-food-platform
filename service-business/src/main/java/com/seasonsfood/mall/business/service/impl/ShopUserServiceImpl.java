package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.*;
import com.seasonsfood.mall.business.api.service.ShopUserBankInfoService;
import com.seasonsfood.mall.business.api.service.ShopUserPayInfoService;
import com.seasonsfood.mall.business.api.service.ShopUserService;
import com.seasonsfood.mall.business.mapper.ShopBaseInfoMapper;
import com.seasonsfood.mall.business.mapper.ShopUserMapper;
import com.seasonsfood.mall.business.mapper.ShopWithdrawRecordMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.PasswordHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.Map;

/**
 * @author ron
 */
@Component
@Service(interfaceClass = ShopUserService.class)
public class ShopUserServiceImpl extends BaseServiceImpl<ShopUser> implements ShopUserService {

    @Resource
    ShopUserMapper shopUserMapper;
    @Resource
    ShopWithdrawRecordMapper shopWithdrawRecordMapper;
    @Resource
    ShopBaseInfoMapper shopBaseInfoMapper;

    @Resource
    PasswordHelper passwordHelper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode shopWithdrawCash(ShopWithdrawRecord shopWithdrawRecord, Long shopId) {

        //获取商家店铺信息
        ShopBaseInfo shopBaseInfo = shopBaseInfoMapper.findShopBaseInfoByUserId(shopId);
        if (shopBaseInfo == null) {
            return ResponseCode.SHOP_BASE_INFO_ERROR;
        }
        if (shopBaseInfo.getAccount().compareTo(shopWithdrawRecord.getWithdrawMoney()) < 0) {
            return ResponseCode.NOT_ENOUGH_MONEY;
        }

        shopWithdrawRecord.setShopUserId(shopId);
        shopWithdrawRecord.setShopBaseInfoId(shopBaseInfo.getId());
        shopWithdrawRecord.setCurrentMoney(shopBaseInfo.getAccount().subtract(shopWithdrawRecord.getWithdrawMoney()));
        shopWithdrawRecord.setCreateTime(new Date());

        shopWithdrawRecordMapper.insertSelective(shopWithdrawRecord);
        shopBaseInfoMapper.withdrawMoney(shopBaseInfo.getId(), shopWithdrawRecord.getWithdrawMoney());
        return ResponseCode.SUCCESS;
    }

    @Override
    public ShopUser findByName(String username) {
        return shopUserMapper.findByName(username);
    }

    @Override
    public ResponseCode addUser(ShopUser shopUser) {

        shopUser.setDelete(false);

        // 密码加密
        this.encryptPassword(shopUser, shopUser.getPassword());

        int count = shopUserMapper.insertSelective(shopUser);
        if (count <= 0) {
            return ResponseCode.ADD_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    @Override
    public ResponseCode updatePasswordById(Long id, String password) {

        ShopUser shopUser = shopUserMapper.selectOne(new ShopUser(id));

        // 密码加密
        this.encryptPassword(shopUser, password);

        int count = shopUserMapper.updateByPrimaryKeySelective(new ShopUser(id, password));
        if (count <= 0) {
            return ResponseCode.MODIFY_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseCode deleteById(Long id) {
        ShopUser shopUser = new ShopUser(id);
        shopUser.setDelete(true);
        int count = shopUserMapper.updateByPrimaryKeySelective(shopUser);
        if (count <= 0) {
            return ResponseCode.DELETE_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    /**
     * 密码加密，并设置到用户实体中
     *
     * @param user     用户实体
     * @param password 密码
     */
    private void encryptPassword(ShopUser user, String password) {
        Map<String, String> passwordMap = passwordHelper.encryptPassword(password, user.getUsername());
        user.setSalt(passwordMap.get("salt"));
        user.setPassword(passwordMap.get("password"));
    }

    @Override
    public Set<String> findRoleNames(String username) {
        return shopUserMapper.findRoleNames(username);
    }

    @Override
    public Set<String> findPermission(String username) {
        return shopUserMapper.findPermission(username);
    }
}