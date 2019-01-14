package com.seasonsfood.mall.fontuser.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "integral_change_record")
public class IntegralChangeRecord implements Serializable {

    private static final long serialVersionUID = 1333542347109072118L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 变动积分
    */
    private BigDecimal integralNumber;

    /**
    * 变动类型   11 邀请赠送  12 新注册赠送 13消费
    */
    private Short changeType;

    /**
    * 描述
    */
    private String remark;

    /**
    * 同步码 tcc用
    */
    private String code;

    /**
    * 用户ID
    */
    private Long fontUserId;

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

    public BigDecimal getIntegralNumber() {
        return integralNumber;
    }

    public void setIntegralNumber(BigDecimal integralNumber) {
        this.integralNumber = integralNumber;
    }

    public Short getChangeType() {
        return changeType;
    }

    public void setChangeType(Short changeType) {
        this.changeType = changeType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getFontUserId() {
        return fontUserId;
    }

    public void setFontUserId(Long fontUserId) {
        this.fontUserId = fontUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}