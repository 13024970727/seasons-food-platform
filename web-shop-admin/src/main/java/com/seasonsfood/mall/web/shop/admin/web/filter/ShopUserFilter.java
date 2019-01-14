package com.seasonsfood.mall.web.shop.admin.web.filter;


import com.alibaba.dubbo.config.annotation.Reference;
//import com.seasonsfood.mall.admin.api.domain.SysUser;
import com.seasonsfood.mall.admin.api.service.SysResourceService;
//import com.seasonsfood.mall.admin.api.service.SysUserService;
import com.seasonsfood.mall.business.api.domain.ShopUser;
import com.seasonsfood.mall.business.api.service.ShopUserService;
import com.seasonsfood.mall.util.constant.Const;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ron
 */
public class ShopUserFilter extends PathMatchingFilter {

    @Reference(check = false)
    private ShopUserService shopUserService;

    /**
     * 忽略前缀
     */
    private static final List<String> IGNORE_PRE = new ArrayList<String>();

    static {
        IGNORE_PRE.add("/api/v");
        IGNORE_PRE.add("/druid");
    }

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getServletPath();


        for (String pre : IGNORE_PRE) {
            if (url.startsWith(pre)) {
                return true;
            }
        }

        String username = (String) SecurityUtils.getSubject().getPrincipal();

        if (username == null) {
            return true;
        }
        ShopUser myShopUser = (ShopUser) ((HttpServletRequest) request).getSession().getAttribute(Const.SHOP_CURRENT_USER);
        if (myShopUser == null) {
            myShopUser = shopUserService.findByName(username);
            ((HttpServletRequest) request).getSession().setAttribute(Const.SHOP_CURRENT_USER, myShopUser);
        }
        return true;
    }
}
