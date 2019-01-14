package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.admin.api.domain.Announcement;
import com.seasonsfood.mall.admin.api.service.AnnouncementService;
import com.seasonsfood.mall.admin.mapper.AnnouncementMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author zq
 */

@Component("announcementService")
@Service(interfaceClass = AnnouncementService.class)
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement> implements AnnouncementService {

    @Resource
    private AnnouncementMapper announcementMapper;

    /**
     *
     * @param announceType 公告类型
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return
     */
    @Override
    public ListResponse getAnnouncementList(String announceType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Announcement.class);
        if(announceType != null){
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("announceType",announceType);
        }
        example.setOrderByClause("sort_number asc");
        PageInfo<Announcement> pageInfo = new PageInfo<>(announcementMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getPageNum(),pageInfo.getList());
    }
}
