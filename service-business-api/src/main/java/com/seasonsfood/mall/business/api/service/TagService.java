package com.seasonsfood.mall.business.api.service;


import com.seasonsfood.mall.business.api.domain.Tag;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

/**
 * @Author jcw
 * @Date 2018/12/7 11:17
 */
public interface TagService extends BaseService<Tag> {
  /**jcw
   * 查找标签
   * @param tag
   * @param pageNum
   * @param pageSize
   * @return
   */
  ListResponse<Tag> selectTag(Tag tag, Integer pageNum, Integer pageSize);

  /**jcw
   * 统计标签信息
   * @param tag
   * @param pageNum
   * @param pageSize
   * @return
   */
  ListResponse<Tag> countGoodsTagInfo(Tag tag, Integer pageNum, Integer pageSize);
}