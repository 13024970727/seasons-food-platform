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
@Table(name = "user_view")
public class UserView implements Serializable {
    private static final long serialVersionUID = 211215069521450315L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 看过的商品ID
    */
    private Long goodsId;

    /**
    * 创建时间
    */
    private Date createTime;

    private Long fontUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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