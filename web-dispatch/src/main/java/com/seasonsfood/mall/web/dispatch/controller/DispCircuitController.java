package com.seasonsfood.mall.web.dispatch.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.service.UserGoodsOrderService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import com.seasonsfood.mall.service.dispatch.api.param.*;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitRecordService;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitRelevanceSiteService;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitService;
import com.seasonsfood.mall.service.dispatch.api.service.DispSiteService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.Assert;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@CrossOrigin
@RestController
@RequestMapping("CountDistance")
public class DispCircuitController {
    @Reference(check = false)
    DispCircuitService dispCircuitService;
    @Reference(check = false)
    DispCircuitRecordService dispCircuitRecordService;
    @Reference(check = false)
    DispCircuitRelevanceSiteService dispCircuitRelevanceSiteService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**jcw
     * 创建配送员配送线路
     *
     * @param
     * @return
     */
    @PostMapping("createDistance")
    public JsonResponse createDistance(DispCircuit dispCircuit) {
        Assert.notNull(dispCircuit.getCircuitName(),"线路名称不能为空");
        Assert.notNull(dispCircuit.getDispatchName(),"配送员名称不能为空");
        Assert.notNull(dispCircuit.getCircuitOrderly(),"线路序号不能为空");
        Assert.notNull(dispCircuit.getDispatchOrderly(),"配送序号不能为空");
        if (dispCircuit.getIsDel() == null) {
            dispCircuit.setIsDel(0);
        }

        dispCircuit.setCreateTime(new Date());
        try {
            Integer success = dispCircuitService.save(dispCircuit);
            if (success > 0) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
            }

        } catch (Exception e) {
            logger.error("createDistance:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
        }
    }
    /**jcw
     * 配送线路添加地点
     *
     * @param dispCircuitRelevanceSite
     * @return
     */
    @PostMapping("addDispCircuitRelevanceSite")
    public JsonResponse addDispCircuitRelevanceSite(@RequestBody DispCircuitRelevanceSiteList dispCircuitRelevanceSite)  {
        System.out.println(dispCircuitRelevanceSite);
        if (dispCircuitRelevanceSite.getDispCircuitRelevanceSite() == null & !dispCircuitRelevanceSite.getDispCircuitRelevanceSite().isEmpty()) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "参数不能为空", true);
        }
        try {
            Integer success = dispCircuitRelevanceSiteService.addDispCircuitRelevanceSite(dispCircuitRelevanceSite.getDispCircuitRelevanceSite());
            if (success > 0) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
            }

        } catch (Exception e) {
            logger.error("addDispCircuitRelevanceSite:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
        }
    }
    /**
     * jcw
     * 查询今日配送线路列表
     *
     * @param pageNum
     * @param pageSize
     * @param time     搜索时间
     * @return
     */
    @PostMapping("selectTodayDispCircuitRecord")
    public JsonResponse selectTodayDispCircuitRecord(Integer pageNum, Integer pageSize, String time) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 3;
        }
        if (time == null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            time = df.format(new Date());// new Date()为获取当前系统时间
        }
        return ResponseUtils.setSuccess(dispCircuitRecordService.selectTodayDispCircuitRecord(pageNum, pageSize, time));

    }

    /**
     * jcw
     * 查询永久配送线路列表
     *
     * @param pageNum
     * @param pageSize
     * @param stateId  是否是删除状态，0否，1是
     * @return
     */
    @PostMapping("selectDispCircuitRecord")
    public JsonResponse selectDispCircuitRecord(Integer pageNum, Integer pageSize, Integer stateId) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        if (stateId == null) {
            stateId = 0;
        }
        return ResponseUtils.setSuccess(dispCircuitService.selectDispCircuitRecord(pageNum, pageSize, stateId));

    }

    /**
     * jcw
     * 查询配送员当前位置
     *
     * @param dispatchId 配送员id
     * @return
     */
    @PostMapping("selectCircuitLocation")
    public JsonResponse selectCircuitLocation(Long dispatchId) {
        Assert.notNull(dispatchId,"参数不能为空");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间
        return ResponseUtils.setSuccess(dispCircuitRecordService.selectCircuitLocation(dispatchId, time));
    }

    /**
     * jcw
     * 修改配送员当日配送顺序
     *
     * @param dispCircuitRecord
     * @return
     */
    @PostMapping("updateTodayDispOrderly")
    public JsonResponse updateTodayDispOrderly(@RequestBody DispCircuitRecordList dispCircuitRecord) {
        try {
            if (dispCircuitRecord.getDispCircuitRecord() == null & !dispCircuitRecord.getDispCircuitRecord().isEmpty()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "参数不能为空", true);
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String time = df.format(new Date());// new Date()为获取当前系统时间
            ResponseCode responseCode=dispCircuitRecordService.updateTodayDispOrderly(dispCircuitRecord.getDispCircuitRecord(), time);
            if(!ResponseCode.SUCCESS.equals(responseCode)){
                throw new BizException(responseCode);
            }
            return ResponseUtils.setSuccess(responseCode);
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateTodayDispOrderly:" + e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }
    /**
     * jcw
     * 修改配送员永久配送顺序
     *
     * @param dispCircuit
     * @return
     */
    @PostMapping("updateDispOrderly")
    public JsonResponse updateDispOrderly(@RequestBody DispCircuitList dispCircuit) {
        try {
            if (dispCircuit.getDispCircuit() == null & !dispCircuit.getDispCircuit().isEmpty()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "参数不能为空", true);
            }
            ResponseCode responseCode= dispCircuitService.updateDispOrderly(dispCircuit.getDispCircuit());
            if(!ResponseCode.SUCCESS.equals(responseCode)){
                throw new BizException(responseCode);
            }
            return ResponseUtils.setSuccess(responseCode);
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateDispOrderly:" + e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }
    /**
     * jcw
     * 统计未分配配送员的订单数量
     * @return
     */
    @PostMapping("selectNoDelivery")
    public JsonResponse selectNoDelivery() {
        return ResponseUtils.setSuccess(dispCircuitService.selectNoDeliveryNum());
    }
    /**
     * jcw
     * 选择配送员或者更换配送员
     *
     * @param deliveryUserIdAndOrderIdList
     * @return
     */
    @PostMapping("updateDelivery")
    public JsonResponse updateDelivery(@RequestBody DeliveryUserIdAndOrderIdList deliveryUserIdAndOrderIdList) {
        System.out.println(deliveryUserIdAndOrderIdList);
        try {
            if (deliveryUserIdAndOrderIdList.getDeliveryUserIdAndOrderIdList() == null & !deliveryUserIdAndOrderIdList.getDeliveryUserIdAndOrderIdList().isEmpty()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "参数不能为空", true);
            }
            ResponseCode responseCode=dispCircuitService.updateDelivery(deliveryUserIdAndOrderIdList.getDeliveryUserIdAndOrderIdList());
            if(!ResponseCode.SUCCESS.equals(responseCode)){
                throw new BizException(responseCode);
            }
            return ResponseUtils.setSuccess(responseCode);
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateDelivery:" + e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    /**
     * jcw
     * 查看配送员今日配送的订单并通过订单离起点的距离排序
     * @param selectOrderByDelivery 配送员id，起点经纬度
     * @return
     */
    @PostMapping("seelectOrderByDelivery")
    public JsonResponse seelectOrderByDelivery(SelectOrderByDelivery selectOrderByDelivery) {
        Assert.notNull(selectOrderByDelivery.getDispatchId(),"配送员不能为空");
        Assert.notNull(selectOrderByDelivery.getLng(),"起点经度不能为空");
        Assert.notNull(selectOrderByDelivery.getLat(),"起点纬度不能为空");
      if (selectOrderByDelivery.getPageNum()==null){
          selectOrderByDelivery.setPageNum(1);
      }
      if (selectOrderByDelivery.getPageSize()==null){
          selectOrderByDelivery.setPageSize(3);
      }
        return ResponseUtils.setSuccess( dispCircuitRecordService.selectOrderByDelivery(selectOrderByDelivery));
    }

}
