package com.seasonsfood.mall.business.mapper;

import com.seasonsfood.mall.business.api.domain.ShopBaseInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

/**
 * @author ron
 */
public interface ShopBaseInfoMapper extends Mapper<ShopBaseInfo> {

    ShopBaseInfo findShopBaseInfoByUserId(Long transferId);

    /**
     * 提现指定金额
     * @param money
     * @return
     */
    Integer withdrawMoney(@Param("shopBaseId") Long shopBaseId,@Param("money")  BigDecimal money);
}