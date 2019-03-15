package com.seasonsfood.mall.service.dispatch.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRecord;
import com.seasonsfood.mall.service.dispatch.api.param.ParamDeliveryOrederInfo;
import com.seasonsfood.mall.service.dispatch.api.param.SelectOrderByDelivery;
import com.seasonsfood.mall.service.dispatch.api.result.DeliveryOrederInfo;
import com.seasonsfood.mall.service.dispatch.api.result.FontUserOrderInfo;
import com.seasonsfood.mall.service.dispatch.api.result.TodayDispCircuitRecordList;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitRecordService;
import com.seasonsfood.mall.service.dispatch.mapper.DispCuitcuitRecordMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;;
import java.util.*;

/**
 * @author jiangchengwei
 * @date: 2019/3/6-17:33
 */
@Component
@Service(interfaceClass = DispCircuitRecordService.class)
public class DispCircuitRecordServiceImpl extends BaseServiceImpl<DispCircuitRecord> implements DispCircuitRecordService {
    @Resource
    DispCuitcuitRecordMapper dispCuitcuitRecordMapper;

    /**
     * @param pageNum
     * @param pageSize
     * @param time
     * @author jiangchengwei
     * @date: 2019/3/6-18:04
     * @methodExplain：查询今日配送线路列表
     * @return：com.seasonsfood.mall.util.model.ListResponse<com.seasonsfood.mall.service.dispatch.api.result.TodayDispCircuitRecordList>
     */
    @Override
    public ListResponse<TodayDispCircuitRecordList> selectTodayDispCircuitRecord(Integer pageNum, Integer pageSize, String time) {
        PageHelper.startPage(pageNum, pageSize);
        List<TodayDispCircuitRecordList> todayDispCircuitRecordList = dispCuitcuitRecordMapper.selectTodayDispCircuitRecord(time);
        PageInfo pageInfo = new PageInfo(todayDispCircuitRecordList);
        return new ListResponse(pageInfo);
    }
    /**
     * @param dispatchId 配送员ID
     * @param time       时间
     * @author jiangchengwei
     * @date: 2019/3/6-17:55
     * @methodExplain：查询配送员当前位置
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
            String[] str = location.split(";");
            String place=str[str.length-1];
            String[] str1 = place.split(":");
            lngLatCircuit = str1[1];//当前位置
        }
        return lngLatCircuit;
    }

    /**
     * @param dispCircuitRecord
     * @param time
     * @author jiangchengwei
     * @date: 2019/3/6-18:04
     * @methodExplain：修改当日配送顺序
     * @return：com.seasonsfood.mall.util.constant.ResponseCode
     */
    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode updateTodayDispOrderly(List<DispCircuitRecord> dispCircuitRecord, String time) {

        Integer succeed ;
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

    @Override
    public int selectNoDeliveryNum() {
        /**
         * @author jiangchengwei
         * @date: 2019/3/11-10:52
         * @methodExplain： 区域管理 统计未分配配送员的订单数量
         * @param
         * @return：int
         */
        long dispatchId = Long.valueOf(0);
        int count = dispCuitcuitRecordMapper.selectNoDeliveryNum(dispatchId);
        return count;
    }

    /**
     * @param selectOrderByDelivery 配送员id
     * @author jiangchengwei
     * @date: 2019/3/6-18:03
     * @methodExplain：查看配送员今日配送的订单并通过订单离起点的距离排序
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

    /**
     * @param paramDeliveryOrederInfo 用户 用户id，配送员，配送状态，分配状态，开始时间，结束时间
     * @author jiangchengwei
     * @date: 2019/3/8-9:55
     * @methodExplain：查看今日配送订单列表
     * @return：com.seasonsfood.mall.util.model.ListResponse<com.seasonsfood.mall.service.dispatch.api.result.DeliveryOrederInfo>
     */
    @Override
    public ListResponse<DeliveryOrederInfo> selectDeliveryOrederInfo(ParamDeliveryOrederInfo paramDeliveryOrederInfo) {
        PageHelper.startPage(paramDeliveryOrederInfo.getPageNum(), paramDeliveryOrederInfo.getPageSize());
        List<DeliveryOrederInfo> deliveryOrederInfoList = dispCuitcuitRecordMapper.selectDeliveryOrederInfo(paramDeliveryOrederInfo);
        for (int i = 0; i < deliveryOrederInfoList.size(); i++) {
            //查出用户的一些基本信息
            FontUserOrderInfo userOrderInfo = dispCuitcuitRecordMapper.selectFontUserInfo(deliveryOrederInfoList.get(i).getId());
            String dispatchName = dispCuitcuitRecordMapper.selectdispatchName(deliveryOrederInfoList.get(i).getDeliveryUserId());
            deliveryOrederInfoList.get(i).setUserName(userOrderInfo.getUserName());//用户名
            deliveryOrederInfoList.get(i).setRealName(userOrderInfo.getRealName());//用户真实姓名
            deliveryOrederInfoList.get(i).setDispatchName(dispatchName);//配送员名字
            if (deliveryOrederInfoList.get(i).getStatus() == 1) {
                deliveryOrederInfoList.get(i).setState("代付款");
            }
            if (deliveryOrederInfoList.get(i).getStatus() == 2) {
                deliveryOrederInfoList.get(i).setState("备货中");
            }
            if (deliveryOrederInfoList.get(i).getStatus() == 3) {
                deliveryOrederInfoList.get(i).setState("待配送");
            }
            if (deliveryOrederInfoList.get(i).getStatus() == 4) {
                deliveryOrederInfoList.get(i).setState("待收货");
            }
            if (deliveryOrederInfoList.get(i).getStatus() == 5) {
                deliveryOrederInfoList.get(i).setState("待评价");
            }
        }
        PageInfo pageInfo = new PageInfo(deliveryOrederInfoList);
        return new ListResponse(pageInfo);
    }
}
