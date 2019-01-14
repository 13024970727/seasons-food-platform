package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author ron
 */
public class GoodsCommentKey implements Serializable {

    private static final long serialVersionUID = -2342100836998617616L;
    @Id
    private Long id;

    @Id
    private Long goodsId;

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
}