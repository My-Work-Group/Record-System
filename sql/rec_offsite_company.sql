/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-05-02 23:39:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rec_offsite_company
-- ----------------------------
DROP TABLE IF EXISTS `rec_offsite_company`;
CREATE TABLE `rec_offsite_company` (
  `company_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `company_name` varchar(30) NOT NULL COMMENT '公司名称',
  `credit_code` varchar(20) NOT NULL COMMENT '统一社会信用代码',
  `director_name` varchar(30) NOT NULL COMMENT '法人姓名',
  `director_num_id` bigint(20) NOT NULL COMMENT '法人身份证号',
  `company_address` varchar(30) NOT NULL COMMENT '公司地址',
  `company_phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `company_name` (`company_name`,`credit_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='公司信息表';

-- ----------------------------
-- Records of rec_offsite_company
-- ----------------------------
INSERT INTO `rec_offsite_company` VALUES ('7', '申通物流有限 公司', '88888', '庞沛东', '411402199509166736', '澄江街道春申路8号黄山小区13幢209室', '13007608847');
