package com.seasonsfood.mall.fontuser.api.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "font_user")
public class FontUser implements Serializable {
    private static final long serialVersionUID = -1262827707600297030L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 电话
    */
    private String phone;

    /**
    * 密码
    */
    private String password;

    /**
    * 支付密码
    */
    private String payPassword;

    /**
    * 盐 加密使用
    */
    private String salt;

    /**
    * 呢称
    */
    private String nickname;

    /**
    * 真实姓名
    */
    private String realName;

    /**
    * 身份证
    */
    private String idCardNumber;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 头像
    */
    private String avatar;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 推荐码
    */
    private String commentCode;

    /**
    * 推荐人ID
    */
    private String recommondUserId;

    /**
    * 是否锁定 默认未锁定
    */
    private Byte isLock;

    /**
    * 用户余额
    */
    private BigDecimal account;

    /**
    * 冻结余额
    */
    private BigDecimal lockAccount;

    /**
    * 积分
    */
    private BigDecimal integral;

    /**
    * 一次性标注
    */
    private String remark;

    /**
    * 用户所属地址
    */
    private Long ownId;

    /**
     * 是否激活
     */
    @Column(name = "is_active")
    private Boolean active;

    /**
    * tcc事物时使用，同步码
    */
    private String code;

    public FontUser(){}

    public FontUser(Long id){ this.id = id; }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }

    public String getRecommondUserId() {
        return recommondUserId;
    }

    public void setRecommondUserId(String recommondUserId) {
        this.recommondUserId = recommondUserId;
    }

    public Byte getIsLock() {
        return isLock;
    }

    public void setIsLock(Byte isLock) {
        this.isLock = isLock;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public BigDecimal getLockAccount() {
        return lockAccount;
    }

    public void setLockAccount(BigDecimal lockAccount) {
        this.lockAccount = lockAccount;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getOwnId() {
        return ownId;
    }

    public void setOwnId(Long ownId) {
        this.ownId = ownId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}