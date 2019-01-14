package com.seasonsfood.mall.web.shop.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.ShopUser;
import com.seasonsfood.mall.business.api.service.ShopUserService;
import com.seasonsfood.mall.util.constant.Const;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ron
 */
@RestController
public class LoginController {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginController.class);

    @Reference(check = false)
    private ShopUserService shopUserService;

    /**
     * 登录方法
     *
     * @param userInfo 用户信息
     * @return
     */
    @PostMapping(value = "/ajaxLogin")
    public Object login(ShopUser userInfo, HttpServletRequest request) {


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        String errorMessage = "未知错误";
        try {
            subject.login(token);

            ShopUser user = shopUserService.findByName(userInfo.getUsername());
//            request.getSession().setAttribute(Const.SHOP_CURRENT_USER,user);
            if (user == null) {
                throw new AuthenticationException();
            }
            if (user.getDelete()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "账户不可用", true);
            }

            if (user.getLocked()) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "账户已被锁定", true);
            }
            return ResponseUtils.setSuccess();
        } catch (IncorrectCredentialsException e) {
            errorMessage = "密码错误";
        } catch (LockedAccountException e) {
            errorMessage = "登录失败，该用户已被冻结";
        } catch (AuthenticationException e) {
            errorMessage = "该用户不存在";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, errorMessage, true);
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @GetMapping(value = "/unAuth")
    public Object unauth() {
        return ResponseUtils.setToJson(ResponseCode.SESSION_TIMEOUT);
    }

}
