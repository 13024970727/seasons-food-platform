package com.seasonsfood.mall.web.all.admin.web.controller.admin;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.SysResource;
import com.seasonsfood.mall.admin.api.domain.SysUser;
import com.seasonsfood.mall.admin.api.model.ResourceModel;
import com.seasonsfood.mall.admin.api.service.SysResourceService;
import com.seasonsfood.mall.admin.api.service.SysUserService;
import com.seasonsfood.mall.util.constant.Const;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.model.TreeModel;
import com.seasonsfood.mall.util.util.JsonUtils;
import com.seasonsfood.mall.util.util.ResponseUtils;
import javafx.util.Pair;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ron
 */
@CrossOrigin
@RestController
@RequestMapping("resource")
public class SysResourceController {

    @Reference(check = false)
    private SysResourceService sysResourceService;
    @Reference(check = false)
    private SysUserService sysUserService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 得到用户的菜单栏
     *
     * @param request 请求作用域
     *
     * @return 用户菜单栏
     */
//    @RequiresPermissions("resource:findMenus")
    @GetMapping("findMenus")
    public JsonResponse findMenus(HttpServletRequest request) {

        SysUser user = (SysUser) request.getAttribute(Const.CURRENT_USER);

        List<SysResource> sysResources = sysUserService.findResources(user.getUsername());
        List<SysResource> rootMenus = sysResourceService.findMenusByUserId(user.getId());

        List<ResourceModel> resourceModelList=new ArrayList<>();

        for (SysResource resource : rootMenus) {
            if (resource.getParentId()==1)
            {
                ResourceModel model=new ResourceModel(resource.getResourceName(),resource.getIcon(),resource.getUrl());
                List<ResourceModel> childModelList=new ArrayList<>();
                for (SysResource child : rootMenus)
                {
                   if(child.getParentId().equals(resource.getId()))
                   {
                       childModelList.add(new ResourceModel(child.getResourceName(),child.getIcon(),child.getUrl()));
                   }
                }
                model.setSubMenuList(childModelList);
                resourceModelList.add(model);
            }

        }

        return ResponseUtils.setSuccess(resourceModelList);

    }

    /**
     * 添加资源
     * @param sysResource 添加的资源
     * @param response 响应作用域
     * @return 添加信息
     */
    @RequiresPermissions("resource:addResource")
    @PostMapping(value = "addResource")
    public JsonResponse addResource(SysResource sysResource, HttpServletResponse response) {
        try {
            Pair<Boolean, String> result = this.checkNullData(sysResource, true);
            if (!result.getKey()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, result.getValue());
            }
            if (!sysResource.getType().trim().equals("button") && !sysResource.getType().trim().equals("menu")) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.FORMAT_ERROR, "资源类别必须为button或menu",true);
            }
            SysResource parentResource = sysResourceService.selectByPrimary(new SysResource(sysResource.getId()));
            if (parentResource == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "父资源不存在",true);
            }
            String parentIds = parentResource.getParentIds() + "/" + parentResource.getId();
            sysResource.setId(null);
            sysResource.setParentIds(parentIds);
            sysResource.setParentId(parentResource.getId());
            sysResource.setIsAvaliable(true);
            sysResourceService.saveSelective(sysResource);
            Map<String, Long> map = new HashMap<>();
            map.put("id", sysResource.getId());
            return ResponseUtils.setSuccess(map);
        } catch (Exception e) {
            logger.error("addResource:" + e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /**
     * 检验数据
     * @param sysResource 需校验的资源信息
     * @param isAdd 是否已添加
     * @return 校验信息
     */
    private Pair<Boolean, String> checkNullData(SysResource sysResource, Boolean isAdd) {
        if (sysResource.getId() == null) {
            if (isAdd) {
                return new Pair<>(false, "资源父ID");
            } else {
                return new Pair<>(false, "资源ID");
            }
        }
        if (sysResource.getResourceName() == null || sysResource.getResourceName().trim().equals("")) {
            return new Pair<>(false, "资源名称");
        }
        if (sysResource.getPriority() == null || sysResource.getPriority().trim().equals("")) {
            return new Pair<>(false, "资源编码");
        }
        if (sysResource.getType() == null || sysResource.getType().trim().equals("")) {
            return new Pair<>(false, "资源类型");
        }
        if (sysResource.getPermission() == null || sysResource.getPermission().trim().equals("")) {
            return new Pair<>(false, "资源权限字符");
        }
        sysResource.setResourceName(sysResource.getResourceName().trim());
        sysResource.setPriority(sysResource.getPriority().trim());
        sysResource.setType(sysResource.getType().trim());
        sysResource.setPermission(sysResource.getPermission().trim());
        return new Pair<>(true, "");
    }

    /**
     * 根据id删除资源
     * @param id 资源id
     * @return 删除结果
     */
    @RequiresPermissions("resource:deleteResource")
    @GetMapping(value = "deleteResource")
    public JsonResponse deleteResource(Long id) {
        try {
            if (id == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "资源ID");
            }
            SysResource sysResource = sysResourceService.selectByPrimary(new SysResource(id));
            if (sysResource == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.DELETE_ERROR, "资源不存在",true);
            }
            sysResourceService.delete(new SysResource(id));
            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            logger.error("deleteResource:" + e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }
    }

    /**
     * 修改资源
     * @param id 资源id
     * @param sysResource 资源信息
     * @param response 响应作用域
     * @return 修改结果
     */
    @RequiresPermissions("resource:updateResource")
    @PostMapping(value = "updateResource")
    public JsonResponse updateResource(Long id, SysResource sysResource, HttpServletResponse response) {
        try {
            sysResource.setId(id);
            Pair<Boolean, String> result = this.checkNullData(sysResource, false);
            if (!result.getKey()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, result.getValue());
            }
            if (!sysResource.getType().trim().equals("button") && !sysResource.getType().trim().equals("menu")) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.FORMAT_ERROR, "资源类别必须为button或menu",true);
            }
            sysResourceService.updateSelective(sysResource);
            SysResource sysResource1 = sysResourceService.selectByPrimary(sysResource);
            return ResponseUtils.setSuccess(sysResource1);
        } catch (Exception e) {
            logger.error("updateResource:" + e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    @GetMapping(value = "/page")
    public String getPage(HttpServletResponse response, Model model) {
        List<SysResource> sysResources = sysResourceService.selectPage(null, null);
        model.addAttribute("resourceList", sysResources);
        return "/admin/index";
    }


    @GetMapping(value = "/list")
    public void getList(HttpServletResponse response) {
        JsonUtils.writeJson(sysResourceService.selectPage(null, null), response);
    }

    /**
     * 获得资源树
     * @return 资源树信息
     */
    @RequiresPermissions("resource:tree")
    @GetMapping(value = "/tree")
    public JsonResponse getTree() {
        logger.info("============resource:tree==============");
        List<SysResource> sysResources = sysResourceService.selectPage(null, null);
        List<TreeModel> treeModels = new ArrayList<>();
        for (SysResource sysResource : sysResources) {
            treeModels.add(new TreeModel(sysResource.getId(), sysResource.getParentId(), sysResource.getResourceName()));
        }
        return ResponseUtils.setSuccess(treeModels);
    }

    @GetMapping(value = "/tree2")
    public void getTree2(HttpServletResponse response) {
        List<SysResource> sysResources = sysResourceService.selectPage(null, null);
        JsonUtils.writeJson(sysResources, response);
    }

    /**
     * 根据id获取资源
     * @param id 资源id
     * @param response 响应作用域
     * @return 资源集合
     */
    @RequiresPermissions("resource:getResource")
    @GetMapping(value = "getResource")
    public JsonResponse getResource(Long id, HttpServletResponse response) {
        if (id == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "资源ID");
        }
        SysResource sysResource = sysResourceService.selectByPrimary(new SysResource(id));
        if (sysResource == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.ERROR, "资源不存在",true);
        }
        return ResponseUtils.setSuccess(sysResource);
    }

}
