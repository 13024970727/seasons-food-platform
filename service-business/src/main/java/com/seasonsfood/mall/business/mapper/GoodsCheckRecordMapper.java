package com.seasonsfood.mall.business.mapper;

import com.seasonsfood.mall.business.api.domain.GoodsCheckRecord;
import com.seasonsfood.mall.business.api.model.GoodsInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsCheckRecordMapper extends Mapper<GoodsCheckRecord> {

    //根据商品id找到所有库存不会0的寄存记录
    List<GoodsCheckRecord> selectByGoodsId(Long goodsId);

    GoodsCheckRecord selectById(Long id);

    /**
     * 查出商品的所属分类和商品的所属商店
     * @param goodsId
     * @return
     */
    GoodsInfo selectGoodsInfo(Long goodsId);
    /**jcw
     * 通过编号查用户名
     * @param id
     * @return
     */
    String findSysUserName(Long id);

    /**jcw
     * 通过用户名查编号
     * @param sysUserName
     * @return
     */
    Long findSysUserId(String sysUserName);

}
