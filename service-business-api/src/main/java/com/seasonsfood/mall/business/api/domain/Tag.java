package com.seasonsfood.mall.business.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**jcw
 * 标签表
 */
@Table(name="tag")
public class Tag implements Serializable {
    /**
     * 标签id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    /**
     * 标签名称
     */
    private  String tagName;
    /**
     * 标签状态
     */
    private  Integer stateId;
    public Tag() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", stateId=" + stateId +
                '}';
    }
}
