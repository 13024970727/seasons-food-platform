package com.seasonsfood.mall.web.shop.admin.web.filter;


import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.GsonUtils;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author ron
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (isLoginRequest(req, resp)) {
            if (isLoginSubmission(req, resp)) {
                if (logger.isTraceEnabled()) {
                    logger.trace("Login submission detected.  Attempting to execute login.");
                }

                return true;
            } else {
                if (logger.isTraceEnabled()) {
                    logger.trace("Login page view.");
                }

                this.sendResponse(resp, ResponseCode.SESSION_TIMEOUT);
                //allow them to see the login page ;)
                return false;
            }
        } else {

            //前端Ajax请求时requestHeader里面带一些参数，用于判断是否是前端的请求
//            Map<String, String[]> parmas = request.getParameterMap();
//            String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
//            if("XMLHttpRequest".equalsIgnoreCase(header)){
            this.sendResponse(resp, ResponseCode.SESSION_TIMEOUT);
//            }else{
//                saveRequestAndRedirectToLogin(request, response);
//            }
            return false;
        }
    }

    /**
     * 发送数据
     *
     * @param response
     * @param responseCode
     *
     * @throws Exception
     */
    private void sendResponse(HttpServletResponse response, ResponseCode responseCode) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print(GsonUtils.getGsonInstance().toJson(ResponseUtils.setToJson(responseCode)));

    }
}
