/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MariaDB
 Source Server Version : 100309
 Source Host           : 127.0.0.1:3306
 Source Schema         : nacos

 Target Server Type    : MariaDB
 Target Server Version : 100309
 File Encoding         : 65001

 Date: 06/11/2019 20:03:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'sso.properties', 'sso', '##################数据源配置###############\r\nspring.datasource.type=com.zaxxer.hikari.HikariDataSource\r\nspring.datasource.url= jdbc:mysql://127.0.0.1:3306/micro-inter-demo?useUnicode=true&serverTimezone=Hongkong&characterEncoding=UTF-8&useSSL=false\r\nspring.datasource.username = root\r\nspring.datasource.password = huangmiao\r\n##########mapper###################\r\nmybatis.mapper-locations=classpath:mapper/**/*Mapper.xml\r\nmybatis.type-aliases-package=tech.mhuang.interchan.sso.*.entity\r\n\r\n#es\r\nmhuang.elasticsearch.enable=true\r\nmhuang.elasticsearch.bean-map.zhangsan.enable=true\r\nmhuang.elasticsearch.bean-map.zhangsan.ip=192.168.1.210\r\n#logger 记录\r\nmhuang.interchan.logger.enable=true\r\nmhuang.interchan.logger.es-key=zhangsan\r\nmhuang.interchan.logger.kafka-key=zhangsan\r\nmhuang.interchan.logger.kafka-topic=logger\r\n#kafka\r\nmhuang.kafka.enable=true\r\nmhuang.kafka.servers=192.168.1.210:9092\r\nmhuang.kafka.enable-producer=true\r\nmhuang.kafka.producer-map.zhangsan.enable=true\r\nmhuang.kafka.enable-consumer=true\r\nmhuang.kafka.consumer-map.zhangsan.enable=true\r\nmhuang.kafka.consumer-map.zhangsan.topics=logger\r\nmhuang.kafka.consumer-map.zhangsan.invoke-bean-name=loggerConsumer\r\nmhuang.kafka.consumer-map.zhangsan.invoke-method-name=invoke\r\n#open single enable\r\nmhuang.interchan.rest.single.enable=true\r\n#auth\r\nmhuang.interchan.auth.enable=true\r\nmhuang.interchan.auth.filter-include-url=/sy/*,/sso/sy/*\r\n#jwt\r\nmhuang.jwt.enable=true\r\nmhuang.jwt.bean-map.zhangsan.enable=true\r\n\r\nchan_mobile_is_not_exists=手机号不存在!\r\nchan_mobile_or_pwd_error=手机号或者密码错误\r\nchan_mobile_valid_code_error=验证码错误\r\nchan_ext_not_exists=用户其他信息不存在\r\nchan_not_exists=用户信息不存在\r\nchan_message_type_exists=验证码类型错误\r\nchan_exists=用户信息已经存在，请登录\r\nchan_mobile_repeat=手机号已存在\r\naccountno_exists=账号已存在\r\nsysuser_mobile_or_pwd_error=手机号或者密码错误\r\nsysuser_pwd_error=密码错误\r\nsysuser_is_invalid=无效用户\r\nsysuser_is_lock=用户已经被锁住\r\nsysroleid_exists=角色代码已经存在\r\nsysrole_not_exists=角色不存在\r\nsysfun_not_exists=功能权限不存在\r\nsysfunid_exists=功能权限代码已经存在\r\nsysfunparent_not_exists=父功能权限不存在\r\nsysfunduser_is_invalid=用户无效\r\nsysfunduseraccount_exists=用户账户已经存在\r\nsysfunduser_account_pwd_error=用户账户或者密码错误\r\nsysfunid_is_error=功能代码不合法\r\n\r\nmhuang.interchan.swagger.enable=true\r\nmhuang.interchan.swagger.title=用户API\r\nmhuang.interchan.swagger.description=用户API编写\r\nmhuang.interchan.swagger.version=1.0\r\nmhuang.interchan.swagger.base-package=tech.mhuang.interchan.sso\r\n\r\nsysuser_pwd_enc_key=!*&1sf1&!@13&', '73ca8eadb04bea820b4bd6871a27787e', '2019-11-06 17:26:58', '2019-11-06 17:26:58', NULL, '127.0.0.1', '', '42962fcc-c2b3-4a24-ad95-9afe72f87bf1', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (2, 'redis.properties', 'DEFAULT_GROUP', 'spring.redis.host=127.0.0.1\r\nspring.redis.port=6379', 'c5749f840d1be41058efa423e501684a', '2019-11-06 17:26:58', '2019-11-06 17:26:58', NULL, '127.0.0.1', '', '42962fcc-c2b3-4a24-ad95-9afe72f87bf1', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (3, 'gateway.yaml', 'gateway', 'spring:\r\n  cloud:\r\n    gateway:\r\n      globalcors:\r\n        corsConfigurations:\r\n          \'[/**]\':\r\n            allowedHeaders: \"*\"\r\n            allowedMethods: \"*\"\r\n            allowedOrigins: \"*\"\r\n            allowCredentials: true\r\n      discovery:\r\n        locator:\r\n          lowerCaseServiceId: true\r\n          enabled: true\r\n      routes:\r\n        - id: sso\r\n          uri: lb://micro-sso\r\n          order: 8084\r\n          predicates:\r\n          - Path=/sso/**\r\n          filters:\r\n          - StripPrefix=1', 'fe0e4f70a83a1fad5bf9db40843999de', '2019-11-06 17:26:58', '2019-11-06 17:26:58', NULL, '127.0.0.1', '', '42962fcc-c2b3-4a24-ad95-9afe72f87bf1', NULL, NULL, NULL, 'text', NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(64) UNSIGNED NOT NULL,
  `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 1, 'sso.properties', 'sso', '', '##################数据源配置###############\r\nspring.datasource.type=com.zaxxer.hikari.HikariDataSource\r\nspring.datasource.url= jdbc:mysql://127.0.0.1:3306/micro-inter-demo?useUnicode=true&serverTimezone=Hongkong&characterEncoding=UTF-8&useSSL=false\r\nspring.datasource.username = root\r\nspring.datasource.password = huangmiao\r\n##########mapper###################\r\nmybatis.mapper-locations=classpath:mapper/**/*Mapper.xml\r\nmybatis.type-aliases-package=tech.mhuang.interchan.sso.*.entity\r\n\r\n#es\r\nmhuang.elasticsearch.enable=true\r\nmhuang.elasticsearch.bean-map.zhangsan.enable=true\r\nmhuang.elasticsearch.bean-map.zhangsan.ip=192.168.1.210\r\n#logger 记录\r\nmhuang.interchan.logger.enable=true\r\nmhuang.interchan.logger.es-key=zhangsan\r\nmhuang.interchan.logger.kafka-key=zhangsan\r\nmhuang.interchan.logger.kafka-topic=logger\r\n#kafka\r\nmhuang.kafka.enable=true\r\nmhuang.kafka.servers=192.168.1.210:9092\r\nmhuang.kafka.enable-producer=true\r\nmhuang.kafka.producer-map.zhangsan.enable=true\r\nmhuang.kafka.enable-consumer=true\r\nmhuang.kafka.consumer-map.zhangsan.enable=true\r\nmhuang.kafka.consumer-map.zhangsan.topics=logger\r\nmhuang.kafka.consumer-map.zhangsan.invoke-bean-name=loggerConsumer\r\nmhuang.kafka.consumer-map.zhangsan.invoke-method-name=invoke\r\n#open single enable\r\nmhuang.interchan.rest.single.enable=true\r\n#auth\r\nmhuang.interchan.auth.enable=true\r\nmhuang.interchan.auth.filter-include-url=/sy/*,/sso/sy/*\r\n#jwt\r\nmhuang.jwt.enable=true\r\nmhuang.jwt.bean-map.zhangsan.enable=true\r\n\r\nchan_mobile_is_not_exists=手机号不存在!\r\nchan_mobile_or_pwd_error=手机号或者密码错误\r\nchan_mobile_valid_code_error=验证码错误\r\nchan_ext_not_exists=用户其他信息不存在\r\nchan_not_exists=用户信息不存在\r\nchan_message_type_exists=验证码类型错误\r\nchan_exists=用户信息已经存在，请登录\r\nchan_mobile_repeat=手机号已存在\r\naccountno_exists=账号已存在\r\nsysuser_mobile_or_pwd_error=手机号或者密码错误\r\nsysuser_pwd_error=密码错误\r\nsysuser_is_invalid=无效用户\r\nsysuser_is_lock=用户已经被锁住\r\nsysroleid_exists=角色代码已经存在\r\nsysrole_not_exists=角色不存在\r\nsysfun_not_exists=功能权限不存在\r\nsysfunid_exists=功能权限代码已经存在\r\nsysfunparent_not_exists=父功能权限不存在\r\nsysfunduser_is_invalid=用户无效\r\nsysfunduseraccount_exists=用户账户已经存在\r\nsysfunduser_account_pwd_error=用户账户或者密码错误\r\nsysfunid_is_error=功能代码不合法\r\n\r\nmhuang.interchan.swagger.enable=true\r\nmhuang.interchan.swagger.title=用户API\r\nmhuang.interchan.swagger.description=用户API编写\r\nmhuang.interchan.swagger.version=1.0\r\nmhuang.interchan.swagger.base-package=tech.mhuang.interchan.sso\r\n\r\nsysuser_pwd_enc_key=!*&1sf1&!@13&', '73ca8eadb04bea820b4bd6871a27787e', '2010-05-05 00:00:00', '2019-11-06 17:26:58', NULL, '127.0.0.1', 'I', '42962fcc-c2b3-4a24-ad95-9afe72f87bf1');
INSERT INTO `his_config_info` VALUES (0, 2, 'redis.properties', 'DEFAULT_GROUP', '', 'spring.redis.host=127.0.0.1\r\nspring.redis.port=6379', 'c5749f840d1be41058efa423e501684a', '2010-05-05 00:00:00', '2019-11-06 17:26:58', NULL, '127.0.0.1', 'I', '42962fcc-c2b3-4a24-ad95-9afe72f87bf1');
INSERT INTO `his_config_info` VALUES (0, 3, 'gateway.yaml', 'gateway', '', 'spring:\r\n  cloud:\r\n    gateway:\r\n      globalcors:\r\n        corsConfigurations:\r\n          \'[/**]\':\r\n            allowedHeaders: \"*\"\r\n            allowedMethods: \"*\"\r\n            allowedOrigins: \"*\"\r\n            allowCredentials: true\r\n      discovery:\r\n        locator:\r\n          lowerCaseServiceId: true\r\n          enabled: true\r\n      routes:\r\n        - id: sso\r\n          uri: lb://micro-sso\r\n          order: 8084\r\n          predicates:\r\n          - Path=/sso/**\r\n          filters:\r\n          - StripPrefix=1', 'fe0e4f70a83a1fad5bf9db40843999de', '2010-05-05 00:00:00', '2019-11-06 17:26:58', NULL, '127.0.0.1', 'I', '42962fcc-c2b3-4a24-ad95-9afe72f87bf1');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '1', '42962fcc-c2b3-4a24-ad95-9afe72f87bf1', 'dev', '开发', 'nacos', 1573032321679, 1573032321679);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
