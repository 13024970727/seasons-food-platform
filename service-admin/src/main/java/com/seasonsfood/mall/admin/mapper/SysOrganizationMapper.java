package com.seasonsfood.mall.admin.mapper;

import com.seasonsfood.mall.admin.api.domain.SysOrganization;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author ron
 */
public interface SysOrganizationMapper extends Mapper<SysOrganization> {


    /**
     * 通过编号查找信息
     *
     * @param id
     *         编号
     *
     * @return
     */
    SysOrganization findById(Long id);

}