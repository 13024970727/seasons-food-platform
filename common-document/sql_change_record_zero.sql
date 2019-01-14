# ---------- 2018-12-12 ----------

# area表新增区域类型
ALTER TABLE `seasons_food_platform`.`area`
ADD COLUMN `area_type` SMALLINT(2) NULL COMMENT '区域类型' AFTER `area_name`;

# sys_user表新增所属区域id
ALTER TABLE `seasons_food_platform`.`sys_user`
ADD COLUMN `area_id` BIGINT(20) NULL COMMENT '所属区域id' AFTER `job_number`;

# font_user表新增是否激活
ALTER TABLE `seasons_food_platform`.`font_user`
ADD COLUMN `is_active` TINYINT(4) NULL DEFAULT 0 COMMENT '是否激活' AFTER `own_id`;