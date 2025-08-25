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

 Date: 25/08/2025 17:56:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ai_chatbot_chat_record
-- ----------------------------
DROP TABLE IF EXISTS `ai_chatbot_chat_record`;
CREATE TABLE `ai_chatbot_chat_record`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一主键',
  `conversation_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '会话ID',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型 USER/ASSISTANT',
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'AI 聊天记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ai_chatbot_chat_record
-- ----------------------------
INSERT INTO `ai_chatbot_chat_record` VALUES ('bb6970536dd83a983ceaad2212277a38', '2', 'USER', '系统菜单权限现状', '2025-08-22 10:06:25', NULL);
INSERT INTO `ai_chatbot_chat_record` VALUES ('f3250d184c2aa199210d8c56ea264263', '2', 'ASSISTANT', '根据查询到的系统菜单权限信息，以下是当前系统菜单权限的结构和现状：\n\n---\n\n### **一级菜单：首页**\n- **路径**：`/home`\n- **图标**：`home`\n- **排序号**：0\n- **是否隐藏**：否\n- **权限级别**：2\n- **描述**：这是系统的主页面。\n\n---\n\n### **一级菜单：系统管理**\n- **路径**：空（父级菜单）\n- **图标**：`system-setting`\n- **排序号**：1\n- **是否隐藏**：否\n- **权限级别**：1\n- **子菜单**：\n  1. **菜单权限**\n     - **路径**：`/permission`\n     - **图标**：`view-list`\n     - **排序号**：1\n     - **是否隐藏**：否\n     - **权限级别**：3\n     - **描述**：用于管理系统的菜单权限定义。\n\n  2. **用户管理**\n     - **路径**：`/user`\n     - **图标**：`user-setting`\n     - **排序号**：2\n     - **是否隐藏**：否\n     - **权限级别**：3\n     - **子功能**：\n       - **按钮-新增用户**\n         - **路径**：空\n         - **图标**：无\n         - **排序号**：0\n         - **是否隐藏**：否\n         - **权限代码**：`SYS_USER_ADD`\n         - **权限级别**：4\n         - **描述**：新增用户功能的按钮权限。\n\n  3. **群组管理**\n     - **路径**：`/group`\n     - **图标**：`usergroup`\n     - **排序号**：3\n     - **是否隐藏**：否\n     - **权限级别**：2\n     - **描述**：用于管理用户群组。\n\n  4. **角色管理**\n     - **路径**：`/role`\n     - **图标**：`user-marked`\n     - **排序号**：4\n     - **是否隐藏**：否\n     - **权限级别**：2\n     - **描述**：用于管理系统角色。\n\n---\n\n### **总结**\n1. 系统目前有两个一级菜单：**首页** 和 **系统管理**。\n2. **系统管理** 菜单下包含四个子菜单：**菜单权限**、**用户管理**、**群组管理** 和 **角色管理**。\n3. **用户管理** 菜单下还定义了一个具体的按钮权限：**新增用户**（权限代码：`SYS_USER_ADD`），用于控制特定操作。\n4. 权限级别从高到低依次为：1（最高）、2、3、4（最低）。\n\n如果需要进一步调整或查询特定权限，请随时告知！', '2025-08-22 10:06:40', NULL);

-- ----------------------------
-- Table structure for ai_chatbot_conversation
-- ----------------------------
DROP TABLE IF EXISTS `ai_chatbot_conversation`;
CREATE TABLE `ai_chatbot_conversation`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一主键',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '会话标题',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'AI 聊天会话' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ai_chatbot_conversation
-- ----------------------------
INSERT INTO `ai_chatbot_conversation` VALUES ('2', '系统菜单权限现状', '1948042872317145090', '2025-08-22 10:06:25', NULL);

-- ----------------------------
-- Table structure for sys_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `pid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `order_no` int NOT NULL DEFAULT 0 COMMENT '排序号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `version` int NOT NULL DEFAULT 0 COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '群组信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_group
-- ----------------------------
INSERT INTO `sys_group` VALUES ('1', NULL, '长安科技集团', 0, '2025-07-07 05:35:12', '2025-07-08 14:08:32', NULL, NULL, 0);
INSERT INTO `sys_group` VALUES ('2', '1', '行政部', 0, '2025-07-07 05:40:00', '2025-07-08 14:08:40', NULL, NULL, 0);
INSERT INTO `sys_group` VALUES ('3', '1', '市场部', 1, '2025-07-07 05:42:05', '2025-07-20 00:24:36', NULL, NULL, 6);
INSERT INTO `sys_group` VALUES ('4', '2', '人事', 0, '2025-07-07 05:35:12', '2025-07-17 15:13:04', NULL, NULL, 0);
INSERT INTO `sys_group` VALUES ('5', '2', '财务', 1, '2025-07-07 05:35:12', '2025-07-17 16:08:35', NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `pid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级id',
  `type` tinyint NOT NULL COMMENT '菜单类型 0菜单 1页面元素 2菜单组',
  `path` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问路径',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标',
  `order_no` int NOT NULL DEFAULT 0 COMMENT '菜单展示顺序',
  `is_hidden` tinyint NOT NULL DEFAULT 0 COMMENT '是否隐藏 0否1是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `menu_level` int NOT NULL COMMENT '菜单层级',
  `auth_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授权编码',
  `version` int NOT NULL DEFAULT 0 COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限定义表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', NULL, 0, '/home', '首页', 'home', 0, 0, '2025-06-23 06:08:00', '2025-06-27 05:42:24', NULL, NULL, 2, NULL, 0);
INSERT INTO `sys_permission` VALUES ('1941127559303680001', '6', 0, '/user', '用户管理', 'user-setting', 2, 0, '2025-07-04 13:30:49', '2025-07-04 15:33:20', NULL, NULL, 3, NULL, 5);
INSERT INTO `sys_permission` VALUES ('1942393667177238530', '6', 0, '/group', '群组管理', 'usergroup', 3, 0, '2025-07-08 09:21:52', NULL, NULL, NULL, 2, NULL, 0);
INSERT INTO `sys_permission` VALUES ('1942480488057921537', '6', 0, '/role', '角色管理', 'user-marked', 4, 0, '2025-07-08 15:06:52', NULL, NULL, NULL, 2, NULL, 0);
INSERT INTO `sys_permission` VALUES ('1952265289684373505', '1941127559303680001', 1, NULL, '按钮-新增用户', NULL, 0, 0, '2025-08-04 15:08:11', '2025-08-04 16:00:16', NULL, NULL, 4, 'SYS_USER_ADD', 1);
INSERT INTO `sys_permission` VALUES ('1959901330290507778', NULL, 0, '/aiChatbot', 'AI 助理', 'chat-bubble-smile', 0, 0, '2025-08-25 16:51:05', NULL, NULL, NULL, 2, NULL, 0);
INSERT INTO `sys_permission` VALUES ('6', NULL, 2, '', '系统管理', 'system-setting', 1, 0, '2025-06-23 06:08:00', '2025-07-07 05:45:12', NULL, NULL, 1, NULL, 1);
INSERT INTO `sys_permission` VALUES ('7', '6', 0, '/permission', '菜单权限', 'view-list', 1, 0, '2025-06-23 06:08:00', '2025-07-01 10:29:22', NULL, NULL, 3, NULL, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `version` int NOT NULL DEFAULT 0 COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色定义表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROOT', '2025-06-26 05:14:19', NULL, NULL, NULL, 0);
INSERT INTO `sys_role` VALUES ('1952554967503376385', '普通用户', '2025-08-05 10:19:15', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色 ID',
  `permission_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色权限关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1952555462913593346', '1952554967503376385', '1');
INSERT INTO `sys_role_permission` VALUES ('1952555462913593347', '1952554967503376385', '6');
INSERT INTO `sys_role_permission` VALUES ('1952555462913593348', '1952554967503376385', '1941127559303680001');
INSERT INTO `sys_role_permission` VALUES ('1952555668803588098', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('1952555668803588099', '1', '1952265289684373505');
INSERT INTO `sys_role_permission` VALUES ('1952555668803588100', '1', '1942480488057921537');
INSERT INTO `sys_role_permission` VALUES ('1952555668803588101', '1', '6');
INSERT INTO `sys_role_permission` VALUES ('1952555668803588102', '1', '7');
INSERT INTO `sys_role_permission` VALUES ('1952555668803588103', '1', '1941127559303680001');
INSERT INTO `sys_role_permission` VALUES ('1952555668803588104', '1', '1942393667177238530');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号 全局唯一',
  `pwd` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `salt` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码盐',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态 0禁用 1启用',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `version` int NOT NULL DEFAULT 0 COMMENT '数据版本',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_unq`(`account` ASC) USING BTREE COMMENT '账号唯一索引',
  INDEX `idx`(`name` ASC) USING BTREE COMMENT '查询索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1948042872317145090', '管理员', 'admin', '91cd443c866ab888fc0cf781690159e1', 'tleXavQC', NULL, 1, NULL, NULL, '2025-07-23 23:29:48', '2025-07-29 14:41:21', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES ('1952555299658698754', '王小熙', 'wxx', '1702836bf16f664c7450f1ef917cb135', 'nLH9ESPs', NULL, 1, NULL, NULL, '2025-08-05 10:20:34', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_user_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_group`;
CREATE TABLE `sys_user_group`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `group_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '群组ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户群组关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_group
-- ----------------------------
INSERT INTO `sys_user_group` VALUES ('1948050397166936066', '1', '2');
INSERT INTO `sys_user_group` VALUES ('1952555299725807618', '1952555299658698754', '4');
INSERT INTO `sys_user_group` VALUES ('1952555299725807619', '1952555299658698754', '3');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户 ID',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1948050397305348098', '1', '1');
INSERT INTO `sys_user_role` VALUES ('1952555299788722177', '1952555299658698754', '1952554967503376385');

SET FOREIGN_KEY_CHECKS = 1;
