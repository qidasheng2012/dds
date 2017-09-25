/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : bing-upms

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-09-26 00:34:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级ID',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名',
  `type` smallint(6) DEFAULT NULL COMMENT '类型 0、菜单 1、功能',
  `sort` smallint(6) DEFAULT NULL COMMENT '排序',
  `url` varchar(100) DEFAULT NULL COMMENT '地址',
  `perm_code` varchar(30) DEFAULT NULL COMMENT '权限编码',
  `icon` varchar(30) DEFAULT NULL COMMENT '图标',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `status` smallint(6) DEFAULT NULL COMMENT '状态 0、禁用 1、正常',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='permission 权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', '系统管理', '0', '100', '-', '-', 'fa fa-cog fa-fw', '系统管理员目录', '1', '2017-09-12 16:48:53', '2017-09-21 16:57:15');
INSERT INTO `permission` VALUES ('2', '1', '用户管理', '1', '110', '/admin/user/list', '1', 'fa fa-user', '用户管理', '1', '2017-09-12 16:52:28', '2017-09-21 16:57:31');
INSERT INTO `permission` VALUES ('3', '1', '角色管理', '1', '120', '/admin/role/list', '1', 'fa fa-circle', '角色管理', '1', '2017-09-12 16:52:34', '2017-09-21 16:58:33');
INSERT INTO `permission` VALUES ('4', '1', '权限管理', '1', '130', '/admin/permission/list', 'user:add', 'fa fa-shirtsinbulk', '权限管理', '1', '2017-09-12 16:52:40', '2017-09-21 16:58:40');
INSERT INTO `permission` VALUES ('5', '0', '测试', '0', '200', '-', '-', 'fa fa-columns', '-', '1', '2017-09-12 16:52:45', '2017-09-21 16:58:52');
INSERT INTO `permission` VALUES ('10', '0', '业务管理', '0', '300', '-', '-', 'fa fa-tag', '-', '1', '2017-09-21 09:34:26', '2017-09-21 16:59:01');
INSERT INTO `permission` VALUES ('11', '10', '批次管理', '1', '310', '/admin/ossStudybatch/list', '-', 'fa fa-bank', '-', '1', '2017-09-21 10:57:25', '2017-09-21 17:01:04');
INSERT INTO `permission` VALUES ('12', '10', '课程管理', '1', '320', '/admin/ossCourseinfo/list', '-', 'fa fa-book', '-', '1', '2017-09-21 10:58:33', '2017-09-21 17:01:19');
INSERT INTO `permission` VALUES ('14', '10', '成绩管理', '1', '340', '-', '-', 'fa fa-file-excel-o', '-', '1', '2017-09-21 11:00:53', '2017-09-21 17:01:58');
INSERT INTO `permission` VALUES ('15', '10', '课件管理', '1', '330', '/admin/ossCourseware/list', '-', 'fa fa-folder', '-', '1', '2017-09-21 17:04:07', '2017-09-21 17:07:42');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '角色名',
  `sort` smallint(6) DEFAULT NULL COMMENT '排序',
  `description` varchar(60) DEFAULT NULL COMMENT '描述',
  `status` smallint(5) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='role 角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', '0', '开发人员', '1', '2017-09-12 16:47:04', '2017-09-12 16:47:07');
INSERT INTO `role` VALUES ('2', '超级管理员', '1', '超级管理员', '1', '2017-09-12 17:04:33', '2017-09-12 17:04:35');
INSERT INTO `role` VALUES ('3', 'test', '123', '123', '1', '2017-09-18 13:05:19', null);
INSERT INTO `role` VALUES ('5', '123', '123', '123', '1', '2017-09-18 15:00:32', null);
INSERT INTO `role` VALUES ('7', '123', '123', '123', '1', '2017-09-19 00:17:10', '2017-09-19 00:21:33');
INSERT INTO `role` VALUES ('8', 't测试', '12', '1', '1', '2017-09-22 12:37:59', '2017-09-22 12:38:11');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` bigint(20) unsigned DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) unsigned DEFAULT NULL COMMENT '权限ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='role_permission 角色权限表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('57', '2', '1', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('58', '2', '2', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('59', '2', '3', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('60', '2', '4', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('61', '2', '15', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('62', '2', '5', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('63', '2', '10', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('64', '2', '11', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('65', '2', '12', '2017-09-21 17:07:19', null);
INSERT INTO `role_permission` VALUES ('66', '2', '14', '2017-09-21 17:07:19', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` smallint(6) DEFAULT NULL COMMENT '0、禁用 1、正常',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8 COMMENT='user 用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'test', 'test', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('3', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('4', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-18 13:38:06');
INSERT INTO `user` VALUES ('5', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('6', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('7', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('8', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('9', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('12', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('13', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '0', '2017-09-13 09:40:18', '2017-09-21 09:26:36');
INSERT INTO `user` VALUES ('14', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('15', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('16', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('17', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('18', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('19', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('20', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('21', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('22', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('23', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('24', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('25', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('26', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('27', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('28', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('29', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('30', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('31', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('32', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('33', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('34', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('35', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('36', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('37', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('38', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('39', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('40', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('41', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('42', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('43', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('44', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('45', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('46', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('47', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('48', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('49', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('50', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('51', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('52', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('53', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('54', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('55', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('56', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('57', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('58', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('59', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('60', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('61', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('62', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('63', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('64', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('65', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('66', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('67', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('68', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('69', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('70', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('71', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('72', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('73', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('74', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('75', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('76', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('77', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('78', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('79', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('80', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('81', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('82', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('83', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('84', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('85', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('86', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('87', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('88', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('89', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('90', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('91', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('92', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('93', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('94', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('95', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('96', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('97', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('98', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('99', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('100', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('101', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('102', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('103', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('104', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('105', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('106', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('107', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('108', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('109', 'test123', 'test123', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2017-09-13 09:40:18', '2017-09-13 09:40:20');
INSERT INTO `user` VALUES ('110', 'XiaoBingBy', 'xiaobingby', '9a44cb11130d98f26f38ae24fcc7d4d2', '1505668300861', 'admin@qq.com', '1', '2017-09-18 01:11:58', null);
INSERT INTO `user` VALUES ('111', 'test123', 'test123', 'b49e30146ca41a3471c077e5fb2ea3a9', '1505668351830', 'admin@qq', '1', '2017-09-18 01:12:32', null);
INSERT INTO `user` VALUES ('112', 'fkdjsfj', 'fdjksfjlskdfj', 'b1fadb710b33dbd57bb6d76eba87272d', '1505668482978', 'admin@qqq.com', '1', '2017-09-18 01:14:43', null);
INSERT INTO `user` VALUES ('113', 'bing', 'bing', 'ec2e3bdab94fe834317d95458559712d', '1505670762376', 'admin@qq.com', '0', '2017-09-18 01:52:42', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` bigint(20) unsigned DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) unsigned DEFAULT NULL COMMENT '角色ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='user_role 用户角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('20', '2', '2', '2017-09-21 17:07:07', null);
