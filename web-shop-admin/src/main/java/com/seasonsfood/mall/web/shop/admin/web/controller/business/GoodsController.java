package com.seasonsfood.mall.web.shop.admin.web.controller.business;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.Goods;
import com.seasonsfood.mall.business.api.domain.GoodsCategoryHasGoods;
import com.seasonsfood.mall.business.api.service.GoodsService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import com.seasonsfood.mall.util.util.Assert;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhaozhirong
 * @Date 2018/12/7 11:22
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Reference(check = false)
    private GoodsService goodsService;

    //  @RequiresPermissions("goods:add")
//    @PostMapping(value = "/add")
//    public Object add(Goods goods, GoodsCategoryHasGoods goodsCategoryHasGoods, HttpServletRequest request) {
//        Assert.notNull(goodsCategoryHasGoods.getGoodsCategoryId(), "商品类别不能为空");
//        Assert.notNull(goodsCategoryHasGoods.getShopBaseInfoId(), "所属商家不能为空");
//        Assert.hasText(goods.getGoodsName(), "商品名称不能为空");
//        Assert.notNull(goods.getCurrentPrice(), "商品单价不能为空");
//        Assert.notNull(goods.getUnitNumber(), "商品单位数量不能为空");
//        Assert.hasText(goods.getUnitSpecification(), "商品规格不能为空");
//        Assert.notNull(goods.getWeightParams(), "商品重量系数不能为空");
//
//        ResponseCode responseCode = goodsService.addNewGoods(goods, goodsCategoryHasGoods);
//        if (!ResponseCode.SUCCESS.equals(responseCode)) {
//            throw new BizException(responseCode);
//        }
//        return ResponseUtils.setSuccess(responseCode);
//    }

    @PostMapping(value = "/update/shop")
    public Object shopUpdateGoods(Goods goods, HttpServletRequest request) {
        Assert.notNull(goods.getId(), "商品编号不能为空");
        Assert.notNull(goods.getChangePrice(), "商品单价不能为空");
        Assert.notNull(goods.getStockQuantity(), "商品库存不能为空");
        Assert.notNull(goods.getOnSale(), "商品是否上架不能为空");
        ResponseCode responseCode = goodsService.updateGoodsByShop(goods);
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }


}
