/*
Navicat MySQL Data Transfer

Source Server         : pangpd
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-04-07 20:55:33
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
  `person_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`case_id`),
  UNIQUE KEY `case_number` (`case_number`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='案件信息表';

-- ----------------------------
-- Records of rec_offsite_case
-- ----------------------------
INSERT INTO `rec_offsite_case` VALUES ('79', '锡交路罚字〔2022〕3001号', '个人', '2022-04-09 17:45:00', '苏B1111', null, null);
INSERT INTO `rec_offsite_case` VALUES ('80', '锡交路罚字〔2022〕3002号', '个人', '2022-04-24 17:45:00', '苏B1111', null, null);
INSERT INTO `rec_offsite_case` VALUES ('81', '锡交路罚字〔2022〕303号', '个人', '2022-04-08 18:39:00', '苏B3333', null, null);
INSERT INTO `rec_offsite_case` VALUES ('82', '锡交路罚字〔2022〕30012号', '个人', '2022-04-08 18:59:00', '苏B9999', null, null);
