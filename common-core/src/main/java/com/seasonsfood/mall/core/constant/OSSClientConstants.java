package com.seasonsfood.mall.core.constant;

import java.io.Serializable;

/**
 *
 * @author ron
 */
public class OSSClientConstants implements Serializable {
    private static final long serialVersionUID = -8820659090159118779L;

    /**
     * 阿里云API的外网域名
     */
    public static final String ENDPOINT = "http://oss-cn-hongkong.aliyuncs.com/";

    /**
     * 外网访问域名
     */
    public static final String CLIENT_ENDPOINT = "http://slb-files.oss-cn-hongkong.aliyuncs.com/";

    /**
     * 阿里云API的密钥Access Key ID
     */
    public static final String ACCESS_KEY_ID = "LTAIbuWZDfy1ROZb";

    /**
     * 阿里云API的密钥Access Key Secret
     */
    public static final String ACCESS_KEY_SECRET = "mPKcocTI76i9o1EkLFjfBj6LxRg6ae";

    /**
     * 阿里云API的bucket名称
     */
    public static final String BACKET_NAME = "slb-files";

    /**
     * 阿里云API的文件夹名称
     */
    public static final String FOLDER="content/";


}
