package com.seasonsfood.mall.web.portal.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.business.api.domain.Tag;
import com.seasonsfood.mall.business.api.domain.TagHasGoods;
import com.seasonsfood.mall.business.api.service.TagHasGoodsService;
import com.seasonsfood.mall.business.api.service.TagService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ron
 */
@RequestMapping("Tag")
@RestController
public class TagController {
    @Reference(check = false)
    private TagService tagService;
    @Reference(check = false)
    private TagHasGoodsService tagHasGoodsService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * jcw
     * 新增标签
     *
     * @param tag
     * @return
     */
    @PostMapping(value = "addTag")
    public JsonResponse addTag(Tag tag) {
        try {
            if (tag.getTagName() == null || "".equals(tag.getTagName())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "标签名称不能为空", true);
            }
            if (tag.getStateId() == null) {
                //启用状态
                tag.setStateId(1);
            }
            int count = tagService.save(tag);
            if (count > 0) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
            }
        } catch (Exception e) {
            logger.error("addVillage:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);

        }

    }

    /**
     * 查找有哪些标签
     *
     * @param tag
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "selectTag")
    public JsonResponse selectTag(Tag tag, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        if (tag.getStateId() == null) {
            tag.setStateId(1);
        }
        return ResponseUtils.setSuccess(tagService.selectTag(tag, pageNum, pageSize));

    }

    /**
     * 为商品添加标签
     *
     * @param tagHasGoods
     * @return
     */
    @PostMapping(value = "addDoodsTag")
    public JsonResponse addDoodsTag(TagHasGoods tagHasGoods) {
        try {
            if (tagHasGoods.getTagId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "标签不能为空", true);
            }
            if (tagHasGoods.getGoodsId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "商品不能为空", true);
            }
            List<TagHasGoods> tagHasGoodsList = tagHasGoodsService.select(tagHasGoods);
            if (tagHasGoodsList.size() > 0) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "标签已存在", true);
            }
            if (tagHasGoodsList.size() <= 0) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "标签不存在", true);
            }
            int count = tagHasGoodsService.save(tagHasGoods);
            if (count > 0) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
            }
        } catch (Exception e) {
            logger.error("addVillage:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);

        }

    }

    /**
     * 查看商品有哪些标签
     *
     * @param tagHasGoods
     * @return
     */
    @PostMapping(value = "selectGoodsTag")
    public JsonResponse selectGoodsTag(TagHasGoods tagHasGoods) {
        if (tagHasGoods.getGoodsId() == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "商品不能为空", true);
        }
        List<TagHasGoods> tagList = tagHasGoodsService.selectTagId(tagHasGoods);
        if (tagList.size() <= 0) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "该商品没有标签", true);
        }
        return ResponseUtils.setSuccess(tagHasGoodsService.selectGoodsTag(tagList));

    }

    /**
     * 统计此标签有哪些商品
     *
     * @param tagHasGoods
     * @return
     */
    @PostMapping(value = "countGoodsTag")
    public JsonResponse countGoodsTag(TagHasGoods tagHasGoods) {
        if (tagHasGoods.getTagId() == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "标签不能为空", true);
        }
        List<TagHasGoods> tagHasGoodsList = tagHasGoodsService.selectGoodsId(tagHasGoods);
        if (tagHasGoodsList.size() <= 0) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "该标签没有商品", true);
        }
        return ResponseUtils.setSuccess(tagHasGoodsService.selectGoods(tagHasGoodsList));
    }
    /**
     * 统计此标签有哪些商品
     *
     * @param tag
     * @return
     */
    @PostMapping(value = "countGoodsTagInfo")
    public JsonResponse countGoodsTagInfo(Tag tag, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        if (tag.getStateId() == null) {
            tag.setStateId(1);
        }
       return ResponseUtils.setSuccess( tagService.countGoodsTagInfo(tag,  pageNum, pageSize));
    }
    /**
     * 修改标签信息
     *
     * @param tag
     * @return
     */
    @PostMapping(value = "updateTag")
    public JsonResponse updateTag(Tag tag) {
        try{
        if (tag.getId() == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "标签不能为空", true);
        }
            int i=tagService.updateSelective(tag);
        if (i > 0) {
            return ResponseUtils.setSuccess();
        } else {
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "修改失败", true);
        }
    } catch (Exception e) {
        logger.error("updateTag:" + e.getMessage());
        return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "修改失败", true);
    }
    }
}
