package com.seasonsfood.mall.util.constant;


/**
 * @author ron
 */

public enum ResponseCode {

    SUCCESS(200, "成功", true),
    NOT_NULL(201, "参数不能为空！", false),
    FORMAT_ERROR(202, "格式有误", false),
    NOT_DATA(203, "暂无数据", false),
    LOGIN_FAIL(204, "账号或密码有误", false),
    OTHER_ERROR(205, "有误", false),
    OPERATION_ERROR(206, "操作有误", false),
    PAGE_ERROR(206, "分页信息有误", false),
    ADD_ERROR(207,"添加失败",false),
    MODIFY_ERROR(208,"修改失败",false),
    DELETE_ERROR(209,"删除失败",false),
    PARAMS_ERROR(210,"参数错误",false),
    DATA_ERROR(211,"数据错误",false),
    DATA_MULTIPLE(212,"数据重复",false),
    NAME_REPEAT(250, "名称重复！", false),
    HAVE_CHILD(251, "存在子节点！", false),
    HAVE_CHILD_RECORD(252, "存在子记录！", false),
    NO_RECORD(253, "不存在记录！", false),
    SESSION_TIMEOUT(301, "Session过期", false),
    USER_NOT_EXIST(302, "用户不存在", false),
    CODE_ILLEGAL(303, "非法授权码", false),
    TOKEN_NOT_EXIT(304, "无token，请重新登录", false),
    ERROR(400, "异常", false),
    PERMISSION(401, "暂无权限", false),
    REPEAT(402, "请勿重复提交表单", false),
    SESSION_ID_NULL(1024, "ssid不能为空！", false),

    //转账
    ACCEPT_INFO_ERROR(650, "收款信息有误！", false),
    SHOP_BASE_INFO_ERROR(651, "店铺信息有误！", false),
    NOT_ENOUGH_MONEY(652, "余额不足！", false),

    //商品信息
    GOODS_CATEGORY_ERROR(601, "商品类别有误！", false),
    //APP
    APP_ACCESS_TOKEN_EXPIRED(10001, "token过期，请重新登陆！", false),


    //DD
    OUT_HAND_ERROR(10001, "系统外部错误！", false),

    ;


    private int code;
    private String desc;
    private boolean isSuccess = false;

    ResponseCode(int code, String desc, boolean isSuccess) {
        this.code = code;
        this.desc = desc;
        this.isSuccess = isSuccess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

}
