package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "deviant_statu")
public class DeviantStatu implements Serializable {

    private static final long serialVersionUID = -3318642727284854557L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 异常名称
    */
    private String divantName;

    /**
    * 是否平台责任
    */
    private Byte isPlatformDuty;

    /**
    * 是否用户责任
    */
    private Byte isUserDuty;

    /**
    * 是否快递责任
    */
    private Byte isDeliveryDuty;

    /**
    * 是否商家责任
    */
    private Byte isShopDuty;

    /**
    * 描述
    */
    private String remark;

    /**
    * 用户看到的异常信息
    */
    private String userView;

    /**
    * 创建时间
    */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDivantName() {
        return divantName;
    }

    public void setDivantName(String divantName) {
        this.divantName = divantName;
    }

    public Byte getIsPlatformDuty() {
        return isPlatformDuty;
    }

    public void setIsPlatformDuty(Byte isPlatformDuty) {
        this.isPlatformDuty = isPlatformDuty;
    }

    public Byte getIsUserDuty() {
        return isUserDuty;
    }

    public void setIsUserDuty(Byte isUserDuty) {
        this.isUserDuty = isUserDuty;
    }

    public Byte getIsDeliveryDuty() {
        return isDeliveryDuty;
    }

    public void setIsDeliveryDuty(Byte isDeliveryDuty) {
        this.isDeliveryDuty = isDeliveryDuty;
    }

    public Byte getIsShopDuty() {
        return isShopDuty;
    }

    public void setIsShopDuty(Byte isShopDuty) {
        this.isShopDuty = isShopDuty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserView() {
        return userView;
    }

    public void setUserView(String userView) {
        this.userView = userView;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}