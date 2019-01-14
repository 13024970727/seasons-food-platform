package com.seasonsfood.mall.fontuser.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "User_collection")
public class UserCollection implements Serializable {
    private static final long serialVersionUID = 4578049006800409223L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 所收藏的商品ID或者店铺ID
    */
    private Long itemId;

    /**
    *  1 商品 2店铺
    */
    private Short type;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 用户ID
    */
    private Long fontUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getFontUserId() {
        return fontUserId;
    }

    public void setFontUserId(Long fontUserId) {
        this.fontUserId = fontUserId;
    }
}