package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.seasonsfood.mall.admin.api.domain.*;
import com.seasonsfood.mall.admin.api.model.UserRequest;
import com.seasonsfood.mall.admin.api.service.SysUserHasSysRoleKeyService;
import com.seasonsfood.mall.admin.api.service.SysUserService;
import com.seasonsfood.mall.admin.mapper.*;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import com.seasonsfood.mall.util.util.PasswordHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;


/**
 * @author ron
 */
@Component
@Service(interfaceClass = SysUserService.class)
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Resource
    SysUserHasSysRoleMapper userRoleMapper;
    @Resource
    SysRoleMapper sysRoleMapper;
    @Resource
    SysResourceMapper sysResourceMapper;
    @Resource
    SysUserMapper sysUserMapper;
    @Resource
    SysRoleHasSysResourceMapper roleResourceMapper;
    @Resource
    PasswordHelper passwordHelper;
    @Resource
    SysUserHasSysRoleKeyService sysUserHasSysRoleKeyService;
    @Resource
    SysOrganizationHasSysUserMapper userOrganizationMapper;


    Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Override
    public SysUser findByName(String userName) {
        logger.debug("test");
        return sysUserMapper.findByName(userName);
    }

    @Override
    public ListResponse<SysUser> findByCondition(UserRequest request) {

        PageHelper.startPage(request.getPage(), request.getPageSize());
        List<SysUser> list;
        boolean flag = (null == request.getOrgId() || 0 == request.getOrgId()) && (null == request.getOrg() || 0 == request.getOrg());
        if (flag) {
            list = sysUserMapper.findByConditionNoOrg(request);
        } else {
            list = sysUserMapper.findByCondition(request);
        }

        return super.listToResponse(list);
    }

    /**
     * 根据用户名找到角色
     *
     * @param username 用户名
     *
     * @return 用户角色信息
     */
    @Override
    public List<SysRole> findRoles(String username) {
        SysUser sysUser = this.selectOne(new SysUser(username));
        SysUserHasSysRoleKey userRoleKey = new SysUserHasSysRoleKey(sysUser.getId());
        List<SysUserHasSysRoleKey> userRoleKeys = userRoleMapper.select(userRoleKey);
        List<Long> roleIds = new ArrayList<Long>();
        for (int i = 0; i < userRoleKeys.size(); i++) {
            roleIds.add(userRoleKeys.get(i).getSysRoleId());
        }

        Example sysRoleExample = new Example(SysRole.class);
        sysRoleExample.or().andIn("id", roleIds);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        return sysRoles;
    }


    /**
     * 根据用户名找到角色名
     *
     * @param username 用户名
     *
     * @return 用户角色名
     */
    @Override
    public Set<String> findRoleNames(String username) {
        List<SysRole> sysRoles = this.findRoles(username);
        Set<String> roleNames = new HashSet<>();
        for (int i = 0; i < sysRoles.size(); i++) {
            roleNames.add(sysRoles.get(i).getRole());
        }
        return roleNames;
    }

    /**
     * 根据用户名找到资源
     *
     * @param username 用户名
     *
     * @return 资源信息
     */
    @Override
    public List<SysResource> findResources(String username) {
        List<SysRole> sysRoles = this.findRoles(username);
        List<Long> roleIds = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            roleIds.add(sysRole.getId());
        }
        List<SysResource> sysResources = new ArrayList<>();
        if(roleIds.size() == 0){
            return sysResources;
        }
        Example roleResourceExample = new Example(SysRoleHasSysResourceKey.class);
        roleResourceExample.or().andIn("sysRoleId", roleIds);
        List<SysRoleHasSysResourceKey> roleResourceKeys = roleResourceMapper.selectByExample(roleResourceExample);

        //一个用户可能会有多个角色,多个角色中可能有重复的资源,使用set过滤重复的资源
        Set<Long> resourceIds = new HashSet<>();
        for (SysRoleHasSysResourceKey roleResourceKey : roleResourceKeys) {
            resourceIds.add(roleResourceKey.getSysResourceId());
        }
        if(resourceIds.size() == 0){
            return sysResources;
        }
        Example sysResourceExample = new Example(SysResource.class);
        sysResourceExample.or().andIn("id", new ArrayList<>(resourceIds));
        sysResources = sysResourceMapper.selectByExample(sysResourceExample);
        return sysResources;
    }

    /**
     * 根据用户名找到资源权限
     *
     * @param username 用户名
     *
     * @return 资源权限
     */
    @Override
    public Set<String> findPermission(String username) {
        List<SysResource> sysResources = this.findResources(username);
        Set<String> permissions = new HashSet<>();
        for (SysResource sysResource : sysResources) {
            permissions.add(sysResource.getPermission());
        }
        return permissions;
    }

    /**
     * 创建用户
     *
     * @param sysUser 用户信息
     *
     * @return 创建操作结果
     */
    @Override
    public Integer createUser(SysUser sysUser) {
        //加密密码
        this.encryptPassword(sysUser,sysUser.getPassword());
        sysUser.setIsDelete(false);
        return super.saveSelective(sysUser);
    }

    /**
     * 更改用户密码
     *
     * @param userId 用户id
     * @param newPassword 新密码
     */
    @Override
    public void updatePassword(Long userId, String newPassword) {
        SysUser sysUser = this.selectOne(new SysUser(userId));

        this.encryptPassword(sysUser,newPassword);

        this.update(sysUser);
    }

    /**
     *
     * @param sysUser
     * @param newPassword
     */
    private void encryptPassword(SysUser sysUser,String newPassword){
        Map<String,String> data =  passwordHelper.encryptPassword(newPassword,sysUser.getUsername());

        sysUser.setSalt(data.get("salt"));
        sysUser.setPassword(data.get("password"));

    }

//    @Override
//    public ServerResponseModel<SysUser> getUserListByOrgId(Long orgId, Integer pageNum, Integer pageSize) {
//        SysOrganizationHasSysUserKey userOrganizationKey = new SysOrganizationHasSysUserKey();
//        userOrganizationKey.setSysOrganizationId(orgId);
//        List<SysOrganizationHasSysUserKey> userOrganizationKeys = userOrganizationMapper.select(userOrganizationKey);
//        List<Long> userIds = new ArrayList<>();
//        for (SysOrganizationHasSysUserKey userOrganizationKey1 : userOrganizationKeys) {
//            userIds.add(userOrganizationKey1.getSysUserId());
//        }
//        if (userIds.size() == 0) {
//            List<SysUser> sysUsers = new ArrayList<>();
//            PageModel pageModel = new PageModel(1, 0L, 1);
//            return new ServerResponseModel<SysUser>(pageModel, sysUsers);
//        } else {
//            Example sysUserExample = new Example(SysUser.class);
//            sysUserExample.or().andIn("id", userIds);
//            return this.selectPageByExampleV2(sysUserExample, pageNum, pageSize);
//        }
//    }

    /**
     *
     * @param orgId 组织编号
     * @param page 页数
     * @param pageSize 每页的数据量
     *
     * @return
     */
    @Override
    public ListResponse<SysUser> findListByOrgId(Long orgId, Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);
        List<SysUser> list = sysUserMapper.findByOrgId(orgId);

        return super.listToResponse(list);
    }

    /**
     *
     * @param user
     *         未修改前的用户信息
     * @param nickName
     *         微信名称
     * @param avatar
     *         微信头像
     *
     * @return
     */

    @Override
    public SysUser updateWeChatInfo(SysUser user, String nickName, String avatar) {

        user.setNickname(nickName);
        user.setAvatar(avatar);
        this.update(user);

        return user;
    }

    /**
     *
     * @param nickName
     *         微信名称
     * @param avatar
     *         微信头像
     * @param openId
     *         openId
     * @param upUser
     *         上级用户
     *
     * @return
     */
    @Override
    public SysUser createUser(String nickName, String avatar, String openId, SysUser upUser) {

        SysUser user = new SysUser();
        user.setNickname(nickName);
        user.setAvatar(avatar);
        user.setCreateTime(new Date());
        user.setIsDelete(false);

        this.save(user);

        return user;
    }

    /**
     *
     * @param id
     *         用户编号
     *
     * @return
     */
    @Override
    public SysUser findById(Long id) {

        return sysUserMapper.findById(id);
    }

    /**
     *
     * @param ids
     *         用户编号列表
     *
     * @return
     */
    @Override
    public List<SysUser> findUser(List<Long> ids) {

        Example example = new Example(SysUser.class);
        example.createCriteria().andIn("id", ids);
        return this.selectPageByExample(example, null, null);
    }

    /**
     *
     * @param sysUser 用户信息
     * @return
     */
    @Override
    public Integer updateUser(SysUser sysUser) {
        SysUser orgSysUser = this.selectByPrimary(new SysUser(sysUser.getId()));
        List<Integer> orgRoleIds = orgSysUser.getRoleList();
        List<Integer> updateRoleIds = sysUser.getRoleList();
        Set<Long> morgRoleIds = new HashSet<>();
        Set<Long> mupdateRoleIds = new HashSet<>();
        Set<Long> totalRoles = new HashSet<>();
        for (Integer orid : orgRoleIds) {
            totalRoles.add(Long.valueOf(orid));
            morgRoleIds.add(Long.valueOf(orid));
        }
        for (Integer urid : updateRoleIds) {
            totalRoles.add(Long.valueOf(urid));
            mupdateRoleIds.add(Long.valueOf(urid));
        }
        Set<Long> addKey = new HashSet<>();
        Set<Long> deleteKey = new HashSet<>();
        if (updateRoleIds.size() != 0) {
            for (Long mroleId : totalRoles) {
                //在原来中含有的角色，但在新修改的角色列表没有，
                if (morgRoleIds.contains(mroleId) && !mupdateRoleIds.contains(mroleId)) {
                    deleteKey.add(Long.valueOf(mroleId));
                    //在原来不包含现在有添加
                } else if (!morgRoleIds.contains(mroleId) && mupdateRoleIds.contains(mroleId)) {
                    addKey.add(Long.valueOf(mroleId));
                }
            }

            for (Long roleId : addKey) {
                SysUserHasSysRoleKey sysUserHasSysRoleKey = new SysUserHasSysRoleKey(sysUser.getId(), roleId);
                sysUserHasSysRoleKeyService.saveSelective(sysUserHasSysRoleKey);
            }

            for (Long roleId : deleteKey) {
                SysUserHasSysRoleKey sysUserHasSysRoleKey = new SysUserHasSysRoleKey(sysUser.getId(), roleId);
                sysUserHasSysRoleKeyService.delete(sysUserHasSysRoleKey);
            }
        }
        return this.updateSelective(sysUser);
    }

    /**
     *
     * @param sysUser 用户
     *
     * @return
     */
    @Override
    public Integer saveUser(SysUser sysUser) {
        this.encryptPassword(sysUser,sysUser.getPassword());
        Integer result = this.saveSelective(sysUser);
        if (sysUser.getRoleList().size() != 0) {
            for (Integer roleId : sysUser.getRoleList()) {
                SysUserHasSysRoleKey sysUserHasSysRoleKey = new SysUserHasSysRoleKey(sysUser.getId(), Long.valueOf
                        (roleId));
                sysUserHasSysRoleKeyService.saveSelective(sysUserHasSysRoleKey);
            }
        }
        return result;
    }
}
