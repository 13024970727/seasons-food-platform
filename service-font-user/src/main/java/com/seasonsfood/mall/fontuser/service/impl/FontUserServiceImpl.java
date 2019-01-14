package com.seasonsfood.mall.fontuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.fontuser.api.domain.FontUser;
import com.seasonsfood.mall.fontuser.api.service.FontUserService;
import com.seasonsfood.mall.fontuser.mapper.FontUserMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.PasswordHelper;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Zero on 18-12-12
 */
@Service(interfaceClass = FontUserService.class)
public class FontUserServiceImpl extends BaseServiceImpl<FontUser> implements FontUserService {

    @Resource
    FontUserMapper fontUserMapper;

    @Resource
    PasswordHelper passwordHelper;

    @Override
    public ResponseCode addUser(FontUser fontUser) {

        fontUser.setActive(false);

        // 密码加密
        this.encryptPassword(fontUser,fontUser.getPassword());

        int count = fontUserMapper.insertSelective(fontUser);
        if(count <= 0){
            return ResponseCode.ADD_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    @Override
    public ResponseCode activeUserById(Long id) {
        FontUser fontUser = new FontUser(id);
        fontUser.setActive(true);

        int count = fontUserMapper.updateByPrimaryKeySelective(fontUser);
        if(count <= 0){
            return ResponseCode.MODIFY_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    /**
     * 密码加密，并设置到用户实体中
     *
     * @param user 用户实体
     * @param password 密码
     */
    private void encryptPassword(FontUser user,String password){
        Map<String,String> passwordMap = passwordHelper.encryptPassword(password,user.getUsername());
        user.setSalt(passwordMap.get("salt"));
        user.setPassword(passwordMap.get("password"));
    }
}
