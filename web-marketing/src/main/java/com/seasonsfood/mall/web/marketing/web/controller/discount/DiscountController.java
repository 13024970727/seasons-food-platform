package com.seasonsfood.mall.web.marketing.web.controller.discount;

import com.alibaba.dubbo.common.utils.Assert;
import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import com.sessonsfood.mall.marketing.api.domain.MarketingDiscount;
import com.sessonsfood.mall.marketing.api.service.MarketingDiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("discount")
public class DiscountController {

    @Reference(check = false)
    private MarketingDiscountService marketingDiscountService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 通过条件查找折扣活动
     * return 折扣列表
     */
    @PostMapping(value = "/list")
    public JsonResponse findDiscountByCondition(MarketingDiscount marketingDiscount, Integer pageNum, Integer pageSize) {
        if (null == marketingDiscount.getDiscountStatus()) {
            marketingDiscount.setDiscountStatus(0);
        }

        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = 10;
        }
        return ResponseUtils.setSuccess();
    }

    /**
     * 编辑修改折扣
     *
     * @param
     * @return 当前id折扣
     */

    @PostMapping(value = "/update")
    public JsonResponse updateDisCount(MarketingDiscount marketingDiscoun, List<Integer> idList) {
        try {
            if (marketingDiscoun.getId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "id不能为空");
            }
            if (marketingDiscoun.getSpendingParty() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "费用支出方不能为空");
            }
            if ((marketingDiscoun.getPlatformPay() + marketingDiscoun.getPlatformPay()) != 100) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.PARAMS_ERROR, "请核对支出百分比");
            }
            if (marketingDiscoun.getDiscountName() == null || "".equals(marketingDiscoun.getDiscountName())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "活动名称不能为空");
            }
            if (marketingDiscoun.getDiscountContent() == null || "".equals(marketingDiscoun.getDiscountContent())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "描述不能为空");
            }
            if (marketingDiscoun.getDiscountStartTime() == null || "".equals(marketingDiscoun.getDiscountStartTime())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择活动开始时间");
            }
            if (marketingDiscoun.getDiscountEndTime() == null || "".equals(marketingDiscoun.getDiscountEndTime())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择活动结束时间");
            }
            if (marketingDiscoun.getAstrictNum() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请填写限购数量");
            }
            if (marketingDiscoun.getDiscountNumber() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请填写折扣数");
            }
            if (marketingDiscoun.getChoiceDiscountRange() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "折扣使用范围不能为空");
            }
            marketingDiscoun.setCreateTime(new Date());


        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
        return ResponseUtils.setSuccess();
    }

    /**
     * 使失效
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/invalidate")
    public JsonResponse invalidateDiscount(Long id) {
        try {
            MarketingDiscount marketingDiscount = new MarketingDiscount();
            marketingDiscount.setId(id);

            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setJsonAndMsg(ResponseCode.DELETE_ERROR, "操做失败");
        }

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/delete")
    public JsonResponse deleteDiscount(Long id) {

        try {
            MarketingDiscount marketingDiscount = new MarketingDiscount();
            marketingDiscount.setId(id);

            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }

    }

    /**
     * 创建折扣
     *
     * @param marketingDiscoun
     * @param idList           //商品id、商店、类别列表
     * @return
     */

    @PostMapping(value = "/add")
    public JsonResponse addDiscount(MarketingDiscount marketingDiscoun, List<Integer> idList) {
        try {

            if (marketingDiscoun.getSpendingParty() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "费用支出方不能为空");
            }
            if (marketingDiscoun.getPlatformPay() + marketingDiscoun.getPlatformPay() == 100) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.PARAMS_ERROR, "请核对支出百分比");
            }
            if (marketingDiscoun.getDiscountName() == null || "".equals(marketingDiscoun.getDiscountName())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "活动名称不能为空");
            }
            if (marketingDiscoun.getDiscountContent() == null || "".equals(marketingDiscoun.getDiscountContent())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "描述不能为空");
            }
            if (marketingDiscoun.getDiscountStartTime() == null || "".equals(marketingDiscoun.getDiscountStartTime())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择活动开始时间");
            }
            if (marketingDiscoun.getDiscountEndTime() == null || "".equals(marketingDiscoun.getDiscountEndTime())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择活动结束时间");
            }
            if (marketingDiscoun.getAstrictNum() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请填写限购数量");
            }
            if (marketingDiscoun.getDiscountNumber() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请填写折扣数");
            }
            if (marketingDiscoun.getChoiceDiscountRange() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "折扣使用范围不能为空");
            }
            marketingDiscoun.setCreateTime(new Date());


        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
        return ResponseUtils.setSuccess();
    }


    /**
     * 根据id获取活动信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "info")
    public Object getAdvertiseInfo(Integer id) {
        Assert.notNull(id, "折扣编号不能为空");
        //通过id查找折扣信息
        MarketingDiscount marketingDiscount = null;
        Assert.notNull(marketingDiscount, "当前折扣不存在");

        return ResponseUtils.setSuccess(marketingDiscount);
    }

}
