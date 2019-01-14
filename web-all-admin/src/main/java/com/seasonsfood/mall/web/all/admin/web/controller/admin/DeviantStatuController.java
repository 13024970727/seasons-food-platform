package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.DeviantStatu;
import com.seasonsfood.mall.admin.api.service.DeviantStatuService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 异常事件管理
 * @author zq
 * @date 2018/12/11 14:58 日期
 **/
@RestController
@RequestMapping("deviantStatu")
public class DeviantStatuController {

    @Reference(check = false)
    private DeviantStatuService deviantStatuService;

    /**
     * 添加异常
     * @param deviantStatu 异常对象
     * @return 添加操作结果
     */
    @PostMapping(value = "add")
    public Object addDeviantStatu(DeviantStatu deviantStatu){
        try {
            if(deviantStatu.getDivantName() == null || "".equals(deviantStatu.getDivantName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"异常名称不能为空",true);
            }
            if(deviantStatu.getUserView() == null || "".equals(deviantStatu.getUserView())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"用户看到的异常信息不能为空",true);
            }
            deviantStatu.setCreateTime(new Date());
            deviantStatuService.saveSelective(deviantStatu);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /**
     * 异常修改
     * @param deviantStatu 异常对象
     * @return 修改操作结果
     */
    @PostMapping(value = "update")
    public Object updateDeviantStatu(DeviantStatu deviantStatu){
        try {
            if(deviantStatu.getId() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"id不能为空",true);
            }
            if(deviantStatu.getDivantName() == null || "".equals(deviantStatu.getDivantName())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"异常名称不能为空",true);
            }
            if(deviantStatu.getUserView() == null || "".equals(deviantStatu.getUserView())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"用户看到的异常信息不能为空",true);
            }
            deviantStatuService.updateSelective(deviantStatu);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    /**
     * 删除异常
     * @param id 异常id
     * @return 删除操作结果
     */
    @PostMapping(value = "delete")
    public Object deleteDeviantStatu(Long id){
        try {
            DeviantStatu deviantStatu = new DeviantStatu();
            deviantStatu.setId(id);
            deviantStatuService.delete(deviantStatu);
            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }
    }

    /**
     * 获得异常列表
     * @param name 名称
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 异常列表
     */
    @GetMapping(value = "list")
    public Object getDeviantStatuList(String name,Integer pageNum,Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(deviantStatuService.getDeviantStatuList(name, pageNum, pageSize));
    }

    /**
     * 根据id获取异常
     * @param id 异常id
     * @return 异常信息
     */
    @GetMapping(value = "info")
    public Object getDeviantStatuInfo(Long id){
        if(id == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"");
        }
        DeviantStatu deviantStatu = new DeviantStatu();
        deviantStatu.setId(id);
        deviantStatu = deviantStatuService.selectByPrimary(deviantStatu);
        if(deviantStatu == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NO_RECORD,"不存在记录",true);
        }
        return ResponseUtils.setSuccess(deviantStatu);
    }

}
