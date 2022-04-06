/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-04-06 13:21:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rec_offsite_case
-- ----------------------------
DROP TABLE IF EXISTS `rec_offsite_case`;
CREATE TABLE `rec_offsite_case` (
  `case_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '案件id',
  `case_number` varchar(50) NOT NULL COMMENT '案件编号',
  `case_object` varchar(20) NOT NULL COMMENT '处罚对象',
  `case_time` datetime NOT NULL COMMENT '立案时间',
  `veh_plate_num` varchar(20) NOT NULL COMMENT '车牌号',
  PRIMARY KEY (`case_id`),
  UNIQUE KEY `case_number` (`case_number`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='案件信息表';
