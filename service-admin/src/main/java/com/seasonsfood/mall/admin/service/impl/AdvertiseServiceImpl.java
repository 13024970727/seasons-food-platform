package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.admin.api.domain.Advertise;
import com.seasonsfood.mall.admin.api.service.AdvertiseService;
import com.seasonsfood.mall.admin.mapper.AdvertiseMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * 广告管理实现类
 * @author zq
 * @date 2018/12/10 14:19
 **/
@Component("advertiseService")
@Service(interfaceClass = AdvertiseService.class)
public class AdvertiseServiceImpl extends BaseServiceImpl<Advertise> implements AdvertiseService {

    @Resource
    AdvertiseMapper advertiseMapper;

    /**
     * 获得广告列表实现类
     * @param name 名称
     * @param advertisePositionId id
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 返回值
     */
    @Override
    public ListResponse getAdvertiseList(String name, Long advertisePositionId, Integer pageNum, Integer pageSize) {
        Example example = new Example(Advertise.class);
        Example.Criteria criteria = example.createCriteria();
        if(null != name){
            String inputName = "%" + name + "%";
            criteria.andLike("adName",inputName);
        }
        if(null != advertisePositionId){
            criteria.andEqualTo("advertisePositionId",advertisePositionId);
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Advertise> pageInfo = new PageInfo<>(advertiseMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getPageNum(),pageInfo.getList());
    }
}
