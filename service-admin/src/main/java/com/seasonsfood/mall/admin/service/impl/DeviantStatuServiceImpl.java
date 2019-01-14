package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.admin.api.domain.DeviantStatu;
import com.seasonsfood.mall.admin.api.service.DeviantStatuService;
import com.seasonsfood.mall.admin.mapper.DeviantStatuMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author zq
 * @date 2018/12/11 14:41
 **/
@Component("deviantStatuService")
@Service(interfaceClass = DeviantStatuService.class)
public class DeviantStatuServiceImpl extends BaseServiceImpl<DeviantStatu> implements DeviantStatuService {

    @Resource
    DeviantStatuMapper deviantStatuMapper;

    /**
     * 异常列表实现类
     * @param name 名称
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 返回值
     */
    @Override
    public ListResponse<DeviantStatu> getDeviantStatuList(String name, Integer pageNum, Integer pageSize) {
        Example example = new Example(DeviantStatu.class);
        Example.Criteria criteria = example.createCriteria();
        if(null != name){
            String inputName = "%" + name + "%";
            criteria.andLike("divantName",inputName);
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<DeviantStatu> pageInfo = new PageInfo<>(deviantStatuMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getPageNum(),pageInfo.getList());
    }

}
