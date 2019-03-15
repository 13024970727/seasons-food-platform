package com.seasonsfood.mall.business.mapper;

import com.seasonsfood.mall.business.api.domain.GoodsCheckRecord;
import com.seasonsfood.mall.business.api.model.GoodsInfo;
import com.seasonsfood.mall.business.api.model.SelectGoodScheckRecordParam;
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

    /**
     * @author jiangchengwei
     * @date: 2019/3/12-16:16
     * @methodExplain：
     * @param selectGoodScheckRecordParam goodsName 商品名称 shopName   店铺名称 categoryName 分类  saveStateId  库存状态
     *   stateID 展示状态 startTime;//起始时间 endTime;//结束时间
     * @return：
     */
    List<GoodsCheckRecord> selectGoodScheckRecord(SelectGoodScheckRecordParam selectGoodScheckRecordParam);
}
