package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.Goods;
import com.seasonsfood.mall.business.api.domain.GoodsCategory;
import com.seasonsfood.mall.business.api.domain.GoodsCategoryHasGoods;
import com.seasonsfood.mall.business.api.service.GoodsService;
import com.seasonsfood.mall.business.mapper.GoodsCategoryHasGoodsMapper;
import com.seasonsfood.mall.business.mapper.GoodsCategoryMapper;
import com.seasonsfood.mall.business.mapper.GoodsMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author zhaozhirong
 * @Date 2018/12/8 9:28
 */
@Component
@Service(interfaceClass = GoodsService.class)
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
    @Resource
    private GoodsCategoryHasGoodsMapper goodsCategoryHasGoodsMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    /**
     *
     * @param goods                 商品信息
     * @param goodsCategoryHasGoods 商品类别和店铺信息
     * @return
     */
    @Override
    public ResponseCode addNewGoods(Goods goods, GoodsCategoryHasGoods goodsCategoryHasGoods) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(goodsCategoryHasGoods.getGoodsCategoryId());
        //判断商品所属分类，第四级
        if (!GoodsCategory.LEVEL_FOUR.equals(goodsCategory.getLevel())) {
            return ResponseCode.GOODS_CATEGORY_ERROR;
        }
        goods.setChangePrice(goods.getCurrentPrice());
        goods.setCreateTime(new Date());
        Integer count = goodsMapper.insertSelective(goods);
        if (count == 1) {
            goodsCategoryHasGoods.setGoodsId(goods.getId());
            //插入商品类别
            Integer count2 = goodsCategoryHasGoodsMapper.insertSelective(goodsCategoryHasGoods);
            if (count2 != 1) {
                throw new BizException("插入商品类别信息失败");
            }
            return ResponseCode.SUCCESS;
        }
        return ResponseCode.MODIFY_ERROR;
    }

    /**
     *
     * @param goods 只更新价格和库存以及是否上架
     * @return
     */
    @Override
    public ResponseCode updateGoodsByShop(Goods goods) {
        Goods updateGoods = new Goods();
        updateGoods.setId(goods.getId());
        updateGoods.setChangePrice(goods.getChangePrice());
        updateGoods.setStockQuantity(goods.getStockQuantity());
        if (goods.getOnSale() != null) {
            updateGoods.setOnSale(goods.getOnSale());
        }
        Integer count = mapper.updateByPrimaryKeySelective(updateGoods);
        return ResponseCode.SUCCESS;
    }

    @Override
    public void updateAllGoodsPrice() {
        goodsMapper.updateAllGoodsPrice();
    }

    @Override
    public ResponseCode updateGoodsByAdmin(Goods goods) {
        if (goods.getId() == null) {
            return ResponseCode.PARAMS_ERROR;
        }
        Integer count = mapper.updateByPrimaryKeySelective(goods);
        return ResponseCode.SUCCESS;
    }
}