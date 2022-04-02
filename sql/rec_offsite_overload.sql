/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-04-02 16:05:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rec_offsite_overload
-- ----------------------------
DROP TABLE IF EXISTS `rec_offsite_overload`;
CREATE TABLE `rec_offsite_overload` (
  `overload_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '超限信息id',
  `check_time` datetime NOT NULL COMMENT '过车时间',
  `check_site` varchar(20) NOT NULL COMMENT '过车地点',
  `total_weight` bigint(20) NOT NULL COMMENT '车货总重',
  `out_weight` bigint(20) NOT NULL COMMENT '超限吨位',
  `goods` varchar(20) NOT NULL COMMENT '装载货物',
  `load_time` datetime NOT NULL COMMENT '装载时间',
  `load_site` varchar(20) NOT NULL COMMENT '装载地点',
  `dest` varchar(20) NOT NULL COMMENT '送往目的地',
  `veh_plate_num` varchar(20) NOT NULL COMMENT '车辆号',
  PRIMARY KEY (`overload_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超限信息表';

-- ----------------------------
-- Records of rec_offsite_overload
-- ----------------------------
