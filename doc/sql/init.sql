SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`
(
  `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid`          bigint(20) DEFAULT NULL COMMENT '上级ID',
  `name`         varchar(50)  DEFAULT NULL COMMENT '权限名',
  `type`         smallint(6) DEFAULT NULL COMMENT '类型 0、菜单 1、功能',
  `sort`         smallint(6) DEFAULT NULL COMMENT '排序',
  `url`          varchar(100) DEFAULT NULL COMMENT '地址',
  `perm_code`    varchar(30)  DEFAULT NULL COMMENT '权限编码',
  `icon`         varchar(30)  DEFAULT NULL COMMENT '图标',
  `description`  varchar(100) DEFAULT NULL COMMENT '描述',
  `status`       smallint(6) DEFAULT NULL COMMENT '状态 0、禁用 1、正常',
  `gmt_create`   datetime     DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime     DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='permission 权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', '系统管理', '0', '100', '-', '-', 'fa fa-cog fa-fw', '系统管理员目录', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('2', '1', '用户管理', '1', '110', '/admin/user/list', 'user:show', 'fa fa-user', '用户管理', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('3', '1', '角色管理', '1', '120', '/admin/role/list', '1', 'fa fa-circle', '角色管理', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('4', '1', '权限管理', '1', '130', '/admin/permission/list', '-', 'fa fa-shirtsinbulk', '权限管理', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('5', '0', '测试', '0', '200', '/user/list', '-', 'fa fa-columns', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('10', '0', '业务管理', '0', '300', '-', '-', 'fa fa-tag', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('11', '10', '批次管理', '1', '310', '/admin/ossStudybatch/list', '-', 'fa fa-bank', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('12', '10', '课程管理', '1', '320', '/admin/ossCourseinfo/list', '-', 'fa fa-book', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('14', '10', '成绩管理', '1', '340', '-', '-', 'fa fa-file-excel-o', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('15', '10', '添加课件', '1', '330', '/admin/ossCourseware/addCoursewareView', '-', 'fa fa-folder', '-', '1', '2019-11-25 16:48:53', '2019-11-25 16:48:53');
INSERT INTO `permission` VALUES ('16', '10', '课件管理', '1', '335', '/admin/ossCourseware/list', '-', '-', '课件管理', '1', '2019-11-25 16:48:53', null);
INSERT INTO `permission` VALUES ('17', '2', '添加用户', '2', '110', '-', 'user:add', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `permission` VALUES ('18', '2', '修改用户', '2', '110', '-', 'user:update', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `permission` VALUES ('19', '2', '分配角色', '2', '110', '-', 'user:distribution', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `permission` VALUES ('20', '2', '审核通过', '2', '110', '-', 'user:optionUserStatus', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `permission` VALUES ('21', '2', '删除用户', '2', '110', '-', 'user:delete', '-', '-', '1', '2019-11-25 16:48:53', null);
INSERT INTO `permission` VALUES ('22', '5', '测试用户无权限', '1', '1', '/admin/user/list', '-', 'fa fa-telegram', '测试用户无权限', '1', '2019-11-25 16:48:53', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
  `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name`         varchar(30) DEFAULT NULL COMMENT '角色名',
  `sort`         smallint(6) DEFAULT NULL COMMENT '排序',
  `description`  varchar(60) DEFAULT NULL COMMENT '描述',
  `status`       smallint(5) DEFAULT NULL,
  `gmt_create`   datetime    DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime    DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='role 角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '1', '超级管理员', '1', '2019-11-25 17:04:33', '2019-11-25 17:04:35');
INSERT INTO `role` VALUES ('2', '审批', '2', '审批员', '1', '2019-11-25 15:53:14', '2019-11-25 19:17:40');
INSERT INTO `role` VALUES ('3', '测试无权限', '3', '测试无权限', '1', '2017-11-05 14:35:16', '2019-11-25 14:35:24');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`
(
  `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid`          bigint(20) unsigned DEFAULT NULL COMMENT '角色ID',
  `pid`          bigint(20) unsigned DEFAULT NULL COMMENT '权限ID',
  `gmt_create`   datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='role_permission 角色权限表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '2', '1', '2019-11-25 15:53:33', null);
INSERT INTO `role_permission` VALUES ('2', '2', '2', '2019-11-25 15:53:33', null);
INSERT INTO `role_permission` VALUES ('3', '2', '20', '2019-11-25 15:53:33', null);
INSERT INTO `role_permission` VALUES ('4', '1', '1', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('5', '1', '2', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('6', '1', '20', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('7', '1', '19', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('8', '1', '18', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('9', '1', '17', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('10', '1', '21', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('11', '1', '3', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('12', '1', '4', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('13', '1', '10', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('14', '1', '11', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('15', '1', '12', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('16', '1', '15', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('17', '1', '16', '2019-11-25 15:56:28', null);
INSERT INTO `role_permission` VALUES ('18', '3', '5', '2019-11-25 14:38:27', null);
INSERT INTO `role_permission` VALUES ('19', '3', '22', '2019-11-25 14:38:27', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
  `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username`     varchar(50) DEFAULT NULL COMMENT '用户名',
  `nickname`     varchar(50) DEFAULT NULL COMMENT '昵称',
  `password`     varchar(50) DEFAULT NULL COMMENT '密码',
  `salt`         varchar(50) DEFAULT NULL COMMENT '盐',
  `email`        varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status`       smallint(6) DEFAULT NULL COMMENT '0、禁用 1、正常',
  `gmt_create`   datetime    DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime    DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user 用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', 'test', 'd829b843a6550a947e82f2f38ed6b7a7', '123', 'admin@qq.com', '1', '2019-11-25 09:40:18', '2019-11-25 09:40:20');
INSERT INTO `user` VALUES ('2', 'root', 'root', '9b95430b2b1aa666dc9a10d2cca6ad9a', '1574681263821', 'root@163.com', '1', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
  `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid`          bigint(20) unsigned DEFAULT NULL COMMENT '用户ID',
  `rid`          bigint(20) unsigned DEFAULT NULL COMMENT '角色ID',
  `gmt_create`   datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY            `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user_role 用户角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2019-11-25 17:07:07', null);
INSERT INTO `user_role` VALUES ('2', '2', '1', null, null);
