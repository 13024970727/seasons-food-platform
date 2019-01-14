package com.seasonsfood.mall.web.all.admin.web.controller.admin;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.SysRole;
import com.seasonsfood.mall.admin.api.service.SysRoleHasSysResourceKeyService;
import com.seasonsfood.mall.admin.api.service.SysRoleService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.JsonUtils;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ron
 */
@CrossOrigin
@RequestMapping("/role")
@RestController
public class SysRoleController{

    @Reference(check = false)
    private SysRoleService sysRoleService;

    @Reference(check = false)
    private SysRoleHasSysResourceKeyService roleResourceKeyService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 为过滤器提供数据
     *
     * @param response 响应作用域
     */
    @GetMapping(value = "/map")
    public void getMap(HttpServletResponse response) {
        List<SysRole> sysRoles = sysRoleService.selectPage(null, null);
        Map<String, String> roleMap = new HashMap<>();
        for (SysRole sysRole : sysRoles) {
            roleMap.put(String.valueOf(sysRole.getId()), sysRole.getDescription());
        }
        JsonUtils.writeJson(roleMap, response);
    }


    /**
     * 添加,具体操作需要在service中完成以便支持事务
     *
     * @param sysRole 添加的角色信息
     *
     * @return 添加信息
     */
    @RequiresPermissions("role:addRole")
    @PostMapping(value = "/addRole")
    public Object addRole(SysRole sysRole) {
        try {
            if (null == sysRole.getRole() || "".equals(sysRole.getRole().trim())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.FORMAT_ERROR, "角色名称不能为空");
            }
            if (null == sysRole.getDescription() || "".equals(sysRole.getDescription().trim())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.FORMAT_ERROR, "角色描述不能为空");
            }
            if (null == sysRole.getResourceIds() || "".equals(sysRole.getResourceIds().trim())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.FORMAT_ERROR, "角色资源不能为空");
            }
            sysRole.setRole(sysRole.getRole().trim());
            sysRole.setDescription(sysRole.getDescription().trim());
            sysRole.setResourceIds(sysRole.getResourceIds().trim());
            if (sysRole.getId() != null) {
                sysRole.setId(null);
            }
            sysRoleService.saveTransaction(sysRole);
            return ResponseUtils.setSuccess();
        }catch (Exception e){
            logger.error("addRole:"+e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /**
     * 修改角色
     * @param id 角色id
     * @param sysRole 修改的角色信息
     * @return 修改信息
     */
    @RequiresPermissions("role:updateRole")
    @PostMapping(value = "/updateRole")
    public Object updateRole(Long id, SysRole sysRole) {
        try {
            if (null == sysRole.getRole() || "".equals(sysRole.getRole().trim())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "角色名称");
            }
            if (null == sysRole.getDescription() || "".equals(sysRole.getDescription().trim())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "角色描述");
            }
            if (null == sysRole.getResourceIds() || "".equals(sysRole.getResourceIds().trim())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "角色资源");
            }
            if (null == sysRole.getId()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "角色ID");
            }
            sysRole.setRole(sysRole.getRole().trim());
            sysRole.setDescription(sysRole.getDescription().trim());
            sysRole.setResourceIds(sysRole.getResourceIds().trim());
            sysRole.setId(id);
            sysRoleService.updateTransaction(sysRole);
            return ResponseUtils.setSuccess();
        }catch (Exception e){
            logger.error("updateRole:"+e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }

    }

    /**
     * 删除
     *
     * @param id 删除的角色id
     *
     * @return 删除信息
     */
    @RequiresPermissions("role:deleteRole")
    @GetMapping(value = "/deleteRole")
    public Object deleteRole(Long id) {
        try {
            if (null == id) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "角色ID");
            }
            SysRole role = new SysRole();
            role.setId(id);
            role = sysRoleService.selectByPrimary(role);
            if(role == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.DELETE_ERROR, "角色不存在");
            }
            boolean isSuccess = sysRoleService.deleteTransaction(id);
            if(isSuccess) {
                return ResponseUtils.setSuccess();
            }else{
                return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
            }
        }catch (Exception e){
            logger.error("deleteRole:"+e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }
    }

    /**
     * 通过id获取角色
     * @param id 角色id
     * @return 查询的角色信息
     */
    @RequiresPermissions("role:getRole")
    @GetMapping(value = "/getRole")
    public JsonResponse getRole(Long id){
        if (null == id) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "角色ID");
        }
        SysRole role = new SysRole();
        role.setId(id);
        role = sysRoleService.selectByPrimary(role);
        if(role == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "角色不存在",true);
        }
        return ResponseUtils.setSuccess(role);
    }

}
