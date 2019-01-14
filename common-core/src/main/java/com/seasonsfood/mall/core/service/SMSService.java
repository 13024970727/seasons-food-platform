package com.seasonsfood.mall.core.service;

/**
 * 发送短信
 * @author ron
 */
public interface SMSService {

    /**
     * sendSMS作用: 发送短信. <br/>
     * 适用条件：.<br/>
     *
     * @JDK 1.8
     * @since 1.0
     */
    Object sendSMS(String phone, String code);


    /**
     * 发送短信验证码
     * @param phone 手机号
     * @return 响应
     */
    Object sendSMS(String phone);

    /**
     * 生成随即数
     * @param from 开始数
     * @param to 结束数
     * @return 随即数
     */
     int randomInt(int from, int to);

    /**
     * 验证
     * @param phone 手机号
     * @param verifyCode 验证码
     * @return 是否通过验证
     */
     boolean verifySMS(String phone, String verifyCode);

    /**
     * 法币交易新订单提醒买家
     * @param phone 买家手机
     * @param userNick 买家昵称
     * @param orderId 订单ID
     */
    Object sendFBNewOrder(String phone, String userNick, Long orderId);

    /**
     * 法币交易订单已付款提醒卖家
     * @param phone 卖家手机
     * @param userNick 卖家昵称
     * @param orderId 订单ID
     */
    Object sendFBOrderChange(String phone, String userNick, Long orderId);

}
