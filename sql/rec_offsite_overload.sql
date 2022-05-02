/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-05-02 23:39:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rec_offsite_overload
-- ----------------------------
DROP TABLE IF EXISTS `rec_offsite_overload`;
CREATE TABLE `rec_offsite_overload` (
  `overload_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '超限信息id= 案件id',
  `check_time` datetime NOT NULL COMMENT '过车时间',
  `check_site` varchar(50) NOT NULL COMMENT '过车地点',
  `total_weight` bigint(20) NOT NULL COMMENT '车货总重',
  `out_weight` bigint(20) NOT NULL COMMENT '超限吨位',
  `goods` varchar(20) NOT NULL COMMENT '装载货物',
  `load_time` datetime NOT NULL COMMENT '装载时间',
  `load_site` varchar(50) NOT NULL COMMENT '装载地点',
  `dest` varchar(50) NOT NULL COMMENT '送往目的地',
  `veh_plate_num` varchar(20) NOT NULL COMMENT '车辆号',
  PRIMARY KEY (`overload_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='超限信息表';

-- ----------------------------
-- Records of rec_offsite_overload
-- ----------------------------
INSERT INTO `rec_offsite_overload` VALUES ('79', '2022-04-20 17:46:00', 'S122 K159+500云亭江阴大道东向西', '88', '20', '棉纱', '2022-04-20 17:46:00', '张家港', '云亭', '苏B1111');
INSERT INTO `rec_offsite_overload` VALUES ('80', '2022-04-20 17:46:00', 'S122 K159+500云亭江阴大道东向西', '88', '20', '棉纱', '2022-04-20 17:46:00', '张家港', '云亭', '苏B1111');
INSERT INTO `rec_offsite_overload` VALUES ('81', '2022-04-14 18:40:00', 'S122 K159+500云亭江阴大道东向西', '88', '20', '棉纱', '2022-04-22 18:40:00', '张家港', '云亭', '苏B3333');
INSERT INTO `rec_offsite_overload` VALUES ('82', '2022-04-25 18:59:00', 'S122 K159+500云亭江阴大道东向西', '88', '20', '棉纱', '2022-04-19 18:59:00', '张家港', '云亭', '苏B9999');
INSERT INTO `rec_offsite_overload` VALUES ('83', '2022-04-20 13:14:00', 'S122 K159+500云亭江阴大道东向西', '66', '23', '棉纱', '2022-04-12 13:15:00', '张家港', '云亭', '苏B1234');
INSERT INTO `rec_offsite_overload` VALUES ('84', '2022-05-04 13:20:00', 'S122 K159+500云亭江阴大道东向西', '29', '18', '快递', '2022-04-28 13:20:00', '江苏省常州市', '江阴市区', '苏B8910');
INSERT INTO `rec_offsite_overload` VALUES ('98', '2022-05-03 12:40:00', 'S122 K159+500云亭江阴大道东向西', '88', '3', '111', '2022-05-09 12:40:00', '张家港', '云亭', '苏B987');
INSERT INTO `rec_offsite_overload` VALUES ('101', '2022-05-08 14:14:00', 'S122 K159+500云亭江阴大道东向西', '45', '8', '泥土', '2022-04-21 14:14:00', '江阴3号码头', '江阴申港', '豫QC7332');
