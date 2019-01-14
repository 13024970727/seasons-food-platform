package com.seasonsfood.mall.web.shop.admin.web.controller.business;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.ShopUser;
import com.seasonsfood.mall.business.api.domain.ShopUserBankInfo;
import com.seasonsfood.mall.business.api.domain.ShopUserPayInfo;
import com.seasonsfood.mall.business.api.domain.ShopWithdrawRecord;
import com.seasonsfood.mall.business.api.model.WithdrawCashModel;
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
import java.util.Date;

/**
 * @Author zhaozhirong
 * @Date 2018/12/7 11:22
 */
@RestController
@RequestMapping("shopUser")
public class ShopUserController {

    @Reference(check = false)
    private ShopUserService shopUserService;

    @Reference(check = false)
    private ShopUserBankInfoService shopUserBankInfoService;

    @Reference(check = false)
    private ShopUserPayInfoService shopUserPayInfoService;

    /**
     * 商户提现
     *
     * @param
     * @param request
     * @return
     */
    //  @RequiresPermissions("goods:add")
    @PostMapping(value = "/withdrawCash")
    public Object transfer(WithdrawCashModel model, HttpServletRequest request) {
        Assert.notNull(model.getMoney(), "提现金额有误！");
        Assert.notNull(model.getType(), "提现类型不能为空！");
        Assert.notNull(model.getReceiptId(), "未选择收款账户！");

        if (model.getMoney().compareTo(BigDecimal.ZERO) < 1) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "提现金额有误", true);
        }

        ShopUser shopUser = (ShopUser) request.getSession().getAttribute(Const.SHOP_CURRENT_USER);


        ShopWithdrawRecord shopWithdrawRecord = new ShopWithdrawRecord();

        //判断收款信息是否有误
        if (WithdrawCashModel.WITHDRAW_TYPE_BANK.equals(model.getType())) {
            //判断银行卡信息
            ShopUserBankInfo bankInfo = shopUserBankInfoService.selectBankInfoByIdAndShopUserId(model.getReceiptId(), shopUser.getId());
            if (bankInfo == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "收款信息有误", true);
            }
            shopWithdrawRecord.setRealName(bankInfo.getRealName());
            shopWithdrawRecord.setCardNumber(bankInfo.getCardNumber());
            shopWithdrawRecord.setAccountFrom(bankInfo.getBank());
        } else {
            if (WithdrawCashModel.WITHDRAW_TYPE_ALIPAY.equals(model.getType()) || WithdrawCashModel.WITHDRAW_TYPE_WECHAT.equals(model.getType())) {
                ShopUserPayInfo payInfo = shopUserPayInfoService.selectPayInfoByIdAndShopUserId(model.getReceiptId(),model.getType(), shopUser.getId());
                if (payInfo == null) {
                    return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "收款信息有误!", true);
                }
                shopWithdrawRecord.setRealName(payInfo.getRealName());
                shopWithdrawRecord.setQrcode(payInfo.getAccount());
                shopWithdrawRecord.setAccountFrom(payInfo.getAccountName());

            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "收款信息有误！", true);
            }
        }

        shopWithdrawRecord.setWithdrawType(model.getType());
        shopWithdrawRecord.setWithdrawMoney(model.getMoney());
        shopWithdrawRecord.setRemark(model.getRemark());
        shopWithdrawRecord.setWithdrawMoney(model.getMoney());
        shopWithdrawRecord.setStatus(ShopWithdrawRecord.WITHDRAW_STATUS_AUDITING);
        shopWithdrawRecord.setTransfer(false);
        ResponseCode responseCode = shopUserService.shopWithdrawCash(shopWithdrawRecord,shopUser.getId());
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }


}
