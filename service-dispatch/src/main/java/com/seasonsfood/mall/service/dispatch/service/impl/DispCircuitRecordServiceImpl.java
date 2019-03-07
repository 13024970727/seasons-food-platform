package com.seasonsfood.mall.service.dispatch.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRecord;
import com.seasonsfood.mall.service.dispatch.api.param.SelectOrderByDelivery;
import com.seasonsfood.mall.service.dispatch.api.result.FontUserOrderInfo;
import com.seasonsfood.mall.service.dispatch.api.result.TodayDispCircuitRecordList;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitRecordService;
import com.seasonsfood.mall.service.dispatch.mapper.DispCuitcuitRecordMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.*;
/**
*@author jiangchengwei
*@date: 2019/3/6-17:33
*/
@Component
@Service(interfaceClass = DispCircuitRecordService.class)
public class DispCircuitRecordServiceImpl extends BaseServiceImpl<DispCircuitRecord> implements DispCircuitRecordService {
    @Resource
    DispCuitcuitRecordMapper dispCuitcuitRecordMapper;

    /**
     * @author jiangchengwei
     * @date: 2019/3/6-18:04
     * @methodExplain：查询今日配送线路列表
     * @param pageNum
     * @param pageSize
     * @param time
     * @return：com.seasonsfood.mall.util.model.ListResponse<com.seasonsfood.mall.service.dispatch.api.result.TodayDispCircuitRecordList>
     */
    @Override
    public ListResponse<TodayDispCircuitRecordList> selectTodayDispCircuitRecord(Integer pageNum, Integer pageSize, String time) {

        List<TodayDispCircuitRecordList> todayDispCircuitRecordList = dispCuitcuitRecordMapper.selectTodayDispCircuitRecord(time);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(todayDispCircuitRecordList);
        return new ListResponse(pageInfo);
    }

    /**
     * @author jiangchengwei
     * @date: 2019/3/6-17:55
     * @methodExplain：查询配送员当前位置
     * @param dispatchId 配送员ID
     * @param time 时间
     * @return：java.lang.String
     */
    @Override
    public String selectCircuitLocation(Long dispatchId, String time) {
        Example example = new Example(DispCircuitRecord.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("lngLatCircuit");
        criteria.andEqualTo("dispatchId", dispatchId);
        criteria.andEqualTo("createTime", time);
        List<DispCircuitRecord> dispCircuitRecordListispCircuitRecord = dispCuitcuitRecordMapper.selectByExample(example);
        String lngLatCircuit = null;
        if (dispCircuitRecordListispCircuitRecord.size() == 0) {
            lngLatCircuit = "暂无位置";
        } else {
            String location = dispCircuitRecordListispCircuitRecord.get(0).getLngLatCircuit();//位置坐标
            int one = location.lastIndexOf(";");
            String str = location.substring((one + 1), location.length());
            String[] str1 = str.split(":");
            lngLatCircuit = str1[1];//当前位置
        }
        return lngLatCircuit;
    }
    /**
     * @author jiangchengwei
     * @date: 2019/3/6-18:04
     * @methodExplain：修改当日配送顺序
     * @param dispCircuitRecord
     * @param time
     * @return：com.seasonsfood.mall.util.constant.ResponseCode
     */
    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode updateTodayDispOrderly(List<DispCircuitRecord> dispCircuitRecord, String time) {

        Integer succeed = null;
        for (int i = 0; i < dispCircuitRecord.size(); i++) {
            Long dispatchId = dispCircuitRecord.get(i).getDispatchId();//配送时间
            Integer dispatchOrderly = dispCircuitRecord.get(i).getDispatchOrderly();//配送顺序
            succeed = dispCuitcuitRecordMapper.updateTodayDispOrderly(dispatchId, dispatchOrderly, time);
            if (succeed <= 0) {
                return ResponseCode.DELETE_ERROR;
            }
        }
        return ResponseCode.SUCCESS;
    }

    /**
     * @author jiangchengwei
     * @date: 2019/3/6-18:03
     * @methodExplain：查看配送员今日配送的订单并通过订单离起点的距离排序
     * @param selectOrderByDelivery 配送员id
     * @return：com.seasonsfood.mall.util.model.ListResponse<com.seasonsfood.mall.service.dispatch.api.result.FontUserOrderInfo>
     */
    @Override
    public ListResponse<FontUserOrderInfo> selectOrderByDelivery(SelectOrderByDelivery selectOrderByDelivery) {
        PageHelper.startPage(selectOrderByDelivery.getPageNum(), selectOrderByDelivery.getPageSize());
        List<FontUserOrderInfo> fontUserOrderInfoList = dispCuitcuitRecordMapper.selectOrderByDelivery(selectOrderByDelivery.getDispatchId(), selectOrderByDelivery.getLng(), selectOrderByDelivery.getLat());
        List<FontUserOrderInfo> resultList = new ArrayList<>();
        for (int i = 0; i < fontUserOrderInfoList.size(); i++) {
            FontUserOrderInfo fontUserOrderInfo = new FontUserOrderInfo();
            //查出用户的一些基本信息
            FontUserOrderInfo userOrderInfo = dispCuitcuitRecordMapper.selectFontUserInfo(fontUserOrderInfoList.get(i).getId());
            fontUserOrderInfo.setId(fontUserOrderInfoList.get(i).getId());//用户ID
            fontUserOrderInfo.setOrderId(fontUserOrderInfoList.get(i).getOrderId());//订单id
            fontUserOrderInfo.setUserName(userOrderInfo.getUserName());//用户名字
            fontUserOrderInfo.setDeliveryAddress(fontUserOrderInfoList.get(i).getDeliveryAddress());//收货地址
            fontUserOrderInfo.setPhone(userOrderInfo.getPhone());//手机号码
            resultList.add(fontUserOrderInfo);
        }
        PageInfo pageInfo = new PageInfo(resultList);
        return new ListResponse(pageInfo);
    }
}
