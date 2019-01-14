package com.seasonsfood.mall.admin.api.service;



import com.seasonsfood.mall.admin.api.domain.SysResource;
import com.seasonsfood.mall.admin.api.domain.SysRole;
import com.seasonsfood.mall.core.service.BaseService;

import java.util.List;

/**
 * @author ron
 */
public interface SysRoleService extends BaseService<SysRole> {

//    public ServerResponseModel<SysRole> selectRoleResource(Integer pageNumber, Integer pageSize);

    /**
     * 根据角色获取资源
     * @param sysRole 角色信息
     * @return 资源集合
     */
    List<SysResource> getResource(SysRole sysRole);

    /**
     * 保存角色
     * @param sysRole 角色信息
     * @return 保存结果
     */
    Boolean saveTransaction(SysRole sysRole);

    /**
     * 修改角色
     * @param sysRole 角色信息
     * @return 修改结果
     */
    Boolean updateTransaction(SysRole sysRole);

    /**
     * 删除角色
     * @param id 角色id
     * @return 删除结果
     */
    Boolean deleteTransaction(Long id);
}
