/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : security-jwt

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 09/04/2019 16:37:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permission_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限编号',
  `permission_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '授权url',
  `permission_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `permission_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '权限状态,0正常，-1删除',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('25d3a1861c3443c49be383b145f1576d', '/role/list', '获取所有角色', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `role_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '角色状态，0正常，-1删除',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('3ac96c378b2b4df1a9d96dda9ef5f7f1', 'ADMIN', '0');
INSERT INTO `role` VALUES ('c1867457d1c34cd7a705eb5700daccef', 'REPORTADMIN', '0');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_permission_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限编号',
  `role_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `permission_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限编号',
  `role_permission_status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '角色权限状态',
  PRIMARY KEY (`role_permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('0cc1b1428fe945dcb52d95bc1d1b1b86', '3ac96c378b2b4df1a9d96dda9ef5f7f1', '25d3a1861c3443c49be383b145f1576d', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编号',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_phone` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户手机号码\r\n',
  `user_password` varchar(65) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `user_last_login_time` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户最近一次登录时间',
  `user_create_time` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户注册时间',
  `user_status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '用户状态，0正常，-1删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1601e658096048f48225c50f7e879a02', '冯钒荣', '15159302973', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', '1554780930910', '1554692301493', '0');
INSERT INTO `user` VALUES ('2e405a31b084486b996c27c96e6c1d8c', '冯初', '15295939085', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', '1554797136702', '1554692301492', '0');
INSERT INTO `user` VALUES ('4dd2cd7c843542469cc3d5e2764aa35e', '秦罨', '13914971140', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', NULL, '1554692301493', '0');
INSERT INTO `user` VALUES ('53fae163e43442ea8493c1558bcb2e10', '褚蠲', '13068973140', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', NULL, '1554692301493', '0');
INSERT INTO `user` VALUES ('72600c1533f3491e9da0ff6f3899d9b6', '秦钞', '13287831741', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', '1554797042895', '1554692301490', '0');
INSERT INTO `user` VALUES ('88ad850b79794f1f94fb3dfad4644224', '郑殡操', '13331333893', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', NULL, '1554692301492', '0');
INSERT INTO `user` VALUES ('c50b9b75ced043629dfc5a1b4a5dcb69', '尤儿', '13520809386', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', NULL, '1554692301493', '0');
INSERT INTO `user` VALUES ('ddc2117aabfa4c4f9f4e632a7f9c696f', '钱讲支', '13538888864', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', NULL, '1554692301493', '0');
INSERT INTO `user` VALUES ('e683f274ba534f969758ef636788876d', '卫孳苫', '13917242800', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', NULL, '1554692301492', '0');
INSERT INTO `user` VALUES ('fc75ce7d00dd4319b65ba616a408a1e9', '卫渊', '15572008602', '$2a$10$tDsFVTyEPebE2PSeKBoduu0Hokl2LUrQD5yBgBsPoDmuIZe8eW6.y', NULL, '1554692301492', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户角色编号',
  `user_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编号',
  `role_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `user_role_status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '用户角色状态，0正常，-1删除',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('31b9adde41804b70bf7c76921ddb2fbc', '53fae163e43442ea8493c1558bcb2e10', 'c1867457d1c34cd7a705eb5700daccef', '0');
INSERT INTO `user_role` VALUES ('523de48205634300afcb1dc4ce705a87', 'c50b9b75ced043629dfc5a1b4a5dcb69', '3ac96c378b2b4df1a9d96dda9ef5f7f1', '0');
INSERT INTO `user_role` VALUES ('6731e8195ce24f729509314ee93c49c3', 'e683f274ba534f969758ef636788876d', '3ac96c378b2b4df1a9d96dda9ef5f7f1', '0');
INSERT INTO `user_role` VALUES ('6caaa88bbf704992ba868807a37aeb3a', 'ddc2117aabfa4c4f9f4e632a7f9c696f', 'c1867457d1c34cd7a705eb5700daccef', '0');
INSERT INTO `user_role` VALUES ('6cc02688ce0f42ef8aae9b5f09ff9771', '72600c1533f3491e9da0ff6f3899d9b6', '3ac96c378b2b4df1a9d96dda9ef5f7f1', '0');
INSERT INTO `user_role` VALUES ('90321c12b44844268f13019d89efe2e5', '2e405a31b084486b996c27c96e6c1d8c', 'c1867457d1c34cd7a705eb5700daccef', '0');
INSERT INTO `user_role` VALUES ('92409d5d6da44d70a74dfa15609eef29', 'fc75ce7d00dd4319b65ba616a408a1e9', 'c1867457d1c34cd7a705eb5700daccef', '0');
INSERT INTO `user_role` VALUES ('939bccfcc0554ab9b9fad605d9714cc2', '88ad850b79794f1f94fb3dfad4644224', 'c1867457d1c34cd7a705eb5700daccef', '0');
INSERT INTO `user_role` VALUES ('c38813f45a4c4087a712a09e5700c6e1', '4dd2cd7c843542469cc3d5e2764aa35e', '3ac96c378b2b4df1a9d96dda9ef5f7f1', '0');
INSERT INTO `user_role` VALUES ('c44e3f15f5d74e28959144c4bd1dc34d', '1601e658096048f48225c50f7e879a02', '3ac96c378b2b4df1a9d96dda9ef5f7f1', '0');

SET FOREIGN_KEY_CHECKS = 1;
