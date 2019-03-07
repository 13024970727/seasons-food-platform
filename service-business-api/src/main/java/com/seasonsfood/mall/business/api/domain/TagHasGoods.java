package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Table;
import java.io.Serializable;

/**jcw
 * 商品标签关系表
 */
@Table(name="tag_has_goods")
public class TagHasGoods implements Serializable {
    /**
     * 标签id
     */
    private Long tagId;
    /**
     * 商品id
     */
    private Long goodsId;
    public TagHasGoods(){
        super();
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "TagHasGoods{" +
                "tagId=" + tagId +
                ", goodsId=" + goodsId +
                '}';
    }
}
