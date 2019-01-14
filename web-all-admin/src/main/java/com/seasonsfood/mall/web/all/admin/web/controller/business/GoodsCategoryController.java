package com.seasonsfood.mall.web.all.admin.web.controller.business;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.GoodsCategory;
import com.seasonsfood.mall.business.api.service.GoodsCategoryService;
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
@RequestMapping("goodsCategory")
public class GoodsCategoryController {

    @Reference(check = false)
    private GoodsCategoryService goodsCategoryService;

    @PostMapping(value = "/add")
    public Object add(GoodsCategory goodsCategory, HttpServletRequest request) {
        Assert.hasText(goodsCategory.getCategoryName(), "类别名称不能为空");
        //查询商品父类别信息
        if (goodsCategory.getParentId() != null) {
            GoodsCategory pGoodCategory = goodsCategoryService.selectByPrimaryKey(goodsCategory.getParentId());
            if (pGoodCategory == null || pGoodCategory.getLevel() == null) {
                throw new BizException(ResponseCode.PARAMS_ERROR);
            }
            //判断新类别是否在1到4级内
            Integer level = pGoodCategory.getLevel() + 1;
            if (level < GoodsCategory.LEVEL_TWO || level > GoodsCategory.LEVEL_FOUR) {
                throw new BizException(ResponseCode.DATA_ERROR);
            }
            goodsCategory.setLevel(level);
            if (GoodsCategory.LEVEL_FOUR.equals(level)) {
                Assert.hasText(goodsCategory.getCategoryName(), "商品类别名称不能为空");
                Assert.hasText(goodsCategory.getPictureUrl(), "商品主图不能为空");
                Assert.notNull(goodsCategory.getPrice(), "商品价格不能为空");
                Assert.notNull(goodsCategory.getUpLimit(), "商品分拣上限不能为空");
                Assert.notNull(goodsCategory.getDownLimit(), "商品分拣下限不能为空");
                Assert.notNull(goodsCategory.getCategoryWeightParams(), "商品系数不能为空");
            }
        }
        ResponseCode responseCode = goodsCategoryService.addNewGoodsCategory(goodsCategory);
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }


}
