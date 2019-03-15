package com.seasonsfood.mall.service.dispatch.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.business.api.domain.UserGoodsOrder;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import com.seasonsfood.mall.service.dispatch.api.param.DeliveryUserIdAndOrderId;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitService;
import com.seasonsfood.mall.service.dispatch.mapper.DispCircuitMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispCircuitRelevanceSiteMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispCuitcuitRecordMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispSiteMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
@Service(interfaceClass = DispCircuitService.class)
public class DispCircuitServiceImpl extends BaseServiceImpl<DispCircuit> implements DispCircuitService {
    @Resource
    DispCircuitMapper dispCircuitMapper;
    @Resource
    DispSiteMapper dispSiteMapper;
    @Resource
    DispCircuitRelevanceSiteMapper dispCircuitRelevanceSiteMapper;

    /**
     * @param pageNum
     * @param pageSize
     * @param stateId  是否是删除状态，0否，1是
     * @author jiangchengwei
     * @date: 2019/3/11-10:53
     * @methodExplain： 查看永久配送线路列表
     * @param pageNum
     * @param pageSize
     * @param stateId 是否是删除状态，0否，1是
     * @return：com.seasonsfood.mall.util.model.ListResponse<com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit>
     */
    @Override
    public ListResponse<DispCircuit> selectDispCircuitRecord(Integer pageNum, Integer pageSize, Integer stateId) {
        PageHelper.startPage(pageNum, pageSize);
        List<DispCircuit> dispCircuitList = dispCircuitMapper.selectDispCircuit(pageNum, pageSize, stateId);
        PageInfo pageInfo = new PageInfo(dispCircuitList);
        return new ListResponse(pageInfo);
    }

    /**
     * @param dispCircuit 配送线路实体
     * @author jiangchengwei
     * @date: 2019/3/11-10:53
     * @methodExplain：修改永久线路序
     * @return：com.seasonsfood.mall.util.constant.ResponseCode
     */
    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode updateCircuitOrderly(List<DispCircuit> dispCircuit) {

        int succeed = 0;
        for (int i = 0; i < dispCircuit.size(); i++) {
            Long circuitId = dispCircuit.get(i).getId();//线路ID
            Integer circuitOrderly = dispCircuit.get(i).getCircuitOrderly();
            succeed = dispCircuitMapper.updateCircuitOrderly(circuitId, circuitOrderly);
            if (succeed <= 0) {
                return ResponseCode.DELETE_ERROR;
            }
        }
        return ResponseCode.SUCCESS;
    }

    /**
     * @param dispCircuit 配送线路实体
     * @author jiangchengwei
     * @date: 2019/3/11-10:53
     * @methodExplain：修改当日配送顺序
     * @param dispCircuit 配送线路实体
     * @return：com.seasonsfood.mall.util.constant.ResponseCode
     */
    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode updateDispOrderly(List<DispCircuit> dispCircuit) {

        int succeed = 0;
        for (int i = 0; i < dispCircuit.size(); i++) {
            Long dispatchId = dispCircuit.get(i).getDispatchId();//配送员ID
            Integer dispatchOrderly = dispCircuit.get(i).getDispatchOrderly();
            succeed = dispCircuitMapper.updateDispOrderly(dispatchId, dispatchOrderly);
            if (succeed <= 0) {
                return ResponseCode.DELETE_ERROR;
            }
        }
        return ResponseCode.SUCCESS;
    }

    /**
     * @param deliveryUserIdAndOrderId 配送员ID , 订单ID
     * @author jiangchengwei
     * @date: 2019/3/11-10:52
     * @methodExplain：  更换配送员或者选择配送员（无配送员的订单）
     * @param deliveryUserIdAndOrderId 配送员ID , 订单ID
     * @return：com.seasonsfood.mall.util.constant.ResponseCode
     */
    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode updateDelivery(List<DeliveryUserIdAndOrderId> deliveryUserIdAndOrderId) {

        for (int i = 0; i < deliveryUserIdAndOrderId.size(); i++) {
            //查找订单小区的经纬度
            LngAndLat lngAndLat = dispSiteMapper.selectLngAndLat(deliveryUserIdAndOrderId.get(i).getOrderId());
            // 通过订单地点找出距离被选配送员所有地点中最近的地点
            Long siteId = dispSiteMapper.findSite(deliveryUserIdAndOrderId.get(i).getDeliveryUserId(), lngAndLat.getLng(), lngAndLat.getLat());
            //通过这个配送地点找出是配送员的哪条配送线路
            Long dispCircuitId = dispCircuitRelevanceSiteMapper.selcetDispCircuitId(deliveryUserIdAndOrderId.get(i).getDeliveryUserId(), siteId);
            UserGoodsOrder userGoodsOrder = new UserGoodsOrder();
            userGoodsOrder.setId(deliveryUserIdAndOrderId.get(i).getOrderId());//订单ID
            userGoodsOrder.setDeliveryUserId(deliveryUserIdAndOrderId.get(i).getDeliveryUserId());//配送员ID
            userGoodsOrder.setCircuitId(dispCircuitId);//线路ID
            int succeed = dispCircuitMapper.updateDelivery(deliveryUserIdAndOrderId.get(i).getOrderId(), deliveryUserIdAndOrderId.get(i).getDeliveryUserId(), dispCircuitId);
            if (succeed <= 0) {
                return ResponseCode.DELETE_ERROR;
            }
        }
        return ResponseCode.SUCCESS;
    }

    /**
     * @param
     * @author jiangchengwei
     * @date: 2019/3/14-10:28
     * @methodExplain： 统计启用的线路数量
     * @return： java.lang.Integer
     */
    @Override
    public Integer countCircuitNum() {
        Integer count=dispCircuitMapper.countCircuitNum();
        return count;
    }

}
