package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.ShopUser;
import com.seasonsfood.mall.business.api.service.ShopUserService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zero on 18-12-12
 */
@RestController
@RequestMapping("shopUser")
public class ShopUserController {

    @Reference(check = false)
    ShopUserService shopUserService;

    /**
     * 创建商户
     *
     * @param shopUser 商户信息
     * @return 响应信息
     */
    @RequiresPermissions("shopUser:add")
    @PostMapping("/add")
    public JsonResponse addUser(ShopUser shopUser){
        try {
            ResponseCode responseCode = shopUserService.addUser(shopUser);
            if (!ResponseCode.SUCCESS.equals(responseCode)) {
                throw new BizException(responseCode);
            }
            return ResponseUtils.setSuccess(responseCode);
        } catch (BizException e) {
            return ResponseUtils.setToJson(e.getResponseCode());
        }
    }
}
