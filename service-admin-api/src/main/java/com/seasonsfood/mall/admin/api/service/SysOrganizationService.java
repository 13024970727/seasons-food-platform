package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.SysOrganization;
import com.seasonsfood.mall.core.service.BaseService;

import java.util.List;

/**
 * @author ron
 */
public interface SysOrganizationService extends BaseService<SysOrganization> {

    /**
     * 找出所有未被删除的营业厅
     *
     * @param pageNum 页码
     * @param pageSize 页面大小
     *
     * @return 未被删除的营业厅集合
     */
    List<SysOrganization> findAll(Integer pageNum, Integer pageSize);

    /**
     * 添加树节点，并改变其祖宗的类型０祖１父２子
     */
    Long addChild(String title, Long pId);

    /**
     * 删除子节点
     * @param id 子节点id
     * @return 删除结果
     */
    Boolean deleteChild(Long id);

    /**
     * 通过编号查找信息
     * @param id 编号
     * @return 营业厅信息
     */
    SysOrganization findById(Long id);



}
