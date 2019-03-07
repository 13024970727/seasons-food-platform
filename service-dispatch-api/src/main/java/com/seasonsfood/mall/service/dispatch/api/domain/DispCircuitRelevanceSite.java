package com.seasonsfood.mall.service.dispatch.api.domain;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 配送主干线路地点
 */
@Table(name="disp_circuit_relevance_site")
public class DispCircuitRelevanceSite implements Serializable {

    @Id
    private Long id;//配送主干线路地点id
    private Long circuitId;//配送主干线路
    private Long siteId;//地点
    private Integer siteOrderly;//地点序号
    private Integer isStart;//是否启用 1是 0否
    private Date createTime;//创建时间

    public DispCircuitRelevanceSite() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(Long circuitId) {
        this.circuitId = circuitId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Integer getSiteOrderly() {
        return siteOrderly;
    }

    public void setSiteOrderly(Integer siteOrderly) {
        this.siteOrderly = siteOrderly;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DispCircuitRelevanceSite{" +
                "id=" + id +
                ", circuitId=" + circuitId +
                ", siteId='" + siteId + '\'' +
                ", siteOrderly=" + siteOrderly +
                ", isStart=" + isStart +
                ", createTime=" + createTime +
                '}';
    }
}
