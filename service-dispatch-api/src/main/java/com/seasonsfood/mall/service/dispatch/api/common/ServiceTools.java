package com.seasonsfood.mall.service.dispatch.api.common;

import java.util.List;
import java.util.UUID;

public class ServiceTools {

    /**
     * 生成主键id
     * @return
     */
    public static Long serviceUUID16(){
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0){//有可能是负数
            hashCodeV = - hashCodeV;
        }
        //         0 代表前面补充0
        //         4 代表长度为4
        //         d 代表参数为正数型
        return Long.valueOf((machineId+ String.format("%015d", hashCodeV)));
    }

    /**
     * 验证列表集合
     * @param list
     * @return
     */
    public static boolean listHasData(List<?> list) {
        boolean ret = false;
        if (list != null && !list.isEmpty()) {
            ret = true;
        }
        return ret;
    }

}
