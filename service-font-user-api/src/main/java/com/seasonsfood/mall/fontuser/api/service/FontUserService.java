package com.seasonsfood.mall.fontuser.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.fontuser.api.domain.FontUser;
import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * @author Zero on 18-12-12
 */
public interface FontUserService extends BaseService<FontUser> {

    /**
     * 创建用户
     *
     * @param fontUser
     * @return
     */
    ResponseCode addUser(FontUser fontUser);

    /**
     * 通过用户id激活用户
     *
     * @param id
     * @return
     */
    ResponseCode activeUserById(Long id);
}
