/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3306
 Source Schema         : ag_admin_v1

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 19/11/2018 11:02:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_element
-- ----------------------------
DROP TABLE IF EXISTS `base_element`;
CREATE TABLE `base_element`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源编码',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源类型',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `menu_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源关联菜单',
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源树状检索路径',
  `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源请求类型',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `crt_time` datetime(0) NULL DEFAULT NULL,
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_element
-- ----------------------------
INSERT INTO `base_element` VALUES (3, 'userManager:btn_add', 'button', '新增', '/admin/user', '1', NULL, NULL, 'POST', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (4, 'userManager:btn_edit', 'button', '编辑', '/admin/user/{*}', '1', NULL, NULL, 'PUT', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (5, 'userManager:btn_del', 'button', '删除', '/admin/user/{*}', '1', NULL, NULL, 'DELETE', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (9, 'menuManager:element', 'uri', '按钮页面', '/admin/element', '6', NULL, NULL, 'GET', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (10, 'menuManager:btn_add', 'button', '新增', '/admin/menu/{*}', '6', NULL, NULL, 'POST', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (11, 'menuManager:btn_edit', 'button', '编辑', '/admin/menu/{*}', '6', '', '', 'PUT', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES (12, 'menuManager:btn_del', 'button', '删除', '/admin/menu/{*}', '6', '', '', 'DELETE', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES (13, 'menuManager:btn_element_add', 'button', '新增元素', '/admin/element', '6', NULL, NULL, 'POST', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (14, 'menuManager:btn_element_edit', 'button', '编辑元素', '/admin/element/{*}', '6', NULL, NULL, 'PUT', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (15, 'menuManager:btn_element_del', 'button', '删除元素', '/admin/element/{*}', '6', NULL, NULL, 'DELETE', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (16, 'groupManager:btn_add', 'button', '新增', '/admin/group', '7', NULL, NULL, 'POST', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (17, 'groupManager:btn_edit', 'button', '编辑', '/admin/group/{*}', '7', NULL, NULL, 'PUT', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (18, 'groupManager:btn_del', 'button', '删除', '/admin/group/{*}', '7', NULL, NULL, 'DELETE', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (19, 'groupManager:btn_userManager', 'button', '分配用户', '/admin/group/{*}/user', '7', NULL, NULL, 'PUT', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (20, 'groupManager:btn_resourceManager', 'button', '分配权限', '/admin/group/{*}/authority', '7', NULL, NULL, 'GET', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (21, 'groupManager:menu', 'uri', '分配菜单', '/admin/group/{*}/authority/menu', '7', NULL, NULL, 'POST', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (22, 'groupManager:element', 'uri', '分配资源', '/admin/group/{*}/authority/element', '7', NULL, NULL, 'POST', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (23, 'userManager:view', 'uri', '查看', '/admin/user/{*}', '1', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES (24, 'menuManager:view', 'uri', '查看', '/admin/menu/{*}', '6', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES (27, 'menuManager:element_view', 'uri', '查看', '/admin/element/{*}', '6', NULL, NULL, 'GET', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (28, 'groupManager:view', 'uri', '查看', '/admin/group/{*}', '7', NULL, NULL, 'GET', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (32, 'groupTypeManager:view', 'uri', '查看', '/admin/groupType/{*}', '8', NULL, NULL, 'GET', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (33, 'groupTypeManager:btn_add', 'button', '新增', '/admin/groupType', '8', NULL, NULL, 'POST', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (34, 'groupTypeManager:btn_edit', 'button', '编辑', '/admin/groupType/{*}', '8', NULL, NULL, 'PUT', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (35, 'groupTypeManager:btn_del', 'button', '删除', '/admin/groupType/{*}', '8', NULL, NULL, 'DELETE', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (41, 'gateLogManager:view', 'button', '查看', '/admin/gateLog', '27', NULL, NULL, 'GET', '', '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (42, 'serviceManager:view', 'URI', '查看', '/auth/service/{*}', '30', NULL, NULL, 'GET', NULL, '2017-12-26 20:17:42', '1', 'Mr.AG', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (43, 'serviceManager:btn_add', 'button', '新增', '/auth/service', '30', NULL, NULL, 'POST', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (44, 'serviceManager:btn_edit', 'button', '编辑', '/auth/service/{*}', '30', NULL, NULL, 'PUT', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (45, 'serviceManager:btn_del', 'button', '删除', '/auth/service/{*}', '30', NULL, NULL, 'DELETE', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_element` VALUES (46, 'serviceManager:btn_clientManager', 'button', '服务授权', '/auth/service/{*}/client', '30', NULL, NULL, 'POST', NULL, '2017-12-30 16:32:48', '1', 'Mr.AG', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_group
-- ----------------------------
DROP TABLE IF EXISTS `base_group`;
CREATE TABLE `base_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `parent_id` int(11) NOT NULL COMMENT '上级节点',
  `path` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '树状关系',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `group_type` int(11) NOT NULL COMMENT '角色组类型',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_time` datetime(0) NULL DEFAULT NULL,
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_time` datetime(0) NULL DEFAULT NULL,
  `upd_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_group
-- ----------------------------
INSERT INTO `base_group` VALUES (1, 'adminRole', '管理员', -1, '/adminRole', NULL, 1, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group` VALUES (3, 'testGroup', '体验组', -1, '/testGroup', NULL, 1, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group` VALUES (4, 'visitorRole', '游客', 3, '/testGroup/visitorRole', NULL, 1, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group` VALUES (6, 'company', 'AG集团', -1, '/company', NULL, 2, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group` VALUES (7, 'financeDepart', '财务部', 6, '/company/financeDepart', NULL, 2, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group` VALUES (8, 'hrDepart', '人力资源部', 6, '/company/hrDepart', NULL, 2, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group` VALUES (9, 'blogAdmin', '博客管理员', -1, '/blogAdmin', NULL, 1, '', '2017-07-16 16:59:30', '1', 'Mr.AG', '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_group_leader
-- ----------------------------
DROP TABLE IF EXISTS `base_group_leader`;
CREATE TABLE `base_group_leader`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_time` datetime(0) NULL DEFAULT NULL,
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_time` datetime(0) NULL DEFAULT NULL,
  `upd_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_group_leader
-- ----------------------------
INSERT INTO `base_group_leader` VALUES (6, '9', '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group_leader` VALUES (13, '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_group_member
-- ----------------------------
DROP TABLE IF EXISTS `base_group_member`;
CREATE TABLE `base_group_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_time` datetime(0) NULL DEFAULT NULL,
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_time` datetime(0) NULL DEFAULT NULL,
  `upd_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_group_member
-- ----------------------------
INSERT INTO `base_group_member` VALUES (2, '4', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group_member` VALUES (9, '9', '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group_member` VALUES (10, '1', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_group_type
-- ----------------------------
DROP TABLE IF EXISTS `base_group_type`;
CREATE TABLE `base_group_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `crt_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建主机',
  `upd_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  `upd_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后更新人ID',
  `upd_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后更新人',
  `upd_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后更新主机',
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_group_type
-- ----------------------------
INSERT INTO `base_group_type` VALUES (1, 'role', '角色类型', 'role', NULL, NULL, NULL, NULL, '2017-08-25 17:52:37', '1', 'Mr.AG', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group_type` VALUES (2, 'depart', '部门类型', NULL, NULL, NULL, NULL, NULL, '2017-08-25 17:52:43', '1', 'Mr.AG', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_group_type` VALUES (3, 'free', '自定义类型', 'sadf', NULL, NULL, NULL, NULL, '2017-08-26 08:22:25', '1', 'Mr.AG', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径编码',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `parent_id` int(11) NOT NULL COMMENT '父级节点',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单上下级关系',
  `enabled` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '启用禁用',
  `crt_time` datetime(0) NULL DEFAULT NULL,
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_time` datetime(0) NULL DEFAULT NULL,
  `upd_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_menu
-- ----------------------------
INSERT INTO `base_menu` VALUES (1, 'userManager', '用户管理', 5, '/admin/user', 'fa-user', 'menu', 0, '', '/adminSys/baseManager/userManager', NULL, NULL, NULL, NULL, NULL, '2017-09-05 21:06:51', '1', 'admin', '127.0.0.1', '_import(\'admin/user/index\')', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (5, 'baseManager', '基础配置管理', 13, '/admin', 'setting', 'dirt', 0, '', '/adminSys/baseManager', NULL, NULL, NULL, NULL, NULL, '2017-09-05 21:46:11', '1', 'admin', '127.0.0.1', 'Layout', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (6, 'menuManager', '菜单管理', 5, '/admin/menu', 'category', 'menu', 0, '', '/adminSys/baseManager/menuManager', NULL, NULL, NULL, NULL, NULL, '2017-09-05 21:10:25', '1', 'admin', '127.0.0.1', '_import(\'admin/menu/index\')', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (7, 'groupManager', '角色权限管理', 5, '/admin/group', 'group_fill', 'menu', 0, '', '/adminSys/baseManager/groupManager', NULL, NULL, NULL, NULL, NULL, '2017-09-05 21:11:34', '1', 'admin', '127.0.0.1', 'import(\'admin/group/index\')', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (8, 'groupTypeManager', '角色类型管理', 5, '/admin/groupType', 'fa-users', 'menu', 0, '', '/adminSys/baseManager/groupTypeManager', NULL, NULL, NULL, NULL, NULL, '2017-09-05 21:12:28', '1', 'admin', '127.0.0.1', '_import(\'admin/groupType/index\')', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (13, 'adminSys', '权限管理系统', -1, '/base', 'setting', 'dirt', 0, '', '/adminSys', NULL, NULL, NULL, NULL, NULL, '2017-09-28 12:09:22', '1', 'admin', '127.0.0.1', 'Layout', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (21, 'dictManager', '数据字典', 5, '', 'fa fa-book', NULL, 0, '', '/adminSys/baseManager/dictManager', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (27, 'gateLogManager', '操作日志', 5, '/admin/gateLog', 'viewlist', 'menu', 0, '', '/adminSys/baseManager/gateLogManager', NULL, '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', '2017-09-05 22:32:55', '1', 'admin', '127.0.0.1', '_import(\'admin/gateLog/index\')', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (29, 'authManager', '服务权限管理', 13, '/auth', 'service', NULL, 0, '服务权限管理', '/adminSys/authManager', NULL, '2017-12-26 19:54:45', '1', 'admin', '127.0.0.1', '2017-12-26 19:55:18', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (30, 'serviceManager', '服务管理', 29, '/auth/service', 'client', NULL, 0, '服务管理', '/adminSys/authManager/serviceManager', NULL, '2017-12-26 19:56:06', '1', 'admin', '127.0.0.1', '2017-12-26 19:56:06', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (31, 'monitorManager', '监控模块管理', 13, NULL, 'service', NULL, 0, NULL, '/adminSys/monitorManager', NULL, '2018-02-25 09:36:35', '1', 'admin', '127.0.0.1', '2018-02-25 09:38:55', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (32, 'serviceEurekaManager', '服务注册中心', 31, NULL, 'client', NULL, 0, NULL, '/adminSys/monitorManager/serviceEurekaManager', NULL, '2018-02-25 09:37:04', '1', 'admin', '127.0.0.1', '2018-02-25 09:37:41', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (33, 'serviceMonitorManager', '服务状态监控', 31, NULL, 'client', NULL, 0, NULL, '/adminSys/monitorManager/serviceEurekaManager', NULL, '2018-02-25 09:37:05', '1', 'admin', '127.0.0.1', '2018-02-25 09:37:35', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_menu` VALUES (34, 'serviceZipkinManager', '服务链路监控', 31, NULL, 'client', NULL, 0, NULL, '/adminSys/monitorManager/serviceZipkinManager', NULL, '2018-02-25 09:38:05', '1', 'admin', '127.0.0.1', '2018-02-25 09:38:05', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_resource_authority
-- ----------------------------
DROP TABLE IF EXISTS `base_resource_authority`;
CREATE TABLE `base_resource_authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  `authority_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色类型',
  `resource_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源ID',
  `resource_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源类型',
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_time` datetime(0) NULL DEFAULT NULL,
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_resource_authority
-- ----------------------------
INSERT INTO `base_resource_authority` VALUES (287, '1', 'group', '5', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (288, '1', 'group', '9', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (289, '1', 'group', '10', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (290, '1', 'group', '11', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (291, '1', 'group', '12', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (294, '1', 'group', '5', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (295, '1', 'group', '9', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (296, '1', 'group', '10', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (297, '1', 'group', '11', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (298, '1', 'group', '12', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (299, '1', 'group', '9', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (300, '1', 'group', '12', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (301, '1', 'group', '10', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (302, '1', 'group', '11', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (303, '1', 'group', '13', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (304, '1', 'group', '14', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (305, '1', 'group', '15', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (306, '1', 'group', '10', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (307, '1', 'group', '11', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (308, '1', 'group', '12', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (309, '1', 'group', '13', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (310, '1', 'group', '14', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (311, '1', 'group', '9', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (312, '1', 'group', '15', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (313, '1', 'group', '16', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (314, '1', 'group', '17', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (315, '1', 'group', '18', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (317, '1', 'group', '20', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (318, '1', 'group', '21', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (319, '1', 'group', '22', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (349, '4', 'group', '9', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (371, '1', 'group', '23', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (372, '1', 'group', '24', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (373, '1', 'group', '27', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (374, '1', 'group', '28', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (375, '1', 'group', '23', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (378, '1', 'group', '5', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (379, '1', 'group', '9', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (380, '1', 'group', '11', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (381, '1', 'group', '14', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (382, '1', 'group', '13', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (383, '1', 'group', '15', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (384, '1', 'group', '12', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (385, '1', 'group', '24', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (386, '1', 'group', '10', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (387, '1', 'group', '27', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (388, '1', 'group', '16', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (389, '1', 'group', '18', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (390, '1', 'group', '17', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (392, '1', 'group', '20', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (393, '1', 'group', '28', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (394, '1', 'group', '22', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (395, '1', 'group', '21', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (396, '4', 'group', '23', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (397, '4', 'group', '9', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (398, '4', 'group', '27', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (399, '4', 'group', '24', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (400, '4', 'group', '28', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (401, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (402, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (403, '1', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (421, '1', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (422, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (423, '4', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (424, '4', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (436, '1', 'group', '32', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (437, '1', 'group', '33', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (438, '1', 'group', '34', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (439, '1', 'group', '35', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (440, '4', 'group', '32', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (464, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (465, '1', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (466, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (467, '1', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (468, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (469, '1', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (470, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (471, '1', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (472, '1', 'group', '40', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (492, '1', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (493, '1', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (494, '1', 'group', '40', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (516, '4', 'group', '41', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (517, '4', 'group', '30', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (518, '4', 'group', '31', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (519, '4', 'group', '40', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (611, '4', 'group', '42', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (612, '4', 'group', '36', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (628, '4', 'group', '13', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (629, '4', 'group', '5', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (630, '4', 'group', '1', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (631, '4', 'group', '6', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (632, '4', 'group', '7', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (633, '4', 'group', '8', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (634, '4', 'group', '27', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (635, '4', 'group', '9', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (636, '4', 'group', '24', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (637, '4', 'group', '22', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (638, '4', 'group', '23', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (639, '4', 'group', '25', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (640, '4', 'group', '26', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (641, '4', 'group', '28', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (666, '1', 'group', '41', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (689, '1', 'group', '43', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (691, '1', 'group', '44', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (710, '9', 'group', '42', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (711, '9', 'group', '43', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (712, '9', 'group', '44', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (713, '9', 'group', '45', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (718, '9', 'group', '42', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (719, '9', 'group', '44', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (720, '9', 'group', '45', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (721, '9', 'group', '43', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (722, '1', 'group', '41', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (749, '10', 'group', '13', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (750, '10', 'group', '14', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (751, '10', 'group', '-1', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (752, '10', 'group', '5', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (753, '10', 'group', '6', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (754, '10', 'group', '17', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (755, '10', 'group', '20', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (774, '1', 'group', '3', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (775, '1', 'group', '4', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (812, '1', 'group', '19', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (924, '1', 'group', '42', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (945, '1', 'group', '45', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (956, '1', 'group', '46', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (981, '9', 'group', '23', 'button', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (982, '9', 'group', '1', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (983, '9', 'group', '13', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (984, '9', 'group', '-1', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (985, '9', 'group', '5', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (986, '1', 'group', '33', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (987, '1', 'group', '34', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (988, '1', 'group', '13', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (989, '1', 'group', '-1', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (990, '1', 'group', '27', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (991, '1', 'group', '29', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (992, '1', 'group', '1', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (993, '1', 'group', '5', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (994, '1', 'group', '6', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (995, '1', 'group', '7', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (996, '1', 'group', '8', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (997, '1', 'group', '30', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (998, '1', 'group', '31', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (999, '1', 'group', '21', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_resource_authority` VALUES (1000, '1', 'group', '32', 'menu', '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mobile_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tel_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_time` datetime(0) NULL DEFAULT NULL,
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_time` datetime(0) NULL DEFAULT NULL,
  `upd_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upd_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `attr8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES (1, 'admin', '$2a$12$S/yLlj9kzi5Dgsz97H4rAekxrPlk/10eXp1lUJcAVAx.2M9tOpWie', 'yunnet', '', NULL, '', NULL, '', '男', NULL, NULL, '', NULL, NULL, NULL, NULL, '2018-09-14 17:00:36', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_user` VALUES (2, 'test', '$2a$12$zWe6knO6rGp15UVfdWTTxu.Ykt.k3QnD5FPoj6a1cnL63csHY2A1S', '测试账户', '', NULL, '', NULL, '', '男', NULL, NULL, '', NULL, NULL, NULL, NULL, '2017-07-15 19:18:07', '1', '管理员', '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `base_user` VALUES (4, 'blog', '$2a$12$S/yLlj9kzi5Dgsz97H4rAekxrPlk/10eXp1lUJcAVAx.2M9tOpWie', '测试人员', '', NULL, '', NULL, '', '女', NULL, NULL, '12', NULL, NULL, NULL, NULL, '2018-09-14 17:01:06', '1', 'admin', '127.0.0.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for gate_log
-- ----------------------------
DROP TABLE IF EXISTS `gate_log`;
CREATE TABLE `gate_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单',
  `opt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `crt_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `crt_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  `crt_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `crt_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作主机',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gate_log
-- ----------------------------
INSERT INTO `gate_log` VALUES (1, '菜单管理', '新增', '/admin/menu', '2018-02-25 09:36:35', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (2, '菜单管理', '新增', '/admin/menu', '2018-02-25 09:37:04', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (3, '菜单管理', '新增', '/admin/menu', '2018-02-25 09:37:04', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (4, '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:20', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (5, '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:32', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (6, '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:35', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (7, '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:37:40', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (8, '菜单管理', '新增', '/admin/menu', '2018-02-25 09:38:04', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (9, '角色权限管理', '新增', '/admin/group', '2018-02-25 09:38:21', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (10, '菜单管理', '编辑', '/admin/menu', '2018-02-25 09:38:55', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (11, '用户管理', '编辑', '/admin/user', '2018-03-06 11:26:28', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (12, '用户管理', '编辑', '/admin/user', '2018-03-06 11:26:34', '1', 'Mr.AG', '127.0.0.1');
INSERT INTO `gate_log` VALUES (13, '用户管理', '编辑', '/admin/user', '2018-03-07 11:21:10', '1', 'Mr.AG', '127.0.0.1');

SET FOREIGN_KEY_CHECKS = 1;
