/*
 Navicat Premium Data Transfer

 Source Server         : localhost_5432
 Source Server Type    : PostgreSQL
 Source Server Version : 90610
 Source Host           : localhost:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90610
 File Encoding         : 65001

 Date: 22/11/2019 22:15:26
*/


-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dept";
CREATE TABLE "public"."sys_dept" (
                                     "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                     "name" varchar(300) COLLATE "pg_catalog"."default",
                                     "code" varchar(32) COLLATE "pg_catalog"."default",
                                     "status" varchar(2) COLLATE "pg_catalog"."default",
                                     "created_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "created_time" timestamp(6),
                                     "updated_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "updated_time" timestamp(6),
                                     "sort" numeric,
                                     "leader_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "contact_phone" varchar(32) COLLATE "pg_catalog"."default",
                                     "description" varchar(300) COLLATE "pg_catalog"."default",
                                     "parent_id" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_dept"."id" IS 'ID';
COMMENT ON COLUMN "public"."sys_dept"."name" IS '部门名称';
COMMENT ON COLUMN "public"."sys_dept"."code" IS '部门代号';
COMMENT ON COLUMN "public"."sys_dept"."status" IS '逻辑删';
COMMENT ON COLUMN "public"."sys_dept"."created_id" IS '创建人ID';
COMMENT ON COLUMN "public"."sys_dept"."created_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_dept"."updated_id" IS '修改人ID';
COMMENT ON COLUMN "public"."sys_dept"."updated_time" IS '修改时间';
COMMENT ON COLUMN "public"."sys_dept"."sort" IS '排序';
COMMENT ON COLUMN "public"."sys_dept"."leader_id" IS '负责人';
COMMENT ON COLUMN "public"."sys_dept"."contact_phone" IS '联系电话';
COMMENT ON COLUMN "public"."sys_dept"."description" IS '描述';
COMMENT ON COLUMN "public"."sys_dept"."parent_id" IS '上级部门ID';
COMMENT ON TABLE "public"."sys_dept" IS '组织结构表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO "public"."sys_dept" VALUES ('ff8081816e73e433016e741385e80000', '靓仔兼有型', '666', '1', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-16 19:57:46.848', NULL, NULL, 1, NULL, NULL, NULL, '0');
INSERT INTO "public"."sys_dept" VALUES ('ff8081816e747129016e74ef21290000', '科技部', '01', '1', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-16 23:57:38.984', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-17 00:38:40.655', 1, NULL, '333', '333', 'ff8081816e73e433016e741385e80000');
INSERT INTO "public"."sys_dept" VALUES ('ff8081816e89e730016e89fc534b0000', '财务部', '02', '1', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-21 02:04:05.323', NULL, NULL, 1, 'ff8081816e658cd3016e65a0f88e0000', '11', '111', 'ff8081816e73e433016e741385e80000');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dict";
CREATE TABLE "public"."sys_dict" (
                                     "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                     "code" varchar(32) COLLATE "pg_catalog"."default",
                                     "name" varchar(32) COLLATE "pg_catalog"."default",
                                     "category_code" varchar(32) COLLATE "pg_catalog"."default",
                                     "created_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "created_time" timestamp(6),
                                     "updated_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "updated_time" timestamp(6),
                                     "status" varchar(2) COLLATE "pg_catalog"."default",
                                     "is_update" varchar(2) COLLATE "pg_catalog"."default",
                                     "sort" numeric,
                                     "parent_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "description" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO "public"."sys_dict" VALUES ('ff8081816e722e8a016e728d6eee0000', '1', '男', 'user_sex', NULL, '2019-11-16 12:51:41.933', NULL, NULL, '1', '0', 1, '0', '男');
INSERT INTO "public"."sys_dict" VALUES ('ff8081816e729944016e7299c5890000', '2', '女', 'user_sex', NULL, '2019-11-16 13:05:10.536', NULL, NULL, '1', '0', 2, '0', '女');
INSERT INTO "public"."sys_dict" VALUES ('ff8081816e72b378016e72ba1ac90000', '0', '禁用', 'user_status', NULL, '2019-11-16 13:40:29.512', NULL, NULL, '1', '1', 1, '0', '');
INSERT INTO "public"."sys_dict" VALUES ('ff8081816e72b378016e72bb8c650001', '1', '启用', 'user_status', NULL, '2019-11-16 13:42:04.133', NULL, '2019-11-16 15:51:48.731', '1', '1', 2, '0', '123');
INSERT INTO "public"."sys_dict" VALUES ('ff8081816e738247016e738367650000', '2', '113', 'user_status', NULL, '2019-11-16 17:20:21.861', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-21 00:42:59.529', '0', '1', 3, '0', '1');

-- ----------------------------
-- Table structure for sys_dict_category
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dict_category";
CREATE TABLE "public"."sys_dict_category" (
                                              "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                              "code" varchar(32) COLLATE "pg_catalog"."default",
                                              "name" varchar(32) COLLATE "pg_catalog"."default",
                                              "created_time" timestamp(6),
                                              "updated_time" timestamp(6),
                                              "status" varchar(2) COLLATE "pg_catalog"."default",
                                              "is_update" varchar(2) COLLATE "pg_catalog"."default",
                                              "created_id" varchar(32) COLLATE "pg_catalog"."default",
                                              "updated_id" varchar(32) COLLATE "pg_catalog"."default",
                                              "description" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of sys_dict_category
-- ----------------------------
INSERT INTO "public"."sys_dict_category" VALUES ('ff8081816e6a2141016e6ac103720001', 'user_status', '用户管理-用户状态', '2019-11-15 00:31:04.562', NULL, '1', '0', NULL, NULL, '用户状态');
INSERT INTO "public"."sys_dict_category" VALUES ('ff8081816e6a2141016e6aadcdd90000', 'user_sex', '用户管理-性别', '2019-11-15 00:10:05.657', '2019-11-16 15:21:16.024', '1', '1', NULL, NULL, '用户性别。。');
INSERT INTO "public"."sys_dict_category" VALUES ('ff8081816e72b378016e731976a60003', '333', '33', '2019-11-16 15:24:38.95', '2019-11-16 15:27:43.945', '0', '1', NULL, NULL, '333');
INSERT INTO "public"."sys_dict_category" VALUES ('ff8081816e72b378016e7318defb0002', '123', '123', '2019-11-16 15:24:00.123', '2019-11-16 15:37:11.369', '0', '1', NULL, NULL, '123');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_menu";
CREATE TABLE "public"."sys_menu" (
                                     "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                     "name" varchar(32) COLLATE "pg_catalog"."default",
                                     "code" varchar(32) COLLATE "pg_catalog"."default",
                                     "icon" varchar(32) COLLATE "pg_catalog"."default",
                                     "menu_url" varchar(128) COLLATE "pg_catalog"."default",
                                     "parent_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "sort" numeric,
                                     "status" varchar(2) COLLATE "pg_catalog"."default",
                                     "menu_type" varchar(2) COLLATE "pg_catalog"."default",
                                     "auth_code" varchar(64) COLLATE "pg_catalog"."default",
                                     "component" varchar(64) COLLATE "pg_catalog"."default",
                                     "created_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "created_time" timestamp(6),
                                     "updated_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "updated_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_menu"."id" IS '主键ID';
COMMENT ON COLUMN "public"."sys_menu"."name" IS '菜单名称';
COMMENT ON COLUMN "public"."sys_menu"."code" IS '菜单代码';
COMMENT ON COLUMN "public"."sys_menu"."icon" IS '菜单图标';
COMMENT ON COLUMN "public"."sys_menu"."menu_url" IS '菜单链接';
COMMENT ON COLUMN "public"."sys_menu"."parent_id" IS '父级ID';
COMMENT ON COLUMN "public"."sys_menu"."sort" IS '排序';
COMMENT ON COLUMN "public"."sys_menu"."status" IS '逻辑删';
COMMENT ON COLUMN "public"."sys_menu"."menu_type" IS '菜单类别';
COMMENT ON COLUMN "public"."sys_menu"."auth_code" IS '权限代码';
COMMENT ON COLUMN "public"."sys_menu"."component" IS '组件路径';
COMMENT ON COLUMN "public"."sys_menu"."created_id" IS '创建人ID';
COMMENT ON COLUMN "public"."sys_menu"."created_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_menu"."updated_id" IS '修改人id';
COMMENT ON COLUMN "public"."sys_menu"."updated_time" IS '修改时间';
COMMENT ON TABLE "public"."sys_menu" IS '菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO "public"."sys_menu" VALUES ('ff8081816e8eb16e016e8edb80e50001', '系统管理', 'Sys', '', '', '', NULL, '1', '', 'Sys', '', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-22 00:46:20.389', NULL, NULL);
INSERT INTO "public"."sys_menu" VALUES ('ff8081816e8eb16e016e8eda17180000', '控制台', 'dashboard', '', '', '0', 1, '1', '1', 'dashboard', '', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-22 00:44:47.767', 'ff8081816e5fd029016e5fd0a0440000', '2019-11-22 00:49:16.411');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_permission";
CREATE TABLE "public"."sys_permission" (
                                           "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                           "name" varchar(32) COLLATE "pg_catalog"."default",
                                           "code" varchar(32) COLLATE "pg_catalog"."default",
                                           "description" varchar(255) COLLATE "pg_catalog"."default",
                                           "created_time" timestamp(6),
                                           "updated_time" timestamp(6),
                                           "created_id" varchar(32) COLLATE "pg_catalog"."default",
                                           "updated_id" varchar(32) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
                                     "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                     "name" varchar(32) COLLATE "pg_catalog"."default",
                                     "description" varchar(255) COLLATE "pg_catalog"."default",
                                     "created_time" timestamp(6),
                                     "updated_time" timestamp(6),
                                     "code" varchar(32) COLLATE "pg_catalog"."default",
                                     "created_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "updated_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "status" varchar(2) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_role"."id" IS '主键ID';
COMMENT ON COLUMN "public"."sys_role"."name" IS '角色名称';
COMMENT ON COLUMN "public"."sys_role"."description" IS '说明';
COMMENT ON COLUMN "public"."sys_role"."created_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_role"."updated_time" IS '修改时间';
COMMENT ON COLUMN "public"."sys_role"."code" IS '角色代码';
COMMENT ON COLUMN "public"."sys_role"."created_id" IS '创建人ID';
COMMENT ON COLUMN "public"."sys_role"."updated_id" IS '修改人ID';
COMMENT ON COLUMN "public"."sys_role"."status" IS '逻辑删';
COMMENT ON TABLE "public"."sys_role" IS '角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" VALUES ('ff8081816e89ab95016e89cb48ca0008', '12321', '', '2019-11-21 01:10:31.37', '2019-11-21 01:10:33.95', '323', 'ff8081816e5fd029016e5fd0a0440000', 'ff8081816e5fd029016e5fd0a0440000', '0');
INSERT INTO "public"."sys_role" VALUES ('ff8081816e89ab95016e89b9eca20000', '管理员', '管理员1问问', '2019-11-21 00:51:33.665', '2019-11-21 01:11:26.365', 'admin', 'ff8081816e5fd029016e5fd0a0440000', 'ff8081816e5fd029016e5fd0a0440000', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_permission";
CREATE TABLE "public"."sys_role_permission" (
                                                "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                                "role_id" varchar(32) COLLATE "pg_catalog"."default",
                                                "permission_id" varchar(32) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_user";
CREATE TABLE "public"."sys_role_user" (
                                          "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                          "role_id" varchar(32) COLLATE "pg_catalog"."default",
                                          "user_id" varchar(32) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
                                     "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
                                     "name" varchar(32) COLLATE "pg_catalog"."default",
                                     "account" varchar(32) COLLATE "pg_catalog"."default",
                                     "password" varchar(32) COLLATE "pg_catalog"."default",
                                     "created_time" timestamp(6),
                                     "updated_time" timestamp(6),
                                     "status" varchar(2) COLLATE "pg_catalog"."default",
                                     "sex" varchar(2) COLLATE "pg_catalog"."default",
                                     "mobile" varchar(32) COLLATE "pg_catalog"."default",
                                     "email" varchar(64) COLLATE "pg_catalog"."default",
                                     "dept_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "description" varchar(255) COLLATE "pg_catalog"."default",
                                     "post_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "salt" varchar(32) COLLATE "pg_catalog"."default",
                                     "user_status" varchar(2) COLLATE "pg_catalog"."default",
                                     "created_id" varchar(32) COLLATE "pg_catalog"."default",
                                     "updated_id" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_user"."id" IS '主键ID';
COMMENT ON COLUMN "public"."sys_user"."name" IS '姓名';
COMMENT ON COLUMN "public"."sys_user"."account" IS '账号';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."created_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."updated_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_user"."status" IS '逻辑删';
COMMENT ON COLUMN "public"."sys_user"."sex" IS '性别';
COMMENT ON COLUMN "public"."sys_user"."mobile" IS '手机';
COMMENT ON COLUMN "public"."sys_user"."email" IS '邮箱';
COMMENT ON COLUMN "public"."sys_user"."dept_id" IS '所属部门';
COMMENT ON COLUMN "public"."sys_user"."description" IS '描述';
COMMENT ON COLUMN "public"."sys_user"."post_id" IS '岗位';
COMMENT ON COLUMN "public"."sys_user"."salt" IS '密码盐';
COMMENT ON COLUMN "public"."sys_user"."user_status" IS '用户状态';
COMMENT ON TABLE "public"."sys_user" IS '系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES ('ff8081816e89449a016e895d3bfe0000', '是的撒', 'asd', 'f57f9c21a43e52b10acc783c3d679225', '2019-11-20 23:10:19.134', '2019-11-21 01:54:26.894', '1', '1', '', '', 'ff8081816e747129016e74ef21290000', '', '', '9887e834c6bb41c4ba5c81fe84c8cdc9', '1', 'ff8081816e5fd029016e5fd0a0440000', 'ff8081816e5fd029016e5fd0a0440000');
INSERT INTO "public"."sys_user" VALUES ('1', '靓仔兼有型', 'smallking', '22116b010a60d2411650200174c55e66', '2019-08-22 22:45:19', '2019-11-21 01:54:54.293', '1', '1', NULL, NULL, 'ff8081816e747129016e74ef21290000', NULL, NULL, 'ec6e4673b9364c829e7b3d3a23622ee4', '1', NULL, 'ff8081816e5fd029016e5fd0a0440000');
INSERT INTO "public"."sys_user" VALUES ('ff8081816e5fd029016e5fd0a0440000', 'ddd', 'ddd', '0d213fb7b5c7ee97490e1d5405bb2e11', '2019-11-12 21:32:18.372', '2019-11-21 02:04:16.965', '1', '1', 'dd', 'dd', 'ff8081816e89e730016e89fc534b0000', '', '', '06c70e6390704ca99d37fde2d21afb25', '1', NULL, 'ff8081816e5fd029016e5fd0a0440000');
INSERT INTO "public"."sys_user" VALUES ('ff8081816e5fd029016e6004102e0001', 'aaa', 'aaa', '361e973a9f9ff25a0681bc25da437e89', '2019-11-12 22:28:29.358', '2019-11-13 22:28:08.876', '0', '1', 'aaa', 'aaa', 'aaa', 'aaasddasdaaaa', 'aa', '7068d1dbc24b45fb94c2898c92e641c8', '1', NULL, NULL);
INSERT INTO "public"."sys_user" VALUES ('ff8081816e658cd3016e65a2cffb0002', 'sadasd', 'sadas', '2c596479cf4a3408a3a6410540eb7f58', '2019-11-14 00:39:59.227', '2019-11-14 00:40:02.721', '0', '1', 'asd', 'sadsad', 'sad', 'sadasd', 'sad', '3565d31ab59648fba7716cb473d55a2d', '1', NULL, NULL);
INSERT INTO "public"."sys_user" VALUES ('ff8081816e658cd3016e65a20f850001', 'adsad', 'sadasd', 'c90f5507fa8d330ade00b92d15e9b188', '2019-11-14 00:39:09.957', '2019-11-14 00:39:13.186', '0', '1', 'ssad', 'asdsad', 'sad', 'sadsd', 'sad', '13b0d897b38647a09d161288974095e9', '1', NULL, NULL);
INSERT INTO "public"."sys_user" VALUES ('ff8081816e658cd3016e65a0f88e0000', 'zzz', 'zzz', '1a25f4b134b8b5fa93cc6752c1db988d', '2019-11-14 00:37:58.542', '2019-11-20 23:06:31.61', '1', '2', 'zzz', 'zzz111', 'ff8081816e747129016e74ef21290000', 'zzz111', '请问', 'dae87dacc7ae4880ae0bad42814e9ae2', '1', NULL, 'ff8081816e5fd029016e5fd0a0440000');

-- ----------------------------
-- Primary Key structure for table sys_dept
-- ----------------------------
ALTER TABLE "public"."sys_dept" ADD CONSTRAINT "sys_dept_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_dict
-- ----------------------------
ALTER TABLE "public"."sys_dict" ADD CONSTRAINT "sys_dict_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_dict_category
-- ----------------------------
ALTER TABLE "public"."sys_dict_category" ADD CONSTRAINT "sys_dict_category_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "public"."sys_menu" ADD CONSTRAINT "sys_menu_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_permission
-- ----------------------------
ALTER TABLE "public"."sys_permission" ADD CONSTRAINT "sys_permission_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD CONSTRAINT "sys_role_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_permission
-- ----------------------------
ALTER TABLE "public"."sys_role_permission" ADD CONSTRAINT "sys_role_permission_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_user
-- ----------------------------
ALTER TABLE "public"."sys_role_user" ADD CONSTRAINT "sys_role_user_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD CONSTRAINT "sys_user_pk" PRIMARY KEY ("id");
