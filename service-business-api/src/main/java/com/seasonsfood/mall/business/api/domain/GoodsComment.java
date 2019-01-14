package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "goods_comment")
public class GoodsComment extends GoodsCommentKey  implements Serializable {
    private static final long serialVersionUID = -7221117770221515131L;
    /**
    * 评价
    */
    private String comment;

    /**
    * 星级
    */
    private Short grade;

    /**
    * 评价用户ID
    */
    private Long userId;

    /**
    * 是否显示
    */
    private Boolean isShow;

    /**
    * 评价用户ID
    */
    private Date createTime;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}