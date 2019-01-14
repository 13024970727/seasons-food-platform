package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.admin.api.domain.CouponManage;
import com.seasonsfood.mall.admin.api.service.CouponManageService;
import com.seasonsfood.mall.admin.mapper.CouponManageMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author zq
 * @date 2018/12/10 20:17
 **/
@Component("couponManageService")
@Service(interfaceClass = CouponManageService.class)
public class CouponManageServiceImpl extends BaseServiceImpl<CouponManage> implements CouponManageService {

    @Resource
    private CouponManageMapper couponManageMapper;

    /**
     * 优惠券列表实现类
     * @param couponName 优惠券名称
     * @param couponType 优惠券类型
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 返回值
     */
    @Override
    public ListResponse getCouponManageList(String couponName, Integer couponType, Integer pageNum, Integer pageSize) {
        Example example = new Example(CouponManage.class);
        Example.Criteria criteria = example.createCriteria();
        if(couponName != null){
            String inputName = "%" + couponName + "%";
            criteria.andLike("couponName",inputName);
        }
        if(couponType != null){
            criteria.andEqualTo("couponType",couponType);

        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<CouponManage> pageInfo = new PageInfo<>(couponManageMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getPageNum(),pageInfo.getList());
    }
}
