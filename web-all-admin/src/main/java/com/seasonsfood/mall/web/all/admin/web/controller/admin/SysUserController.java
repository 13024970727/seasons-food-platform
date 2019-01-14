package com.seasonsfood.mall.web.all.admin.web.controller.admin;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.SysUser;
import com.seasonsfood.mall.admin.api.model.UserRequest;
import com.seasonsfood.mall.admin.api.service.SysUserService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @author ron
 */
@RequestMapping("user")
@RestController
public class SysUserController {

    @Reference(check = false)
    private SysUserService sysUserService;

    /**
     * 通过条件查找用户列表信息
     *
     * @param request 请求域
     *
     * @return 用户列表
     */
    @RequiresPermissions("user:findByCondition")
    @PostMapping(value = "findByCondition")
    public JsonResponse findByCondition(UserRequest request) {

        if (null == request.getPage() || null == request.getPageSize()) {
            return ResponseUtils.setToJson(ResponseCode.PAGE_ERROR);
        }

        return ResponseUtils.setDataAndResponse(sysUserService.findByCondition(request));
    }


    /**
     * 删除用户
     *
     * @param uid 用户id
     */
    @RequiresPermissions("user:delete")
    @PostMapping(value = "delete")
    public JsonResponse deleteUser(Long uid) {


        if (null == uid) {
            return ResponseUtils.setToJson(ResponseCode.OPERATION_ERROR);
        }

        SysUser sysUser = sysUserService.findById(uid);
        if (null == sysUser) {
            return ResponseUtils.setToJson(ResponseCode.OPERATION_ERROR);
        }
        sysUser.setIsDelete(true);
        sysUserService.update(sysUser);

        return ResponseUtils.setSuccess();
    }

    /**
     * 查找组织下的用户列表
     *
     * @param orgId
     *         组织编号
     * @param page
     *         页数
     * @param pageSize
     *         每页的数据量
     */
    @RequiresPermissions("user:findListByOrgId")
    @GetMapping(value = "findListByOrgId")
    public JsonResponse getListByOrgId(Long orgId, Integer page, Integer pageSize) {

        if (null == page || null == pageSize) {
            return ResponseUtils.setToJson(ResponseCode.PAGE_ERROR);
        }

        return ResponseUtils.setDataAndResponse(sysUserService.findListByOrgId(orgId, page, pageSize));
    }

    /**
     * 修改密码
     *
     * @param uid
     *         用修改的用户编号
     * @param password
     *         新的密码
     */
    @RequiresPermissions("user:modifyPwd")
    @PostMapping(value = "modifyPwd")
    public JsonResponse modifyPwd(Long uid, String password) {

        if (null == uid) {
            return ResponseUtils.setToJson(ResponseCode.OPERATION_ERROR);
        }

        if (null == password) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "新密码");
        }

        //加密密码
        sysUserService.updatePassword(uid,password);

        return ResponseUtils.setSuccess();
    }

    /**
     * 修改用户信息
     *
     * @param user
     *         修改的用户信息
     *
     * @return 修改成功的用户信息
     */
    @RequiresPermissions("user:modify")
    @PostMapping(value = "modify")
    public JsonResponse modify(SysUser user) {

        if (null == user || null == user.getId()) {
            return ResponseUtils.setToJson(ResponseCode.OPERATION_ERROR);
        }

        if (null == user.getUsername()) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "用户名");
        }

        SysUser sysUser = sysUserService.findById(user.getId());
        if (null == sysUser) {
            return ResponseUtils.setToJson(ResponseCode.OPERATION_ERROR);
        }

        if (!sysUser.getUsername().equals(user.getUsername())) {
            SysUser sysUser1 = sysUserService.findByName(user.getUsername());
            if (null != sysUser1) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "该用户名已存在", true);
            }
        }

        sysUser.setUsername(user.getUsername());
        sysUser.setNickname(user.getNickname());
        sysUser.setPhone(user.getPhone());
        sysUser.setRoleIds(user.getRoleIds());
        sysUser.setLocked(user.getLocked());
        sysUserService.updateUser(sysUser);

        return ResponseUtils.setSuccess(sysUser);
    }

    /**
     * 添加后台用户
     *
     * @param sysUser 添加后台的用户信息
     * @return 添加成功的用户信息
     */
    @RequiresPermissions("user:add")
    @PostMapping(value = "add")
    public JsonResponse addUser(SysUser sysUser) {

        if (null == sysUser) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "提交的数据");
        }

        if (null == sysUser.getUsername()) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "用户名");
        }

        if (null == sysUser.getPassword()) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "密码");
        }

        if (null == sysUser.getRoleIds()) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择一个用户角色", true);
        }

        SysUser nameUser = sysUserService.findByName(sysUser.getUsername());
        if (null != nameUser) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "该用户名已存在", true);
        }

        sysUser.setLocked(false);
        sysUser.setCreateTime(new Date());

        sysUserService.saveUser(sysUser);

        return ResponseUtils.setSuccess(sysUser);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     *
     * @return 用户信息
     */
    @RequiresPermissions("user:getUser")
    @GetMapping(value = "getUser")
    public JsonResponse getUser(Long id) {
        if (id == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "用户ID");
        }
        SysUser sysUser = sysUserService.findById(id);
        if (sysUser == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.ERROR, "用户不存在", true);
        }
        return ResponseUtils.setSuccess(sysUser);
    }

}
