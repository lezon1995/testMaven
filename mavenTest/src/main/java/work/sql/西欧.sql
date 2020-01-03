CREATE TABLE `pisces_paladin_alarm_relation_ag` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `alarm_id` varchar(32) NOT NULL DEFAULT '' COMMENT '报警id',
  `alarm_num` varchar(32) NOT NULL DEFAULT '' COMMENT 'AG报警标识',
  `clear_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '清除标志 0-未完成 1-已完成',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  `gmt_finish` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '成功处理时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态 0-无效 1-有效',
  PRIMARY KEY (`id`),
  KEY `idx_alarm_id` (`alarm_id`),
  KEY `idx_alarm_num` (`alarm_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='AG警报关系表'

CREATE TABLE `pisces_pisces_user_geo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(64) NOT NULL DEFAULT '' COMMENT 'uid',
  `geo_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户是否开启GeoService 0关闭 1开启',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_uid` (`uid`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户GeoService关系表'

CREATE TABLE `pisces_pisces_dealer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(64) NOT NULL COMMENT '注册码',
  `dealer_id` varchar(64) NOT NULL COMMENT '服务商id',
  `gmt_period` bigint(20) NOT NULL DEFAULT '0' COMMENT '账期',
  `biz` int(11) NOT NULL DEFAULT '0' COMMENT '业务线id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_code` (`code`),
  UNIQUE KEY `unq_dealerid` (`dealer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8mb4 COMMENT='注册码'

CREATE TABLE `pisces_pisces_alarm_operation_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `alarm_id` varchar(64) NOT NULL COMMENT '报警信息id',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `operation` varchar(500) NOT NULL COMMENT '操作',
  `op_type` smallint(4) unsigned NOT NULL COMMENT '操作类型',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态信息 1-有效，0-无效',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  `mc_operator` varchar(32) NOT NULL DEFAULT '' COMMENT 'mc_operator',
  `op_value` varchar(32) NOT NULL DEFAULT '' COMMENT '额外信息',
  PRIMARY KEY (`id`),
  KEY `idx_alarmid` (`alarm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报警消息操作记录'

CREATE TABLE `pisces_pisces_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '类型:1服务商 2渠道商',
  `code` varchar(12) NOT NULL DEFAULT '' COMMENT '注册码',
  `dealer_or_channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '服务商id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_code` (`code`),
  UNIQUE KEY `unq_type_dealerorchannel` (`type`,`dealer_or_channel_id`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='注册码'

CREATE TABLE `pisces_pisces_disturb_time` (
  `id` bigint(13) NOT NULL COMMENT '主键',
  `biz_id` varchar(16) NOT NULL DEFAULT '' COMMENT '业务大类,push,email,sms,voicecall',
  `uid` varchar(20) NOT NULL DEFAULT '' COMMENT '用户id',
  `start_time` varchar(10) NOT NULL DEFAULT '' COMMENT '开始时间',
  `end_time` varchar(10) NOT NULL DEFAULT '' COMMENT '结束时间',
  `time_zone_id` varchar(64) NOT NULL DEFAULT '' COMMENT '时区',
  `status` int(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `gmt_create` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uid_bizId` (`uid`,`biz_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息免打扰时间区间'

CREATE TABLE `pisces_pisces_custom_rule_template` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_id` varchar(32) NOT NULL DEFAULT '' COMMENT '资源id',
  `product_id` varchar(32) NOT NULL DEFAULT '' COMMENT '产品id',
  `customer` varchar(32) NOT NULL DEFAULT '' COMMENT '定制方',
  `mode` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '模式',
  `rule` varchar(1024) NOT NULL DEFAULT '' COMMENT '规则',
  `attribute` int(11) NOT NULL DEFAULT '0' COMMENT '属性',
  `env` tinyint(2) NOT NULL DEFAULT '0' COMMENT '环境',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_customer_templateid` (`customer`,`template_id`,`status`,`gmt_delete`),
  KEY `idx_productid` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='定制规则模板'

CREATE TABLE `pisces_pisces_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道id',
  `type` tinyint(2) NOT NULL DEFAULT '2' COMMENT '1:默认渠道,2自定义渠道',
  `dealer_id` varchar(32) NOT NULL DEFAULT '' COMMENT '服务商id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '渠道名',
  `phone` varchar(24) NOT NULL DEFAULT '' COMMENT '电话',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT 'email',
  `code` varchar(8) NOT NULL DEFAULT '' COMMENT '注册码',
  `state` varchar(32) NOT NULL DEFAULT '' COMMENT '州',
  `city` varchar(64) NOT NULL DEFAULT '' COMMENT '城市',
  `address` varchar(128) NOT NULL DEFAULT '' COMMENT '地址',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  `channel_level` tinyint(2) NOT NULL DEFAULT '0' COMMENT '渠道等级0-n,0表示顶级服务商，n表示渠道商',
  `parent_channel` varchar(32) NOT NULL DEFAULT '' COMMENT '父渠道',
  `channel_account` varchar(32) NOT NULL DEFAULT '0' COMMENT '账号',
  `channel_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '渠道类型0:表示root,1:Dealer,2:No-dealer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_channel` (`channel_id`),
  KEY `idx_dealer` (`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='渠道商信息'

CREATE TABLE `pisces_pisces_operation_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group` int(1) NOT NULL DEFAULT '0' COMMENT '操作类型',
  `tag` varchar(64) NOT NULL DEFAULT '' COMMENT '标识',
  `detail` varchar(1024) NOT NULL DEFAULT '' COMMENT '操作详情',
  `user` varchar(32) NOT NULL COMMENT '操作人',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态信息 1-有效，0-无效',
  `gmt_create` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL DEFAULT '0' COMMENT '修改时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_tag_group` (`tag`,`group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='pisces操作记录'

CREATE TABLE `pisces_pisces_message_type_mapping` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `biz_id` varchar(16) NOT NULL DEFAULT '' COMMENT '业务类型',
  `message_type` int(2) NOT NULL DEFAULT '0' COMMENT '映射前类型',
  `biz_key` varchar(64) NOT NULL DEFAULT '' COMMENT 'category, 如alarmAlerts, cameraAlerts',
  `mapping_type` int(2) NOT NULL DEFAULT '0' COMMENT '映射后类型',
  `lang_key` varchar(128) NOT NULL DEFAULT '' COMMENT '多语言key',
  `biz_value` tinyint(1) NOT NULL DEFAULT '0' COMMENT '映射默认值',
  `sort_order` int(2) NOT NULL DEFAULT '0' COMMENT '顺序',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `gmt_create` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `is_app_show` int(1) NOT NULL DEFAULT '1' COMMENT 'app是否展示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_biz_message_key` (`biz_id`,`message_type`,`biz_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='开关公共配置表'

CREATE TABLE `pisces_pisces_dp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'pid',
  `dp_id` int(4) NOT NULL COMMENT 'dp',
  `group` tinyint(2) NOT NULL DEFAULT '0' COMMENT 'dp分组',
  `dp_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT 'dp类型',
  `dp_name` varchar(64) NOT NULL DEFAULT '' COMMENT 'dp名称',
  `schema` varchar(512) NOT NULL DEFAULT '' COMMENT 'schema',
  `attribute` int(11) NOT NULL DEFAULT '0' COMMENT '附加属性',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_product_group_dpid` (`product_id`,`group`,`dp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3007 DEFAULT CHARSET=utf8mb4 COMMENT='dp配置'

CREATE TABLE `pisces_pisces_jupiter_linkage_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rule_id` varchar(32) NOT NULL DEFAULT '' COMMENT '规则ID',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭ID',
  `device_id` varchar(32) NOT NULL DEFAULT '' COMMENT '触发设备ID',
  `entity_id` varchar(32) NOT NULL DEFAULT '' COMMENT '目标设备ID',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '联动动作类型 0:未定义 1:抓拍 2:录像',
  `property` varchar(512) NOT NULL DEFAULT '' COMMENT '额外数据',
  `enable` tinyint(2) NOT NULL DEFAULT '1' COMMENT '启用状态 0禁用 1启用',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态 0无效 1有效',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '最近更新时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_ruleid` (`rule_id`),
  KEY `idx_deviceid_homeid` (`device_id`,`home_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备联动action表'

CREATE TABLE `pisces_pisces_device_default` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mode` tinyint(4) NOT NULL DEFAULT '1' COMMENT '布防模式 1-在家 2-离家 -1 固定设备 -2 网关',
  `product_id` varchar(32) NOT NULL DEFAULT '' COMMENT '产品id或者品类编号',
  `env` tinyint(2) NOT NULL DEFAULT '2' COMMENT '环境 1预发 2线上',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态 0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_product_id_mode_env` (`product_id`,`mode`,`env`)
) ENGINE=InnoDB AUTO_INCREMENT=2002 DEFAULT CHARSET=utf8mb4 COMMENT='布防模式默认设备表'

CREATE TABLE `pisces_pisces_rule` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rule_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'id',
  `home_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'homeid',
  `mode` tinyint(4) NOT NULL DEFAULT '1' COMMENT '模式',
  `env` tinyint(2) NOT NULL DEFAULT '2' COMMENT '环境:1预发 2线上',
  `entity_id` varchar(32) NOT NULL DEFAULT '' COMMENT '设备id',
  `source_id` varchar(32) NOT NULL DEFAULT '' COMMENT '资源id',
  `attribute` int(11) NOT NULL DEFAULT '0' COMMENT '附加属性',
  `rule` varchar(1024) NOT NULL DEFAULT '' COMMENT '规则',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_ruleid` (`rule_id`),
  UNIQUE KEY `unq_homeid_entityid_mode_sourceid` (`home_id`,`entity_id`,`mode`,`source_id`,`status`,`gmt_delete`),
  KEY `idx_entityid` (`entity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防规则'

CREATE TABLE `pisces_pisces_common_phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_id` varchar(32) NOT NULL DEFAULT '' COMMENT '设备ID',
  `dealer_id` varchar(32) NOT NULL DEFAULT '' COMMENT '经销商ID',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道ID',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭ID',
  `is_leaving` tinyint(2) NOT NULL COMMENT '是否离家 0在家 1离家',
  `is_common` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否常用 0不常用 1常用',
  `device_name` varchar(64) NOT NULL DEFAULT '' COMMENT '设备名称',
  `mac` varchar(64) NOT NULL DEFAULT '' COMMENT 'mac地址',
  `last_login_time` bigint(13) NOT NULL COMMENT '最后登录时间',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态 0无效 1有效',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '最近更新时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  `is_effective` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否参与围栏边缘判断 0不参与 1参与',
  PRIMARY KEY (`id`),
  KEY `idx_uid_deviceid` (`uid`,`device_id`) USING BTREE COMMENT '针对用户ID和设备ID建立联合索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户常用手机'

CREATE TABLE `pisces_pisces_password` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT '家庭id',
  `type` tinyint(4) NOT NULL COMMENT '密码类型',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `password` varchar(512) NOT NULL DEFAULT '' COMMENT '围栏数据',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_home_id_type` (`home_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防密码'

CREATE TABLE `pisces_pisces_alarm` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `alarm_id` varchar(32) NOT NULL DEFAULT '' COMMENT '报警id',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭id',
  `msg_id` varchar(64) NOT NULL DEFAULT '' COMMENT '报警消息id',
  `state` tinyint(2) NOT NULL DEFAULT '1' COMMENT '流程状态',
  `type` varchar(64) NOT NULL DEFAULT '' COMMENT '报警类型',
  `gmt_finish` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '处理时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  `dealer_id` varchar(32) NOT NULL DEFAULT '' COMMENT '服务商id',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道id',
  `env` tinyint(2) NOT NULL DEFAULT '4' COMMENT '环境 1开发 2日常 3预发 4线上',
  `dps` varchar(256) NOT NULL DEFAULT '' COMMENT '报警dp信息',
  `biz_id` int(11) NOT NULL DEFAULT '0' COMMENT '业务id',
  `extra` varchar(255) NOT NULL DEFAULT '' COMMENT '扩展字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_alarmid` (`alarm_id`),
  KEY `idx_gmtcreate` (`gmt_create`),
  KEY `idx_homeid` (`home_id`),
  KEY `idx_dealer` (`dealer_id`),
  KEY `idx_channel` (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报警'

CREATE TABLE `pisces_pisces_fence` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fence_id` varchar(64) NOT NULL COMMENT '围栏id',
  `home_id` varchar(64) NOT NULL COMMENT '家庭id',
  `fence_data` varchar(512) NOT NULL DEFAULT '' COMMENT '围栏数据',
  `enable` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否开启',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid` (`home_id`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地理围栏'

CREATE TABLE `pisces_pisces_rule_source_tmp` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mode` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `env` tinyint(2) NOT NULL DEFAULT '2' COMMENT '环境:1预发 2线上',
  `dealer_id` varchar(64) NOT NULL COMMENT '服务商id',
  `product_id` varchar(64) NOT NULL COMMENT '产品id',
  `attribute` int(11) NOT NULL DEFAULT '0' COMMENT '附加属性',
  `source_id` varchar(64) NOT NULL DEFAULT '' COMMENT '资源id',
  `rule` varchar(2048) NOT NULL DEFAULT '' COMMENT '规则',
  `weight` int(11) NOT NULL DEFAULT '0' COMMENT '权重',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_productid_dealerid` (`product_id`,`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地理围栏'

CREATE TABLE `pisces_pisces_ipc_cover` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭id',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT '设备id',
  `attach_pics` varchar(512) NOT NULL DEFAULT '' COMMENT '附加图片',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_home_id_device_id` (`home_id`,`device_id`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='摄像头封面图'

CREATE TABLE `pisces_pisces_time` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT '家庭id',
  `mode` tinyint(4) NOT NULL DEFAULT '1' COMMENT '布防模式',
  `type` tinyint(2) NOT NULL COMMENT '类型',
  `time` int(11) NOT NULL COMMENT '时间',
  `env` tinyint(2) NOT NULL DEFAULT '2' COMMENT '环境:1预发 2线上',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid_mode_type` (`home_id`,`mode`,`type`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防延迟时间'

CREATE TABLE `pisces_paladin_monitor_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `transmitter_code` varchar(50) NOT NULL COMMENT 'AG监控中心账户标识',
  `home_id` varchar(64) NOT NULL DEFAULT '' COMMENT '家庭id',
  `function_name` varchar(50) NOT NULL COMMENT '调用的方法名',
  `retry` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '重试次数',
  `success_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '成功状态  0-初始,-1-失败,1-成功',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态信息 1-有效，0-无效',
  PRIMARY KEY (`id`),
  KEY `idx_tc` (`transmitter_code`),
  KEY `idx_homeid` (`home_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='监控中心消息日志表'

CREATE TABLE `pisces_pisces_fence_home_member_state` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭id',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT 'uid',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0离家1在家',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid_uid` (`home_id`,`uid`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户家庭在线状态'

CREATE TABLE `pisces_pisces_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(64) NOT NULL COMMENT 'uid',
  `dealer_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'dealer',
  `biz` int(11) NOT NULL DEFAULT '0' COMMENT '业务线id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_uid` (`uid`),
  KEY `idx_dealerid` (`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防用户'

CREATE TABLE `pisces_paladin_message_ext` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(20) NOT NULL DEFAULT '' COMMENT '用户id',
  `msg_id` varchar(20) NOT NULL DEFAULT '' COMMENT '消息id',
  `read_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '读取状态',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_msgid` (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息扩展表'

CREATE TABLE `pisces_pisces_fence_home_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭ID',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0无效 1有效',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态 0无效 1有效',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '最近更新时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid_uid` (`home_id`,`uid`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='家庭地理围栏手机'

CREATE TABLE `pisces_pisces_message` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `msg_id` varchar(64) NOT NULL COMMENT '消息id',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `home_id` varchar(64) NOT NULL DEFAULT '' COMMENT '家庭id',
  `product_id` varchar(64) NOT NULL DEFAULT '' COMMENT '产品id',
  `product_type` varchar(64) NOT NULL DEFAULT '' COMMENT '设备类型',
  `device_ids` varchar(256) NOT NULL DEFAULT '' COMMENT '设备Id',
  `icon` varchar(255) NOT NULL DEFAULT '' COMMENT '消息图片',
  `msg_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '消息类型',
  `msg_title` varchar(150) DEFAULT NULL COMMENT '消息标题',
  `msg_content` varchar(300) DEFAULT NULL COMMENT '消息内容',
  `msg_src_id` varchar(32) NOT NULL DEFAULT '' COMMENT '消息来源id',
  `attach_pics` varchar(512) DEFAULT NULL COMMENT '消息附加图片',
  `attach_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '附件类型 0-默认 1-image 2-video',
  `favorite` tinyint(2) NOT NULL DEFAULT '0' COMMENT '收藏 0-未收藏 1-已收藏',
  `state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '消息状态 0未读 1已读',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态字段 0-无效，1-有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_mid` (`msg_id`),
  KEY `idx_src_id_type` (`msg_src_id`,`msg_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防消息中心表'

CREATE TABLE `pisces_pisces_product_category` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `uid` varchar(20) NOT NULL DEFAULT '' COMMENT '用户id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `parent_code` varchar(20) NOT NULL DEFAULT '' COMMENT '父类code',
  `category_code` varchar(50) NOT NULL DEFAULT '' COMMENT 'code',
  `category_level` int(1) NOT NULL DEFAULT '0' COMMENT '1-大类,3-小类',
  `env` int(1) NOT NULL DEFAULT '1' COMMENT '1-开发,2-日常，3-预发，4-线上',
  `icon` varchar(128) NOT NULL DEFAULT '' COMMENT '图标',
  `schema_id` varchar(20) NOT NULL DEFAULT '0' COMMENT 'dp点 schema',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `sort_order` int(3) NOT NULL DEFAULT '0' COMMENT '排序',
  `gmt_create` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `capability` bigint(13) NOT NULL DEFAULT '0' COMMENT '联网通信能力',
  `category_type` int(2) NOT NULL DEFAULT '0' COMMENT '0-使用系统多语言key,1-多语言需要更改，使用新版,2-不需要名称',
  `version` int(2) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_parent_version_code` (`parent_code`,`category_code`,`env`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防大类配置表'

CREATE TABLE `pisces_paladin_door_lock_dp` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` varchar(64) NOT NULL DEFAULT '' COMMENT '门锁产品id',
  `lock_point` varchar(20) NOT NULL DEFAULT '' COMMENT '开锁关锁DP点',
  `value_type` varchar(10) NOT NULL DEFAULT 'bool' COMMENT 'DP点数据类型',
  `open_value` varchar(64) NOT NULL DEFAULT '' COMMENT '开锁DP数据',
  `close_value` varchar(64) NOT NULL DEFAULT '' COMMENT '关锁DP数据',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `gmt_create` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_pid` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='门锁的开锁/关锁DP信息'

CREATE TABLE `pisces_pisces_protocol_state` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gateway_id` varchar(32) NOT NULL DEFAULT '' COMMENT '网关id',
  `state_id` varchar(32) NOT NULL DEFAULT '' COMMENT '布防id',
  `home_id` varchar(20) NOT NULL DEFAULT '' COMMENT '家庭id',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `node_id` varchar(32) NOT NULL DEFAULT '' COMMENT '设备的mesh中的id',
  `type` varchar(32) NOT NULL DEFAULT '' COMMENT '协议类型',
  `mode` tinyint(2) NOT NULL DEFAULT '0' COMMENT '布防状态',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1-有效 0-无效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_home_gateway_state_id` (`home_id`,`gateway_id`,`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防协议上报关系表'

CREATE TABLE `pisces_pisces_gw` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT 'homeid',
  `device_id` varchar(64) NOT NULL COMMENT '设备id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_device` (`device_id`,`status`,`gmt_delete`),
  KEY `idx_home` (`home_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='家庭网关'

CREATE TABLE `pisces_pisces_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '上一级的id值',
  `area_name` varchar(50) NOT NULL DEFAULT '' COMMENT '地区名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '99' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_sort` (`sort`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2248 DEFAULT CHARSET=utf8mb4 COMMENT='地区信息'

CREATE TABLE `pisces_pisces_rule_source` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mode` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `env` tinyint(2) NOT NULL DEFAULT '2' COMMENT '环境:1预发 2线上',
  `dealer_id` varchar(64) NOT NULL COMMENT '服务商id',
  `product_id` varchar(64) NOT NULL COMMENT '产品id',
  `attribute` int(11) NOT NULL DEFAULT '0' COMMENT '附加属性',
  `source_id` varchar(64) DEFAULT NULL COMMENT '资源id',
  `rule` varchar(2048) NOT NULL DEFAULT '' COMMENT '规则',
  `weight` int(11) NOT NULL DEFAULT '0' COMMENT '权重',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_productid_dealerid` (`product_id`,`dealer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6002 DEFAULT CHARSET=utf8mb4 COMMENT='地理围栏'

CREATE TABLE `pisces_pisces_contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL DEFAULT '' COMMENT '家庭id',
  `name` varchar(64) DEFAULT NULL COMMENT '联系人姓名',
  `phone` varchar(32) NOT NULL COMMENT '电话号码',
  `area_code` varchar(8) NOT NULL DEFAULT '1' COMMENT '电话区号',
  `sequence` tinyint(4) DEFAULT NULL COMMENT '联系人顺序',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态信息 1-有效，0-无效',
  PRIMARY KEY (`id`),
  KEY `idx_location_id_status` (`home_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防紧急联系人表'

CREATE TABLE `pisces_paladin_lock_dp` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` varchar(64) NOT NULL DEFAULT '' COMMENT '门锁产品id',
  `type` tinyint(4) NOT NULL COMMENT 'DP类型',
  `dp` varchar(10) NOT NULL DEFAULT '' COMMENT 'DP',
  `value_type` varchar(10) NOT NULL DEFAULT '' COMMENT 'DP点数据类型',
  `value` varchar(128) NOT NULL DEFAULT '' COMMENT 'DP数据',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_productid_type` (`product_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='门锁DP信息'

CREATE TABLE `pisces_pisces_alarm_type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `record_type` int(11) NOT NULL DEFAULT '0' COMMENT '0:pid,1:category_code',
  `product_id_code` varchar(64) NOT NULL DEFAULT '' COMMENT '产品id或者品类编号',
  `type_code` varchar(64) NOT NULL COMMENT '报警类型',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_product_id_code_type` (`record_type`,`product_id_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8mb4 COMMENT='报警类型'

CREATE TABLE `pisces_paladin_monitor_siteinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(20) NOT NULL DEFAULT '' COMMENT '家庭id',
  `lat` varchar(20) NOT NULL DEFAULT '' COMMENT '维度',
  `lng` varchar(20) NOT NULL DEFAULT '' COMMENT '经度',
  `country` varchar(32) NOT NULL DEFAULT '' COMMENT '国家',
  `region` varchar(20) NOT NULL DEFAULT '' COMMENT '地区',
  `state` varchar(20) NOT NULL DEFAULT '' COMMENT '州',
  `city` varchar(32) NOT NULL DEFAULT '' COMMENT '城市',
  `zipcode` varchar(10) NOT NULL DEFAULT '' COMMENT '邮编',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '地址',
  `address2` varchar(255) NOT NULL DEFAULT '' COMMENT '备用地址',
  `additional` varchar(128) NOT NULL DEFAULT '' COMMENT '额外信息',
  `site_type` varchar(10) NOT NULL DEFAULT '' COMMENT '住宅类型',
  `time_zone` varchar(10) NOT NULL DEFAULT '' COMMENT '时区',
  `lang` varchar(20) NOT NULL DEFAULT '' COMMENT '语言',
  `codeword` varchar(32) NOT NULL DEFAULT '' COMMENT '验证码',
  `signature` varchar(20) NOT NULL DEFAULT '' COMMENT '签名',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态 1-有效 0-无效',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_home_id` (`home_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='监控中心家庭信息表'

CREATE TABLE `pisces_pisces_base_rule_template` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_id` varchar(32) NOT NULL DEFAULT '' COMMENT '资源id',
  `product_id` varchar(32) NOT NULL DEFAULT '' COMMENT '产品id',
  `customer` varchar(32) NOT NULL DEFAULT '' COMMENT '定制方',
  `mode` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '模式',
  `rule` varchar(1024) NOT NULL DEFAULT '' COMMENT '规则',
  `attribute` int(11) NOT NULL DEFAULT '0' COMMENT '属性',
  `env` tinyint(2) NOT NULL DEFAULT '0' COMMENT '环境',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_templateid` (`template_id`,`status`,`gmt_delete`),
  KEY `idx_productid` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='规则模板'

CREATE TABLE `pisces_pisces_user_switch_config` (
  `id` bigint(13) unsigned NOT NULL COMMENT '主键',
  `biz_id` varchar(16) NOT NULL DEFAULT '' COMMENT '业务类型, push, email, sms, voicecall',
  `uid` varchar(20) NOT NULL DEFAULT '' COMMENT '用户id',
  `biz_key` varchar(64) NOT NULL DEFAULT '' COMMENT '子类型，alarmAlerts, cameraAlerts',
  `biz_value` varchar(255) NOT NULL DEFAULT '' COMMENT '开关配置value',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `gmt_create` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_biz_uid_key` (`biz_id`,`uid`,`biz_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户开关配置表'

CREATE TABLE `pisces_pisces_home` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT 'homeid',
  `dealer_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'dealer',
  `biz` int(11) NOT NULL DEFAULT '0' COMMENT '业务线id',
  `mode` tinyint(2) DEFAULT NULL COMMENT '布防状态',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道',
  `service_plan` tinyint(2) NOT NULL DEFAULT '0' COMMENT '服务类型',
  `admin_user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '管理员',
  `mc_state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '监控中心设置 0-初始 1-个人 2-专业',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid` (`home_id`),
  KEY `idx_dealerid` (`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防家庭'

CREATE TABLE `pisces_pisces_device_operation` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `device_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'deviceid',
  `operation_type` int(1) NOT NULL DEFAULT '0' COMMENT '类型,1:升级,2:重启',
  `operation_code` varchar(16) NOT NULL DEFAULT '' COMMENT '操作批次',
  `operation_status` int(1) NOT NULL DEFAULT '0' COMMENT '升级状态,1:升级中,2:成功,3:失败',
  `operation_user` varchar(32) NOT NULL DEFAULT '' COMMENT '操作人',
  `operation_desc` varchar(32) NOT NULL DEFAULT '' COMMENT '描述',
  `operation_detail` varchar(2048) NOT NULL DEFAULT '' COMMENT '操作详情',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态,1:有效,0:无效',
  `gmt_create` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_device` (`device_id`,`operation_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='固件升级记录表'

CREATE TABLE `pisces_pisces_user_phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uuid` varchar(64) NOT NULL DEFAULT '' COMMENT '设备ID',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '设备名称',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `active` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否常用 0不常用 1常用',
  `mac` varchar(64) NOT NULL DEFAULT '' COMMENT 'mac地址',
  `last_login_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '最后登录时间',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态 0无效 1有效',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '最近更新时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_uid_uuid` (`uid`,`uuid`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户常用手机'

CREATE TABLE `pisces_pisces_meal_statistics` (
  `id` bigint(10) NOT NULL COMMENT '主键id',
  `home_id` varchar(11) NOT NULL DEFAULT '0' COMMENT '家庭id',
  `service_code` varchar(64) NOT NULL DEFAULT '0' COMMENT '服务编码',
  `order_id` varchar(20) NOT NULL DEFAULT '0' COMMENT '套餐id',
  `total` int(10) NOT NULL DEFAULT '0' COMMENT '统计值',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `gmt_create` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_home_service` (`home_id`,`service_code`,`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='统计套餐使用量'

CREATE TABLE `pisces_pisces_notification_phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `phone_number` varchar(32) NOT NULL DEFAULT '' COMMENT '自定义手机号码',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0禁用1启用',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户自定义手机号配置表'

CREATE TABLE `pisces_pisces_schema` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` varchar(32) NOT NULL DEFAULT '' COMMENT '产品id',
  `dp` varchar(12) NOT NULL COMMENT 'dp',
  `dp_type` varchar(12) NOT NULL DEFAULT '' COMMENT 'dp类型',
  `dp_name` varchar(64) NOT NULL DEFAULT '' COMMENT 'dp名称',
  `schema` varchar(1024) NOT NULL DEFAULT '' COMMENT 'schema',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_product_dp` (`product_id`,`dp`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='schema配置'

CREATE TABLE `pisces_pisces_device` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mode` tinyint(4) NOT NULL DEFAULT '1' COMMENT '布防模式',
  `env` tinyint(2) NOT NULL DEFAULT '2' COMMENT '环境:1预发 2线上',
  `home_id` varchar(64) NOT NULL COMMENT '家庭id',
  `device_id` varchar(64) NOT NULL COMMENT '设备id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid_mode_deviceid` (`home_id`,`mode`,`device_id`,`status`,`gmt_delete`),
  KEY `idx_deviceid` (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='安防设备'

CREATE TABLE `pisces_pisces_reminder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭ID',
  `job_id` varchar(32) NOT NULL DEFAULT '' COMMENT '任务id',
  `type` tinyint(1) NOT NULL COMMENT '类型 1:在家 2:离家',
  `check_time` bigint(13) NOT NULL DEFAULT '0' COMMENT 'stay reminder的执行时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态0:无效 1:有效',
  `gmt_create` bigint(13) NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) NOT NULL DEFAULT '0' COMMENT '删除时间',
  `enable` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0:禁用 1启用',
  `time_zone` varchar(32) NOT NULL DEFAULT '' COMMENT '时区id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='arm reminder配置表'

