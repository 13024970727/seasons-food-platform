-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: seasons_food_platform
-- ------------------------------------------------------
-- Server version	5.7.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advertise`
--

DROP TABLE IF EXISTS `advertise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_name` varchar(40) DEFAULT NULL COMMENT '广告名字\n',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `picture_url` varchar(150) DEFAULT NULL COMMENT '图片地址',
  `refer_url` varchar(150) DEFAULT NULL COMMENT '关联地址',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `advertise_category_id` bigint(20) DEFAULT NULL,
  `advertise_position_id` bigint(20) DEFAULT NULL COMMENT '位置ID',
  PRIMARY KEY (`id`),
  KEY `fk_advertise_advertise_category1_idx` (`advertise_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告位置设置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertise`
--

LOCK TABLES `advertise` WRITE;
/*!40000 ALTER TABLE `advertise` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertise_category`
--

DROP TABLE IF EXISTS `advertise_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertise_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL COMMENT '类别名字',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '类别ID',
  `remark` varchar(150) DEFAULT NULL COMMENT '描述\n',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertise_category`
--

LOCK TABLES `advertise_category` WRITE;
/*!40000 ALTER TABLE `advertise_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertise_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertise_position`
--

DROP TABLE IF EXISTS `advertise_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertise_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `position_name` varchar(45) DEFAULT NULL COMMENT '位置',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `remark` varchar(150) DEFAULT NULL COMMENT '描述',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertise_position`
--

LOCK TABLES `advertise_position` WRITE;
/*!40000 ALTER TABLE `advertise_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertise_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `announce_type` varchar(45) DEFAULT NULL COMMENT ' 通知类别 1  平台用户  2 平台商户',
  `annount_time` datetime DEFAULT NULL COMMENT '通知时间',
  `review_picture` varchar(150) DEFAULT NULL COMMENT '预览图片',
  `sort_number` smallint(5) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(45) DEFAULT NULL COMMENT '区域名字',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '直接上级区域',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '所有上级区域，格式 0/1/2',
  `description` varchar(45) DEFAULT NULL COMMENT '描述',
  `sort_number` mediumint(10) DEFAULT NULL COMMENT '排序编号',
  `is_use` tinyint(4) DEFAULT '1' COMMENT '是否启用',
  `area_param` varchar(45) DEFAULT NULL COMMENT '地区系数（预留字段）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_has_delivery_user`
--

DROP TABLE IF EXISTS `area_has_delivery_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_has_delivery_user` (
  `area_id` bigint(20) NOT NULL COMMENT '地区id',
  `delivery_user_id` bigint(20) NOT NULL COMMENT '外送员id',
  PRIMARY KEY (`area_id`,`delivery_user_id`),
  KEY `fk_area_has_delivery_user_delivery_user1_idx` (`delivery_user_id`),
  KEY `fk_area_has_delivery_user_area1_idx` (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_has_delivery_user`
--

LOCK TABLES `area_has_delivery_user` WRITE;
/*!40000 ALTER TABLE `area_has_delivery_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_has_delivery_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon_manage`
--

DROP TABLE IF EXISTS `coupon_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(45) DEFAULT NULL COMMENT '优惠卷名称',
  `money` decimal(10,2) DEFAULT NULL COMMENT '抵扣金额',
  `use_start_time` datetime DEFAULT NULL COMMENT '使用开始时间',
  `use_end_time` datetime DEFAULT NULL COMMENT '使用结束时间',
  `coupon_type` tinyint(2) DEFAULT NULL COMMENT '优惠卷类别  1 无门槛  2 抵扣通用运费 3 满扣',
  `over_limit` decimal(10,2) DEFAULT NULL COMMENT '限定金额',
  `remark` varchar(150) DEFAULT NULL COMMENT '描述',
  `is_use` tinyint(4) DEFAULT '0' COMMENT '是否使用',
  `limit_number` int(11) DEFAULT NULL,
  `create_time` varchar(45) DEFAULT NULL COMMENT '限定数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠卷管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon_manage`
--

LOCK TABLES `coupon_manage` WRITE;
/*!40000 ALTER TABLE `coupon_manage` DISABLE KEYS */;
/*!40000 ALTER TABLE `coupon_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_record`
--

DROP TABLE IF EXISTS `delivery_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_time` datetime DEFAULT NULL COMMENT '配送开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '配送结束时间',
  `delivery_number` int(11) DEFAULT NULL COMMENT '配送数量',
  `delivery_efficiency` decimal(10,2) DEFAULT NULL COMMENT '配送效率',
  `record_date` datetime DEFAULT NULL COMMENT '记录到年月日 yyyy-MM-dd 00:00:00',
  `delivery_user_id` bigint(20) NOT NULL,
  `delivery_time` decimal(10,2) DEFAULT NULL COMMENT '配送总时间,单位分钟',
  `delivery_value` decimal(10,2) DEFAULT NULL COMMENT '配送的总价值',
  PRIMARY KEY (`id`),
  KEY `fk_delivery_record_delivery_user1_idx` (`delivery_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外送记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_record`
--

LOCK TABLES `delivery_record` WRITE;
/*!40000 ALTER TABLE `delivery_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_settle_extra`
--

DROP TABLE IF EXISTS `delivery_settle_extra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_settle_extra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) DEFAULT NULL COMMENT '子项名',
  `item_value` decimal(10,2) DEFAULT NULL COMMENT '子项值',
  `item_type` smallint(2) DEFAULT NULL COMMENT ' 1 加钱 2 扣钱',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `record_time` datetime DEFAULT NULL COMMENT '记录时间，精确到月',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `delivery_user_id` bigint(20) NOT NULL COMMENT '外送员id',
  PRIMARY KEY (`id`),
  KEY `fk_delivery_settle_extra_delivery_user1_idx` (`delivery_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外送员工资结算浮动项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_settle_extra`
--

LOCK TABLES `delivery_settle_extra` WRITE;
/*!40000 ALTER TABLE `delivery_settle_extra` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_settle_extra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_settle_record`
--

DROP TABLE IF EXISTS `delivery_settle_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_settle_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_day` int(11) DEFAULT NULL COMMENT '配送天数',
  `delivery_number` int(11) DEFAULT NULL COMMENT '配送数',
  `base_pay` decimal(10,2) DEFAULT NULL COMMENT '基础工资',
  `oil_subsidy` decimal(10,2) DEFAULT NULL COMMENT '油费',
  `delivery_subsidy` decimal(10,2) DEFAULT NULL COMMENT '外送补贴',
  `total_pay` decimal(10,2) DEFAULT NULL COMMENT '总工资',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `delivery_user_id` bigint(20) NOT NULL,
  `record_time` datetime DEFAULT NULL COMMENT '记录时间，精确到月',
  PRIMARY KEY (`id`),
  KEY `fk_delivery_settle_record_delivery_user1_idx` (`delivery_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配送员结算记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_settle_record`
--

LOCK TABLES `delivery_settle_record` WRITE;
/*!40000 ALTER TABLE `delivery_settle_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_settle_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_user`
--

DROP TABLE IF EXISTS `delivery_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(12) DEFAULT NULL COMMENT '电话号',
  `password` varchar(150) DEFAULT NULL COMMENT '密码',
  `id_card_number` varchar(45) DEFAULT NULL COMMENT '身份证',
  `account` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `lock_account` decimal(10,2) DEFAULT NULL COMMENT '冻结金额（体现中的金额）',
  `open_id` varchar(100) DEFAULT NULL COMMENT '开放平台ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外送员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_user`
--

LOCK TABLES `delivery_user` WRITE;
/*!40000 ALTER TABLE `delivery_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_user_bank_info`
--

DROP TABLE IF EXISTS `delivery_user_bank_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_user_bank_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank` varchar(60) DEFAULT NULL COMMENT '银行',
  `card_number` varchar(40) DEFAULT NULL COMMENT '卡号',
  `real_name` varchar(40) DEFAULT NULL COMMENT '真实姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `delivery_user_id` bigint(20) NOT NULL COMMENT '外送员id',
  PRIMARY KEY (`id`),
  KEY `fk_delivery_user_bank_info_delivery_user1_idx` (`delivery_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外送员银行卡信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_user_bank_info`
--

LOCK TABLES `delivery_user_bank_info` WRITE;
/*!40000 ALTER TABLE `delivery_user_bank_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_user_bank_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_user_pay_info`
--

DROP TABLE IF EXISTS `delivery_user_pay_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_user_pay_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_type` tinyint(2) DEFAULT NULL COMMENT '第三方支付  2 支付宝 3 微信',
  `account` varchar(45) DEFAULT NULL COMMENT '账户',
  `account_name` varchar(45) DEFAULT NULL COMMENT '账户名',
  `real_name` varchar(45) DEFAULT NULL COMMENT '真实名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `delivery_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_delivery_user_pay_info_delivery_user1_idx` (`delivery_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外送员第三方支付信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_user_pay_info`
--

LOCK TABLES `delivery_user_pay_info` WRITE;
/*!40000 ALTER TABLE `delivery_user_pay_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_user_pay_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_withdraw_record`
--

DROP TABLE IF EXISTS `delivery_withdraw_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_withdraw_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `delivery_user_id` bigint(20) NOT NULL,
  `money` decimal(10,2) DEFAULT NULL COMMENT '提现金额',
  `change_after` decimal(10,2) DEFAULT NULL COMMENT '改变后得金额',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 1 同意 2 拒绝',
  `is_transfer` varchar(45) DEFAULT NULL COMMENT '是否转账',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `account` varchar(45) DEFAULT NULL COMMENT '提现账户',
  `account_from` tinyint(2) DEFAULT NULL COMMENT '提现渠道 1 银行 2 支付宝 3 微信',
  `account_name` varchar(45) DEFAULT NULL COMMENT '账户名字',
  `real_name` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`),
  KEY `fk_delivery_withdraw_record_delivery_user1_idx` (`delivery_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外送员提现记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_withdraw_record`
--

LOCK TABLES `delivery_withdraw_record` WRITE;
/*!40000 ALTER TABLE `delivery_withdraw_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_withdraw_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deviant_statistics_record`
--

DROP TABLE IF EXISTS `deviant_statistics_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deviant_statistics_record` (
  `deviant_statu_id` bigint(20) NOT NULL COMMENT '异常时间id',
  `deviant_goods_numebr` int(11) DEFAULT NULL COMMENT '异常事件数量',
  `deviant_order_number` int(11) DEFAULT NULL COMMENT '异常订单数量',
  `normal_order_number` int(11) DEFAULT NULL COMMENT '正常订单数量',
  `deviant_rate` decimal(10,2) DEFAULT NULL COMMENT '异常订单/正常订单',
  `record_time` datetime NOT NULL COMMENT '记录时间精确到天  一个异常事件一天一个统计记录',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`deviant_statu_id`,`record_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='异常统计';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deviant_statistics_record`
--

LOCK TABLES `deviant_statistics_record` WRITE;
/*!40000 ALTER TABLE `deviant_statistics_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `deviant_statistics_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deviant_statu`
--

DROP TABLE IF EXISTS `deviant_statu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deviant_statu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `divant_name` varchar(45) DEFAULT NULL COMMENT '异常名称',
  `is_platform_duty` tinyint(4) DEFAULT '0' COMMENT '是否平台责任',
  `is_user_duty` tinyint(4) DEFAULT '0' COMMENT '是否用户责任',
  `is_delivery_duty` tinyint(4) DEFAULT '0' COMMENT '是否快递责任',
  `is_shop_duty` tinyint(4) DEFAULT '0' COMMENT '是否商家责任',
  `remark` varchar(200) DEFAULT NULL COMMENT '描述',
  `user_view` varchar(60) DEFAULT NULL COMMENT '用户看到的异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `divant_name_UNIQUE` (`divant_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='异常状态';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deviant_statu`
--

LOCK TABLES `deviant_statu` WRITE;
/*!40000 ALTER TABLE `deviant_statu` DISABLE KEYS */;
/*!40000 ALTER TABLE `deviant_statu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `font_user`
--

DROP TABLE IF EXISTS `font_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `font_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(13) DEFAULT NULL COMMENT '电话',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `pay_password` varchar(45) DEFAULT NULL COMMENT '支付密码',
  `salt` varchar(150) DEFAULT NULL COMMENT '盐 加密使用',
  `nickname` varchar(45) DEFAULT NULL COMMENT '呢称',
  `real_name` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `id_card_number` varchar(45) DEFAULT NULL COMMENT '身份证',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `comment_code` varchar(45) DEFAULT NULL COMMENT '推荐码',
  `recommond_user_id` varchar(45) DEFAULT NULL COMMENT '推荐人ID',
  `is_lock` tinyint(4) DEFAULT '0' COMMENT '是否锁定 默认未锁定',
  `account` decimal(10,2) DEFAULT NULL COMMENT '用户余额',
  `lock_account` decimal(10,2) DEFAULT NULL COMMENT '冻结余额',
  `integral` decimal(10,2) DEFAULT NULL COMMENT '积分',
  `remark` varchar(200) DEFAULT NULL COMMENT '一次性标注',
  `own_id` bigint(20) DEFAULT NULL COMMENT '用户所属地址',
  `code` varchar(50) DEFAULT NULL COMMENT 'tcc事物时使用，同步码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台前端用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `font_user`
--

LOCK TABLES `font_user` WRITE;
/*!40000 ALTER TABLE `font_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `font_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `font_user_address`
--

DROP TABLE IF EXISTS `font_user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `font_user_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `detail_address` varchar(150) DEFAULT NULL COMMENT '详细地址',
  `is_default` tinyint(4) DEFAULT NULL COMMENT '是否默认地址',
  `address_type` tinyint(2) DEFAULT NULL COMMENT '地址类型 1  小区 2 自建房 3 店铺 4 公司 5其他',
  `ladder_number` varchar(40) DEFAULT NULL COMMENT '梯号',
  `house_number` varchar(40) DEFAULT NULL COMMENT '门牌号',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort_number` smallint(10) DEFAULT NULL COMMENT '排序',
  `font_user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `delivery_user_id` bigint(20) NOT NULL COMMENT '此地址分配的配送员',
  `area_id` bigint(20) NOT NULL COMMENT '地区ID',
  PRIMARY KEY (`id`),
  KEY `fk_font_user_address_font_user1_idx` (`font_user_id`),
  KEY `fk_font_user_address_delivery_user1_idx` (`delivery_user_id`),
  KEY `fk_font_user_address_area1_idx` (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `font_user_address`
--

LOCK TABLES `font_user_address` WRITE;
/*!40000 ALTER TABLE `font_user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `font_user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku` varchar(45) DEFAULT NULL COMMENT 'sku编码',
  `goods_name` varchar(45) DEFAULT NULL COMMENT '商品名',
  `current_price` decimal(10,2) DEFAULT NULL COMMENT '当前单价（一份的价格）',
  `change_price` decimal(10,2) DEFAULT NULL COMMENT '改变单价，今天改，明天生效（一份的价格）',
  `unit_number` varchar(45) DEFAULT NULL COMMENT '一份的单位数量',
  `unit_specification` varchar(20) DEFAULT 'g' COMMENT '单位规格（g,kg,盒，箱,默认g）',
  `is_custom` tinyint(4) DEFAULT '0' COMMENT '是否客户支持自定义重量',
  `stock_quantity` mediumint(10) DEFAULT NULL COMMENT '库存数量',
  `warn_quantity` mediumint(10) DEFAULT NULL COMMENT '预警数量',
  `sale_quantity` mediumint(10) DEFAULT NULL COMMENT '卖出数量',
  `daily_quantity` mediumint(10) DEFAULT NULL COMMENT '每日数量，每天将每日数量和库存同步',
  `extral_delivery_fee` decimal(10,2) DEFAULT NULL COMMENT '额外的快递费用',
  `rebate` varchar(45) DEFAULT NULL COMMENT '返点',
  `delivery_type` smallint(2) DEFAULT NULL COMMENT ' 1 平台配送 2 商家配送',
  `weight_params` decimal(10,2) DEFAULT NULL COMMENT '实际重量计算参数',
  `sort_number` smallint(10) DEFAULT NULL COMMENT '商品排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_category`
--

DROP TABLE IF EXISTS `goods_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父亲ID',
  `parent_ids` varchar(60) DEFAULT NULL COMMENT '祖先id，以‘/’分隔；eg 0/1/2',
  `category_name` varchar(60) DEFAULT NULL COMMENT '类别名字',
  `picture_url` varchar(150) DEFAULT NULL COMMENT '主图',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `up_limit` decimal(10,2) DEFAULT NULL COMMENT '上限重量',
  `down_limit` decimal(10,2) DEFAULT NULL COMMENT '下限重量',
  `create_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_category`
--

LOCK TABLES `goods_category` WRITE;
/*!40000 ALTER TABLE `goods_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_category_has_goods`
--

DROP TABLE IF EXISTS `goods_category_has_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_category_has_goods` (
  `goods_category_id` bigint(20) NOT NULL COMMENT '类别ID',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '商户ID，在某个类别下的某个商品归属于某个商户',
  PRIMARY KEY (`goods_category_id`,`goods_id`),
  KEY `fk_goods_category_has_goods_goods1_idx` (`goods_id`),
  KEY `fk_goods_category_has_goods_goods_category1_idx` (`goods_category_id`),
  KEY `fk_goods_category_has_goods_shop_base_info1_idx` (`shop_base_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类商品中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_category_has_goods`
--

LOCK TABLES `goods_category_has_goods` WRITE;
/*!40000 ALTER TABLE `goods_category_has_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_category_has_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_comment`
--

DROP TABLE IF EXISTS `goods_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(300) DEFAULT NULL COMMENT '评价',
  `grade` smallint(2) DEFAULT NULL COMMENT '星级',
  `user_id` bigint(20) DEFAULT NULL COMMENT '评价用户ID',
  `is_show` tinyint(1) DEFAULT NULL COMMENT '是否显示',
  `create_time` datetime DEFAULT NULL COMMENT '评价用户ID',
  `goods_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`goods_id`),
  KEY `fk_goods_comment_goods1_idx` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评价表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_comment`
--

LOCK TABLES `goods_comment` WRITE;
/*!40000 ALTER TABLE `goods_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_deviant`
--

DROP TABLE IF EXISTS `goods_deviant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_deviant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deviant_statu_name` varchar(45) DEFAULT NULL COMMENT '异常名字',
  `platform_duty_money` decimal(10,2) DEFAULT NULL COMMENT '平台承担的费用',
  `delivery_duty_money` decimal(10,2) DEFAULT NULL COMMENT '快递员承担的费用',
  `user_duty_money` decimal(10,2) DEFAULT NULL COMMENT '用户承担的费用',
  `shop_duty_money` decimal(10,2) DEFAULT NULL COMMENT '店铺承担的费用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(150) DEFAULT NULL COMMENT '备注',
  `user_view` varchar(50) DEFAULT NULL COMMENT '用户看到的异常信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品异常信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_deviant`
--

LOCK TABLES `goods_deviant` WRITE;
/*!40000 ALTER TABLE `goods_deviant` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_deviant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_order_has_goods`
--

DROP TABLE IF EXISTS `goods_order_has_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_order_has_goods` (
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `user_goods_order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '供货商铺ID',
  `per_price` decimal(10,2) DEFAULT NULL COMMENT '买时每份的价格',
  `unit_number` decimal(10,2) DEFAULT NULL COMMENT '买时每份的单位数量',
  `unit_specification` varchar(10) DEFAULT NULL COMMENT '买时的基础单位',
  `goods_deviant_id` bigint(20) NOT NULL COMMENT '异常信息ID',
  `status` smallint(2) DEFAULT NULL COMMENT '状态  1 正常 2 缺货 3 破损 4 重量超标 5 重量不足',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`goods_id`,`user_goods_order_id`),
  KEY `fk_goods_order_has_goods_goods1_idx` (`goods_id`),
  KEY `fk_order_has_goods_goods_deviant1_idx` (`goods_deviant_id`),
  KEY `fk_user_goods_order_has_goods_shop_base_info1_idx` (`shop_base_info_id`),
  KEY `fk_goods_order_has_goods_goods_order1_idx` (`user_goods_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_order_has_goods`
--

LOCK TABLES `goods_order_has_goods` WRITE;
/*!40000 ALTER TABLE `goods_order_has_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_order_has_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `integral_change_record`
--

DROP TABLE IF EXISTS `integral_change_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `integral_change_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `integral_number` decimal(10,2) DEFAULT NULL COMMENT '变动积分',
  `change_type` smallint(2) DEFAULT NULL COMMENT '变动类型   11 邀请赠送  12 新注册赠送 13消费',
  `remark` varchar(150) DEFAULT NULL COMMENT '描述',
  `code` varchar(45) DEFAULT NULL COMMENT '同步码 tcc用',
  `font_user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_integral_change_record_font_user1_idx` (`font_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户积分记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integral_change_record`
--

LOCK TABLES `integral_change_record` WRITE;
/*!40000 ALTER TABLE `integral_change_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `integral_change_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `market_category`
--

DROP TABLE IF EXISTS `market_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `market_category` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父亲ID，预留',
  `market_name` varchar(100) DEFAULT NULL COMMENT '市场名字',
  `image_url` varchar(80) DEFAULT NULL COMMENT '封面图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort_number` smallint(10) DEFAULT NULL COMMENT '排序',
  `address` varchar(150) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='市场类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `market_category`
--

LOCK TABLES `market_category` WRITE;
/*!40000 ALTER TABLE `market_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `market_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `money_change_record`
--

DROP TABLE IF EXISTS `money_change_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `money_change_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `user_account` decimal(10,2) DEFAULT NULL COMMENT '用户当前余额',
  `remark` varchar(150) DEFAULT NULL COMMENT '描述\n',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `font_user_id` bigint(20) NOT NULL,
  `change_type` smallint(3) DEFAULT NULL COMMENT '变动类别  11 支付宝充值  12 微信充值 13 其他方式充值  14平台退款  15积分兑换\n                       21 订单支付',
  `code` varchar(60) DEFAULT NULL COMMENT '分布式事物所需字段',
  PRIMARY KEY (`id`),
  KEY `fk_recharge_record_font_user1_idx` (`font_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户资金变动记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `money_change_record`
--

LOCK TABLES `money_change_record` WRITE;
/*!40000 ALTER TABLE `money_change_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `money_change_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform_sale_record`
--

DROP TABLE IF EXISTS `platform_sale_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform_sale_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_time` datetime DEFAULT NULL COMMENT '精确到天，每天记录一条',
  `sale_money` decimal(10,2) DEFAULT NULL COMMENT '销售金额',
  `sale_order_number` int(11) DEFAULT NULL COMMENT '销售订单数',
  `buy_user_number` int(11) DEFAULT NULL COMMENT '购买用户ID',
  `first_buy_user_number` int(11) DEFAULT NULL COMMENT '首次购买用户ID',
  `total_delivery_fee` decimal(10,2) DEFAULT NULL COMMENT '总外送费用（统一）',
  `total_delivery_extra_fee` decimal(10,2) DEFAULT NULL COMMENT '总外送费用（额外）',
  `avg_order_value` varchar(45) DEFAULT NULL COMMENT '客单价（销售金额/订单数）',
  `total_draw` decimal(10,2) DEFAULT NULL COMMENT '总抽点金额',
  `shop_user_number` int(11) DEFAULT NULL COMMENT '商户数量',
  `avg_draw` varchar(45) DEFAULT NULL COMMENT '平均抽点金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `record_time_UNIQUE` (`record_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台销售报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform_sale_record`
--

LOCK TABLES `platform_sale_record` WRITE;
/*!40000 ALTER TABLE `platform_sale_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `platform_sale_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_apply_record`
--

DROP TABLE IF EXISTS `return_apply_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_apply_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `font_user_id` bigint(20) DEFAULT NULL COMMENT '申请用户ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '退货商品',
  `goods_order_id` bigint(20) DEFAULT NULL COMMENT '退货订单',
  `return_money` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  `return_reason` varchar(150) DEFAULT NULL COMMENT '退款金额\n',
  `status` varchar(45) DEFAULT NULL COMMENT '状态  1 申请中 2 同意 3 拒绝',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退货申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_apply_record`
--

LOCK TABLES `return_apply_record` WRITE;
/*!40000 ALTER TABLE `return_apply_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_apply_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_base_info`
--

DROP TABLE IF EXISTS `shop_base_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_base_info` (
  `id` bigint(20) NOT NULL,
  `shop_name` varchar(60) DEFAULT NULL COMMENT '店铺名字',
  `account` decimal(10,2) DEFAULT NULL COMMENT '商铺余额',
  `lock_account` decimal(10,2) DEFAULT NULL COMMENT '锁定余额',
  `free_sample` decimal(10,2) DEFAULT NULL COMMENT '免抽点',
  `address` varchar(70) DEFAULT NULL COMMENT '地址',
  `shop_level` int(2) DEFAULT NULL COMMENT '店铺等级',
  `market_category_id` bigint(20) NOT NULL,
  `daily_status` smallint(2) DEFAULT NULL COMMENT '状态  1 开业  2 关闭',
  `msg_account` decimal(10,2) DEFAULT NULL COMMENT '短信余额',
  `shop_status` varchar(45) DEFAULT NULL COMMENT '店铺状态  1 正常营业 2 不再营业 3 退出平台 4 退押金关店',
  `open_time` datetime DEFAULT NULL COMMENT '开店时间',
  `phone` varchar(12) DEFAULT NULL COMMENT '联系电话',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort_number` smallint(10) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `fk_shop_base_info_market_category1_idx` (`market_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺基础信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_base_info`
--

LOCK TABLES `shop_base_info` WRITE;
/*!40000 ALTER TABLE `shop_base_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_base_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_base_info_has_shop_user`
--

DROP TABLE IF EXISTS `shop_base_info_has_shop_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_base_info_has_shop_user` (
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '店铺id',
  `shop_user_id` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`shop_base_info_id`,`shop_user_id`),
  KEY `fk_shop_base_info_has_shop_user_shop_user1_idx` (`shop_user_id`),
  KEY `fk_shop_base_info_has_shop_user_shop_base_info1_idx` (`shop_base_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_base_info_has_shop_user`
--

LOCK TABLES `shop_base_info_has_shop_user` WRITE;
/*!40000 ALTER TABLE `shop_base_info_has_shop_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_base_info_has_shop_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_deduction_record`
--

DROP TABLE IF EXISTS `shop_deduction_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_deduction_record` (
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '商铺ID',
  `unity_time` varchar(45) NOT NULL COMMENT '记录时间(联合时间)，同时根据商户ID记录的时间关联到结算记录 年月日',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `duty_money` decimal(10,2) DEFAULT NULL COMMENT '赔偿金额',
  `description` varchar(150) DEFAULT NULL COMMENT '赔偿描述',
  `extral_picture` varchar(150) DEFAULT NULL COMMENT '赔偿图片',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`shop_base_info_id`,`unity_time`),
  KEY `fk_shop_deduction_record_shop_base_info1_idx` (`shop_base_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家扣款记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_deduction_record`
--

LOCK TABLES `shop_deduction_record` WRITE;
/*!40000 ALTER TABLE `shop_deduction_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_deduction_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_goods_order`
--

DROP TABLE IF EXISTS `shop_goods_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_goods_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '商家ID',
  `user_goods_order_id` bigint(20) NOT NULL COMMENT '用户订单ID，用户订单和商户订单为1对多关系，一个用户订单由多个商户配送',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态  1 确认 2 待确认',
  `order_number` varchar(100) DEFAULT NULL COMMENT '订单流水号',
  `order_time` datetime DEFAULT NULL COMMENT '预定日期\n',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `total_money` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `rebate_money` decimal(10,2) DEFAULT NULL COMMENT '返点扣减金额,结算时应该减去此金额',
  `settle_money` decimal(10,2) DEFAULT NULL COMMENT '结算金额\n',
  PRIMARY KEY (`id`),
  KEY `fk_shop_goods_order_shop_base_info1_idx` (`shop_base_info_id`),
  KEY `fk_shop_goods_order_user_goods_order1_idx` (`user_goods_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商铺商品订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_goods_order`
--

LOCK TABLES `shop_goods_order` WRITE;
/*!40000 ALTER TABLE `shop_goods_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_goods_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_price_record`
--

DROP TABLE IF EXISTS `shop_price_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_price_record` (
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '商铺id',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `change_time` datetime DEFAULT NULL COMMENT '价格变动时间',
  PRIMARY KEY (`goods_id`,`shop_base_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录商品价格变动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_price_record`
--

LOCK TABLES `shop_price_record` WRITE;
/*!40000 ALTER TABLE `shop_price_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_price_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_sale_record`
--

DROP TABLE IF EXISTS `shop_sale_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_sale_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_base_info_id` bigint(20) DEFAULT NULL COMMENT '商铺id',
  `goods_number` int(11) DEFAULT NULL COMMENT '当前商品数量',
  `order_number` int(11) DEFAULT NULL COMMENT '每日的订单金额',
  `record_time` datetime DEFAULT NULL COMMENT '记录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `platform_total_sale` decimal(10,2) DEFAULT NULL COMMENT '平台总金额',
  `sale_rate` decimal(10,2) DEFAULT NULL COMMENT '占平台销售额的百分比',
  `moth_shop_total_sale` decimal(10,2) DEFAULT NULL COMMENT '店铺月销售总额',
  `month_platform_total_sale` decimal(10,2) DEFAULT NULL COMMENT '平台销售总额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商铺销售报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_sale_record`
--

LOCK TABLES `shop_sale_record` WRITE;
/*!40000 ALTER TABLE `shop_sale_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_sale_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_settle_record`
--

DROP TABLE IF EXISTS `shop_settle_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_settle_record` (
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '商铺ID',
  `unity_time` datetime NOT NULL COMMENT '结算时间（联合时间），同时根据记录的天数，关联到扣款记录 记录到年月日，',
  `goods_money` decimal(10,2) DEFAULT NULL COMMENT '货款总额',
  `shelf_fee` decimal(10,2) DEFAULT NULL COMMENT '货架费',
  `duty_money` decimal(10,2) DEFAULT NULL COMMENT '罚款金额',
  `handle_fee_rate` decimal(10,2) DEFAULT NULL COMMENT '手续费率',
  `shop_account` decimal(10,2) DEFAULT NULL COMMENT '商家余额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`shop_base_info_id`,`unity_time`),
  KEY `fk_shop_settle_record_shop_base_info1_idx` (`shop_base_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家结算记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_settle_record`
--

LOCK TABLES `shop_settle_record` WRITE;
/*!40000 ALTER TABLE `shop_settle_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_settle_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user`
--

DROP TABLE IF EXISTS `shop_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_user` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码\n',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐\n',
  `role_ids` varchar(100) DEFAULT NULL,
  `locked` tinyint(4) DEFAULT NULL COMMENT '是否锁定',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(60) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(45) DEFAULT NULL COMMENT '昵称',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL,
  `real_name` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user`
--

LOCK TABLES `shop_user` WRITE;
/*!40000 ALTER TABLE `shop_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user_bank_info`
--

DROP TABLE IF EXISTS `shop_user_bank_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_user_bank_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank` varchar(60) DEFAULT NULL COMMENT '银行',
  `card_number` varchar(40) DEFAULT NULL COMMENT '卡号',
  `real_name` varchar(40) DEFAULT NULL COMMENT '真实名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `shop_user_id` bigint(10) unsigned NOT NULL COMMENT '商户id',
  PRIMARY KEY (`id`),
  KEY `fk_shop_user_bank_info_shop_user1_idx` (`shop_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家银行卡信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user_bank_info`
--

LOCK TABLES `shop_user_bank_info` WRITE;
/*!40000 ALTER TABLE `shop_user_bank_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_user_bank_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user_has_sys_role`
--

DROP TABLE IF EXISTS `shop_user_has_sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_user_has_sys_role` (
  `shop_user_id` bigint(10) unsigned NOT NULL COMMENT '商户id',
  `sys_role_id` bigint(10) unsigned NOT NULL COMMENT '角色id',
  PRIMARY KEY (`shop_user_id`,`sys_role_id`),
  KEY `fk_shop_user_has_shop_role_shop_user1_idx` (`shop_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user_has_sys_role`
--

LOCK TABLES `shop_user_has_sys_role` WRITE;
/*!40000 ALTER TABLE `shop_user_has_sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_user_has_sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user_pay_info`
--

DROP TABLE IF EXISTS `shop_user_pay_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_user_pay_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_type` tinyint(2) DEFAULT NULL COMMENT '第三方支付  2 支付宝 3 微信',
  `account` varchar(45) DEFAULT NULL COMMENT '账户',
  `account_name` varchar(45) DEFAULT NULL COMMENT '账户名',
  `real_name` varchar(45) DEFAULT NULL COMMENT '真实名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `shop_user_id` bigint(10) unsigned NOT NULL COMMENT '商户id',
  PRIMARY KEY (`id`),
  KEY `fk_shop_user_pay_info_shop_user1_idx` (`shop_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户第三方支付信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user_pay_info`
--

LOCK TABLES `shop_user_pay_info` WRITE;
/*!40000 ALTER TABLE `shop_user_pay_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_user_pay_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_withdraw_record`
--

DROP TABLE IF EXISTS `shop_withdraw_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_withdraw_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_user_id` bigint(10) unsigned NOT NULL COMMENT '提现用户ID',
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '所属商铺ID',
  `withdraw_money` decimal(10,2) DEFAULT NULL COMMENT '体现金额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态  1 提现中 2 审核通过 3 审核不通过',
  `withdraw_type` smallint(2) DEFAULT NULL COMMENT '提现方式  1 银行卡  2 支付宝  3 微信',
  `account` varchar(45) DEFAULT NULL COMMENT '账户',
  `account_from` varchar(45) DEFAULT NULL COMMENT '账户来源  支付宝  兴业银行等',
  `real_name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `is_transfer` tinyint(4) DEFAULT '0' COMMENT '是否已经转账',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_shop_withdraw_record_shop_user1_idx` (`shop_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家用户提现记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_withdraw_record`
--

LOCK TABLES `shop_withdraw_record` WRITE;
/*!40000 ALTER TABLE `shop_withdraw_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_withdraw_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_access_record`
--

DROP TABLE IF EXISTS `sys_access_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_access_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sid` varchar(100) DEFAULT NULL COMMENT '会话id',
  `ip_address` varchar(45) DEFAULT NULL COMMENT 'ip地址',
  `handle_module` varchar(200) DEFAULT NULL COMMENT '处理模块',
  `last_access_time` varchar(45) DEFAULT NULL COMMENT '最后操作时间',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `sensitive_handle` varchar(255) DEFAULT NULL COMMENT '敏感模块',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='安全日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_access_record`
--

LOCK TABLES `sys_access_record` WRITE;
/*!40000 ALTER TABLE `sys_access_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_access_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_organization`
--

DROP TABLE IF EXISTS `sys_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_organization` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `is_avaliable` tinyint(4) DEFAULT NULL,
  `org_type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_organization`
--

LOCK TABLES `sys_organization` WRITE;
/*!40000 ALTER TABLE `sys_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_organization_has_sys_user`
--

DROP TABLE IF EXISTS `sys_organization_has_sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_organization_has_sys_user` (
  `sys_organization_id` bigint(20) unsigned NOT NULL,
  `sys_user_id` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`sys_organization_id`,`sys_user_id`),
  KEY `fk_sys_organization_has_sys_user_sys_user1_idx` (`sys_user_id`),
  KEY `fk_sys_organization_has_sys_user_sys_organization1_idx` (`sys_organization_id`),
  CONSTRAINT `fk_sys_organization_has_sys_user_sys_organization1` FOREIGN KEY (`sys_organization_id`) REFERENCES `sys_organization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sys_organization_has_sys_user_sys_user1` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_organization_has_sys_user`
--

LOCK TABLES `sys_organization_has_sys_user` WRITE;
/*!40000 ALTER TABLE `sys_organization_has_sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_organization_has_sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_resource`
--

DROP TABLE IF EXISTS `sys_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_resource` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(45) DEFAULT NULL COMMENT '资源名',
  `type` varchar(45) DEFAULT NULL COMMENT '资源的类型：menu：菜单，button：按钮',
  `priority` varchar(45) DEFAULT NULL COMMENT '排序',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `parent_ids` varchar(250) DEFAULT NULL COMMENT '祖先id，预留',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限字符',
  `is_avaliable` tinyint(4) DEFAULT NULL COMMENT '是否生效，预留',
  `url` varchar(100) DEFAULT NULL COMMENT '资源链接',
  `icon` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_resource`
--

LOCK TABLES `sys_resource` WRITE;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;
INSERT INTO `sys_resource` VALUES (1,'资源','menu','0',0,'0/','a',1,'',''),(67,'系统管理','menu','10',1,'0//1','system',1,'javascript:void(0);','fa-gears'),(68,'用户管理','menu','1901',67,'0//1/67','user:*',1,'./pages/admin/list.html','fa-user'),(69,'角色管理','menu','1902',67,'0//1/67','role:*',1,'./pages/role/list.html','fa-user-circle-o'),(70,'权限管理','menu','1903',67,'0//1/67','resource:*',1,'/pages/rule/list.html','fa-plus-square-o'),(71,'日志管理','menu','18',1,'0//1','access_record',1,'',''),(72,'操作日志','menu','1801',71,'0//1/71','access_record:*',1,'/page/access1',''),(73,'组织结构','menu','02',1,'0//1','bizOrg',1,'javascript:void(0);','fa-sitemap'),(75,'人员管理','menu','0201',73,'0//1/73','bizOrg:*',1,'./pages/bizOrg/userList.html','fa-group'),(76,'组织树','button','020101',75,'0//1/73/75','bizOrg:tree',1,'',''),(77,'组织内人员','button','020102',75,'0//1/73/75','bizOrg:user',1,'',''),(78,'部门管理','menu','0202',73,'0//1/73','bizOrgManage:*',1,'./pages/bizOrg/orgManage.html','fa-cubes');
/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL COMMENT '角色',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `resource_ids` varchar(100) DEFAULT NULL COMMENT '资源id列表（预留）',
  `is_avaliable` tinyint(4) DEFAULT NULL COMMENT '是否显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'admin','超级管理员','',1),(2,'管理员1','管理员','',1);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_has_sys_resource`
--

DROP TABLE IF EXISTS `sys_role_has_sys_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_has_sys_resource` (
  `sys_role_id` bigint(10) unsigned NOT NULL COMMENT '角色id',
  `sys_resource_id` bigint(10) unsigned NOT NULL COMMENT '资源id',
  PRIMARY KEY (`sys_role_id`,`sys_resource_id`),
  KEY `fk_sys_role_has_sys_resource_sys_resource1_idx` (`sys_resource_id`),
  KEY `fk_sys_role_has_sys_resource_sys_role1_idx` (`sys_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_has_sys_resource`
--

LOCK TABLES `sys_role_has_sys_resource` WRITE;
/*!40000 ALTER TABLE `sys_role_has_sys_resource` DISABLE KEYS */;
INSERT INTO `sys_role_has_sys_resource` VALUES (1,67),(1,68),(2,68),(1,69),(2,69),(1,70),(2,70),(1,73),(1,75),(1,76),(1,77),(1,78);
/*!40000 ALTER TABLE `sys_role_has_sys_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_setting`
--

DROP TABLE IF EXISTS `sys_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_setting` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `priority` int(3) DEFAULT NULL COMMENT '排序',
  `code` varchar(45) DEFAULT NULL COMMENT '编码，编码时用',
  `sys_name` varchar(45) DEFAULT NULL COMMENT '设置属性名',
  `sys_value` varchar(100) DEFAULT NULL COMMENT '属性值',
  `extend_value1` varchar(100) DEFAULT NULL COMMENT '拓展值1',
  `extend_value2` varchar(100) DEFAULT NULL COMMENT '拓展值2',
  `sys_description` varchar(200) DEFAULT NULL COMMENT '描述',
  `is_show` tinyint(1) DEFAULT NULL COMMENT '是否在管理界面显示',
  `category_id` bigint(10) unsigned DEFAULT NULL COMMENT '类别ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_setting`
--

LOCK TABLES `sys_setting` WRITE;
/*!40000 ALTER TABLE `sys_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_setting_category`
--

DROP TABLE IF EXISTS `sys_setting_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_setting_category` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL COMMENT '类别名',
  `category_code` varchar(45) DEFAULT NULL COMMENT '类别编码',
  `parent_id` bigint(10) DEFAULT NULL COMMENT '父亲ID',
  `parent_ids` varchar(45) DEFAULT NULL COMMENT '祖先id',
  `priority` int(11) DEFAULT NULL COMMENT '排序',
  `description` varchar(45) DEFAULT NULL COMMENT '描述',
  `type` tinyint(1) DEFAULT NULL COMMENT '类别 预留',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_setting_category`
--

LOCK TABLES `sys_setting_category` WRITE;
/*!40000 ALTER TABLE `sys_setting_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_setting_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码\n',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐\n',
  `role_ids` varchar(100) DEFAULT NULL COMMENT '用户角色ID',
  `locked` tinyint(4) DEFAULT NULL COMMENT '是否锁定',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(60) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(45) DEFAULT NULL COMMENT '昵称',
  `user_type` smallint(2) DEFAULT NULL COMMENT '用户类型 1 系统管理员 2 检货员',
  `job_number` varchar(45) DEFAULT NULL COMMENT '工号',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f',NULL,0,'18159801259',NULL,'admin',1,NULL,0,'2018-12-05 11:12:30');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_has_sys_role`
--

DROP TABLE IF EXISTS `sys_user_has_sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_has_sys_role` (
  `sys_user_id` bigint(10) unsigned NOT NULL COMMENT '用户id',
  `sys_role_id` bigint(10) unsigned NOT NULL COMMENT '角色id',
  PRIMARY KEY (`sys_user_id`,`sys_role_id`),
  KEY `fk_sys_user_has_sys_role_sys_role1_idx` (`sys_role_id`),
  KEY `fk_sys_user_has_sys_role_sys_user1_idx` (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_has_sys_role`
--

LOCK TABLES `sys_user_has_sys_role` WRITE;
/*!40000 ALTER TABLE `sys_user_has_sys_role` DISABLE KEYS */;
INSERT INTO `sys_user_has_sys_role` VALUES (1,1);
/*!40000 ALTER TABLE `sys_user_has_sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiller_record`
--

DROP TABLE IF EXISTS `tiller_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiller_record` (
  `sys_user_id` bigint(20) unsigned NOT NULL COMMENT '分拣员id',
  `record_time` datetime NOT NULL COMMENT '记录时间，记录到天',
  `tiller_number` int(11) DEFAULT NULL COMMENT '分拣数量',
  `start_time` varchar(45) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(45) DEFAULT NULL COMMENT '结束时间',
  `efficient` decimal(10,2) DEFAULT NULL COMMENT '效率',
  `tiller_order_value` decimal(10,2) DEFAULT NULL COMMENT '分捡金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`sys_user_id`,`record_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分捡记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiller_record`
--

LOCK TABLES `tiller_record` WRITE;
/*!40000 ALTER TABLE `tiller_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiller_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_collection`
--

DROP TABLE IF EXISTS `user_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) DEFAULT NULL COMMENT '所收藏的商品ID或者店铺ID',
  `type` smallint(2) DEFAULT NULL COMMENT ' 1 商品 2店铺',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `font_user_id` bigint(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  KEY `fk_user_collection_font_user1_idx` (`font_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_collection`
--

LOCK TABLES `user_collection` WRITE;
/*!40000 ALTER TABLE `user_collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_coupon`
--

DROP TABLE IF EXISTS `user_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(45) DEFAULT NULL COMMENT '优惠卷名称',
  `money` decimal(10,2) DEFAULT NULL COMMENT '抵扣金额',
  `use_start_time` datetime DEFAULT NULL COMMENT '使用开始时间',
  `use_end_time` datetime DEFAULT NULL COMMENT '使用结束时间',
  `coupon_type` tinyint(2) DEFAULT NULL COMMENT '优惠卷类别  1 无门槛  2 抵扣通用运费 3 满扣',
  `over_limit` decimal(10,2) DEFAULT NULL COMMENT '限定金额',
  `remark` varchar(150) DEFAULT NULL COMMENT '描述',
  `is_use` tinyint(4) DEFAULT '0' COMMENT '是否使用',
  `create_time` varchar(45) DEFAULT NULL COMMENT '创建时间',
  `font_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_coupon_font_user1_idx` (`font_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户拥有的优惠卷';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_coupon`
--

LOCK TABLES `user_coupon` WRITE;
/*!40000 ALTER TABLE `user_coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_goods_order`
--

DROP TABLE IF EXISTS `user_goods_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_goods_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `font_user_id` bigint(20) NOT NULL COMMENT '前端用户ID',
  `delivery_user_id` bigint(20) NOT NULL COMMENT '外送员用户ID',
  `total_pay` decimal(10,2) DEFAULT NULL COMMENT '总费用',
  `order_time` datetime DEFAULT NULL COMMENT '预定时间',
  `remark` varchar(150) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `order_from` smallint(2) DEFAULT NULL COMMENT '订单来源 1 app 2 小程序',
  `delivery_picture` varchar(150) DEFAULT NULL COMMENT '外送图片',
  `delivery_sort` smallint(10) DEFAULT NULL COMMENT '配送排序',
  `delivery_group` tinyint(3) DEFAULT '1' COMMENT '配送组别',
  `delivery_type` varchar(45) DEFAULT NULL COMMENT '配送方式 1 平台配送 2 商家配送',
  `dlivery_address` varchar(45) DEFAULT NULL COMMENT '外送地址',
  `delivery_fee` decimal(10,2) DEFAULT NULL COMMENT '外送费用(统一)',
  `delivery_extra_fee` decimal(10,2) DEFAULT NULL COMMENT '配送费用（额外）',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态  1 待付款  2 备货中 3  待配送 4 待收货  5 待评价',
  `pay_type` tinyint(2) DEFAULT NULL COMMENT '付款类型 1  预付款 2 货到付款',
  `deviant_rate` decimal(10,2) DEFAULT NULL COMMENT '订单异常率  此异常商品/此订单总商品',
  `tiller_user_id` bigint(20) DEFAULT NULL COMMENT '分拣员用户ID',
  `address_id` bigint(20) DEFAULT NULL COMMENT '地址ID\n',
  PRIMARY KEY (`id`),
  KEY `fk_goods_order_font_user2_idx` (`font_user_id`),
  KEY `fk_goods_order_delivery_user2_idx` (`delivery_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_goods_order`
--

LOCK TABLES `user_goods_order` WRITE;
/*!40000 ALTER TABLE `user_goods_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_goods_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_statistics_record`
--

DROP TABLE IF EXISTS `user_statistics_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_statistics_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_date` datetime DEFAULT NULL COMMENT '精确到天',
  `register_number` int(11) DEFAULT NULL COMMENT '注册用户数量',
  `buy_user_number` int(11) DEFAULT NULL COMMENT '有下单购买用户数',
  `platform_total_number` int(11) DEFAULT NULL COMMENT '当前平台用户数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户报表统计';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_statistics_record`
--

LOCK TABLES `user_statistics_record` WRITE;
/*!40000 ALTER TABLE `user_statistics_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_statistics_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_view`
--

DROP TABLE IF EXISTS `user_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_view` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '看过的商品ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `font_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_view_font_user1_idx` (`font_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户足迹';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_view`
--

LOCK TABLES `user_view` WRITE;
/*!40000 ALTER TABLE `user_view` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variety_category`
--

DROP TABLE IF EXISTS `variety_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `variety_category` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父亲ID，预留',
  `variety_name` varchar(60) DEFAULT NULL COMMENT '品类名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort_number` smallint(10) DEFAULT NULL COMMENT '排序',
  `is_show` tinyint(4) DEFAULT '1' COMMENT '是否显示',
  `is_chosen` tinyint(4) DEFAULT '1' COMMENT '是否精选分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品类类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variety_category`
--

LOCK TABLES `variety_category` WRITE;
/*!40000 ALTER TABLE `variety_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `variety_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variety_category_has_shop_base_info`
--

DROP TABLE IF EXISTS `variety_category_has_shop_base_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `variety_category_has_shop_base_info` (
  `variety_category_id` bigint(20) NOT NULL COMMENT '品种分类ID',
  `shop_base_info_id` bigint(20) NOT NULL COMMENT '商铺ID',
  PRIMARY KEY (`variety_category_id`,`shop_base_info_id`),
  KEY `fk_variety_category_has_shop_base_info_shop_base_info1_idx` (`shop_base_info_id`),
  KEY `fk_variety_category_has_shop_base_info_variety_category1_idx` (`variety_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variety_category_has_shop_base_info`
--

LOCK TABLES `variety_category_has_shop_base_info` WRITE;
/*!40000 ALTER TABLE `variety_category_has_shop_base_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `variety_category_has_shop_base_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-07  9:29:21
