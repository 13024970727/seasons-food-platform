package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.Goods;
import com.seasonsfood.mall.business.api.domain.Tag;
import com.seasonsfood.mall.business.api.domain.TagHasGoods;
import com.seasonsfood.mall.business.api.service.TagHasGoodsService;
import com.seasonsfood.mall.business.mapper.GoodsMapper;
import com.seasonsfood.mall.business.mapper.TagHasGoodsMapper;
import com.seasonsfood.mall.business.mapper.TagMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * jcw
 */
@Component
@Service(interfaceClass = TagHasGoodsService.class)
public class TagHasGoodsServiceImpl extends BaseServiceImpl<TagHasGoods> implements TagHasGoodsService {
     @Resource
     TagMapper tagMapper;
     @Resource
     TagHasGoodsMapper tagHasGoodsMapper;
     @Resource
     GoodsMapper goodsMapper;
     /**
      * 通过商品id查出商品的标签id
      * @param tagHasGoods
      * @return
      */
     @Override
     public  List<TagHasGoods> selectTagId(TagHasGoods tagHasGoods){
          List<TagHasGoods> tagIdList =tagHasGoodsMapper.select(tagHasGoods);
          return tagIdList;
     }

     /**
      * 通过标签id查出标签
      * @param tagListl
      * @return
      */
     @Override
     public   List<Tag> selectGoodsTag(List<TagHasGoods> tagListl){
          Long tagId;
          Tag tag=new Tag();
          List<Tag> list=new ArrayList<>();
          for(int j=0;j<tagListl.size();j++){
               tagId=tagListl.get(j).getTagId();
               tag.setId(tagId);
               System.out.println(tag);
               List<Tag> tagList =tagMapper.select(tag);
               for (int i=0;i<tagList.size();i++){
                    Tag tagg=tagList.get(i);
                    System.out.println(tagg);
                    list.add(tagList.get(i));
               }
          }
          return list;
     }
     /**
      * 通过标签id查出商品的商品id
      * @param tagHasGoods
      * @return
      */
     @Override
     public  List<TagHasGoods> selectGoodsId(TagHasGoods tagHasGoods){
          List<TagHasGoods> goodsIdList =tagHasGoodsMapper.select(tagHasGoods);
          return goodsIdList;
     }
     /**
      * 通过商品id查出商品
      * @param tagHasGoodsList
      * @return
      */
     @Override
     public  List<Goods> selectGoods(List<TagHasGoods> tagHasGoodsList){
          Long goodsId;

          List<Goods> list=new ArrayList<>();
          for(int j=0;j<tagHasGoodsList.size();j++){
               goodsId=tagHasGoodsList.get(j).getGoodsId();
               Goods goodss =goodsMapper.selectGoodsName(goodsId);
               list.add(goodss);
          }
          return list;
     }

}