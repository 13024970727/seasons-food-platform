package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DispCircuitMapper extends Mapper<DispCircuit> {
    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:32
     * @methodExplain： 修改永久配送顺序
     * @param dispatchId 配送员
     * @param  dispatchOrderly 配送顺序
     * @return：
     */
    Integer updateDispOrderly(@Param("dispatchId")Long dispatchId, @Param("dispatchOrderly")Integer dispatchOrderly);

    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:32
     * @methodExplain： 修改永久线路顺序
     * @param circuitId 配送员
     * @param  circuitOrderly 配送顺序
     * @return：
     */
    Integer updateCircuitOrderly(@Param("circuitId")Long circuitId, @Param("circuitOrderly")Integer circuitOrderly);

    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:31
     * @methodExplain： 查看永久配送线路列表
     * @param stateId
     * @return：
     */
    List<DispCircuit> selectDispCircuit( @Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize,@Param("stateId")Integer stateId);

    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:31
     * @methodExplain： 永久配送线路列表信息总条数
     * @param stateId
     * @return：
     */
    Integer countDispCircuit(@Param("stateId")Integer stateId);

    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:31
     * @methodExplain： 更换配送员或者选择配送员（无配送员的订单）
     * @param orderId 订单id
     * @param dispatchId 配送员id
     * @param dispCircuitId 线路id
     * @return：
     */
    Integer updateDelivery(@Param("orderId")Long orderId,@Param("dispatchId")Long dispatchId, @Param("dispCircuitId")Long dispCircuitId);

    /**
     * @param
     * @author jiangchengwei
     * @date: 2019/3/14-10:28
     * @methodExplain： 统计启用的线路数量
     * @return： java.lang.Integer
     */
    Integer countCircuitNum();
}
