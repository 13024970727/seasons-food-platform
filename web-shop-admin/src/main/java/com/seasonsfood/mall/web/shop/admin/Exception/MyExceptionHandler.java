package com.seasonsfood.mall.web.shop.admin.Exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * @author ron
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        ex.printStackTrace();
        if (ex instanceof UnauthenticatedException) {
            attributes.put("success",false);
            attributes.put("code", "1000001");
            attributes.put("desc", "token错误");
        } else if (ex instanceof UnauthorizedException) {
            attributes.put("success",false);
            attributes.put("code", "1000002");
            attributes.put("desc", "用户无权限");
        } else if (ex instanceof BizException) {
            ResponseCode responseCode = ((BizException) ex).getResponseCode();
            attributes.put("success",responseCode.isSuccess());
            attributes.put("code", responseCode.getCode());
            attributes.put("desc", responseCode.getDesc());
        } else {
            attributes.put("success",false);
            attributes.put("code", "1000003");
            attributes.put("desc", ex.getMessage());
        }

        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
