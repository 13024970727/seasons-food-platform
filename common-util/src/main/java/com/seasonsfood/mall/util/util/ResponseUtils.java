package com.seasonsfood.mall.util.util;


import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.model.ListResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ron
 */
public class ResponseUtils {

    public static JsonResponse setSuccess() {
        return setToJson(ResponseCode.SUCCESS);
    }

    /**
     * 返回无数据
     *
     * @param responseCode
     *         {@link ResponseCode}
     *
     * @return
     */
    public static JsonResponse setToJson(ResponseCode responseCode) {
        JsonResponse json = new JsonResponse();
        return setToJson(responseCode, json);
    }

    /**
     * 返回无数据
     *
     * @param responseCode
     *         {@link ResponseCode}
     * @param json
     *         {@link JsonResponse}
     *
     * @return
     */
    public static JsonResponse setToJson(ResponseCode responseCode, JsonResponse json) {

        json.setCode(responseCode.getCode());
        json.setDesc(responseCode.getDesc());
        json.setSuccess(responseCode.isSuccess());
        return json;
    }

    /**
     * 返回成功的数据
     *
     * @param obj
     *         数据
     *
     * @return
     */
    public static JsonResponse setSuccess(Object obj) {

        JsonResponse json = new JsonResponse();
        json.setCode(ResponseCode.SUCCESS.getCode());
        json.setDesc(ResponseCode.SUCCESS.getDesc());
        json.setSuccess(ResponseCode.SUCCESS.isSuccess());
        json.setResult(obj);
        return json;
    }

    /**
     * 设置返回列表数据
     *
     * @param list
     *         列表数据
     *
     * @return
     */
    public static JsonResponse setDataAndResponse(ListResponse list) {

        if (null != list && null != list.getRows() && list.getRows().size() > 0) {
            //
            return ResponseUtils.setSuccess(list);
        } else {
            return ResponseUtils.setToJson(ResponseCode.NOT_DATA);
        }
    }

    /**
     * 发送不可替代的信息
     *
     * @param responseCode
     * @param msg
     *
     * @return
     */
    public static JsonResponse setJsonAndMsg(ResponseCode responseCode, String msg) {
        return setJsonAndMsg(responseCode, msg, false);
    }

    /**
     * 发送信息
     *
     * @param responseCode
     * @param msg
     * @param isReplace
     *         msg是否替代Json的msg
     *
     * @return
     */
    public static JsonResponse setJsonAndMsg(ResponseCode responseCode, String msg, boolean isReplace) {

        JsonResponse json = new JsonResponse();
        json.setCode(responseCode.getCode());
        if (isReplace) {
            json.setDesc(msg);
        } else {
            json.setDesc(responseCode.getDesc() + "," + msg);
        }
        json.setSuccess(responseCode.isSuccess());

        return json;
    }

    /**
     * 响应
     * @param response
     * @param responseCode
     * @throws Exception
     */
    public static void sendResponse(HttpServletResponse response, ResponseCode responseCode) throws Exception{

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print(GsonUtils.getGsonInstance().toJson(ResponseUtils.setToJson(responseCode)));

    }


}
