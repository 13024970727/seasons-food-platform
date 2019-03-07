package com.seasonsfood.mall.business.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.business.api.domain.Goods;

import com.seasonsfood.mall.business.api.domain.GoodsStockOutRecord;
import com.seasonsfood.mall.business.api.result.GoodsStockOutRecordResult;
import com.seasonsfood.mall.business.api.service.GoodsStockOutRecordService;
import com.seasonsfood.mall.business.mapper.GoodsCheckRecordMapper;
import com.seasonsfood.mall.business.mapper.GoodsStockOutRecordMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@Service(interfaceClass = GoodsStockOutRecordService.class)
public class GoodsStockOutRecordServiceImpl extends BaseServiceImpl<GoodsStockOutRecord> implements GoodsStockOutRecordService {

    @Resource
    GoodsCheckRecordMapper goodsCheckRecordMapper;
    @Resource
    GoodsStockOutRecordMapper goodsStockOutRecordMapper;

    @Override
    public ListResponse<GoodsStockOutRecord> selecGoodsStockOutRecord(String type, Integer pageNum, Integer pageSize, String timeA, String timeB,String sysUserName) {
        PageInfo<GoodsStockOutRecord> pageInfo;
        PageHelper.startPage(pageNum, pageSize);
        Date dateA = null;
        Date dateB = null;
        Example example = new Example(GoodsStockOutRecord.class);
        Example.Criteria criteria = example.createCriteria();
        if (type != null) {
            criteria.andEqualTo("type", type);
        }
        try {


            if (timeA != null & timeB != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateA = sdf.parse(timeA);
                dateB = sdf.parse(timeB);
                criteria.andBetween("writeTime", dateA, dateB);
            }
            if (timeA != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateA = sdf.parse(timeA);
                criteria.andGreaterThan("writeTime", dateA);
            }
            if (timeB != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateB = sdf.parse(timeB);
                criteria.andLessThan("writeTime", dateB);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (sysUserName!= null){
            Long executorId = goodsCheckRecordMapper.findSysUserId(sysUserName);

            criteria.andEqualTo("executorId",executorId);
        }
        pageInfo = new PageInfo<>(goodsStockOutRecordMapper.selectByExample(example));
        List<GoodsStockOutRecordResult> goodsStockOutRecordResultList = new ArrayList<>();
        for (int j = 0; j < pageInfo.getList().size(); j++) {
            GoodsStockOutRecordResult goodsStockOutRecordResult = new GoodsStockOutRecordResult();
            String executorName = goodsCheckRecordMapper.findSysUserName(pageInfo.getList().get(j).getExecutorId());
            goodsStockOutRecordResult.setId(pageInfo.getList().get(j).getId());
            Date date = pageInfo.getList().get(j).getWriteTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            String writeTime = dateFormat.format(date); //当前时间
            goodsStockOutRecordResult.setWriteTime(writeTime);
            String typeName = null;
            if (pageInfo.getList().get(j).getType() == 1) {
                typeName = "入库";
            }
            if (pageInfo.getList().get(j).getType() == 2) {
                typeName = "售出";
            }
            if (pageInfo.getList().get(j).getType() == 3) {
                typeName = "破损";
            }
            if (pageInfo.getList().get(j).getType() == 4) {
                typeName = "退还";
            }
            goodsStockOutRecordResult.setType(typeName);
            goodsStockOutRecordResult.setNumber(pageInfo.getList().get(j).getNumber());
            goodsStockOutRecordResult.setExecutorName(executorName);
            goodsStockOutRecordResult.setRemark(pageInfo.getList().get(j).getRemark());
            goodsStockOutRecordResultList.add(goodsStockOutRecordResult);
        }
        return new ListResponse(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), goodsStockOutRecordResultList);
    }

    /**
     * 查找记录类型
     * @return
     */
    @Override
    public  List<GoodsStockOutRecordResult> selecGoodsStockOutRecordType() {
        List<GoodsStockOutRecordResult> typeNameList =new ArrayList<>();
        String typeName = null;
        for (int j = 1; j < 5; j++) {
            if (j == 1) {
                typeName = "入库";
            }
            if (j == 2) {
                typeName = "售出";
            }
            if (j == 3) {
                typeName = "破损";
            }
            if (j == 4) {
                typeName = "退还";
            }
            GoodsStockOutRecordResult goodsStockOutRecordResult = new GoodsStockOutRecordResult();
            goodsStockOutRecordResult.setType(typeName);
            goodsStockOutRecordResult.setTypeNum((byte) j);
            typeNameList.add(goodsStockOutRecordResult);
        }
        return typeNameList;
    }
}
