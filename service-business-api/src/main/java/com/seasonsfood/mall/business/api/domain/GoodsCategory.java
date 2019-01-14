package com.seasonsfood.mall.business.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "goods_category")
public class GoodsCategory implements Serializable {
    /**
     * 第一级类别.
     */
    public static final Integer LEVEL_ONE = 1;
    /**
     * 第二级类别.
     */
    public static final Integer LEVEL_TWO = 2;
    /**
     * 第三级类别
     */
    public static final Integer LEVEL_THREE = 3;
    /**
     * 第四级类别
     */
    public static final Integer LEVEL_FOUR = 4;
    private static final long serialVersionUID = -5513036586789206678L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父亲ID
     */
    private Long parentId;

    /**
     * 祖先id，以‘/’分隔；eg 0/1/2
     */
    private String parentIds;

    /**
     * 类别名字
     */
    private String categoryName;

    /**
     * 主图
     */
    private String pictureUrl;

    /**
     * 商品类别等级
     */
    private Integer level;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 上限重量
     */
    private BigDecimal upLimit;

    /**
     * 下限重量
     */
    private BigDecimal downLimit;
    /**
     * 商品重量系数
     */
    private BigDecimal categoryWeightParams;

    /**
     * 时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(BigDecimal upLimit) {
        this.upLimit = upLimit;
    }

    public BigDecimal getDownLimit() {
        return downLimit;
    }

    public void setDownLimit(BigDecimal downLimit) {
        this.downLimit = downLimit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BigDecimal getCategoryWeightParams() {
        return categoryWeightParams;
    }

    public void setCategoryWeightParams(BigDecimal categoryWeightParams) {
        this.categoryWeightParams = categoryWeightParams;
    }
}