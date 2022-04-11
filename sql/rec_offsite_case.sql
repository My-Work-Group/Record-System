/*
Navicat MySQL Data Transfer

Source Server         : pangpd
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-04-11 21:01:32
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
  `create_time` datetime NOT NULL COMMENT '立案时间',
  `veh_plate_num` varchar(20) NOT NULL COMMENT '车牌号',
  `person_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`case_id`),
  UNIQUE KEY `case_number` (`case_number`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COMMENT='案件信息表';

-- ----------------------------
-- Records of rec_offsite_case
-- ----------------------------
INSERT INTO `rec_offsite_case` VALUES ('79', '锡交路罚字〔2022〕3001号', '个人', '2022-04-09 17:45:00', '苏B1111', null, null);
INSERT INTO `rec_offsite_case` VALUES ('80', '锡交路罚字〔2022〕3002号', '个人', '2022-04-24 17:45:00', '苏B1111', null, null);
INSERT INTO `rec_offsite_case` VALUES ('81', '锡交路罚字〔2022〕303号', '个人', '2022-04-08 18:39:00', '苏B3333', null, null);
INSERT INTO `rec_offsite_case` VALUES ('82', '锡交路罚字〔2022〕30012号', '个人', '2022-04-08 18:59:00', '苏B9999', null, null);
INSERT INTO `rec_offsite_case` VALUES ('83', '锡交路罚字〔2022〕30035号', '个人', '2022-04-10 13:15:06', '苏B1234', null, null);
INSERT INTO `rec_offsite_case` VALUES ('84', '锡交路罚字〔2022〕30088号', '公司', '2022-04-10 13:20:51', '苏B8910', null, null);
