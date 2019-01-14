package com.seasonsfood.mall.web.marketing.web.controller.discount;

import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chooseGoods")
public class ChooseDiscountGoodsController {
    /**
     * 获得商铺列表
     * @param shopName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "/shopList")
    public JsonResponse findShopList(String shopName,Integer pageNum,Integer pageSize) {

        if (pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=5;
        }

        return ResponseUtils.setSuccess();
    }

    /**
     * 获得商品列表
     * @param goodName
     * @param deliveryType 0已上架/1未上架
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "/goodList")
    public JsonResponse findGoodList(String goodName,Short deliveryType,Integer pageNum,Integer pageSize) {
        if(deliveryType==null){
            deliveryType=0;
        }
        if (pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=5;
        }

        return ResponseUtils.setSuccess();
    }

    /**
     * 获得分类列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "/classifyList")
    public JsonResponse findClassifyList(String classifyName,Integer pageNum,Integer pageSize) {
        if (pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=5;
        }

        return ResponseUtils.setSuccess();
    }


}
