/*
Navicat MySQL Data Transfer

Source Server         : root@172.16.234.141ps12345678
Source Server Version : 50718
Source Host           : 172.16.234.141:3306
Source Database       : ccgp

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-07-25 18:17:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for beijing
-- ----------------------------
DROP TABLE IF EXISTS `beijing`;
CREATE TABLE `beijing` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `title` char(255) DEFAULT NULL COMMENT '公告标题',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `area` char(10) DEFAULT NULL COMMENT '地区',
  `caigouren` char(255) DEFAULT NULL COMMENT '采购人',
  `href` char(255) NOT NULL COMMENT '链接',
  `status` char(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`href`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC  charSET=utf8;
-- ----------------------------
-- Table structure for hubei
-- ----------------------------
DROP TABLE IF EXISTS `hubei`;
CREATE TABLE `hubei` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `title` char(255) DEFAULT NULL COMMENT '公告标题',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `area` char(10) DEFAULT NULL COMMENT '地区',
  `caigouren` char(255) DEFAULT NULL COMMENT '采购人',
  `href` char(255) NOT NULL COMMENT '链接',
  `status` char(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`href`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC  charSET=utf8;

-- ----------------------------
-- Table structure for jiangsu
-- ----------------------------
DROP TABLE IF EXISTS `jiangsu`;
CREATE TABLE `jiangsu` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `title` char(255) DEFAULT NULL COMMENT '公告标题',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `area` char(10) DEFAULT NULL COMMENT '地区',
  `caigouren` char(255) DEFAULT NULL COMMENT '采购人',
  `href` char(255) NOT NULL COMMENT '链接',
  `status` char(50) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`href`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC charSET=utf8;

-- ----------------------------
-- Table structure for neimeng
-- ----------------------------
DROP TABLE IF EXISTS `neimeng`;
CREATE TABLE `neimeng` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `title` char(255) DEFAULT NULL COMMENT '公告标题',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `area` char(255) DEFAULT NULL COMMENT '地区',
  `caigouren` char(255) DEFAULT NULL COMMENT '采购人',
  `href` char(255) NOT NULL COMMENT '链接',
  `status` char(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`href`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC charSET=utf8;

-- ----------------------------
-- Table structure for sichuan
-- ----------------------------
DROP TABLE IF EXISTS `sichuan`;
CREATE TABLE `sichuan` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `title` char(255) DEFAULT NULL COMMENT '公告标题',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `area` char(10) DEFAULT NULL COMMENT '地区',
  `caigouren` char(255) DEFAULT NULL COMMENT '采购人',
  `href` char(255) NOT NULL COMMENT '链接',
  `status` char(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`href`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC charSET=utf8;

-- ----------------------------
-- Table structure for zhongyang
-- ----------------------------
DROP TABLE IF EXISTS `zhongyang`;
CREATE TABLE `zhongyang` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `title` char(255) DEFAULT NULL COMMENT '公告标题',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `area` char(10) DEFAULT NULL COMMENT '地区',
  `caigouren` char(255) DEFAULT NULL COMMENT '采购人',
  `href` char(255) NOT NULL COMMENT '链接',
  `status` char(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`href`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC charSET=utf8;
-- ----------------------------
-- Table structure for hebei
-- ----------------------------
DROP TABLE IF EXISTS `hebei`;
CREATE TABLE `hebei` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `title` char(255) DEFAULT NULL COMMENT '公告标题',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `area` char(10) DEFAULT NULL COMMENT '地区',
  `caigouren` char(255) DEFAULT NULL COMMENT '采购人',
  `href` char(255) NOT NULL COMMENT '链接',
  `status` char(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`href`)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC charSET=utf8;
-- ----------------------------
-- View structure for 北京view
-- ----------------------------
DROP VIEW IF EXISTS `北京view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `北京view` AS (select `beijing`.`id` AS `id`,`beijing`.`title` AS `title`,`beijing`.`time` AS `time`,`beijing`.`area` AS `area`,`beijing`.`caigouren` AS `caigouren`,`beijing`.`href` AS `href`,`beijing`.`status` AS `status` from `beijing` where ((`beijing`.`title` like '%非法集资%') or (`beijing`.`title` like '%金融%') or (`beijing`.`title` like '%网络监管%') or (`beijing`.`title` like '%网络监测%') or (`beijing`.`title` like '%大数据%') or (`beijing`.`title` like '%风险分析%') or (`beijing`.`title` like '%检测预警%') or (`beijing`.`title` like '%风险排查%') or (`beijing`.`title` like '%监管%') or (`beijing`.`title` like '%云资源%') or (`beijing`.`title` like '%银行%') or (`beijing`.`title` like '%政务%') or (`beijing`.`title` like '%证券%'))) ;

-- ----------------------------
-- View structure for 湖北view
-- ----------------------------
DROP VIEW IF EXISTS `湖北view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `湖北view` AS (select `hubei`.`id` AS `id`,`hubei`.`title` AS `title`,`hubei`.`time` AS `time`,`hubei`.`area` AS `area`,`hubei`.`caigouren` AS `caigouren`,`hubei`.`href` AS `href`,`hubei`.`status` AS `status` from `hubei` where ((`hubei`.`title` like '%非法集资%') or (`hubei`.`title` like '%金融%') or (`hubei`.`title` like '%网络监管%') or (`hubei`.`title` like '%网络监测%') or (`hubei`.`title` like '%大数据%') or (`hubei`.`title` like '%政务%') or (`hubei`.`title` like '%风险分析%') or (`hubei`.`title` like '%检测预警%') or (`hubei`.`title` like '%风险排查%') or (`hubei`.`title` like '%监管%') or (`hubei`.`title` like '%云资源%') or (`hubei`.`title` like '%银行%') or (`hubei`.`title` like '%证券%'))) ;

-- ----------------------------
-- View structure for 江苏view
-- ----------------------------
DROP VIEW IF EXISTS `江苏view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `江苏view` AS (select `jiangsu`.`id` AS `id`,`jiangsu`.`title` AS `title`,`jiangsu`.`time` AS `time`,`jiangsu`.`area` AS `area`,`jiangsu`.`caigouren` AS `caigouren`,`jiangsu`.`href` AS `href`,`jiangsu`.`status` AS `status` from `jiangsu` where ((`jiangsu`.`title` like '%非法集资%') or (`jiangsu`.`title` like '%金融%') or (`jiangsu`.`title` like '%网络监管%') or (`jiangsu`.`title` like '%网络监测%') or (`jiangsu`.`title` like '%大数据%') or (`jiangsu`.`title` like '%风险分析%') or (`jiangsu`.`title` like '%检测预警%') or (`jiangsu`.`title` like '%风险排查%') or (`jiangsu`.`title` like '%监管%') or (`jiangsu`.`title` like '%政务%') or (`jiangsu`.`title` like '%云资源%') or (`jiangsu`.`title` like '%银行%') or (`jiangsu`.`title` like '%证券%'))) ;

-- ----------------------------
-- View structure for 内蒙view
-- ----------------------------
DROP VIEW IF EXISTS `内蒙view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `内蒙view` AS (select `neimeng`.`id` AS `id`,`neimeng`.`title` AS `title`,`neimeng`.`time` AS `time`,`neimeng`.`area` AS `area`,`neimeng`.`caigouren` AS `caigouren`,`neimeng`.`href` AS `href`,`neimeng`.`status` AS `status` from `neimeng` where ((`neimeng`.`title` like '%非法集资%') or (`neimeng`.`title` like '%金融%') or (`neimeng`.`title` like '%网络监管%') or (`neimeng`.`title` like '%网络监测%') or (`neimeng`.`title` like '%政务%') or (`neimeng`.`title` like '%大数据%') or (`neimeng`.`title` like '%风险分析%') or (`neimeng`.`title` like '%检测预警%') or (`neimeng`.`title` like '%风险排查%') or (`neimeng`.`title` like '%监管%') or (`neimeng`.`title` like '%云资源%') or (`neimeng`.`title` like '%银行%') or (`neimeng`.`title` like '%证券%'))) ;

-- ----------------------------
-- View structure for 四川view
-- ----------------------------
DROP VIEW IF EXISTS `四川view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `四川view` AS (select `sichuan`.`id` AS `id`,`sichuan`.`title` AS `title`,`sichuan`.`time` AS `time`,`sichuan`.`area` AS `area`,`sichuan`.`caigouren` AS `caigouren`,`sichuan`.`href` AS `href`,`sichuan`.`status` AS `status` from `sichuan` where ((`sichuan`.`title` like '%非法集资%') or (`sichuan`.`title` like '%金融%') or (`sichuan`.`title` like '%网络监管%') or (`sichuan`.`title` like '%政务%') or (`sichuan`.`title` like '%网络监测%') or (`sichuan`.`title` like '%大数据%') or (`sichuan`.`title` like '%风险分析%') or (`sichuan`.`title` like '%检测预警%') or (`sichuan`.`title` like '%风险排查%') or (`sichuan`.`title` like '%监管%') or (`sichuan`.`title` like '%云资源%') or (`sichuan`.`title` like '%银行%') or (`sichuan`.`title` like '%证券%'))) ;

-- ----------------------------
-- View structure for 中央view
-- ----------------------------
DROP VIEW IF EXISTS `中央view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `中央view` AS (select `zhongyang`.`id` AS `id`,`zhongyang`.`title` AS `title`,`zhongyang`.`time` AS `time`,`zhongyang`.`area` AS `area`,`zhongyang`.`caigouren` AS `caigouren`,`zhongyang`.`href` AS `href`,`zhongyang`.`status` AS `status` from `zhongyang` where ((`zhongyang`.`title` like '%非法集资%') or (`zhongyang`.`title` like '%金融%') or (`zhongyang`.`title` like '%网络监管%') or (`zhongyang`.`title` like '%网络监测%') or (`zhongyang`.`title` like '%政务%') or (`zhongyang`.`title` like '%大数据%') or (`zhongyang`.`title` like '%风险分析%') or (`zhongyang`.`title` like '%检测预警%') or (`zhongyang`.`title` like '%风险排查%') or (`zhongyang`.`title` like '%监管%') or (`zhongyang`.`title` like '%云资源%') or (`zhongyang`.`title` like '%银行%') or (`zhongyang`.`title` like '%证券%'))) ;
-- ----------------------------
-- View structure for 河北view
-- ----------------------------
DROP VIEW IF EXISTS `河北view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `河北view` AS (select `hebei`.`id` AS `id`,`hebei`.`title` AS `title`,`hebei`.`time` AS `time`,`hebei`.`area` AS `area`,`hebei`.`caigouren` AS `caigouren`,`hebei`.`href` AS `href`,`hebei`.`status` AS `status` from `hebei` where ((`hebei`.`title` like '%非法集资%') or (`hebei`.`title` like '%金融%') or (`hebei`.`title` like '%网络监管%') or (`hebei`.`title` like '%网络监测%') or (`hebei`.`title` like '%大数据%') or (`hebei`.`title` like '%政务%') or (`hebei`.`title` like '%风险分析%') or (`hebei`.`title` like '%检测预警%') or (`hebei`.`title` like '%风险排查%') or (`hebei`.`title` like '%监管%') or (`hebei`.`title` like '%云资源%') or (`hebei`.`title` like '%银行%') or (`hebei`.`title` like '%证券%'))) ;
