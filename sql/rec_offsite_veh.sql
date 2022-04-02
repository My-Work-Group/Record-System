/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-04-02 16:05:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rec_offsite_veh
-- ----------------------------
DROP TABLE IF EXISTS `rec_offsite_veh`;
CREATE TABLE `rec_offsite_veh` (
  `veh_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `veh_plate_num` varchar(20) NOT NULL COMMENT '车牌号',
  `plate_color` varchar(1) NOT NULL COMMENT '车牌颜色',
  `veh_type` varchar(20) NOT NULL COMMENT '车型',
  `veh_axes` int(4) NOT NULL COMMENT '轴数',
  `person_id` bigint(20) DEFAULT NULL COMMENT '所属个人编号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司编号',
  PRIMARY KEY (`veh_id`),
  UNIQUE KEY `veh_plate_num` (`veh_plate_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息表';

-- ----------------------------
-- Records of rec_offsite_veh
-- ----------------------------
