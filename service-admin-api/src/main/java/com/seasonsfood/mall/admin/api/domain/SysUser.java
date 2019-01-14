package com.seasonsfood.mall.admin.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ron
 */
@Table(name = "sys_user")
public class SysUser implements Serializable {


    //-------------------用户类型

    /**
     * 用户类型：普通用户
     */
    @Transient
    public static final Integer TYPE_ORDINARY = 0;

    /**
     * 用户类型：管理人员
     */
    @Transient
    public static final Integer TYPE_ADMIN = 1;

    private static final long serialVersionUID = -2763257053464899486L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String salt;

    private String roleIds;

    private Boolean locked;


    private String phone;

    private String avatar;

    private String nickname;

    /**
     * 所属区域id
     */
    private Long areaId;

    @JsonIgnore
    private Boolean isDelete;

    private Date createTime;

    @Transient
    private String authorization;

    @Transient
    private String sid;


    public SysUser() {
        super();
    }

    public SysUser(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }


    public SysUser(Long id) {
        this.id = id;
    }


    public SysUser(String username) {
        this.username = username;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @JsonIgnore
    public String getCredentialsSalt() {
        return username + salt;
    }

    public List<Integer> getRoleList() {
        List<Integer> roleList = new ArrayList<>();
        if (roleIds != null && !"".equals(roleIds)) {
            String[] roles = roleIds.split(",");
            for (String id : roles) {
                roleList.add(Integer.valueOf(id));
            }
        }
        return roleList;
    }

}