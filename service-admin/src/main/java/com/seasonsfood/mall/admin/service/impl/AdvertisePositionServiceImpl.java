package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.admin.api.domain.AdvertisePosition;
import com.seasonsfood.mall.admin.api.service.AdvertisePositionService;
import com.seasonsfood.mall.admin.mapper.AdvertisePositionMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * 广告位置管理实现类
 * @author zq
 * @date 2018/12/10 17:38
 **/
@Component("advertisePositionService")
@Service(interfaceClass = AdvertisePositionService.class)
public class AdvertisePositionServiceImpl extends BaseServiceImpl<AdvertisePosition> implements AdvertisePositionService {

    @Resource
    private AdvertisePositionMapper advertisePositionMapper;

    /**
     * 广告位置列表
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return 返回值
     */
    @Override
    public ListResponse getAdvertisePositionList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(AdvertisePosition.class);
        Example.Criteria criteria = example.createCriteria();
        PageInfo<AdvertisePosition> pageInfo = new PageInfo<>(advertisePositionMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getPageNum(),pageInfo.getList());
    }
}
