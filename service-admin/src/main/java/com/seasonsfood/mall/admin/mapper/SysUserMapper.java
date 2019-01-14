package com.seasonsfood.mall.admin.mapper;


import com.seasonsfood.mall.admin.api.domain.SysUser;
import com.seasonsfood.mall.admin.api.model.UserRequest;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ron
 */
public interface SysUserMapper extends Mapper<SysUser> {


    /**
     * 通过用户名查找用户信息
     *
     * @param userName 用户名
     * @return
     */
    SysUser findByName(String userName);


    /**
     * 通过编号查找用户
     *
     * @param id
     *         用户编号
     *
     * @return 用户信息
     */
    SysUser findById(Long id);

    /**
     * 通过条件查找用户信息
     *
     * @param request
     *
     * @return
     */
    List<SysUser> findByCondition(UserRequest request);


    /**
     * 通过条件查找用户信息(不包含查找部门)
     *
     * @param request
     *
     * @return
     */
    List<SysUser> findByConditionNoOrg(UserRequest request);

    /**
     * 通过组织编号查找用户类别
     *
     * @param orgId
     *         组织编号
     *
     * @return
     */
    List<SysUser> findByOrgId(Long orgId);
}