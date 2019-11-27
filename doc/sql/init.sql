SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
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
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='permission 权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '0', '系统管理', '0', '100', '-', '-', 'fa fa-cog fa-fw', '系统管理员目录', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `t_permission` VALUES ('2', '1', '用户管理', '1', '110', '/user/toList', 'user:show', 'fa fa-user', '用户管理', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `t_permission` VALUES ('3', '1', '角色管理', '1', '120', '/role/toList', '1', 'fa fa-circle', '角色管理', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `t_permission` VALUES ('4', '1', '权限管理', '1', '130', '/permission/toList', '-', 'fa fa-shirtsinbulk', '权限管理', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `t_permission` VALUES ('5', '0', '测试', '0', '200', '/user/toList', '-', 'fa fa-columns', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `t_permission` VALUES ('10', '0', '业务管理', '0', '300', '-', '-', 'fa fa-tag', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `t_permission` VALUES ('11', '10', '产品管理', '1', '310', '/product/toList', '-', 'fa fa-bank', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `t_permission` VALUES ('17', '2', '添加用户', '2', '110', '-', 'user:add', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `t_permission` VALUES ('18', '2', '修改用户', '2', '110', '-', 'user:update', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `t_permission` VALUES ('19', '2', '分配角色', '2', '110', '-', 'user:distribution', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `t_permission` VALUES ('20', '2', '审核通过', '2', '110', '-', 'user:optionUserStatus', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `t_permission` VALUES ('21', '2', '删除用户', '2', '110', '-', 'user:delete', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `t_permission` VALUES ('22', '5', '测试用户无权限', '1', '1', '/user/toList', '-', 'fa fa-telegram', '测试用户无权限', '1', '2019-11-25 16:48:53', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '角色名',
  `sort` smallint(6) DEFAULT NULL COMMENT '排序',
  `description` varchar(60) DEFAULT NULL COMMENT '描述',
  `status` smallint(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='role 角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '1', '超级管理员', '1', '2019-11-25 17:04:33', '2019-11-25 17:04:35');
INSERT INTO `t_role` VALUES ('2', '审批员', '2', '审批员', '1', '2019-11-25 15:53:14', null);
INSERT INTO `t_role` VALUES ('3', '测试员', '3', '无权限', '1', '2017-11-05 14:35:16', null);

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` bigint(20) unsigned DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) unsigned DEFAULT NULL COMMENT '权限ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='role_permission 角色权限表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('20', '1', '1', null, null);
INSERT INTO `t_role_permission` VALUES ('21', '1', '2', null, null);
INSERT INTO `t_role_permission` VALUES ('22', '1', '17', null, null);
INSERT INTO `t_role_permission` VALUES ('23', '1', '18', null, null);
INSERT INTO `t_role_permission` VALUES ('24', '1', '19', null, null);
INSERT INTO `t_role_permission` VALUES ('25', '1', '20', null, null);
INSERT INTO `t_role_permission` VALUES ('26', '1', '21', null, null);
INSERT INTO `t_role_permission` VALUES ('27', '1', '3', null, null);
INSERT INTO `t_role_permission` VALUES ('28', '1', '4', null, null);
INSERT INTO `t_role_permission` VALUES ('29', '1', '10', null, null);
INSERT INTO `t_role_permission` VALUES ('30', '1', '11', null, null);
INSERT INTO `t_role_permission` VALUES ('31', '1', '12', null, null);
INSERT INTO `t_role_permission` VALUES ('32', '2', '1', null, null);
INSERT INTO `t_role_permission` VALUES ('33', '2', '2', null, null);
INSERT INTO `t_role_permission` VALUES ('34', '2', '20', null, null);
INSERT INTO `t_role_permission` VALUES ('35', '3', '5', null, null);
INSERT INTO `t_role_permission` VALUES ('36', '3', '22', null, null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` smallint(6) DEFAULT NULL COMMENT '0、禁用 1、正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user 用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'root', 'root', '9b95430b2b1aa666dc9a10d2cca6ad9a', '1574681263821', 'root@163.com', '1', null, null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` bigint(20) unsigned DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) unsigned DEFAULT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user_role 用户角色关联表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '2019-11-25 17:07:07', null);
