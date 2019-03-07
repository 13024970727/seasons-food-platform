package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.business.api.domain.Tag;
import com.seasonsfood.mall.business.api.domain.TagHasGoods;
import com.seasonsfood.mall.business.api.model.CountGoodsTagInfo;
import com.seasonsfood.mall.business.api.service.TagService;
import com.seasonsfood.mall.business.mapper.TagHasGoodsMapper;
import com.seasonsfood.mall.business.mapper.TagMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * jcw
 */
@Component
@Service(interfaceClass = TagService.class)
public class TagServiceImpl extends BaseServiceImpl<Tag> implements TagService {
    @Resource
    TagMapper tagMapper;
    @Resource
    TagHasGoodsMapper tagHasGoodsMapper;

    /**
     * 查询标签信息
     * @param tag
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ListResponse<Tag> selectTag(Tag tag, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Tag.class);
        Example.Criteria criteria = example.createCriteria();
        if (null != tag.getTagName()) {
            String inputName = "%" + tag.getTagName() + "%";
            criteria.andLike("villageName", inputName);
        }
        if (null != tag.getStateId()) {
            criteria.andEqualTo("stateId", tag.getStateId());
        }

        PageInfo<Tag> pageInfo = new PageInfo<>(tagMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), pageInfo.getList());

    }

    /**
     * 查询标签信息并统计该标签下的商品数量
     * @param tag
     * @param pageNum
     * @param pageSize
     * @return
     */
   public ListResponse<Tag> countGoodsTagInfo (Tag tag, Integer pageNum, Integer pageSize){
       PageHelper.startPage(pageNum, pageSize);
       Example example = new Example(Tag.class);
       Example.Criteria criteria = example.createCriteria();
       if (null != tag.getTagName()) {
           String inputName = "%" + tag.getTagName() + "%";
           criteria.andLike("villageName", inputName);
       }
       if (null != tag.getStateId()) {
           criteria.andEqualTo("stateId", tag.getStateId());
       }
       PageInfo<Tag> pageInfo = new PageInfo<>(tagMapper.selectByExample(example));
       List<CountGoodsTagInfo> countGoodsTagInfoList=new ArrayList<>();
               for(int i=0;i< pageInfo.getList().size();i++) {
                   TagHasGoods tagHasGoods=new TagHasGoods();
                   tagHasGoods.setTagId(pageInfo.getList().get(i).getId());
                   int count=tagHasGoodsMapper.selectCount(tagHasGoods);
                   CountGoodsTagInfo countGoodsTagInfo =new CountGoodsTagInfo();
                   countGoodsTagInfo.setId(pageInfo.getList().get(i).getId());
                   countGoodsTagInfo.setTagName(pageInfo.getList().get(i).getTagName());
                   countGoodsTagInfo.setCountGoodsNumber(count);
                   countGoodsTagInfo.setStateId(pageInfo.getList().get(i).getStateId());
                   countGoodsTagInfoList.add(countGoodsTagInfo);
               }
        return  new ListResponse(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), countGoodsTagInfoList);
   }
}
