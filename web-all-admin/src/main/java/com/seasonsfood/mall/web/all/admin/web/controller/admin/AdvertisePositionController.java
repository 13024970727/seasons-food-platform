package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.AdvertisePosition;
import com.seasonsfood.mall.admin.api.service.AdvertisePositionService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 广告位置管理
 * @author zq
 * @date 2018/12/10 17:56
 **/
@RestController
@RequestMapping(value = "advertisePosition")
public class AdvertisePositionController {

    @Reference(check = false)
    private AdvertisePositionService advertisePositionService;

    /**
     * 添加广告位置
     * @param advertisePosition 广告位置对象
     * @return 添加操作结果
     */
    @PostMapping(value = "add")
    public Object addAdvertisePosition(AdvertisePosition advertisePosition){
        try {
            if(advertisePosition.getPositionName() == null || "".equals(advertisePosition.getPositionName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"位置名称不能为空",true);
            }
            if(advertisePosition.getHeight() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"高度不能为空",true);
            }
            if(advertisePosition.getWidth() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"宽度不能为空",true);
            }
            advertisePosition.setCreateTime(new Date());
            advertisePositionService.saveSelective(advertisePosition);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /**
     * 修改广告位置
     * @param advertisePosition 广告位置对象
     * @return 添加操作结果
     */
    @PostMapping(value = "update")
    public Object updateAdvertisePosition(AdvertisePosition advertisePosition){
        try {
            if(advertisePosition.getId() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"id不能为空",true);
            }
            if(advertisePosition.getPositionName() == null || "".equals(advertisePosition.getPositionName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"位置名称不能为空",true);
            }
            if(advertisePosition.getHeight() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"高度不能为空",true);
            }
            if(advertisePosition.getWidth() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"宽度不能为空",true);
            }
            advertisePosition.setUpdateTime(new Date());
            advertisePositionService.updateSelective(advertisePosition);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    /**
     * 删除广告位置
     * @param id 位置id
     * @return 删除操作结果
     */
    @PostMapping(value = "delete")
    public Object deleteAdvertisePosition(Long id){
        try {
            AdvertisePosition advertisePosition = new AdvertisePosition();
            advertisePosition.setId(id);
            advertisePositionService.delete(advertisePosition);
            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }
    }

    /**
     * 获取广告位置列表
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 广告位置列表
     */
    @GetMapping(value = "list")
    public Object getAdvertisePositionList(Integer pageNum, Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(advertisePositionService.getAdvertisePositionList(pageNum,pageSize));
    }

    /**
     * 根据id获得广告位置信息
     * @param id 位置id
     * @return 广告位置信息
     */
    @GetMapping(value = "info")
    public Object getAdvertisePositionInfo(Long id){
        if(id == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"参数不能为空",true);
        }
        AdvertisePosition advertisePosition = new AdvertisePosition();
        advertisePosition.setId(id);
        advertisePosition = advertisePositionService.selectByPrimary(advertisePosition);
        if(advertisePosition == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NO_RECORD,"不存在记录",true);
        }
        return ResponseUtils.setSuccess(advertisePosition);
    }
}
