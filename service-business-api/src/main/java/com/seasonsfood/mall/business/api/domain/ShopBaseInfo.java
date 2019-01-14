package com.seasonsfood.mall.business.api.domain;

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
@Table(name = "shop_base_info")
public class ShopBaseInfo implements Serializable {
    private static final long serialVersionUID = 7731882838701197900L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 店铺名字
    */
    private String shopName;

    /**
    * 商铺余额
    */
    private BigDecimal account;

    /**
    * 锁定余额
    */
    private BigDecimal lockAccount;

    /**
    * 免抽点
    */
    private BigDecimal freeSample;

    /**
    * 地址
    */
    private String address;

    /**
    * 店铺等级
    */
    private Integer shopLevel;
    /**
     * 店铺分类id
     */
    private Long marketCategoryId;

    /**
    * 状态  1 开业  2 关闭
    */
    private Short dailyStatus;

    /**
    * 短信余额
    */
    private BigDecimal msgAccount;

    /**
    * 店铺状态  1 正常营业 2 不再营业 3 退出平台 4 退押金关店
    */
    private String shopStatus;

    /**
    * 开店时间
    */
    private Date openTime;

    /**
    * 联系电话
    */
    private String phone;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 排序
    */
    private Short sortNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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

    public BigDecimal getFreeSample() {
        return freeSample;
    }

    public void setFreeSample(BigDecimal freeSample) {
        this.freeSample = freeSample;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getShopLevel() {
        return shopLevel;
    }

    public void setShopLevel(Integer shopLevel) {
        this.shopLevel = shopLevel;
    }

    public Long getMarketCategoryId() {
        return marketCategoryId;
    }

    public void setMarketCategoryId(Long marketCategoryId) {
        this.marketCategoryId = marketCategoryId;
    }

    public Short getDailyStatus() {
        return dailyStatus;
    }

    public void setDailyStatus(Short dailyStatus) {
        this.dailyStatus = dailyStatus;
    }

    public BigDecimal getMsgAccount() {
        return msgAccount;
    }

    public void setMsgAccount(BigDecimal msgAccount) {
        this.msgAccount = msgAccount;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Short sortNumber) {
        this.sortNumber = sortNumber;
    }
}