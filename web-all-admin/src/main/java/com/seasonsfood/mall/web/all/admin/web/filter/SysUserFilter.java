package com.seasonsfood.mall.web.all.admin.web.filter;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.SysUser;
import com.seasonsfood.mall.admin.api.service.SysResourceService;
import com.seasonsfood.mall.admin.api.service.SysUserService;
import com.seasonsfood.mall.util.constant.Const;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ron
 */
public class SysUserFilter extends PathMatchingFilter {

    @Reference(check = false)
    private SysUserService sysUserService;

//    @Resource
//    private AccessRecordService accessRecordService;

    @Reference(check = false)
    private SysResourceService sysResourceService;

    /**
     * 忽略前缀
     * */
    private static final List<String> IGNORE_PRE = new ArrayList<String>();

    static {
        IGNORE_PRE.add("/api/v");
        IGNORE_PRE.add("/druid");
    }

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getServletPath();

        for (String pre : IGNORE_PRE) {
            if (url.startsWith(pre)) {
                return true;
            }
        }

        String username = (String) SecurityUtils.getSubject().getPrincipal();

        if (username == null){
            return true;
        }
        SysUser sysUser = new SysUser(username);
        SysUser mySysUser = sysUserService.selectOne(sysUser);
        request.setAttribute(Const.CURRENT_USER, mySysUser);


        //记录操作日志
//        AccessRecord accessRecord = null;
//        String sid = httpServletRequest.getSession().getId();
//        try {
//            Map<String,String> moduleMap = sysResourceService.getResourceMap();
//            accessRecord = accessRecordService.selectOne(new AccessRecord(sid));
//
//            Long time = httpServletRequest.getSession().getLastAccessedTime();
//            Date lastAccessedTime = new Date(time);
//            String ip = IpUtils.getIpAddr(httpServletRequest);
//            if (accessRecord != null){
//                accessRecord.setLastAccessTime(lastAccessedTime);
//                String oldHandleModule = accessRecord.getHandleModule();
//                oldHandleModule = oldHandleModule == null ? "":oldHandleModule;
//                if (moduleMap.get(url)!= null&& !moduleMap.get(url).equals("")&&!oldHandleModule.contains(moduleMap.get(url))){
//                    if (oldHandleModule.equals("")){
//                        accessRecord.setHandleModule(moduleMap.get(url));
//                    }else {
//                        accessRecord.setHandleModule(oldHandleModule + "," + moduleMap.get(url));
//                    }
//                }
//                try {
//                    accessRecordService.updateSelective(accessRecord);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }else {
//                AccessRecord newAccessRecord = new AccessRecord( sid,  ip,  moduleMap.get(url),null ,  lastAccessedTime,  username);
//                accessRecordService.saveSelective(newAccessRecord);
//            }
//
//        }catch (MyBatisSystemException e){
//            List<AccessRecord> accessRecords = accessRecordService.select(new AccessRecord(sid));
//            accessRecords.forEach(accessRecord1 -> {
//                accessRecordService.delete(accessRecord1);
//            });
//            e.printStackTrace();
//        }

        return true;
    }
}
