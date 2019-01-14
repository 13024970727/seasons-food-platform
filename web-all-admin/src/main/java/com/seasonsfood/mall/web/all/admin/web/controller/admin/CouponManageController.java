package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.CouponManage;
import com.seasonsfood.mall.admin.api.service.CouponManageService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 优惠券管理
 * @author zq
 * @date 2018/12/10 20:36
 **/
@RestController
@RequestMapping("couponManage")
public class CouponManageController {

    @Reference(check = false)
    private CouponManageService couponManageService;

    /**
     * 获取优惠券列表
     * @param couponName 优惠券名称
     * @param couponType 1、无门槛 2、抵扣通用运费 3、满扣
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 优惠券列表信息
     */
    @GetMapping(value = "list")
    public Object getCouponManageList(String couponName,Integer couponType,Integer pageNum,Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(couponManageService.getCouponManageList(couponName, couponType, pageNum, pageSize));
    }

    /**
     * 添加优惠券
     * @param couponManage 优惠券信息
     * @return 添加操作结果
     */
    @PostMapping(value = "add")
    public Object addCouponManage(CouponManage couponManage){
        try {
            if(couponManage.getCouponName() == null || "".equals(couponManage.getCouponName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"优惠券名称不能为空",true);
            }
            if(couponManage.getMoney() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"抵扣金额不能为空",true);
            }
            if(couponManage.getOverLimit() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"限定金额不能为空",true);
            }
            if(couponManage.getLimitNumber() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"限定数量不能为空",true);
            }
            couponManage.setCreateTime(new Date());
            couponManageService.saveSelective(couponManage);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /**
     * 修改优惠券
     * @param couponManage 优惠券信息
     * @return 修改操作结果
     */
    @PostMapping(value = "update")
    public Object updateCouponManage(CouponManage couponManage){
        try {
            if(couponManage.getId() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"id不能为空",true);
            }
            if(couponManage.getCouponName() == null || "".equals(couponManage.getCouponName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"优惠券名称不能为空",true);
            }
            if(couponManage.getMoney() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"抵扣金额不能为空",true);
            }
            if(couponManage.getOverLimit() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"限定金额不能为空",true);
            }
            if(couponManage.getLimitNumber() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"限定数量不能为空",true);
            }
            couponManageService.updateSelective(couponManage);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    /**
     * 删除优惠券
     * @param id 优惠券id
     * @return 删除操作结果
     */
    @PostMapping(value = "delete")
    public Object deleteCouponManage(Long id){
        try {
            CouponManage couponManage = new CouponManage();
            couponManage.setId(id);
            couponManageService.delete(couponManage);
            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }
    }

    /**
     * 根据id获取优惠券信息
     * @param id 优惠券id
     * @return 优惠券信息
     */
    @GetMapping(value = "info")
    public Object getCouponInfo(Long id){
        if(id == null){
            ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"参数不能为空",true);
        }
        CouponManage couponManage = new CouponManage();
        couponManage.setId(id);
        couponManage = couponManageService.selectByPrimary(couponManage);
        if(couponManage == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NO_RECORD,"不存在记录",true);
        }
        return ResponseUtils.setSuccess(couponManage);
    }

}
