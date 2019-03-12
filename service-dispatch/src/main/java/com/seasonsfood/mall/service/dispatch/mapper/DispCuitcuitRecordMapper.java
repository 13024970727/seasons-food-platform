package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRecord;
import com.seasonsfood.mall.service.dispatch.api.param.ParamDeliveryOrederInfo;
import com.seasonsfood.mall.service.dispatch.api.result.DeliveryOrederInfo;
import com.seasonsfood.mall.service.dispatch.api.result.FontUserOrderInfo;
import com.seasonsfood.mall.service.dispatch.api.result.TodayDispCircuitRecordList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DispCuitcuitRecordMapper extends Mapper<DispCircuitRecord> {
    /**
     * @param time 查询时间
     * @author jiangchengwei
     * @date: 2019/3/11-11:40
     * @methodExplain： 查询今日配送线路列表
     * @return：
     */
    List<TodayDispCircuitRecordList> selectTodayDispCircuitRecord(@Param("time") String time);

    /**
     * @param dispatchId 配送员
     * @param time       当前时间
     * @author jiangchengwei
     * @date: 2019/3/11-11:40
     * @methodExplain： 修改当日配送顺序
     * @return：
     */
    Integer updateTodayDispOrderly(@Param("dispatchId") Long dispatchId, @Param("dispOrderly") Integer dispOrderly, @Param("time") String time);

    /**
     * @param dispatchId
     * @author jiangchengwei
     * @date: 2019/3/11-16:56
     * @methodExplain： 统计未分配订单
     * @return：
     */
    int selectNoDeliveryNum(@Param("dispatchId")Long dispatchId);

    /**
     * @param dispatchId 配送员ID
     * @param lng        起点经度
     * @param lat        起点纬度
     * @author jiangchengwei
     * @date: 2019/3/11-11:40
     * @methodExplain： 查看配送员今日配送的订单并通过订单离起点的距离排序
     * @return：
     */
    List<FontUserOrderInfo> selectOrderByDelivery(@Param("dispatchId") Long dispatchId, @Param("lng") Double lng, @Param("lat") Double lat);

    /**
     * @param userId 用户ID
     * @author jiangchengwei
     * @date: 2019/3/11-11:39
     * @methodExplain： 查找用户名和电话
     * @return：
     */
    FontUserOrderInfo selectFontUserInfo(@Param("userId") Long userId);

    /**
     * @param deliveryUserId 派送员ID
     * @author jiangchengwei
     * @date: 2019/3/11-11:39
     * @methodExplain： 查找派送员姓名
     * @return：
     */
    String selectdispatchName(@Param("deliveryUserId") Long deliveryUserId);

    /**
     * @param paramDeliveryOrederInfo 搜索条件
     * @author jiangchengwei
     * @date: 2019/3/8-9:59
     * @methodExplain： 查看今日配送订单列表
     * @return：
     */
    List<DeliveryOrederInfo> selectDeliveryOrederInfo(ParamDeliveryOrederInfo paramDeliveryOrederInfo);
}
