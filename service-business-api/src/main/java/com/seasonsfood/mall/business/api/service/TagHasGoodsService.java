package com.seasonsfood.mall.business.api.service;


import com.seasonsfood.mall.business.api.domain.Goods;
import com.seasonsfood.mall.business.api.domain.Tag;
import com.seasonsfood.mall.business.api.domain.TagHasGoods;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

/**
 * @Author jcw
 * @Date 2018/12/7 11:17
 */
public interface TagHasGoodsService extends BaseService<TagHasGoods> {
     /**jcw
      * 通过商品id查出商品的标签id
      * @param tagHasGoods
      * @return
      */
     List<TagHasGoods> selectTagId(TagHasGoods tagHasGoods);

     /**
      *   通过标签id查出标签
      * @param tagList
      * @return
      */
     List<Tag> selectGoodsTag(List<TagHasGoods> tagList);

     /**
      * 通过标签ID查出商品ID
      * @param tagHasGoods
      * @return
      */
     List<TagHasGoods> selectGoodsId(TagHasGoods tagHasGoods);
     /**
      *   通过商品id查出商品
      * @param tagHasGoodsList
      * @return
      */
     List<Goods> selectGoods(List<TagHasGoods> tagHasGoodsList);
}