package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.business.api.domain.*;
import com.seasonsfood.mall.business.api.model.GoodsInfo;
import com.seasonsfood.mall.business.api.result.CheckList;
import com.seasonsfood.mall.business.api.result.CheckParticulars;
import com.seasonsfood.mall.business.api.service.GoodsCheckRecordService;
import com.seasonsfood.mall.business.mapper.*;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Service(interfaceClass = GoodsCheckRecordService.class)
public class GoodsCheckRecordServiceImpl extends BaseServiceImpl<GoodsCheckRecord> implements GoodsCheckRecordService {
    @Resource
    GoodsCheckRecordMapper goodsCheckRecordMapper;
    @Resource
    GoodsStockOutRecordMapper goodsStockOutRecordMapper;
    @Resource
    GoodsMeteringUnitMapper goodsMeteringUnitMapper;
    @Resource
    GoodsConsignmentWarehouseMapper goodsConsignmentWarehouseMapper;
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    ShopBaseInfoMapper shopBaseInfoMapper;
    @Resource
    GoodsCategoryHasGoodsMapper goodsCategoryHasGoodsMapper;
    @Resource
    GoodsCategoryMapper goodsCategoryMapper;


    //@Transactional
    @Override
    public ResponseCode addCheckRecord(GoodsCheckRecord goodsCheckRecord, String remark) {
        try {
            goodsCheckRecordMapper.insertSelective(goodsCheckRecord);
            GoodsStockOutRecord goodsStockOutRecord = new GoodsStockOutRecord();
            goodsStockOutRecord.setWriteTime(goodsCheckRecord.getWarehouseEntryTime());
            goodsStockOutRecord.setType((byte) 1);
            goodsStockOutRecord.setNumber(goodsCheckRecord.getQuantityInStock());
            goodsStockOutRecord.setExecutorId(goodsCheckRecord.getResponsiblePersonId());
            goodsStockOutRecord.setCheckId(goodsCheckRecord.getId());
            goodsStockOutRecord.setRemark(remark);
            goodsStockOutRecordMapper.insert(goodsStockOutRecord);
            return ResponseCode.SUCCESS;
        } catch (Exception e) {
            return ResponseCode.ADD_ERROR;

        }
    }

    @Override
    public ResponseCode sell(Long goodsId, BigDecimal number) {
        try {
            List<GoodsCheckRecord> GoodsCheckRecordList = goodsCheckRecordMapper.selectByGoodsId(goodsId);
            for (int i = 0; i < GoodsCheckRecordList.size(); i++) {
                if (number.compareTo(BigDecimal.valueOf(0)) == 0) {
                    break;
                }
                if (number.compareTo(GoodsCheckRecordList.get(i).getQuantityInStock()) == -1 || number.compareTo(GoodsCheckRecordList.get(i).getQuantityInStock()) == 0) {
                    GoodsCheckRecordList.get(i).setQuantityInStock(GoodsCheckRecordList.get(i).getQuantityInStock().subtract(number));
                    //判断库存数量是否低于预警数量
                    BigDecimal quantityInStock = GoodsCheckRecordList.get(i).getQuantityInStock();//库存数量
                    BigDecimal quantityWarning = GoodsCheckRecordList.get(i).getQuantityWarning();//预警数量
                    if (quantityWarning.compareTo(quantityInStock) == 1) {
                        GoodsCheckRecordList.get(i).setSaveStateId(2);
                    } else {
                        GoodsCheckRecordList.get(i).setSaveStateId(1);
                    }

                    goodsCheckRecordMapper.updateByPrimaryKeySelective(GoodsCheckRecordList.get(i));
                    GoodsStockOutRecord goodsStockOutRecord = new GoodsStockOutRecord();
                    goodsStockOutRecord.setWriteTime(new Date());
                    goodsStockOutRecord.setType((byte) 2);
                    goodsStockOutRecord.setNumber(number);
                    //获取当前分拣员id
                    goodsStockOutRecord.setExecutorId(Long.valueOf(10002));
                    goodsStockOutRecord.setCheckId(GoodsCheckRecordList.get(i).getId());
                    String remark = "向某某订单出售了" + number;
                    goodsStockOutRecord.setRemark(remark);
                    goodsStockOutRecordMapper.insert(goodsStockOutRecord);
                    number = BigDecimal.valueOf(0);


                } else {
                    number = number.subtract(GoodsCheckRecordList.get(i).getQuantityInStock());

                    GoodsStockOutRecord goodsStockOutRecord = new GoodsStockOutRecord();
                    goodsStockOutRecord.setWriteTime(new Date());
                    goodsStockOutRecord.setType((byte) 2);
                    goodsStockOutRecord.setNumber(GoodsCheckRecordList.get(i).getQuantityInStock());
                    //获取当前分拣员id
                    goodsStockOutRecord.setExecutorId(Long.valueOf(10002));
                    goodsStockOutRecord.setCheckId(GoodsCheckRecordList.get(i).getId());
                    String remark = "向某某订单出售了" + GoodsCheckRecordList.get(i).getQuantityInStock();
                    goodsStockOutRecord.setRemark(remark);
                    GoodsCheckRecordList.get(i).setQuantityInStock(BigDecimal.valueOf(0));
                    //判断库存数量是否低于预警数量
                    BigDecimal quantityInStock = GoodsCheckRecordList.get(i).getQuantityInStock();//库存数量
                    BigDecimal quantityWarning = GoodsCheckRecordList.get(i).getQuantityWarning();//预警数量
                    if (quantityWarning.compareTo(quantityInStock) == 1) {
                        GoodsCheckRecordList.get(i).setSaveStateId(2);
                    } else {
                        GoodsCheckRecordList.get(i).setSaveStateId(1);
                    }


                    goodsCheckRecordMapper.updateByPrimaryKeySelective(GoodsCheckRecordList.get(i));
                    goodsStockOutRecordMapper.insert(goodsStockOutRecord);
                }
            }

            return ResponseCode.SUCCESS;
        } catch (Exception e) {
            return ResponseCode.OTHER_ERROR;

        }
    }

    @Override
    public ResponseCode sendBack(Long id, BigDecimal number, String remark) {
        try {
            GoodsCheckRecord goodsCheckRecord = goodsCheckRecordMapper.selectById(id);
            if (goodsCheckRecord.getQuantityInStock().compareTo(number) == -1) {
                return ResponseCode.DATA_ERROR;
            }
            goodsCheckRecord.setQuantityInStock(goodsCheckRecord.getQuantityInStock().subtract(number));
            goodsCheckRecordMapper.updateByPrimaryKeySelective(goodsCheckRecord);
            GoodsStockOutRecord goodsStockOutRecord = new GoodsStockOutRecord();
            goodsStockOutRecord.setWriteTime(new Date());
            goodsStockOutRecord.setType((byte) 4);
            goodsStockOutRecord.setNumber(number);
            //获取当前分拣员id
            goodsStockOutRecord.setExecutorId(Long.valueOf(10002));
            goodsStockOutRecord.setCheckId(goodsCheckRecord.getId());
            goodsStockOutRecord.setRemark(remark);
            goodsStockOutRecordMapper.insert(goodsStockOutRecord);
            return ResponseCode.SUCCESS;
        } catch (Exception e) {
            return ResponseCode.OTHER_ERROR;

        }
    }

    @Override
    public ResponseCode scrap(Long id, BigDecimal number, String remark) {
        try {
            GoodsCheckRecord goodsCheckRecord = goodsCheckRecordMapper.selectById(id);
            if (goodsCheckRecord.getQuantityInStock().compareTo(number) == -1) {
                return ResponseCode.DATA_ERROR;
            }
            goodsCheckRecord.setQuantityInStock(goodsCheckRecord.getQuantityInStock().subtract(number));
            goodsCheckRecordMapper.updateByPrimaryKeySelective(goodsCheckRecord);
            GoodsStockOutRecord goodsStockOutRecord = new GoodsStockOutRecord();
            goodsStockOutRecord.setWriteTime(new Date());
            goodsStockOutRecord.setType((byte) 3);
            goodsStockOutRecord.setNumber(number);
            //获取当前分拣员id
            goodsStockOutRecord.setExecutorId(Long.valueOf(10002));
            goodsStockOutRecord.setCheckId(goodsCheckRecord.getId());
            goodsStockOutRecord.setRemark(remark);
            goodsStockOutRecordMapper.insert(goodsStockOutRecord);
            return ResponseCode.SUCCESS;
        } catch (Exception e) {
            return ResponseCode.OTHER_ERROR;

        }
    }




    /**
     * jcw
     * 寄存商品列表
     *
     * @param goodsName  商品名称
     * @param shopName   店铺名称
     * @param categoryId 分类ID
     * @param stateId    库存状态
     * @param time       时间
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ListResponse<GoodsCheckRecord> selectGoodScheckRecord(String goodsName, String shopName, String goodsCategoryName, Integer categoryId, Integer stateId, Integer saveStateId, Date time, Integer pageNum, Integer pageSize) {
        if (goodsName != null) {
          /*  Integer pageNum1 = (2 - 1) * 2;
            Integer pageSize1 = 2;
            String shopName1="%" + shopName + "%";
            List<GoodsCheckRecord> goodsCheckRecord = goodsCheckRecordMapper.findCheckRecordByGoods(shopName1);
            List<CheckList> checkList = new ArrayList<>();
             System.out.println(goodsCheckRecord.size()+goodsCheckRecord.get(0).getId());*/
            PageInfo<Goods> pageInfo;
            PageHelper.startPage(pageNum,pageSize);
            Example example = new Example(Goods.class);
            Example.Criteria criteria = example.createCriteria();
            String goodsName1 = "%" + goodsName + "%";
            criteria.andLike("goodsName", goodsName1);
            //查出商品id
            example.selectProperties("id");
            pageInfo=new PageInfo<>(goodsMapper.selectByExample(example));
            List<CheckList> checkList = new ArrayList<>();

            for(int j=0;j<pageInfo.getList().size();j++){
                Example example1 = new Example(GoodsCheckRecord.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("stateId", 1);
                if (saveStateId==null){
                    saveStateId=1;
                }
                criteria1.andEqualTo("saveStateId", saveStateId);
                //通过商品id查出该商品的寄存记录
                criteria1.andEqualTo("goodsId", pageInfo.getList().get(j).getId());
                example1.selectProperties("id", "goodsId", "warehouseEntryTime", "warehouseId", "expirationDate", "quantityInStock", "unitId", "quantityWarning", "dateInProduced", "deadlineWarning");
                List<GoodsCheckRecord> goodsCheckRecord=goodsCheckRecordMapper.selectByExample(example1);
                //查出寄存商品的信息
                for (int i = 0; i < goodsCheckRecord.size(); i++) {

                    System.out.println(goodsCheckRecord.size());
                    CheckList checkListBean = new CheckList();
                    Long goodsId = goodsCheckRecord.get(i).getGoodsId();
                    System.out.println(goodsId);
                    //查出商品的所属分类和商品的所属商店
                    GoodsInfo goodsInfo = goodsCheckRecordMapper.selectGoodsInfo(goodsId);
                    Long responsiblePersonId = goodsCheckRecord.get(i).getResponsiblePersonId();
                    Date warehouseEntryTime = goodsCheckRecord.get(i).getWarehouseEntryTime();
                    Date now = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
                    String currentTime = dateFormat.format(now); //当前时间
                    String warehouseTime = dateFormat.format(warehouseEntryTime);  //入库时间
                    Long expirationDate = goodsCheckRecord.get(i).getExpirationDate();//保质期
                    Date dateInProduced = goodsCheckRecord.get(i).getDateInProduced();//生产日期
                    String dateInProduced1 = dateFormat.format(dateInProduced);//生产日期
                    Long deadlineWarning = goodsCheckRecord.get(i).getDeadlineWarning();//保质期预警天数
                    long day = 0;//已存时间
                    long sellByDate;//已过保质期天数
                    Long date = null;//剩余保质期天数
                    String warningMessage;//预警消息
                    try {
                        Date currentTime1 = dateFormat.parse(currentTime);//当前时间
                        Date warehouseTime1 = dateFormat.parse(warehouseTime);//入库时间
                        //获取相减后天数
                        day = (currentTime1.getTime() - warehouseTime1.getTime()) / (24 * 60 * 60 * 1000);
                        Date dateOfManufacture = dateFormat.parse(dateInProduced1);//生产日期
                        sellByDate = (currentTime1.getTime() - dateOfManufacture.getTime()) / (24 * 60 * 60 * 1000);
                        date = expirationDate / 2 - sellByDate;//剩余保质期天数
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (date <= deadlineWarning) {
                        warningMessage = "商品保质期即将过半";
                    } else {
                        warningMessage = "正常";
                    }
                    Integer warehouseId = goodsCheckRecord.get(i).getWarehouseId();//仓库ID
                    //查出仓库名称
                    GoodsConsignmentWarehouse goodsConsignmentWarehouse = goodsConsignmentWarehouseMapper.selectByPrimaryKey(warehouseId);
                    BigDecimal quantityInStock = goodsCheckRecord.get(i).getQuantityInStock();//库存数量
                    Integer unitId = goodsCheckRecord.get(i).getUnitId();
                    GoodsMeteringUnit goodsMeteringUnit = goodsMeteringUnitMapper.selectByPrimaryKey(unitId);

                    BigDecimal quantityWarning = goodsCheckRecord.get(i).getQuantityWarning();//预警数量
                    String warningMessage1;//预警消息
                    GoodsCheckRecord goodsCheckRecord1 = new GoodsCheckRecord();
                    goodsCheckRecord1.setId(goodsCheckRecord.get(i).getId());
                    if (quantityWarning.compareTo(quantityInStock) == 1) {
                        warningMessage1 = "库存数量不足";
                    } else {
                        warningMessage1 = "库存充足";
                    }
                    checkListBean.setId(goodsCheckRecord.get(i).getId());
                    checkListBean.setGoodsId(goodsId);
                    checkListBean.setGoodsName(goodsInfo.getGoodsName());
                    checkListBean.setShopName(goodsInfo.getShopName());
                    checkListBean.setCategoryName(goodsInfo.getCategoryName());
                    checkListBean.setUnitName(goodsMeteringUnit.getUnitName());
                    checkListBean.setQuantityInStock(quantityInStock);
                    checkListBean.setCountState(warningMessage1);
                    checkListBean.setExpirationDateState(warningMessage);
                    checkListBean.setSaveTime(day);
                    checkList.add(checkListBean);
                }
            }
            return new ListResponse(checkList.size(), pageNum, pageNum, checkList);
        }

        if (shopName != null) {
            PageInfo<ShopBaseInfo> pageInfo;
            PageHelper.startPage(pageNum, pageSize);
            Example example = new Example(ShopBaseInfo.class);
            Example.Criteria criteria = example.createCriteria();
            String shopName1 = "%" + shopName + "%";
            criteria.andLike("shopName", shopName1);
            //查出商店id
            example.selectProperties("id");
            pageInfo = new PageInfo<>(shopBaseInfoMapper.selectByExample(example));
            List<CheckList> checkList = new ArrayList<>();

            for (int j = 0; j < pageInfo.getList().size(); j++) {
                PageHelper.startPage(pageNum, 3);
                Example example1 = new Example(GoodsCategoryHasGoods.class);
                Example.Criteria criteria1 = example1.createCriteria();
                //通过商店id查出商店寄存的商品id
                criteria1.andEqualTo("shopBaseInfoId", pageInfo.getList().get(j).getId());
                PageInfo<GoodsCategoryHasGoods> shopPageInfo = new PageInfo<>(goodsCategoryHasGoodsMapper.selectByExample(example1));
                for (int z = 0; z < shopPageInfo.getList().size(); z++) {

                    if (saveStateId == null) {
                        saveStateId = 1;
                    }
                    Example example2 = new Example(GoodsCheckRecord.class);
                    Example.Criteria criteria2 = example2.createCriteria();
                    criteria2.andEqualTo("saveStateId", saveStateId);
                    criteria2.andEqualTo("goodsId", shopPageInfo.getList().get(z).getGoodsId());
                    example2.selectProperties("id", "goodsId", "warehouseEntryTime", "warehouseId", "expirationDate", "quantityInStock", "unitId", "quantityWarning", "dateInProduced", "deadlineWarning");
                    List<GoodsCheckRecord> goodsCheckRecord = goodsCheckRecordMapper.selectByExample(example2);
                    //查出寄存商品的信息
                    for (int i = 0; i < goodsCheckRecord.size(); i++) {
                        CheckList checkListBean = new CheckList();
                        Long goodsId = goodsCheckRecord.get(i).getGoodsId();
                        //查出商品的所属分类和商品的所属商店
                        GoodsInfo goodsInfo = goodsCheckRecordMapper.selectGoodsInfo(goodsId);
                        Long responsiblePersonId = goodsCheckRecord.get(i).getResponsiblePersonId();
                        Date warehouseEntryTime = goodsCheckRecord.get(i).getWarehouseEntryTime();
                        Date now = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
                        String currentTime = dateFormat.format(now); //当前时间
                        String warehouseTime = dateFormat.format(warehouseEntryTime);  //入库时间
                        Long expirationDate = goodsCheckRecord.get(i).getExpirationDate();//保质期
                        Date dateInProduced = goodsCheckRecord.get(i).getDateInProduced();//生产日期
                        String dateInProduced1 = dateFormat.format(dateInProduced);//生产日期
                        Long deadlineWarning = goodsCheckRecord.get(i).getDeadlineWarning();//保质期预警天数
                        long day = 0;//已存时间
                        long sellByDate;//已过保质期天数
                        Long date = null;//剩余保质期天数
                        String warningMessage;//预警消息
                        try {
                            Date currentTime1 = dateFormat.parse(currentTime);//当前时间
                            Date warehouseTime1 = dateFormat.parse(warehouseTime);//入库时间
                            //获取相减后天数
                            day = (currentTime1.getTime() - warehouseTime1.getTime()) / (24 * 60 * 60 * 1000);
                            Date dateOfManufacture = dateFormat.parse(dateInProduced1);//生产日期
                            sellByDate = (currentTime1.getTime() - dateOfManufacture.getTime()) / (24 * 60 * 60 * 1000);
                            date = expirationDate / 2 - sellByDate;//剩余保质期天数
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date <= deadlineWarning) {
                            warningMessage = "商品保质期即将过半";
                        } else {
                            warningMessage = "正常";
                        }
                        Integer warehouseId = goodsCheckRecord.get(i).getWarehouseId();//仓库ID
                        //查出仓库名称
                        GoodsConsignmentWarehouse goodsConsignmentWarehouse = goodsConsignmentWarehouseMapper.selectByPrimaryKey(warehouseId);
                        BigDecimal quantityInStock = goodsCheckRecord.get(i).getQuantityInStock();//库存数量
                        Integer unitId = goodsCheckRecord.get(i).getUnitId();
                        GoodsMeteringUnit goodsMeteringUnit = goodsMeteringUnitMapper.selectByPrimaryKey(unitId);

                        BigDecimal quantityWarning = goodsCheckRecord.get(i).getQuantityWarning();//预警数量
                        String warningMessage1;//预警消息
                        if (quantityWarning.compareTo(quantityInStock) == 1) {
                            warningMessage1 = "库存数量不足";
                        } else {
                            warningMessage1 = "库存充足";
                        }
                        checkListBean.setId(goodsCheckRecord.get(i).getId());
                        checkListBean.setGoodsId(goodsId);
                        checkListBean.setGoodsName(goodsInfo.getGoodsName());
                        checkListBean.setShopName(goodsInfo.getShopName());
                        checkListBean.setCategoryName(goodsInfo.getCategoryName());
                        checkListBean.setUnitName(goodsMeteringUnit.getUnitName());
                        checkListBean.setQuantityInStock(quantityInStock);
                        checkListBean.setCountState(warningMessage1);
                        checkListBean.setExpirationDateState(warningMessage);
                        checkListBean.setSaveTime(day);
                        checkList.add(checkListBean);
                    }
                }
            }
            return new ListResponse(checkList.size(), pageInfo.getPages(), pageInfo.getPageNum(), checkList);
        }

        if (goodsCategoryName != null) {
            PageInfo<GoodsCategory> pageInfo;
            PageHelper.startPage(pageNum, 1);
            Example example = new Example(GoodsCategory.class);
            Example.Criteria criteria = example.createCriteria();
            String categoryName = "%" + goodsCategoryName + "%";
            criteria.andLike("categoryName", categoryName);
            example.selectProperties("id");
            pageInfo = new PageInfo<>(goodsCategoryMapper.selectByExample(example));
            List<CheckList> checkList = new ArrayList<>();

            for (int j = 0; j < pageInfo.getList().size(); j++) {
                PageHelper.startPage(pageNum, 3);
                Example example1 = new Example(GoodsCategoryHasGoods.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("goodsCategoryId", pageInfo.getList().get(j).getId());
                PageInfo<GoodsCategoryHasGoods> shopPageInfo = new PageInfo<>(goodsCategoryHasGoodsMapper.selectByExample(example1));
                for (int z = 0; z < shopPageInfo.getList().size(); z++) {
                    if (saveStateId == null) {
                        saveStateId = 1;
                    }
                    Example example2 = new Example(GoodsCheckRecord.class);
                    Example.Criteria criteria2 = example2.createCriteria();
                    criteria2.andEqualTo("saveStateId", saveStateId);
                    criteria2.andEqualTo("goodsId", shopPageInfo.getList().get(z).getGoodsId());
                    //查出所需要的字段
                    example2.selectProperties("id", "goodsId", "warehouseEntryTime", "warehouseId", "expirationDate", "quantityInStock", "unitId", "quantityWarning", "dateInProduced", "deadlineWarning");
                    List<GoodsCheckRecord> goodsCheckRecord = goodsCheckRecordMapper.selectByExample(example2);

                    for (int i = 0; i < goodsCheckRecord.size(); i++) {
                        CheckList checkListBean = new CheckList();
                        Long goodsId = goodsCheckRecord.get(i).getGoodsId();
                        //查出商品的所属分类和商品的所属商店
                        GoodsInfo goodsInfo = goodsCheckRecordMapper.selectGoodsInfo(goodsId);
                        Long responsiblePersonId = goodsCheckRecord.get(i).getResponsiblePersonId();
                        Date warehouseEntryTime = goodsCheckRecord.get(i).getWarehouseEntryTime();
                        Date now = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
                        String currentTime = dateFormat.format(now); //当前时间
                        String warehouseTime = dateFormat.format(warehouseEntryTime);  //入库时间
                        Long expirationDate = goodsCheckRecord.get(i).getExpirationDate();//保质期
                        Date dateInProduced = goodsCheckRecord.get(i).getDateInProduced();//生产日期
                        String dateInProduced1 = dateFormat.format(dateInProduced);//生产日期
                        Long deadlineWarning = goodsCheckRecord.get(i).getDeadlineWarning();//保质期预警天数
                        long day = 0;//已存时间
                        long sellByDate;//已过保质期天数
                        Long date = null;//剩余保质期天数
                        String warningMessage;//预警消息
                        try {
                            Date currentTime1 = dateFormat.parse(currentTime);//当前时间
                            Date warehouseTime1 = dateFormat.parse(warehouseTime);//入库时间
                            //获取相减后天数
                            day = (currentTime1.getTime() - warehouseTime1.getTime()) / (24 * 60 * 60 * 1000);
                            Date dateOfManufacture = dateFormat.parse(dateInProduced1);//生产日期
                            sellByDate = (currentTime1.getTime() - dateOfManufacture.getTime()) / (24 * 60 * 60 * 1000);
                            date = expirationDate / 2 - sellByDate;//剩余保质期天数
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date <= deadlineWarning) {
                            warningMessage = "商品保质期即将过半";
                        } else {
                            warningMessage = "正常";
                        }
                        Integer warehouseId = goodsCheckRecord.get(i).getWarehouseId();//仓库ID
                        //查出仓库名称
                        GoodsConsignmentWarehouse goodsConsignmentWarehouse = goodsConsignmentWarehouseMapper.selectByPrimaryKey(warehouseId);
                        BigDecimal quantityInStock = goodsCheckRecord.get(i).getQuantityInStock();//库存数量
                        Integer unitId = goodsCheckRecord.get(i).getUnitId();
                        GoodsMeteringUnit goodsMeteringUnit = goodsMeteringUnitMapper.selectByPrimaryKey(unitId);
                        BigDecimal quantityWarning = goodsCheckRecord.get(i).getQuantityWarning();//预警数量
                        String warningMessage1;//预警消息
                        if (quantityWarning.compareTo(quantityInStock) == 1) {
                            warningMessage1 = "库存数量不足";
                        } else {
                            warningMessage1 = "库存充足";
                        }
                        checkListBean.setId(goodsCheckRecord.get(i).getId());
                        checkListBean.setGoodsId(goodsId);
                        checkListBean.setGoodsName(goodsInfo.getGoodsName());
                        checkListBean.setShopName(goodsInfo.getShopName());
                        checkListBean.setCategoryName(goodsInfo.getCategoryName());
                        checkListBean.setUnitName(goodsMeteringUnit.getUnitName());
                        checkListBean.setQuantityInStock(quantityInStock);
                        checkListBean.setCountState(warningMessage1);
                        checkListBean.setExpirationDateState(warningMessage);
                        checkListBean.setSaveTime(day);
                        checkList.add(checkListBean);
                    }
                }
            }
            return new ListResponse(checkList.size(), pageInfo.getPages(), pageInfo.getPageNum(), checkList);
        }


        List<CheckList> checkList = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(GoodsCheckRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stateId", stateId);
        if (saveStateId == null) {
            saveStateId = 1;
        }
        criteria.andEqualTo("saveStateId", saveStateId);
        example.selectProperties("id", "goodsId", "warehouseEntryTime", "warehouseId", "expirationDate", "quantityInStock", "unitId", "quantityWarning", "dateInProduced", "deadlineWarning");
        PageInfo<GoodsCheckRecord> pageInfo = new PageInfo<>(goodsCheckRecordMapper.selectByExample(example));
        for (int i = 0; i < pageInfo.getList().size(); i++) {
            CheckList checkListBean = new CheckList();
            Long goodsId = pageInfo.getList().get(i).getGoodsId();
            //查出商品的所属分类和商品的所属商店
            GoodsInfo goodsInfo = goodsCheckRecordMapper.selectGoodsInfo(goodsId);
            Long responsiblePersonId = pageInfo.getList().get(i).getResponsiblePersonId();
            Date warehouseEntryTime = pageInfo.getList().get(i).getWarehouseEntryTime();
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
            String currentTime = dateFormat.format(now); //当前时间
            String warehouseTime = dateFormat.format(warehouseEntryTime);  //入库时间
            Long expirationDate = pageInfo.getList().get(i).getExpirationDate();//保质期
            Date dateInProduced = pageInfo.getList().get(i).getDateInProduced();//生产日期
            String dateInProduced1 = dateFormat.format(dateInProduced);//生产日期
            Long deadlineWarning = pageInfo.getList().get(i).getDeadlineWarning();//保质期预警天数
            long day = 0;//已存时间
            long sellByDate;//已过保质期天数
            Long date = null;//剩余保质期天数
            String warningMessage;//预警消息
            try {
                Date currentTime1 = dateFormat.parse(currentTime);//当前时间
                Date warehouseTime1 = dateFormat.parse(warehouseTime);//入库时间
                //获取相减后天数
                day = (currentTime1.getTime() - warehouseTime1.getTime()) / (24 * 60 * 60 * 1000);
                Date dateOfManufacture = dateFormat.parse(dateInProduced1);//生产日期
                sellByDate = (currentTime1.getTime() - dateOfManufacture.getTime()) / (24 * 60 * 60 * 1000);
                date = expirationDate / 2 - sellByDate;//剩余保质期天数
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date <= deadlineWarning) {
                warningMessage = "商品保质期即将过半";
            } else {
                warningMessage = "正常";
            }
            Integer warehouseId = pageInfo.getList().get(i).getWarehouseId();//仓库ID
            //查出仓库名称
            GoodsConsignmentWarehouse goodsConsignmentWarehouse = goodsConsignmentWarehouseMapper.selectByPrimaryKey(warehouseId);
            BigDecimal quantityInStock = pageInfo.getList().get(i).getQuantityInStock();//库存数量
            Integer unitId = pageInfo.getList().get(i).getUnitId();
            GoodsMeteringUnit goodsMeteringUnit = goodsMeteringUnitMapper.selectByPrimaryKey(unitId);

            BigDecimal quantityWarning = pageInfo.getList().get(i).getQuantityWarning();//预警数量
            String warningMessage1;//预警消息
            GoodsCheckRecord goodsCheckRecord = new GoodsCheckRecord();
            goodsCheckRecord.setId(pageInfo.getList().get(i).getId());
            if (quantityWarning.compareTo(quantityInStock) == 1) {
                warningMessage1 = "库存数量不足";
                goodsCheckRecord.setSaveStateId(2);
                goodsCheckRecordMapper.updateByPrimaryKeySelective(goodsCheckRecord);
            } else {
                warningMessage1 = "库存充足";
                goodsCheckRecord.setSaveStateId(1);
                goodsCheckRecordMapper.updateByPrimaryKeySelective(goodsCheckRecord);
            }
            checkListBean.setId(pageInfo.getList().get(i).getId());
            checkListBean.setGoodsId(goodsId);
            checkListBean.setGoodsName(goodsInfo.getGoodsName());
            checkListBean.setShopName(goodsInfo.getShopName());
            checkListBean.setCategoryName(goodsInfo.getCategoryName());
            checkListBean.setUnitName(goodsMeteringUnit.getUnitName());
            checkListBean.setQuantityInStock(quantityInStock);
            checkListBean.setCountState(warningMessage1);
            checkListBean.setExpirationDateState(warningMessage);
            checkListBean.setSaveTime(day);
            checkList.add(checkListBean);
        }
        return new ListResponse(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), checkList);
    }

    /**
     * jcw
     * 寄存商品信息详情
     *
     * @param checkId 寄存商品ID
     * @return
     */
    @Override
    public CheckParticulars selectCheckInfo(Integer checkId) {
        CheckParticulars checkParticularsBean = new CheckParticulars();
        Example example = new Example(GoodsCheckRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", checkId);
        example.selectProperties("id", "goodsId", "responsiblePersonId", "warehouseEntryTime", "warehouseId", "expirationDate", "quantityInStock", "unitId", "quantityWarning", "dateInProduced", "deadlineWarning", "registerFee");
        PageInfo<GoodsCheckRecord> pageInfo = new PageInfo<>(goodsCheckRecordMapper.selectByExample(example));
        for (int i = 0; i < pageInfo.getList().size(); i++) {

            Long goodsId = pageInfo.getList().get(i).getGoodsId();
            //查出商品的所属分类和商品的所属商店
            GoodsInfo goodsInfo = goodsCheckRecordMapper.selectGoodsInfo(goodsId);
            Long responsiblePersonId = pageInfo.getList().get(i).getResponsiblePersonId();

            //   String responsiblePersonName = sysUserMapper.findSysUserName(responsiblePersonId);
            String responsiblePersonName = goodsCheckRecordMapper.findSysUserName(responsiblePersonId);
            Date warehouseEntryTime = pageInfo.getList().get(i).getWarehouseEntryTime();
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            String warehouseEntryTime1 = dateFormat1.format(warehouseEntryTime);
            String currentTime = dateFormat.format(now); //当前时间
            String warehouseTime = dateFormat.format(warehouseEntryTime);  //入库时间
            Long expirationDate = pageInfo.getList().get(i).getExpirationDate();//保质期
            Date dateInProduced = pageInfo.getList().get(i).getDateInProduced();//生产日期
            String dateInProduced1 = dateFormat.format(dateInProduced);//生产日期
            Long deadlineWarning = pageInfo.getList().get(i).getDeadlineWarning();//保质期预警天数
            long day = 0;//已存时间
            long sellByDate;//已过保质期天数
            Long date = null;//剩余保质期天数
            String warningMessage;//预警消息
            try {
                Date currentTime1 = dateFormat.parse(currentTime);//当前时间
                Date warehouseTime1 = dateFormat.parse(warehouseTime);//入库时间
                //获取相减后天数
                day = (currentTime1.getTime() - warehouseTime1.getTime()) / (24 * 60 * 60 * 1000);
                Date dateOfManufacture = dateFormat.parse(dateInProduced1);//生产日期
                sellByDate = (currentTime1.getTime() - dateOfManufacture.getTime()) / (24 * 60 * 60 * 1000);
                date = expirationDate / 2 - sellByDate;//剩余保质期天数
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date <= deadlineWarning) {
                warningMessage = "商品保质期即将过半";
            } else {
                warningMessage = "正常";
            }
            Integer warehouseId = pageInfo.getList().get(i).getWarehouseId();//仓库ID
            //查出仓库名称
            GoodsConsignmentWarehouse goodsConsignmentWarehouse = goodsConsignmentWarehouseMapper.selectByPrimaryKey(warehouseId);
            BigDecimal quantityInStock = pageInfo.getList().get(i).getQuantityInStock();//库存数量
            Integer unitId = pageInfo.getList().get(i).getUnitId();
            GoodsMeteringUnit goodsMeteringUnit = goodsMeteringUnitMapper.selectByPrimaryKey(unitId);

            BigDecimal quantityWarning = pageInfo.getList().get(i).getQuantityWarning();//预警数量
            String warningMessage1;//预警消息
            if (quantityWarning.compareTo(quantityInStock) == 1) {
                warningMessage1 = "库存数量不足";
            } else {
                warningMessage1 = "库存充足";
            }
            checkParticularsBean.setId(pageInfo.getList().get(i).getId());
            checkParticularsBean.setGoodsId(goodsId);
            checkParticularsBean.setResponsiblePersonName(responsiblePersonName);
            checkParticularsBean.setGoodsName(goodsInfo.getGoodsName());
            checkParticularsBean.setShopName(goodsInfo.getShopName());
            checkParticularsBean.setCategoryName(goodsInfo.getCategoryName());
            checkParticularsBean.setWarehouseName(goodsConsignmentWarehouse.getWarehouseName());
            checkParticularsBean.setWarehouseEntryTime(warehouseEntryTime1);
            checkParticularsBean.setRegisterFee(pageInfo.getList().get(i).getRegisterFee());
            checkParticularsBean.setUnitName(goodsMeteringUnit.getUnitName());
            checkParticularsBean.setQuantityInStock(quantityInStock);
            checkParticularsBean.setCountState(warningMessage1);
            checkParticularsBean.setExpirationDateState(warningMessage);
            checkParticularsBean.setSaveTime(day);
        }
        return checkParticularsBean;
    }

}
