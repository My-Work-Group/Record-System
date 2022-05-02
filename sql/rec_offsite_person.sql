/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ry

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2022-05-02 23:39:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rec_offsite_person
-- ----------------------------
DROP TABLE IF EXISTS `rec_offsite_person`;
CREATE TABLE `rec_offsite_person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `person_name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(1) NOT NULL COMMENT '性别',
  `number_id` bigint(20) NOT NULL COMMENT '身份证号',
  `age` varchar(11) NOT NULL COMMENT '年龄',
  `person_phone` varchar(11) NOT NULL COMMENT '手机号',
  `home_address` varchar(30) NOT NULL COMMENT '家庭住址',
  `work_unit` varchar(30) NOT NULL COMMENT '工作单位',
  `post` varchar(20) NOT NULL COMMENT '职务',
  `contact_address` varchar(30) NOT NULL COMMENT '联系地址',
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `person_name` (`person_name`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='个人信息表';

-- ----------------------------
-- Records of rec_offsite_person
-- ----------------------------
INSERT INTO `rec_offsite_person` VALUES ('38', '庞沛东', '男', '412587954236545155', '24', '13007608847', '澄江街道春申路8号黄山小区13幢209室', '江苏省无锡市江阴市五星路18号交通运输局', '无', '澄江街道春申路8号黄山小区13幢209室');
INSERT INTO `rec_offsite_person` VALUES ('52', '黎明', '1', '411402199509166736', '26', '13007608847', '澄江街道春申路8号黄山小区13幢209室', '江苏省无锡市江阴市五星路18号交通运输局', '无', '澄江街道春申路8号黄山小区13幢209室');
INSERT INTO `rec_offsite_person` VALUES ('55', '陈恒山', '1', '320825196603184930', '55', '18626359798', '江苏省泗阳县爱园镇倪圩村一组64号', '驻马店市路龙汽车销售服务有限公司', '驾驶员', '澄江街道春申路8号黄山小区13幢209室');
