package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.Advertise;
import com.seasonsfood.mall.admin.api.service.AdvertiseService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 广告管理
 * @author zq
 * @date 2018/12/10 14:22
 **/
@RestController
@RequestMapping("advertise")
public class AdvertiseController {

    @Reference(check = false)
    private AdvertiseService advertiseService;

    /**
     * 添加广告
     * @param advertise 广告信息
     * @return 添加操作结果
     */
    @PostMapping(value = "add")
    public Object addAdversion(Advertise advertise) {
        try {
            if(advertise.getAdName() == null || "".equals(advertise.getAdName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"广告名字不能为空",true);
            }
            if(advertise.getContent() == null || "".equals(advertise.getContent())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"广告内容不能为空",true);
            }
            if(advertise.getPictureUrl() == null || "".equals(advertise.getPictureUrl())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"图片地址不能为空",true);
            }
            if(advertise.getReferUrl() == null || "".equals(advertise.getReferUrl())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"关联地址不能为空",true);
            }
            if(advertise.getAdvertisePositionId() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"位置不能为空",true);
            }
            advertise.setCreateTime(new Date());
            advertiseService.saveSelective(advertise);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /**
     * 修改广告
     * @param advertise 广告信息
     * @return 修改操作结果
     */
    @PostMapping(value = "update")
    public Object updateAdvertise(Advertise advertise){
        try {
            if (advertise.getId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"id不能为空",true);
            }
            if(advertise.getAdName() == null || "".equals(advertise.getAdName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"广告名字不能为空",true);
            }
            if(advertise.getContent() == null || "".equals(advertise.getContent())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"广告内容不能为空",true);
            }
            if(advertise.getPictureUrl() == null || "".equals(advertise.getPictureUrl())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"图片地址不能为空",true);
            }
            if(advertise.getReferUrl() == null || "".equals(advertise.getReferUrl())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"关联地址不能为空",true);
            }
            if(advertise.getAdvertisePositionId() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"位置不能为空",true);
            }
            advertiseService.updateSelective(advertise);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    /**
     * 删除广告
     * @param id 广告id
     * @return 删除操作结果
     */
    @PostMapping(value = "delete")
    public Object deleteAdvertise(Integer id) {
        try {
            Advertise advertise = new Advertise();
            advertise.setId(id);
            advertiseService.delete(advertise);
            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }
    }

    /**
     * 获得广告列表
     * @param name 广告名称
     * @param advertisePositionId 广告位置id
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 广告列表
     */
    @GetMapping(value = "list")
    public Object getAdvertiseList(String name,Long advertisePositionId,Integer pageNum,Integer pageSize){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(advertiseService.getAdvertiseList(name,advertisePositionId,pageNum,pageSize));
    }

    /**
     * 根据id获取广告信息
     * @param id 广告id
     * @return 广告信息
     */
    @GetMapping(value = "info")
    public Object getAdvertiseInfo(Integer id){
        if(id == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"参数不能为空",true);
        }
        Advertise advertise = new Advertise();
        advertise.setId(id);
        advertise = advertiseService.selectByPrimary(advertise);
        if(advertise == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NO_RECORD,"不存在记录",true);
        }
        return ResponseUtils.setSuccess(advertise);
    }
}
