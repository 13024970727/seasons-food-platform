package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.Announcement;
import com.seasonsfood.mall.admin.api.service.AnnouncementService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 系统公告
 * @author zq
 * @date 2018/12/8 17:48
 **/
@RestController
@RequestMapping("announcement")
public class AnnouncementController {

    @Reference(check = false)
    private AnnouncementService announcementService;

    /**
     * 公告列表
     * @param announceType 1、平台用户 2、平台商户
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 公告列表
     */
    @RequiresPermissions("announcement:query")
    @GetMapping(value = "/list/{announceType}")
    public Object getAnnouncementList(@PathVariable String announceType, Integer pageNum, Integer pageSize){
       if(pageNum == null) {
           pageNum = 1;
       }
       if(pageSize == null){
           pageSize = 10;
       }
       return ResponseUtils.setSuccess(announcementService.getAnnouncementList(announceType,pageNum,pageSize));
    }

    /**
     * 创建公告
     * @param announcement 公告信息
     * @return 添加操作结果
     */
    @RequiresPermissions("announcement:add")
    @PostMapping(value = "add")
    public Object createAnnouncement(Announcement announcement){
        try {
            if (announcement.getTitle() == null || "".equals(announcement.getTitle())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"标题不能为空",true);
            }
            if(announcement.getContent() == null || "".equals(announcement.getContent())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"内容不能为空",true);
            }
            if(announcement.getAnnountTime() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"通知时间不能为空",true);
            }
            announcement.setCreateTime(new Date());
            announcementService.saveSelective(announcement);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /**
     * 修改公告
     * @param announcement 公告信息
     * @return 修改操作结果
     */
    @RequiresPermissions("announcement:update")
    @PostMapping(value = "/update")
    public Object updateAnnouncement(Announcement announcement){
        try {
            if (announcement.getId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"id不能为空",true);
            }
            if (announcement.getTitle() == null || "".equals(announcement.getTitle())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"标题不能为空",true);
            }
            if(announcement.getContent() == null || "".equals(announcement.getContent())){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"内容不能为空",true);
            }
            if(announcement.getAnnountTime() == null){
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"通知时间不能为空",true);
            }
            announcementService.updateSelective(announcement);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    /**
     * 删除公告
     * @param id 公告id
     * @return 删除操作结果
     */
    @RequiresPermissions("announcement:delete")
    @PostMapping(value = "/delete")
    public Object deleteAnnouncement(Integer id){
        try {
            Announcement announcement = new Announcement();
            announcement.setId(id);
            announcementService.delete(announcement);
            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }
    }

    /**
     * 根据id获得公告
     * @param id 公告id
     * @return 公告信息
     */
    @GetMapping(value = "select")
    public Object getAnnouncementById(Integer id){
        if(id == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"");
        }
        Announcement announcement = new Announcement();
        announcement.setId(id);
        Announcement result = announcementService.selectOne(announcement);
        if(StringUtils.isEmpty(result)){
           ResponseUtils.setJsonAndMsg(ResponseCode.NO_RECORD,"不存在记录",true);
        }
        return ResponseUtils.setSuccess(result);
    }

}
