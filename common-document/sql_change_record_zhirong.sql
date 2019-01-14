#12-7 添加商品类别等级
ALTER TABLE `seasons_food_platform`.`goods_category`
ADD COLUMN `level` INT NULL COMMENT '分类等级，1第一级，2第二级，共4级' AFTER `create_time`;

#2018年12月8日10:08:35 商品是否上架
ALTER TABLE `goods`
ADD COLUMN `on_sale`  tinyint(4) NULL DEFAULT 0 COMMENT '是否上架，0未上架，1上架' AFTER `sort_number`;

# 2018年12月8日10:28:40 商品创建日期
ALTER TABLE `goods`
ADD COLUMN `create_time`  datetime NULL COMMENT '商品创建日期' AFTER `on_sale`;


# 2018年12月8日15:13:59 添加商品类别的商品系数
ALTER TABLE `seasons_food_platform`.`goods_category`
ADD COLUMN `category_weight_params` DECIMAL(10,2) NULL DEFAULT 1 COMMENT '类别重量系数，重量乘以这个系数为实际重量' AFTER `level`;

ALTER TABLE `seasons_food_platform`.`goods`
CHANGE COLUMN `unit_number` `unit_number` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '一份的单位数量' ;

ALTER TABLE `seasons_food_platform`.`goods`
CHANGE COLUMN `weight_params` `weight_params` DECIMAL(10,2) NULL DEFAULT 1 COMMENT '实际重量计算参数' ;

#2018年12月8日16:40:45 修改提现记录卡号字段
ALTER TABLE `shop_withdraw_record`
CHANGE COLUMN `account` `card_number`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户' AFTER `withdraw_type`;

# 2018年12月12日16:15:53 设置商家用户名唯一
ALTER TABLE `seasons_food_platform`.`shop_user`
ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC);

# 2018年12月12日17:26:22  设置银行卡号唯一
ALTER TABLE `seasons_food_platform`.`shop_user_bank_info`
ADD UNIQUE INDEX `card_number_UNIQUE` (`card_number` ASC);

# 2018年12月13日09:16:37  设置银行卡提现方式
ALTER TABLE `seasons_food_platform`.`shop_withdraw_record`
CHANGE COLUMN `withdraw_type` `withdraw_type` TINYINT(2) NULL DEFAULT NULL COMMENT '提现方式  1 银行卡  2 支付宝  3 微信' ;

# 2018年12月13日11:26:21 设置收款二维码长度200
ALTER TABLE `seasons_food_platform`.`shop_user_pay_info`
CHANGE COLUMN `account` `account` VARCHAR(200) NULL DEFAULT NULL COMMENT '账户' ;

# 2018年12月13日15:08:18
ALTER TABLE `seasons_food_platform`.`shop_user_bank_info`
CHANGE COLUMN `id` `id` BIGINT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `seasons_food_platform`.`shop_withdraw_record`
ADD COLUMN `qrcode` VARCHAR(200) NULL COMMENT '收款二维码信息' AFTER `create_time`;


ALTER TABLE `seasons_food_platform`.`shop_withdraw_record`
CHANGE COLUMN `withdraw_money` `withdraw_money` DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '提现金额' ,
CHANGE COLUMN `is_transfer` `is_transfer` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否已经转账' ,
CHANGE COLUMN `create_time` `create_time` DATETIME NULL COMMENT '创建时间' ,
ADD COLUMN `current_money` DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '提现后当前店铺余额' AFTER `qrcode`;




