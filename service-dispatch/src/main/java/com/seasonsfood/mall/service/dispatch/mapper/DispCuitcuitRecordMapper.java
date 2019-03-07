package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRecord;
import com.seasonsfood.mall.service.dispatch.api.result.FontUserOrderInfo;
import com.seasonsfood.mall.service.dispatch.api.result.TodayDispCircuitRecordList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DispCuitcuitRecordMapper extends Mapper<DispCircuitRecord> {
    /**
     * jcw
     * 查询今日配送线路列表
     * @param time     查询时间
     * @return
     */
    List<TodayDispCircuitRecordList> selectTodayDispCircuitRecord(@Param("time")String time);

  //  Integer countDispCircuitRecord(@Param("time")String time);
    /**jcw
     * 修改当日配送顺序
     * @param dispatchId 配送员
     * @param time 当前时间
     * @return
     */
    Integer updateTodayDispOrderly(@Param("dispatchId")Long dispatchId,@Param("dispOrderly")Integer dispOrderly,@Param("time")String time);

    /**jcw
     * 查看配送员今日配送的订单并通过订单离起点的距离排序
     * @param dispatchId 配送员ID
     * @param lng 起点经度
     * @param lat 起点纬度
     * @return
     */
    List<FontUserOrderInfo> selectOrderByDelivery(@Param("dispatchId")Long dispatchId,@Param("lng") Double lng,@Param("lat") Double lat);

    /**jcw
     * 查找用户名和电话
     * @param userId 用户ID
     * @return
     */
    FontUserOrderInfo selectFontUserInfo(@Param("userId")Long userId);

}
