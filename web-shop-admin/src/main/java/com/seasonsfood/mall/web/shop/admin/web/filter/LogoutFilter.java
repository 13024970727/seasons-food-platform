package com.seasonsfood.mall.web.shop.admin.web.filter;


import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


/**
 * @author ron
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        Subject subject = this.getSubject(request, response);
        subject.logout();
        HttpServletResponse resp = (HttpServletResponse) response;
        ResponseUtils.sendResponse(resp, ResponseCode.SUCCESS);

        return false;
    }
}
