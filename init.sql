/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : smallking

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 25/06/2020 10:47:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '部门名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门代号',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑删',
  `created_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人ID',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `leader_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `contact_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上级部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '组织结构表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('2', 'SmallKingX', '1', '1', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-21 00:00:00', '1', '2020-04-03 01:33:45', 2, '1', '11', '11haha', '0');
INSERT INTO `sys_dept` VALUES ('40289f9c713b6dd301713c40a4a90001', '12312', '3213', '0', '1', '2020-04-03 02:56:42', '1', '2020-04-03 03:02:11', NULL, '2c93d36d6fb146d1016fb193b81e0005', '123', '123123', 'ff8081816e89e730016e89fc534b0000');
INSERT INTO `sys_dept` VALUES ('40289f9c713b6dd301713c4742580002', '11111111111111111111', '1111', '0', '1', '2020-04-03 03:03:55', '1', '2020-04-03 03:04:00', NULL, '2c93d36d6fb146d1016fb193b81e0005', '213', '213213', 'ff8081816e89e730016e89fc534b0000');
INSERT INTO `sys_dept` VALUES ('40289f9c713b6dd301713c47d4300003', '4214214', '12412', '0', '1', '2020-04-03 03:04:33', '1', '2020-04-03 03:04:35', NULL, '1', '12421', '4214', 'ff8081816e89e730016e89fc534b0000');
INSERT INTO `sys_dept` VALUES ('40289f9c71405f250171407620230000', '按时发贺卡', '5556444', '1', '1', '2020-04-03 00:00:00', '1', '2020-04-04 00:26:37', 2, '402823816fae7f50016faf7661360000', '123', '123', 'ff8081816e89e730016e89fc534b0000');
INSERT INTO `sys_dept` VALUES ('40289f9c71405f2501714090f9ec0001', 'MonSter', '3001', '1', '1', '2020-04-03 00:00:00', '1', '2020-04-04 00:23:58', 3, '2c93d36d6fb146d1016fb193b81e0005', '123', '123', '0');
INSERT INTO `sys_dept` VALUES ('40289f9c71405f25017140c5f3990002', '删除测试一级部门', 'R1', '0', '1', '2020-04-04 00:00:47', '1', '2020-04-04 00:10:57', NULL, '1', '21321', '123123', '0');
INSERT INTO `sys_dept` VALUES ('40289f9c71405f25017140ccc19a0003', '删除测试子部门1', '1111', '0', '1', '2020-04-04 00:08:13', '1', '2020-04-04 00:10:57', NULL, '1', '123', '123213', '40289f9c71405f25017140c5f3990002');
INSERT INTO `sys_dept` VALUES ('40289f9c71405f25017140cd14490004', '删除测试子部门1-1', '5556444', '0', '1', '2020-04-04 00:08:34', '1', '2020-04-04 00:10:57', NULL, '402823816fae7f50016faf7661360000', '123', '123', '40289f9c71405f25017140ccc19a0003');
INSERT INTO `sys_dept` VALUES ('40289f9c71405f25017140cd527e0005', '删除测试子部门2', '1232131', '0', '1', '2020-04-04 00:08:50', '1', '2020-04-04 00:10:57', NULL, '2c93d36d6fb146d1016fb193b81e0005', '12321', '3123123', '40289f9c71405f25017140c5f3990002');
INSERT INTO `sys_dept` VALUES ('40289f9c71405f25017140cd7cc30006', '删除测试子部门2-2', '5556444', '0', '1', '2020-04-04 00:09:01', '1', '2020-04-04 00:10:57', NULL, '402823816fae7f50016faf7661360000', '12312', '3213213', '40289f9c71405f25017140cd527e0005');
INSERT INTO `sys_dept` VALUES ('40289f9c7140dcda017140ddd22a0000', '123123', '123', '1', '1', '2020-04-04 00:00:00', '1', '2020-04-04 00:27:01', 1, '402823816fae7f50016faf7661360000', '1231', '123', 'ff8081816e89e730016e89fc534b0000');
INSERT INTO `sys_dept` VALUES ('40289f9c7140dcda017140f5dab30001', '1212312', '3123123', '0', '1', '2020-04-04 00:53:06', '1', '2020-04-04 00:55:00', 1, '40289f9c71319bae0171319e29c50000', '123123', '123123', '40289f9c71405f250171407620230000');
INSERT INTO `sys_dept` VALUES ('40289f9c72d1f8060172d802ce1f0009', '123213213', '123213', '1', '1', '2020-06-22 01:52:42', NULL, NULL, NULL, '1', NULL, '123123', '40289f9c71405f2501714090f9ec0001');
INSERT INTO `sys_dept` VALUES ('ff8081816e73e433016e741385e80000', '靓仔兼有型', '666', '1', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-16 19:57:47', NULL, NULL, 1, '1', '333', '333', '0');
INSERT INTO `sys_dept` VALUES ('ff8081816e747129016e74ef21290000', '科技部', 'A00001', '1', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-16 00:00:00', '1', '2020-04-03 01:56:45', 1, '1', '333', '333', '2');
INSERT INTO `sys_dept` VALUES ('ff8081816e89e730016e89fc534b0000', '财务部', '02', '1', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-21 00:00:00', '1', '2020-04-03 01:55:15', 2, '40289f9c71319bae0171319e29c50000', '11', '111123123132', 'ff8081816e73e433016e741385e80000');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_time` datetime(0) NULL DEFAULT NULL,
  `updated_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updated_time` datetime(0) NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_update` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `parent_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('2c948a8271592438017159d2a0b20001', '01', '010101', 'duocengji', '1', '2020-04-08 20:45:08', NULL, NULL, '1', '1', NULL, '-1', '123456');
INSERT INTO `sys_dict` VALUES ('2c948a8271592438017159d55daf0002', '02', '020202', 'duocengji', '1', '2020-04-08 20:48:08', NULL, NULL, '1', '1', NULL, '-1', '1111');
INSERT INTO `sys_dict` VALUES ('2c948a8271592438017159d58ef90003', '0101', '010101-01', 'duocengji', '1', '2020-04-08 20:48:20', '1', '2020-04-08 21:40:04', '0', '1', NULL, '01', NULL);
INSERT INTO `sys_dict` VALUES ('2c948a8271592438017159efda180004', '12', '123123', 'duocengji', '1', '2020-04-08 21:17:03', '1', '2020-04-08 21:20:51', '0', '1', NULL, '0101', '123');
INSERT INTO `sys_dict` VALUES ('402823816e9bb533016e9bd754990002', '1', '顶部菜单', 'menu_type', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-24 13:16:51', NULL, NULL, '1', '1', 1, '-1', '');
INSERT INTO `sys_dict` VALUES ('402823816e9bb533016e9bd80aa10003', '2', '侧栏菜单', 'menu_type', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-24 13:17:37', NULL, NULL, '1', '1', 2, '-1', NULL);
INSERT INTO `sys_dict` VALUES ('402823816e9bb533016e9bd87ca10004', '3', '按钮', 'menu_type', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-24 13:18:06', NULL, NULL, '1', '1', 3, '-1', NULL);
INSERT INTO `sys_dict` VALUES ('402823816ea7ede6016ea80d6f2f0009', '4', '子页面', 'menu_type', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-26 22:11:23', NULL, NULL, '1', '1', 4, '-1', '');
INSERT INTO `sys_dict` VALUES ('ff8081816e722e8a016e728d6eee0000', '1', '男', 'user_sex', NULL, '2019-11-16 12:51:42', NULL, NULL, '1', '0', 1, '-1', '男');
INSERT INTO `sys_dict` VALUES ('ff8081816e729944016e7299c5890000', '2', '女', 'user_sex', NULL, '2019-11-16 13:05:11', NULL, NULL, '1', '0', 2, '-1', '女');
INSERT INTO `sys_dict` VALUES ('ff8081816e72b378016e72ba1ac90000', '0', '禁用', 'user_status', NULL, '2019-11-16 13:40:30', NULL, NULL, '1', '1', 1, '-1', '');
INSERT INTO `sys_dict` VALUES ('ff8081816e72b378016e72bb8c650001', '1', '启用', 'user_status', NULL, '2019-11-16 13:42:04', NULL, '2019-11-16 15:51:49', '1', '1', 2, '-1', '123');
INSERT INTO `sys_dict` VALUES ('ff8081816e738247016e738367650000', '0', '禁用', 'status', NULL, '2019-11-16 17:20:22', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-21 00:43:00', '1', '1', 3, '-1', '1');
INSERT INTO `sys_dict` VALUES ('ff8081816e738247016e738367650001', '1', '启用', 'status', NULL, NULL, NULL, NULL, '1', '1', NULL, '-1', '456');

-- ----------------------------
-- Table structure for sys_dict_category
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_category`;
CREATE TABLE `sys_dict_category`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_time` datetime(0) NULL DEFAULT NULL,
  `updated_time` datetime(0) NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_update` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updated_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_category
-- ----------------------------
INSERT INTO `sys_dict_category` VALUES ('1', '123', '12', NULL, '2020-04-08 02:47:58', '0', NULL, NULL, '1', NULL);
INSERT INTO `sys_dict_category` VALUES ('2c948a8271592438017159d256860000', 'duocengji', '多层级', '2020-04-08 20:44:49', NULL, '1', '1', '1', NULL, '123');
INSERT INTO `sys_dict_category` VALUES ('402823816e9bb533016e9bd6d8980001', 'menu_type', '菜单管理-菜单类别', '2019-11-24 13:16:19', '2019-11-24 13:16:31', '1', '1', 'ff8081816e5fd029016e5fd0a0440000', 'ff8081816e5fd029016e5fd0a0440000', '');
INSERT INTO `sys_dict_category` VALUES ('40289f9c7155f09a017157df86920000', 'menu_is_hidden', '菜单管理-菜单显示', '2020-04-08 11:39:59', '2020-04-08 17:00:40', '1', '1', '1', '1', '1');
INSERT INTO `sys_dict_category` VALUES ('ff8081816e6a2141016e6aadcdd90000', 'user_sex', '用户管理-性别', '2019-11-15 00:10:06', '2019-11-16 15:21:16', '1', '1', NULL, NULL, '用户性别。。');
INSERT INTO `sys_dict_category` VALUES ('ff8081816e6a2141016e6ac103720001', 'user_status', '用户管理-用户状态', '2019-11-15 00:31:05', NULL, '1', '0', NULL, NULL, '用户状态');
INSERT INTO `sys_dict_category` VALUES ('ff8081816e72b378016e7318defb0002', 'status', '系统管理-状态', '2019-11-16 15:24:00', '2019-11-16 15:37:11', '1', '1', NULL, NULL, '系统管理-状态');
INSERT INTO `sys_dict_category` VALUES ('ff8081816e72b378016e731976a60003', '333', '33', '2019-11-16 15:24:39', '2019-11-16 15:27:44', '0', '1', NULL, NULL, '333');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键ID',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单代码',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单链接',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级ID',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑删',
  `menu_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单类别',
  `auth_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限代码',
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `created_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人id',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_frame` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否外链',
  `is_hidden` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否可见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', 'Sys', 'setting', 'system', '0', 2, '1', '1', 'system', 'BasicLayout', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-22 00:00:00', '1', '2020-04-07 00:48:48', '0', '1');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', 'User', 'user', 'user-manage', '1', 1, '1', '2', 'sys:user:user', 'sys/user/list', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-24 00:00:00', '1', '2020-04-06 23:40:42', '0', '1');
INSERT INTO `sys_menu` VALUES ('2c948a827153f6aa0171549cda770000', '123', NULL, '123', '123', '0', 4, '0', '1', '123', 'BasicLayout', '1', '2020-04-07 20:28:18', '1', '2020-04-07 20:28:30', '0', '1');
INSERT INTO `sys_menu` VALUES ('2c948a827153f6aa017154b046110001', '字典管理', NULL, 'dict', 'dict-manage', '1', 5, '1', '2', 'system:dict', 'sys/dict/index', '1', '2020-04-07 20:49:31', '1', '2020-04-11 00:02:42', '0', '1');
INSERT INTO `sys_menu` VALUES ('3', '角色管理', 'role', 'peoples', 'role-manage', '1', 2, '1', '2', 'system:role', 'sys/role/index', NULL, NULL, '1', '2020-04-06 23:42:21', '0', '1');
INSERT INTO `sys_menu` VALUES ('4', '百度', '123', 'search', 'http://www.baidu.com', '0', 3, '1', '1', '', '1', NULL, NULL, '1', '2020-04-06 23:51:49', '1', '1');
INSERT INTO `sys_menu` VALUES ('40289f9c715024410171502ca76f0000', '部门管理', NULL, 'org', 'org-manage', '1', 3, '1', '2', 'system:dept', 'sys/dept/index', '1', '2020-04-06 00:00:00', '1', '2020-04-07 16:23:55', '0', '1');
INSERT INTO `sys_menu` VALUES ('40289f9c715024410171502e9f730001', '菜单管理', NULL, 'menus', 'menu-manage', '1', 4, '1', '2', 'system:menu', 'sys/menu/index', '1', '2020-04-06 23:49:25', NULL, NULL, '0', '1');
INSERT INTO `sys_menu` VALUES ('40289f9c715024410171503a9bee0008', '仪表盘', NULL, 'dashboard', 'dashboard', '0', 1, '1', '1', 'dashboard', 'BasicLayout', '1', '2020-04-07 00:00:00', '1', '2020-04-07 00:48:35', '0', '1');
INSERT INTO `sys_menu` VALUES ('40289f9c715024410171503c716f0009', '分析页', NULL, '', 'analysis', '40289f9c715024410171503a9bee0008', 1, '1', '2', 'dashboard:analysis', 'dashboard/Analysis', '1', '2020-04-07 00:00:00', '1', '2020-04-07 00:45:52', '0', '1');
INSERT INTO `sys_menu` VALUES ('40289f9c715024410171503da8c4000a', '监控页', NULL, '', 'monitor', '40289f9c715024410171503a9bee0008', 2, '1', '2', 'dashboard:monitor', 'dashboard/Monitor', '1', '2020-04-07 00:00:00', '1', '2020-04-08 22:14:30', '0', '2');
INSERT INTO `sys_menu` VALUES ('40289f9c715024410171503e5803000b', '工作台', NULL, '', 'workplace', '40289f9c715024410171503a9bee0008', 3, '1', '2', 'dashboard:workplace', 'dashboard/Workplace', '1', '2020-04-07 00:00:00', '1', '2020-04-08 22:14:18', '0', '2');
INSERT INTO `sys_menu` VALUES ('40289f9c7164c954017164d0edf80000', '参数配置', NULL, 'form', 'config-manage', '1', 6, '1', '2', 'system:config', 'sys-manage/config-manage/List', '1', '2020-04-10 23:59:06', '1', '2020-04-11 00:03:40', '0', '1');

-- ----------------------------
-- Table structure for sys_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_relation`;
CREATE TABLE `sys_menu_relation`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu_relation
-- ----------------------------
INSERT INTO `sys_menu_relation` VALUES ('40289f9c7141548f01714662368b001a', '402823816ea31ae8016ea31c24450000', '4');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c7141548f01714662368c001b', '402823816ea31ae8016ea31c24450000', '3');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c7141548f01714662368c001c', '402823816ea31ae8016ea31c24450000', '1');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478830001', 'ff8081816e89ab95016e89b9eca20000', '1');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478870002', 'ff8081816e89ab95016e89b9eca20000', '2');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478870003', 'ff8081816e89ab95016e89b9eca20000', '2c948a827153f6aa017154b046110001');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478870004', 'ff8081816e89ab95016e89b9eca20000', '3');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478870005', 'ff8081816e89ab95016e89b9eca20000', '40289f9c715024410171502ca76f0000');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478870006', 'ff8081816e89ab95016e89b9eca20000', '40289f9c715024410171502e9f730001');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478870007', 'ff8081816e89ab95016e89b9eca20000', '40289f9c7164c954017164d0edf80000');
INSERT INTO `sys_menu_relation` VALUES ('40289f9c72d1f8060172d7f478870008', 'ff8081816e89ab95016e89b9eca20000', '4');

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `config_key` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `config_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `display_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_parameter
-- ----------------------------
INSERT INTO `sys_parameter` VALUES ('1', '1', '112321', '1', '1', 1, '1');
INSERT INTO `sys_parameter` VALUES ('40289f9c716a6e3401716a6feb660000', 'system.user.default.password', '系统用户默认密码', '111111', NULL, 1, '系统用户创建时默认密码');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键ID',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色代码',
  `created_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `updated_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人ID',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑删',
  `role_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('402823816ea31ae8016ea31c24450000', '项目经理', '石狮市', '2019-11-25 23:09:21', '2020-06-22 01:24:43', 'xmjl', 'ff8081816e5fd029016e5fd0a0440000', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('402823816ea31ae8016ea31c59920001', '技术经理', '', '2019-11-25 23:09:34', NULL, 'jsjl', 'ff8081816e5fd029016e5fd0a0440000', NULL, '1', '1');
INSERT INTO `sys_role` VALUES ('40289f9c7141548f0171451cfc0b0000', '按时发贺卡', 'fasdf\nsadfa\nasf', '2020-04-04 20:14:20', '2020-04-07 19:45:01', '5556444', '1', '1', '0', NULL);
INSERT INTO `sys_role` VALUES ('ff8081816e89ab95016e89b9eca20000', '管理员', '管理员1问问11', '2019-11-21 00:00:00', '2020-04-04 20:07:54', 'admin', 'ff8081816e5fd029016e5fd0a0440000', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('ff8081816e89ab95016e89cb48ca0008', '12321', '', '2019-11-21 01:10:31', '2019-11-21 01:10:34', '323', 'ff8081816e5fd029016e5fd0a0440000', 'ff8081816e5fd029016e5fd0a0440000', '0', '1');

-- ----------------------------
-- Table structure for sys_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_relation`;
CREATE TABLE `sys_role_relation`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_relation
-- ----------------------------
INSERT INTO `sys_role_relation` VALUES ('2c948a827153b5e8017153e601f60001', '402823816ea31ae8016ea31c24450000', '2c93d36d6fb146d1016fb193b81e0005');
INSERT INTO `sys_role_relation` VALUES ('2c948a827153b5e8017153e601f60002', '402823816ea31ae8016ea31c59920001', '2c93d36d6fb146d1016fb193b81e0005');
INSERT INTO `sys_role_relation` VALUES ('2c948a827153b5e8017153eb14740003', 'ff8081816e89ab95016e89b9eca20000', '40289f9c7131ae87017131bc52b70000');
INSERT INTO `sys_role_relation` VALUES ('40289f9c7150aa11017150b5340d0007', 'ff8081816e89ab95016e89b9eca20000', '1');
INSERT INTO `sys_role_relation` VALUES ('40289f9c7150aa11017150b62ff00009', 'ff8081816e89ab95016e89b9eca20000', '40289f9c71319bae0171319e29c50000');
INSERT INTO `sys_role_relation` VALUES ('40289fc372e20d470172e4658f3a0000', '402823816ea31ae8016ea31c24450000', '402823816fae7f50016faf7661360000');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键ID',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑删',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `mobile` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `dept_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `post_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码盐',
  `user_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户状态',
  `created_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updated_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '靓仔兼有型', 'smallking', '22116b010a60d2411650200174c55e66', '2019-08-22 00:00:00', '2020-06-23 11:34:12', '1', '2', '123123', '130302055@qq.com', 'ff8081816e89e730016e89fc534b0000', NULL, '1231', 'ec6e4673b9364c829e7b3d3a23622ee4', '1', NULL, '1');
INSERT INTO `sys_user` VALUES ('2c93d36d6fb146d1016fb1923ef10004', '1111111111d', '111111', NULL, NULL, '2020-01-17 11:35:59', '0', '1', '123213', '1231', 'ff8081816e73e433016e741385e80000', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_user` VALUES ('2c93d36d6fb146d1016fb193b81e0005', '123123ddd', '123123ddd', 'ff3b8529c36515ad3b7142965b696c79', '2020-01-17 00:00:00', '2020-06-21 11:11:26', '1', '1', '12312', '312333', 'ff8081816e73e433016e741385e80000', NULL, NULL, '593e5fe991294e449dc6ae94247ca292', '0', '1', '1');
INSERT INTO `sys_user` VALUES ('402823816fae7f50016faf7661360000', 'fasfasf', 'asfsafsdf', '1fc71bbc5adda6bf0c7fc8eb211038cd', '2020-01-17 00:00:00', '2020-01-17 17:10:24', '1', '2', NULL, NULL, 'ff8081816e747129016e74ef21290000', NULL, NULL, '8d35203fd99d409aa74a45260f61e4e2', '1', '1', '1');
INSERT INTO `sys_user` VALUES ('40289f9c71319bae0171319e29c50000', 'litterking', 'litterking', 'deddc2959b3c354a9b9e2ae77de6e1ad', '2020-04-01 00:00:00', '2020-04-07 02:17:29', '1', '1', NULL, NULL, 'ff8081816e73e433016e741385e80000', NULL, NULL, 'd9f750d1529c4420bbb7c40131efa88a', '1', '1', '1');
INSERT INTO `sys_user` VALUES ('40289f9c7131ae87017131bc52b70000', '123123', '123123', 'd8cf1d9cbbb6460056327c4b76e89f25', '2020-04-01 00:00:00', '2020-04-07 17:15:29', '1', '1', '123123333', '130302055@qq.com', 'ff8081816e73e433016e741385e80000', NULL, NULL, 'da679b2cdad7465787b2607db046cec6', '1', '1', '1');
INSERT INTO `sys_user` VALUES ('40289f9c713b6dd301713c3f28e40000', '3123213', NULL, 'e756eceace973ea593dc45d7417e702e', '2020-04-03 02:55:04', '2020-04-07 16:44:52', '0', NULL, NULL, NULL, NULL, '123213', NULL, 'ba95f520fbe04f6ca2994624dae17228', '1', '1', '1');
INSERT INTO `sys_user` VALUES ('40289f9c72d1f8060172d76ce1680000', '尼古拉斯', 'nigulasi', '68a8a293703a91a7521dcdfa1bceb8e9', '2020-06-21 23:08:57', NULL, '1', '1', '13888888888', 'nigulasi@smallking.com', 'ff8081816e73e433016e741385e80000', '舞王·尼古拉斯', '舞王', '0a43657fd6724dbe9c028f692a648320', '1', '1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
