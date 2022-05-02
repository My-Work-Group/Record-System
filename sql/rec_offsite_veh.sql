/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-05-02 23:39:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rec_offsite_veh
-- ----------------------------
DROP TABLE IF EXISTS `rec_offsite_veh`;
CREATE TABLE `rec_offsite_veh` (
  `veh_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `veh_plate_num` varchar(20) NOT NULL COMMENT '车牌号',
  `veh_plate_color` varchar(1) NOT NULL COMMENT '车牌颜色',
  `veh_type` varchar(20) NOT NULL COMMENT '车型',
  `veh_axes` int(4) NOT NULL COMMENT '轴数',
  PRIMARY KEY (`veh_id`),
  UNIQUE KEY `veh_plate_num` (`veh_plate_num`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='车辆信息表';

-- ----------------------------
-- Records of rec_offsite_veh
-- ----------------------------
INSERT INTO `rec_offsite_veh` VALUES ('30', '苏B1111', '黄', '半挂1122', '2');
INSERT INTO `rec_offsite_veh` VALUES ('32', '苏B3333', '黄', '半挂1122', '2');
INSERT INTO `rec_offsite_veh` VALUES ('33', '苏B9999', '黄', '半挂1122', '2');
INSERT INTO `rec_offsite_veh` VALUES ('34', '苏B1234', '黄', '半挂166', '6');
INSERT INTO `rec_offsite_veh` VALUES ('35', '苏B8910', '黄', '小型货车', '2');
INSERT INTO `rec_offsite_veh` VALUES ('36', '苏B987', '黄', '半挂', '2');
INSERT INTO `rec_offsite_veh` VALUES ('39', '豫QC7332', '黄', '重型自卸货车 ', '6');
