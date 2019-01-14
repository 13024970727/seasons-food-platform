# 购物车表
CREATE TABLE `seasons_food_platform`.`user_goods_cart` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NULL COMMENT '用户ID',
  `category_id` BIGINT(20) NULL COMMENT '类别id',
  `goods_id` BIGINT(20) NULL COMMENT '商品ID',
  `create_time` DATETIME NULL COMMENT '创建时间',
  PRIMARY KEY (`id`));
