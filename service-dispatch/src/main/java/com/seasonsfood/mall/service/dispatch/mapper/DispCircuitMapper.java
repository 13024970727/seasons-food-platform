package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DispCircuitMapper extends Mapper<DispCircuit> {
    /**jcw
     * 修改永久配送顺序
     * @param dispatchId 配送员
     * @param  dispatchOrderly 配送顺序
     * @return
     */
    Integer updateDispOrderly(@Param("dispatchId")Long dispatchId, @Param("dispatchOrderly")Integer dispatchOrderly);

    /**jcw
     * 查看永久配送线路列表
     * @param stateId
     * @return
     */
    List<DispCircuit> selectDispCircuit( @Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize,@Param("stateId")Integer stateId);

    /**jcw
     *永久配送线路列表信息总条数
     * @param stateId
     * @return
     */
    Integer countDispCircuit(@Param("stateId")Integer stateId);

    /**
     * 选择配送员或更改配送员
     * @param orderId 订单id
     * @param dispatchId 配送员id
     * @param dispCircuitId 线路id
     * @return
     */
    Integer updateDelivery(@Param("orderId")Long orderId,@Param("dispatchId")Long dispatchId, @Param("dispCircuitId")Long dispCircuitId);
}
