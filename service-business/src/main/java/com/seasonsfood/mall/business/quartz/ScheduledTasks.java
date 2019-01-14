package com.seasonsfood.mall.business.quartz;

import com.seasonsfood.mall.business.api.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
/**
* @Author zhaozhirong
* @Date  14:18
*
*/
//@RequestMapping(value = "/")
//@RestController
//@Component
//@Configurable
//@EnableScheduling
public class ScheduledTasks {

    @Resource
    GoodsService goodsService;
    /*
    五秒执行一次
    @Scheduled(cron = "0/20 * *  * * ? ")
    每天晚上01:01:00定时
   @Scheduled(cron = "0 1 1 * * ?")
   */

    /**
     * 每天晚上01:01:00定时更新商品价格.
     *
     * @param
     * @return void
     */
    @Scheduled(cron = "0 1 1 * * ?")
    public void executeRecruitmentStatisticByCron() {

        goodsService.updateAllGoodsPrice();

    }


    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

}
