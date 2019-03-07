package com.seasonsfood.mall.business.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.codingapi.tx.annotation.TxTransaction;
import com.seasonsfood.mall.business.api.domain.UserGoodsOrder;
import com.seasonsfood.mall.business.api.service.UserGoodsOrderService;
import com.seasonsfood.mall.business.mapper.GoodsMapper;
import com.seasonsfood.mall.business.mapper.UserGoodsOrderMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import com.seasonsfood.mall.service.dispatch.api.domain.DispSite;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;
import com.seasonsfood.mall.service.dispatch.mapper.DispCircuitMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispCircuitRelevanceSiteMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispCuitcuitRecordMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispSiteMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * @Author zhaozhirong
 * @Date 2018年12月17日11:00:37
 */
@Component("userGoodsOrderService")
@Service(interfaceClass = UserGoodsOrderService.class)
public class UserGoodsOrderServiceImpl extends BaseServiceImpl<UserGoodsOrder> implements UserGoodsOrderService {

  /*// @Resource
  //  UserGoodsOrderMapper userGoodsOrderMapper;
    @Resource
    DispCircuitMapper DispCircuitMapper;
   @Resource
    DispSiteMapper dispSiteMapper;
    @Resource
    DispCircuitRelevanceSiteMapper dispCircuitRelevanceSiteMapper;
    @Resource
    DispCuitcuitRecordMapper dispCuitcuitRecordMapper;
    *//**
     * jcw
     * 区域管理
     * 统计未分配配送员的订单数量
     *
     * @return
     *//*
    @Override
    public int selectNoDeliveryNum() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE, -1);//获取昨天时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(calendar.getTime());
        Date time = null;
        try {
            time = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserGoodsOrder serGoodsOrder = new UserGoodsOrder();
        serGoodsOrder.setDeliveryUserId(Long.valueOf(0));
        serGoodsOrder.setOrderTime(time);
       // int count = userGoodsOrderMapper.selectCount(serGoodsOrder);
        return 1;
    }

    *//**
     * jcw
     * 更换配送员
     *
     * @param userGoodsOrderList 配送员ID , 订单ID
     * @return
     *//*
    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode updateDelivery(List<UserGoodsOrder> userGoodsOrderList) {
    *//*    Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE, -1);//获取昨天时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(calendar.getTime());
        Date time = null;
        try {
            time = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*//*
        for (int i = 0; i < userGoodsOrderList.size(); i++) {
            System.out.println(userGoodsOrderList.get(i).getId());
            List<DispSite> asda =  dispSiteMapper.selectAll();
            System.out.println(asda.get(0).getCreateTime());
            //查找订单小区的经纬度
            //LngAndLat lngAndLat = userGoodsOrderMapper.selectLngAndLat(userGoodsOrderList.get(i).getId());
          //  System.out.println(lngAndLat.getLng()+"   1");
            LngAndLat lngAndLat = dispSiteMapper.selectLngAndLat(userGoodsOrderList.get(i).getId());
            System.out.println(lngAndLat.getLng()+"   2");
            // 通过订单地点找出距离被选配送员所有地点中最近的地点
            Long siteId = dispSiteMapper.findSite(userGoodsOrderList.get(i).getDeliveryUserId(), lngAndLat.getLng(), lngAndLat.getLat());
            //通过这个配送地点找出是配送员的哪条配送线路
            Long dispCircuitId = dispCircuitRelevanceSiteMapper.selcetDispCircuitId(userGoodsOrderList.get(i).getDeliveryUserId(), siteId);
            UserGoodsOrder userGoodsOrder = new UserGoodsOrder();
            userGoodsOrder.setId(userGoodsOrderList.get(i).getId());//订单ID
            userGoodsOrder.setDeliveryUserId(userGoodsOrderList.get(i).getDeliveryUserId());//配送员ID
            userGoodsOrder.setCircuitId(dispCircuitId);//线路ID
          //  int succeed =userGoodsOrderMapper.updateByPrimaryKeySelective(userGoodsOrder);
           // if(succeed <= 0){
               // return ResponseCode.DELETE_ERROR;
           // }
        }
          return ResponseCode.SUCCESS;
    }*/
}