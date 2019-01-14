package com.seasonsfood.mall.util.constant;

import java.io.Serializable;

/**
 *
 * @author ron
 * @date 17-9-8
 */
public class SMSConstant implements Serializable {
    public static final long serialVersionUID = 3141442995430017572L;

    /**
     * accessKeyId
     */
    public final static String accessKeyId = "LTAIbuWZDfy1ROZb";

    /**
     * accessKeySecret
     */
    public final static String accessKeySecret = "mPKcocTI76i9o1EkLFjfBj6LxRg6ae";

    /**
     * 短信API产品名称（短信产品名固定，无需修改）
     */
    public final static String product = "Dysmsapi";

    /**
     * 短信API产品域名（接口地址固定，无需修改）
     */
    public final static String domain = "dysmsapi.aliyuncs.com";

    /**
     * 必填:短信签名-可在短信控制台中找到
     */
    public final static String signName = "数来宝";

    /**
     * 模板代码
     */
    public final static String templateCode = "SMS_133275234";
    public final static String FB_NEW_ORDER_TEMPLATE_CODE = "SMS_135038697";
    public final static String FB_ORDER_CHANGE_TEMPLATE_CODE = "SMS_135028847";
}
