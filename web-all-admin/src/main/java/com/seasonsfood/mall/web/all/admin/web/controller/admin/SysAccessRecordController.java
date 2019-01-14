package com.seasonsfood.mall.web.all.admin.web.controller.admin;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问记录
 *
 * @author zyark
 * @date 2018/7/24
 */
@RestController
@RequestMapping("/access_record")
public class SysAccessRecordController {

//    @Resource
//    private AccessRecordService accessRecordService;
//
//    @RequiresPermissions("access_record:query")
//    @RequestMapping(value="query",method = RequestMethod.POST)
//    public JsonResponse query(AccessRecord accessRecord, String startTime, String endTime, Integer page, Integer pageSize){
//        if (page == null){
//            page = 1;
//        }
//        if (pageSize == null){
//            pageSize = 10;
//        }
//        Example example = new Example(AccessRecord.class);
//        Example.Criteria criteria = example.createCriteria();
//        if(null != accessRecord.getUsername() && !"".equals(accessRecord.getUsername().trim())){
//            criteria.andLike("username","%"+accessRecord.getUsername().trim()+"%");
//        }
//        if(null != accessRecord.getIpAddress() && !"".equals(accessRecord.getIpAddress().trim())){
//            criteria.andLike("ipAddress","%"+accessRecord.getIpAddress().trim()+"%");
//        }
//        if(null != accessRecord.getSensitiveHandle() && !"".equals(accessRecord.getSensitiveHandle().trim())){
//            criteria.andLike("sensitiveHandle","%"+accessRecord.getSensitiveHandle().trim()+"%");
//        }
//        if(null != accessRecord.getHandleModule() && !"".equals(accessRecord.getHandleModule().trim())){
//            criteria.andLike("handleModule","%"+accessRecord.getHandleModule().trim()+"%");
//        }
//        if(null != accessRecord.getSid() && !"".equals(accessRecord.getSid().trim())){
//            criteria.andLike("sid","%"+accessRecord.getSid().trim()+"%");
//        }
//        if(null != startTime && !"".equals(startTime)){
//            criteria.andGreaterThanOrEqualTo("lastAccessTime",startTime);
//        }
//        if(null != endTime && !"".equals(endTime)){
//            criteria.andLessThanOrEqualTo("lastAccessTime",endTime);
//        }
//        ServerResponseModel<AccessRecord> model = accessRecordService.selectPageByExampleV2(example,page,pageSize);
//        if(model == null || model.getListDate().size() == 0){
//            return ResponseUtils.setToJson(ResponseCode.NOT_DATA);
//        }
//        return ResponseUtils.setSuccess(accessRecordService.serverResponseModelToResponse(model));
//    }
}
