package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.admin.api.domain.SysOrganization;
import com.seasonsfood.mall.admin.api.domain.SysOrganizationHasSysUserKey;
import com.seasonsfood.mall.admin.api.service.SysOrganizationHasSysUserKeyService;
import com.seasonsfood.mall.admin.api.service.SysOrganizationService;
import com.seasonsfood.mall.admin.mapper.SysOrganizationMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
/**
 * @author ron
 */
@Component
@Service(interfaceClass = SysOrganizationService.class)
public class SysOrganizationServiceImpl extends BaseServiceImpl<SysOrganization> implements SysOrganizationService {


    @Resource
    private SysOrganizationMapper sysOrganizationMapper;

    @Resource
    SysOrganizationHasSysUserKeyService sysOrganizationHasSysUserKeyService;

    /**
     *
     * @param pageNum 页码
     * @param pageSize 页面大小
     *
     * @return
     */
    @Override
    public List<SysOrganization> findAll(Integer pageNum, Integer pageSize) {
        SysOrganization organization = new SysOrganization();
        organization.setIsAvaliable(true);
        organization.setOrgType(2);

        return this.selectByEntityWithSimpleResult(organization, pageNum, pageSize);
    }

    /**
     *
     * @param title
     * @param pId
     * @return
     */
    @Override
    public Long addChild(String title, Long pId) {
        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setOrganizationName(title);
        sysOrganization.setParentId(pId);
        String parentIds = this.selectOne(new SysOrganization(pId)).getParentIds() + pId + "/";
        sysOrganization.setParentIds(parentIds);
        sysOrganization.setIsAvaliable(true);
        sysOrganization.setOrgType(2);
        this.save(sysOrganization);

        //改变其父节点及祖宗节点的状态
        String[] pids = parentIds.split("/");
        for (int i = 0; i < pids.length - 1; i++) {
            SysOrganization grantOrg = new SysOrganization(Long.valueOf(pids[i]));
            grantOrg.setOrgType(0);
            this.updateSelective(grantOrg);
        }
        SysOrganization parentOrg = new SysOrganization(pId);
        parentOrg.setOrgType(1);
        this.updateSelective(parentOrg);
        return sysOrganization.getId();
    }

    /**
     *
     * @param id 编号
     * @return
     */
    @Override
    public SysOrganization findById(Long id) {

        return sysOrganizationMapper.findById(id);
    }


    /**
     *
     * @param id 子节点id
     * @return
     */
    @Override
    public Boolean deleteChild(Long id) {
        SysOrganizationHasSysUserKey sysOrganizationHasSysUserKey = new SysOrganizationHasSysUserKey(id, null);
        List<SysOrganizationHasSysUserKey> sysOrganizationHasSysUserKeys = sysOrganizationHasSysUserKeyService
                .selectByEntityWithSimpleResult(sysOrganizationHasSysUserKey, null, null);
        SysOrganization csysOrganization = this.selectByPrimary(new SysOrganization(id));
        //组织关系下有用户，或者不是根节点不允许删除
        if (sysOrganizationHasSysUserKeys.size() != 0 || csysOrganization.getOrgType() != 2) {
            return false;
        } else {
            SysOrganization sysOrganization = new SysOrganization(id);
            sysOrganization.setIsAvaliable(false);
            //不进行真删除，关联数据备用
            this.updateSelective(sysOrganization);

            SysOrganization findIsParentOrg = new SysOrganization();
            findIsParentOrg.setParentId(csysOrganization.getParentId());
            Boolean isParent = this.selectByEntityWithSimpleResult(findIsParentOrg, null, null).size() == 0 ? false : true;
            //若不是父亲则改为子节点
            if (!isParent) {
                SysOrganization parentOrg = new SysOrganization(csysOrganization.getParentId());
                parentOrg.setOrgType(2);
                this.updateSelective(parentOrg);

                SysOrganization grantOrg = new SysOrganization(parentOrg.getParentId());
                SysOrganization selectOrg = new SysOrganization();
                selectOrg.setParentId(parentOrg.getParentId());
                Boolean hasChild = this.selectByEntityWithSimpleResult(selectOrg, null, null).size() != 0;
                if (!hasChild) {
                    grantOrg.setOrgType(1);
                    this.updateSelective(grantOrg);
                }
            }
            return true;
        }
    }
}
