package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.GoodsStockOutRecord;
import com.seasonsfood.mall.business.api.result.GoodsStockOutRecordResult;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

public interface GoodsStockOutRecordService extends BaseService<GoodsStockOutRecord> {
    /**jcw
     *查看出入库记录
     * @param type
     * @param pageNum
     * @param pageSize
     * @param timeA
     * @param timeB
     * @param sysUserName
     * @return
     */
    ListResponse<GoodsStockOutRecord> selecGoodsStockOutRecord (String type, Integer pageNum, Integer pageSize , String timeA, String timeB, String sysUserName);

    /**jcw
     *查找记录类型
     * @return
     */
    List<GoodsStockOutRecordResult> selecGoodsStockOutRecordType ();


}
