package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.fontuser.api.service.FontUserAddressService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户收货地址管理
 *
 * @author Zero on 18-12-12
 */
@RestController
@RequestMapping("fontUserAddress")
public class FontUserAddressController {

    @Reference(check = false)
    FontUserAddressService fontUserAddressService;

    /**
     * 给收货地址设置配送员
     *
     * @param addressId 收货地址id
     * @param deliveryUserId 配送员id
     * @return 设置结果
     */
    //RequiresPermissions:当前Subject需要拥有某些特定的权限时，才能执行被该注解标注的方法。
    // 如果当前Subject不具有这样的权限，则方法不会被执行。
    @RequiresPermissions("fontUserAddress:update")
    @PostMapping("/setDeliveryUser")
    public JsonResponse setDeliveryUser(@RequestParam Long addressId, @RequestParam Long deliveryUserId){
        try {
            ResponseCode responseCode = fontUserAddressService.setDeliveryUserIdById(addressId,deliveryUserId);
            if (!ResponseCode.SUCCESS.equals(responseCode)) {
                throw new BizException(responseCode);
            }
            return ResponseUtils.setSuccess(responseCode);
        } catch (BizException e) {
            return ResponseUtils.setToJson(e.getResponseCode());
        }
    }
}
