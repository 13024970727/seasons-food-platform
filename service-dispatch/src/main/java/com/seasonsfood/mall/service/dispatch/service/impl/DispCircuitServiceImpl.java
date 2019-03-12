package com.seasonsfood.mall.service.dispatch.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.codingapi.tx.annotation.TxTransaction;
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
     * @author jiangchengwei
     * @date: 2019/3/11-10:53
     * @methodExplain： 查看永久配送线路列表
     * @param pageNum
     * @param pageSize
     * @param stateId 是否是删除状态，0否，1是
     * @return：com.seasonsfood.mall.util.model.ListResponse<com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit>
     */
    @Override
    public ListResponse<DispCircuit> selectDispCircuitRecord(Integer pageNum, Integer pageSize,Integer stateId) {

        List<DispCircuit> dispCircuitList = dispCircuitMapper.selectDispCircuit(pageNum,pageSize,stateId);
        int count = dispCircuitMapper.countDispCircuit(stateId);
        int pageAll = 0;//总页数
        if (count % pageSize != 0) {
            pageAll = (count / pageSize) + 1;
        } else {
            pageAll = (count / pageSize);
        }
        return new ListResponse(count, pageAll, pageNum, dispCircuitList);
    }
    /**
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

     int succeed=0 ;
        for (int i = 0; i < dispCircuit.size(); i++) {
            Long dispatchId = dispCircuit.get(i).getDispatchId();//配送员ID
            Integer dispatchOrderly = dispCircuit.get(i).getDispatchOrderly();
            succeed= dispCircuitMapper.updateDispOrderly(dispatchId,dispatchOrderly);
            if(succeed <= 0){
                return ResponseCode.DELETE_ERROR;
            }
        }
        return ResponseCode.SUCCESS;
    }

    /**
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
             int succeed =dispCircuitMapper.updateDelivery(deliveryUserIdAndOrderId.get(i).getOrderId(),deliveryUserIdAndOrderId.get(i).getDeliveryUserId(),dispCircuitId);
            if(succeed <= 0){
             return ResponseCode.DELETE_ERROR;
            }
        }
        return ResponseCode.SUCCESS;
    }




























    /*@Override
    public Boolean CreateDispCircuit(DispCircuit dispCircuit) throws ServiceException {
        //BigDecimal ecimal=117.028498;
        Double originLng=117.028498;
        Double originLat=25.081877;
        Double destinationLng=117.043563;
        Double destinationlat=25.073646;

        Double originLng1=117.043563;
        Double originLat1=25.073646;
        Double destinationLng1=117.04456;
        Double destinationlat1=25.071175;

        Double originLng2=117.04456;
        Double originLat2=25.071175;
        Double destinationLng2=117.049923;
        Double destinationlat2=25.070807;

        Double originLng3=117.049923;
        Double originLat3=25.070807;
        Double destinationLng3=117.054289;
        Double destinationlat3=25.071814;

        DispCircuitRes  dispCircuitRes = new DispCircuitRes();
        DispCircuitRes  dispCircuitRes1 = new DispCircuitRes();
        DispCircuitRes  dispCircuitRes2 = new DispCircuitRes();
        DispCircuitRes  dispCircuitRes3 = new DispCircuitRes();

        dispCircuitRes.setOriginLat(originLat);
        dispCircuitRes.setOriginLng(originLng);
        dispCircuitRes.setDestinationlat(destinationlat);
        dispCircuitRes.setDestinationLng(destinationLng);

        dispCircuitRes1.setOriginLat(originLat1);
        dispCircuitRes1.setOriginLng(originLng1);
        dispCircuitRes1.setDestinationlat(destinationlat1);
        dispCircuitRes1.setDestinationLng(destinationLng1);

        dispCircuitRes2.setOriginLat(originLat2);
        dispCircuitRes2.setOriginLng(originLng2);
        dispCircuitRes2.setDestinationlat(destinationlat2);
        dispCircuitRes2.setDestinationLng(destinationLng2);

        dispCircuitRes3.setOriginLat(originLat3);
        dispCircuitRes3.setOriginLng(originLng3);
        dispCircuitRes3.setDestinationlat(destinationlat3);
        dispCircuitRes3.setDestinationLng(destinationLng3);

        List<DispCircuitRes> dispCircuitResList=new ArrayList<>();
        dispCircuitResList.add(dispCircuitRes);
        dispCircuitResList.add(dispCircuitRes1);
        dispCircuitResList.add(dispCircuitRes2);
        dispCircuitResList.add(dispCircuitRes3);
        BigDecimal countDistance= BigDecimal.valueOf(0);
      for (int i=0; i<dispCircuitResList.size()-1;i++){
          DispCircuitRes dispCircuitRes4=dispCircuitResList.get(i);
          DispCircuitRes dispCircuitRes5=dispCircuitResList.get(i+1);
          String distance=CountDistance.getDistance(dispCircuitRes4.getOriginLng(),dispCircuitRes4.getOriginLat(),dispCircuitRes5.getOriginLng(),dispCircuitRes5.getOriginLat());
          BigDecimal bd = new BigDecimal(distance);
         System.out.println(bd+"er");
          countDistance = countDistance.add(bd);
      }
    System.out.println(countDistance);
        return null;
    }*/

}
