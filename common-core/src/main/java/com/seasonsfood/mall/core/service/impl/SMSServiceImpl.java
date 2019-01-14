package com.seasonsfood.mall.core.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.seasonsfood.mall.core.constant.SMSConstant;
import com.seasonsfood.mall.core.service.SMSService;
import com.seasonsfood.mall.util.util.RedisUtils;

import java.util.Random;


/**
 * @author ron
 */
public class SMSServiceImpl implements SMSService {

    RedisUtils<String> redisUtils;

    public void setRedisUtils(RedisUtils<String> redisUtils) {
        this.redisUtils = redisUtils;
    }

    public SMSServiceImpl(RedisUtils<String> redisUtils) {
        this.redisUtils = redisUtils;
    }

    /**
     *
     * @param phone 手机号
     * @return
     */
    @Override
    public Object sendSMS(String phone) {
        String code = String.valueOf(randomInt(1, 999999));
        return sendSMS(phone, code);
    }

    /**
     *
     * @param phone
     * @param code
     * @return
     */
    @Override
    public Object sendSMS(String phone, String code) {
        redisUtils.cacheValue(phone, code, 600);
        SendSmsResponse sendSmsResponse = sendSms(SMSConstant.templateCode, phone, "{\"code\":\"" + code + "\"}");
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功
            redisUtils.cacheValue(phone, code, 600);
        }
        return null;
    }

    /**
     *
     * @param from 开始数
     * @param to 结束数
     * @return
     */
    @Override
    public int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

    /**
     * 验证短信验证码登陆
     */
    @Override
    public boolean verifySMS(String phone, String verifyCode) {

        String cacheVerifyCode = redisUtils.getValue(phone);

        if (verifyCode.equals(cacheVerifyCode)) {
            redisUtils.remove(phone);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param phone 买家手机
     * @param userNick 买家昵称
     * @param orderId 订单ID
     * @return
     */
    @Override
    public Object sendFBNewOrder(String phone, String userNick, Long orderId) {
        JSONObject params = new JSONObject();
        params.put("name", userNick);
        params.put("orderId", orderId);
        sendSms(SMSConstant.FB_NEW_ORDER_TEMPLATE_CODE, phone, params.toJSONString());
        return null;
    }

    /**
     *
     * @param phone 卖家手机
     * @param userNick 卖家昵称
     * @param orderId 订单ID
     * @return
     */
    @Override
    public Object sendFBOrderChange(String phone, String userNick, Long orderId) {
        JSONObject params = new JSONObject();
        params.put("name", userNick);
        params.put("orderId", orderId);
        sendSms(SMSConstant.FB_ORDER_CHANGE_TEMPLATE_CODE, phone, params.toJSONString());
        return null;
    }

    /**
     * 发送短信
     * @param templateCode  模板编号
     * @param phone  手机号码
     * @param params  模板参数
     * @return
     */
    private SendSmsResponse sendSms(String templateCode, String phone, String params){
        System.setProperty("sun.net.client.defaultConnectTimeout", "100000");
        System.setProperty("sun.net.client.defaultReadTimeout", "100000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", SMSConstant.accessKeyId, SMSConstant.accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", SMSConstant.product, SMSConstant.domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        request.setSignName(SMSConstant.signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);

        request.setTemplateParam(params);


        request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return sendSmsResponse;
    }

    public RedisUtils<String> getRedisUtils() {
        return redisUtils;
    }
}
