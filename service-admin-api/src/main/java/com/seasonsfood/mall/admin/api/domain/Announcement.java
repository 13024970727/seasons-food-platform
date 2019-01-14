package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "announcement")
public class Announcement implements Serializable {

    private static final long serialVersionUID = -8178521702784399753L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
    * 标题
    */
    private String title;

    /**
    * 内容
    */
    private String content;

    /**
    *  通知类别 1  平台用户  2 平台商户
    */
    private String announceType;

    /**
    * 通知时间
    */
    private Date annountTime;

    /**
    * 预览图片
    */
    private String reviewPicture;

    /**
    * 排序
    */
    private Short sortNumber;

    /**
    * 创建时间
    */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnnounceType() {
        return announceType;
    }

    public void setAnnounceType(String announceType) {
        this.announceType = announceType;
    }

    public Date getAnnountTime() {
        return annountTime;
    }

    public void setAnnountTime(Date annountTime) {
        this.annountTime = annountTime;
    }

    public String getReviewPicture() {
        return reviewPicture;
    }

    public void setReviewPicture(String reviewPicture) {
        this.reviewPicture = reviewPicture;
    }

    public Short getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Short sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}