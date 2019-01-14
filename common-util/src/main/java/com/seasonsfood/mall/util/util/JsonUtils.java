package com.seasonsfood.mall.util.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ron
 */
public class JsonUtils {

    /**
     * 将json返回页面
     * @param object 传输的对象
     * @param response response域
     */
    public static void writeJson(Object object, HttpServletResponse response) {
        try {
            String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
