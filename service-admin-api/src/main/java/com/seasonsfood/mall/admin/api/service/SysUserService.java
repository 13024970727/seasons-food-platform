package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.SysResource;
import com.seasonsfood.mall.admin.api.domain.SysRole;
import com.seasonsfood.mall.admin.api.domain.SysUser;
import com.seasonsfood.mall.admin.api.model.UserRequest;
import com.seasonsfood.mall.util.model.ListResponse;
import com.seasonsfood.mall.core.service.BaseService;

import java.util.List;
import java.util.Set;


/**
 * @author ron
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 通过用户名查找用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    SysUser findByName(String userName);

    /**
     * 通过条件查找用户信息
     *
     * @param request 请求作用域
     *
     * @return 用户信息
     */
    ListResponse<SysUser> findByCondition(UserRequest request);



    /**
     * 修改用户的微信信息
     *
     * @param user
     *         未修改前的用户信息
     * @param nickName
     *         微信名称
     * @param avatar
     *         微信头像
     *
     * @return 用户信息
     */
    SysUser updateWeChatInfo(SysUser user, String nickName, String avatar);

    /**
     * 创建微信用户
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
     * @return 用户信息
     */
    SysUser createUser(String nickName, String avatar, String openId, SysUser upUser);

    /**
     * 通过编号查找用户
     *
     * @param id
     *         用户编号
     *
     * @return 用户信息
     */
    SysUser findById(Long id);

    //------------------------------------------------------------------------

    /**
     * 根据用户名找到角色
     *
     * @param username 用户名
     *
     * @return 角色信息
     */
     List<SysRole> findRoles(String username);


    /**
     * 根据用户名找到角色名
     *
     * @param username 用户名
     *
     * @return 角色名
     */
    Set<String> findRoleNames(String username);

    /**
     * 根据用户名找到资源
     *
     * @param username 用户名
     *
     * @return 资源
     */
    List<SysResource> findResources(String username);

    /**
     * 根据用户名找到资源权限
     *
     * @param username 用户名
     *
     * @return 资源权限
     */
    Set<String> findPermission(String username);

    /**
     * 创建用户
     *
     * @param sysUser
     *         对象{@link SysUser}
     *
     * @return 创建操作结果
     */
    Integer createUser(SysUser sysUser);

    /**
     * 更改用户密码
     *
     * @param userId 用户id
     * @param newPassword 新密码
     */
    void updatePassword(Long userId, String newPassword);

    /**
     * 更具组织获取用户列表
     *
     * @param orgId 组织id
     * @param pageNum 页码
     * @param pageSize 页面大小
     *
     * @return 用户列表
     */
//    public ServerResponseModel<SysUser> getUserListByOrgId(Long orgId, Integer pageNum, Integer pageSize);


    /**
     * 根据组织获取用户列表
     *
     * @param orgId 组织编号
     * @param page 页数
     * @param pageSize 每页的数据量
     *
     * @return 用户列表
     */
    ListResponse<SysUser> findListByOrgId(Long orgId, Integer page, Integer pageSize);


    /**
     * 查找所有的用户
     *
     * @param ids
     *         用户编号列表
     *
     * @return 用户集合
     */
    List<SysUser> findUser(List<Long> ids);

    /**
     * 修改用户
     * @param sysUser 用户信息
     * @return 修改条数
     */
    Integer updateUser(SysUser sysUser);

    /**
     * 修改
     *
     * @param sysUser 用户
     *
     * @return 成功条数
     */
    Integer saveUser(SysUser sysUser);

}
