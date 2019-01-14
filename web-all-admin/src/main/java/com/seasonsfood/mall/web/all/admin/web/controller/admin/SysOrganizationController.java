package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.SysOrganization;
import com.seasonsfood.mall.admin.api.domain.SysOrganizationHasSysUserKey;
import com.seasonsfood.mall.admin.api.service.SysOrganizationHasSysUserKeyService;
import com.seasonsfood.mall.admin.api.service.SysOrganizationService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.model.TreeModel;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ron
 */
@RequestMapping("org")
@RestController
public class SysOrganizationController{

    @Reference(check = false)
    SysOrganizationService sysOrganizationService;

    @Reference(check = false)
    SysOrganizationHasSysUserKeyService userOrganizationKeyService;


    /**
     * 获取组织树
     *
     * @return 组织树
     */
    @RequiresPermissions("org:tree")
    @GetMapping("tree")
    public JsonResponse getTree() {

        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setIsAvaliable(true);
        List<SysOrganization> sysOrganizations = sysOrganizationService.selectByEntityWithSimpleResult(sysOrganization, null, null);
        List<TreeModel> treeData = new ArrayList<>();
        for (SysOrganization sysOrganization1 : sysOrganizations) {
            treeData.add(new TreeModel(sysOrganization1.getId(), sysOrganization1.getParentId(), sysOrganization1.getOrganizationName()));
        }

        return ResponseUtils.setSuccess(treeData);
    }


    /**
     * 添加部门节点
     *
     * @param pId
     *         上级编号
     * @param title
     *         部门名称
     *
     * @return 添加操作信息
     */
    @RequiresPermissions("org:add")
    @PostMapping(value = "add")
    public JsonResponse addNode(Long pId, String title) {

        if (null == pId) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择一个父节点", true);
        }
        if (null == title) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "名称");
        }

        SysOrganization parentNode = sysOrganizationService.findById(pId);
        if (null == parentNode) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "不存在该父节点", true);
        }

        Long cid = sysOrganizationService.addChild(title, pId);
        return ResponseUtils.setSuccess(new TreeModel(cid, pId, title));
    }

    /**
     * 更新树节点名字
     *
     * @param id
     *         节点编号
     * @param title
     *         名称
     */
    @RequiresPermissions("org:update")
    @PostMapping(value = "update")
    public JsonResponse updateNode(Long id, String title) {

        if (null == id) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择一个要更新的节点", true);
        }
        if (null == title) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "名称");
        }

        SysOrganization sysOrganization = sysOrganizationService.findById(id);
        if (null == sysOrganization) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "不存在该节点", true);
        }

        sysOrganization.setOrganizationName(title);
        sysOrganizationService.update(sysOrganization);
        return ResponseUtils.setSuccess();
    }

    /**
     * 删除部门节点
     *
     * @param id
     *         节点编号
     *
     * @return 删除操作信息
     */
    @RequiresPermissions("org:delete")
    @PostMapping(value = "delete")
    public JsonResponse deleteNode(Long id) {

        if (null == id) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "请选择一个要删除的节点", true);
        }

        boolean flag = sysOrganizationService.deleteChild(id);
        if (!flag) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "组织关系下有用户，或者不是根节点不允许删除", true);
        }

        return ResponseUtils.setSuccess();
    }


    /**
     * 往部门中添加用户
     *
     * @param uids
     *         用户编号（以，分割）
     * @param orgId
     *         部门编号
     *
     * @return 添加操作信息
     */
    @RequiresPermissions("org:addUser")
    @PostMapping(value = "addUser")
    public JsonResponse addKey(String uids, Long orgId) {

        if (null == uids) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "请选择用添加的用户", true);
        }

        if (null == orgId) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择一个要添加的节点", true);
        }

        SysOrganization sysOrganization = sysOrganizationService.findById(orgId);
        if (null == sysOrganization) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "不存在该节点", true);
        }

        String[] sids = uids.split(",");

        for (String id : sids) {

            //当用户为管理员判断组织中是否有管理员
            SysOrganizationHasSysUserKey userOrganizationKey = new SysOrganizationHasSysUserKey(orgId, Long.valueOf(id));
            userOrganizationKeyService.save(userOrganizationKey);
        }

        return ResponseUtils.setSuccess();
    }

    /**
     * 删除用户的部门关系
     *
     * @param uid
     *         用户编号
     *
     * @return 删除操作信息
     */
    @RequiresPermissions("org:deleteRelation")
    @PostMapping(value = "deleteRelation")
    public JsonResponse deleteKey(Long uid) {
        if (null == uid) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "请选择一个要删除的用户", true);
        }
        SysOrganizationHasSysUserKey userOrganizationKey = new SysOrganizationHasSysUserKey();
        userOrganizationKey.setSysUserId(uid);
        userOrganizationKeyService.delete(userOrganizationKey);

        return ResponseUtils.setSuccess();
    }

}
