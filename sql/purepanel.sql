/*
 Navicat Premium Dump SQL

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 90300 (9.3.0)
 Source Host           : localhost:3306
 Source Schema         : purepanel

 Target Server Type    : MySQL
 Target Server Version : 90300 (9.3.0)
 File Encoding         : 65001

 Date: 25/07/2025 00:34:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `pid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父级id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
  `order_no` int NOT NULL DEFAULT '0' COMMENT '排序号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
  `version` int NOT NULL DEFAULT '0' COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='群组信息表';

-- ----------------------------
-- Records of sys_group
-- ----------------------------
BEGIN;
INSERT INTO `sys_group` (`id`, `pid`, `name`, `order_no`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `version`) VALUES ('1', NULL, '长安科技集团', 0, '2025-07-07 05:35:12', '2025-07-08 14:08:32', NULL, NULL, 0);
INSERT INTO `sys_group` (`id`, `pid`, `name`, `order_no`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `version`) VALUES ('2', '1', '行政部', 0, '2025-07-07 05:40:00', '2025-07-08 14:08:40', NULL, NULL, 0);
INSERT INTO `sys_group` (`id`, `pid`, `name`, `order_no`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `version`) VALUES ('3', '1', '市场部', 1, '2025-07-07 05:42:05', '2025-07-20 00:24:36', NULL, NULL, 6);
INSERT INTO `sys_group` (`id`, `pid`, `name`, `order_no`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `version`) VALUES ('4', '2', '人事', 0, '2025-07-07 05:35:12', '2025-07-17 15:13:04', NULL, NULL, 0);
INSERT INTO `sys_group` (`id`, `pid`, `name`, `order_no`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `version`) VALUES ('5', '2', '财务', 1, '2025-07-07 05:35:12', '2025-07-17 16:08:35', NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `pid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父级id',
  `type` tinyint NOT NULL COMMENT '菜单类型 0菜单 1按钮 2菜单组',
  `path` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '访问路径',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `order_no` int NOT NULL DEFAULT '0' COMMENT '菜单展示顺序',
  `is_hidden` tinyint NOT NULL DEFAULT '0' COMMENT '是否隐藏 0否1是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
  `menu_level` int NOT NULL COMMENT '菜单层级',
  `auth_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '授权编码',
  `version` int NOT NULL DEFAULT '0' COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='权限定义表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` (`id`, `pid`, `type`, `path`, `title`, `icon`, `order_no`, `is_hidden`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `menu_level`, `auth_code`, `version`) VALUES ('1', NULL, 0, '/home', '首页', 'home', 0, 0, '2025-06-23 06:08:00', '2025-06-27 05:42:24', NULL, NULL, 2, NULL, 0);
INSERT INTO `sys_permission` (`id`, `pid`, `type`, `path`, `title`, `icon`, `order_no`, `is_hidden`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `menu_level`, `auth_code`, `version`) VALUES ('1941127559303680001', '6', 0, '/user', '用户管理', 'user-setting', 2, 0, '2025-07-04 13:30:49', '2025-07-04 15:33:20', NULL, NULL, 3, NULL, 5);
INSERT INTO `sys_permission` (`id`, `pid`, `type`, `path`, `title`, `icon`, `order_no`, `is_hidden`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `menu_level`, `auth_code`, `version`) VALUES ('1942393667177238530', '6', 0, '/group', '群组管理', 'usergroup', 3, 0, '2025-07-08 09:21:52', NULL, NULL, NULL, 2, NULL, 0);
INSERT INTO `sys_permission` (`id`, `pid`, `type`, `path`, `title`, `icon`, `order_no`, `is_hidden`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `menu_level`, `auth_code`, `version`) VALUES ('1942480488057921537', '6', 0, '/role', '角色管理', 'user-marked', 4, 0, '2025-07-08 15:06:52', NULL, NULL, NULL, 2, NULL, 0);
INSERT INTO `sys_permission` (`id`, `pid`, `type`, `path`, `title`, `icon`, `order_no`, `is_hidden`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `menu_level`, `auth_code`, `version`) VALUES ('6', NULL, 2, '', '系统管理', 'system-setting', 1, 0, '2025-06-23 06:08:00', '2025-07-07 05:45:12', NULL, NULL, 1, NULL, 1);
INSERT INTO `sys_permission` (`id`, `pid`, `type`, `path`, `title`, `icon`, `order_no`, `is_hidden`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `menu_level`, `auth_code`, `version`) VALUES ('7', '6', 0, '/permission', '菜单权限', 'view-list', 1, 0, '2025-06-23 06:08:00', '2025-07-01 10:29:22', NULL, NULL, 3, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
  `version` int NOT NULL DEFAULT '0' COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色定义表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`id`, `name`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `version`) VALUES ('1', 'ROOT', '2025-06-26 05:14:19', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色 ID',
  `permission_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色权限关联表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES ('1948419695626469378', '1', '1942480488057921537');
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES ('1948419695634857985', '1', '6');
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES ('1948419695634857986', '1', '7');
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES ('1948419695634857987', '1', '1941127559303680001');
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES ('1948419695634857988', '1', '1942393667177238530');
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES ('1948420127287459842', '2', '1');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号 全局唯一',
  `pwd` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `salt` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码盐',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态 0禁用 1启用',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
  `version` int NOT NULL DEFAULT '0' COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `account_unq` (`account`) USING BTREE COMMENT '账号唯一索引',
  KEY `idx` (`name`) USING BTREE COMMENT '查询索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `name`, `account`, `pwd`, `salt`, `avatar`, `status`, `email`, `phone_number`, `create_time`, `update_time`, `create_by_user_id`, `update_by_user_id`, `version`) VALUES ('1948042872317145090', '管理员', 'admin', '91cd443c866ab888fc0cf781690159e1', 'tleXavQC', NULL, 1, NULL, NULL, '2025-07-23 23:29:48', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_group`;
CREATE TABLE `sys_user_group` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `group_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '群组ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户群组关联表';

-- ----------------------------
-- Records of sys_user_group
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_group` (`id`, `user_id`, `group_id`) VALUES ('1948042872526860290', '1948042872317145090', '1');
INSERT INTO `sys_user_group` (`id`, `user_id`, `group_id`) VALUES ('1948050397166936066', '1', '2');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户 ID',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES ('1948042872686243842', '1948042872317145090', '1');
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES ('1948050397305348098', '1', '1');
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES ('1948420095360417794', '2', '2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
