package com.seasonsfood.mall.web.shop.admin.web.controller.business;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.ShopUser;
import com.seasonsfood.mall.business.api.domain.ShopUserBankInfo;
import com.seasonsfood.mall.business.api.domain.ShopUserPayInfo;
import com.seasonsfood.mall.business.api.service.ShopUserBankInfoService;
import com.seasonsfood.mall.business.api.service.ShopUserPayInfoService;
import com.seasonsfood.mall.business.api.service.ShopUserService;
import com.seasonsfood.mall.util.constant.Const;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import com.seasonsfood.mall.util.util.Assert;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * @Author zhaozhirong
 * @Date 2018年12月12日16:51:26
 */
@RestController
@RequestMapping("payInfo")
public class PaykInfoController {

    @Reference(check = false)
    private ShopUserService shopUserService;

    @Reference(check = false)
    private ShopUserBankInfoService shopUserBankInfoService;
    @Reference(check = false)
    private ShopUserPayInfoService shopUserPayInfoService;

    /**
     * 添加银行卡信息.
     *
     * @param bankInfo
     * @param request
     * @return
     */
    @PostMapping(value = "/bank/add")
    public Object addNewBankCard(ShopUserBankInfo bankInfo, HttpServletRequest request) {
        Assert.hasText(bankInfo.getBank(), "开户行不能为空！");
        Assert.hasText(bankInfo.getCardNumber(), "银行卡号不能为空！");
        Assert.hasText(bankInfo.getRealName(), "持卡人不能为空！");
        ShopUser shopUser = (ShopUser) request.getSession().getAttribute(Const.SHOP_CURRENT_USER);
        if (shopUser == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "无法获取商户信息！", true);
        }
        bankInfo.setShopUserId(shopUser.getId());

        ShopUserBankInfo shopUserBankInfo = shopUserBankInfoService.selectBankInfoByCardNumber(bankInfo.getCardNumber());
        if (shopUserBankInfo != null) {
            if (!shopUserBankInfo.getShopUserId().equals(shopUser.getId())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "该银行卡被其他用户绑定！", true);
            }
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "你已绑定该银行卡，请更换银行卡进行绑定！", true);
        }
        //添加银行卡信息
        ResponseCode responseCode = shopUserBankInfoService.addNewBankInfo(bankInfo);
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }

    /**
     * 添加支付宝或微信收款码.
     *
     * @param payInfo
     * @param request
     * @return
     */
    @PostMapping(value = "/add")
    public Object addNewBankCard(ShopUserPayInfo payInfo, HttpServletRequest request) {
        Assert.hasText(payInfo.getAccount(), "收款二维码不能为空！");
        Assert.hasText(payInfo.getAccountName(), "微信号或支付宝号不能为空！");
        Assert.hasText(payInfo.getRealName(), "真实姓名不能为空！");
        Assert.notNull(payInfo.getPayType(), "收款码类型不能为空！");
        if (!ShopUserPayInfo.PAY_TYPE_ALIPAY.equals(payInfo.getPayType()) && !ShopUserPayInfo.PAY_TYPE_WECHAT.equals(payInfo.getPayType())) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "收款码类型有误！", true);
        }
        ShopUser shopUser = (ShopUser) request.getSession().getAttribute(Const.SHOP_CURRENT_USER);
        if (shopUser == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "无法获取商户信息！", true);
        }
        payInfo.setShopUserId(shopUser.getId());

        //添加收款信息
        ResponseCode responseCode = shopUserPayInfoService.addNewPayInfo(payInfo);
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }
}
