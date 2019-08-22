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
) ENGINE=InnoDB AUTO_INCREMENT=11014 DEFAULT CHARSET=utf8mb4 COMMENT='AG警报关系表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='门锁的开锁/关锁DP信息';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='门锁DP信息';

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
) ENGINE=InnoDB AUTO_INCREMENT=21007 DEFAULT CHARSET=utf8mb4 COMMENT='消息扩展表';

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
) ENGINE=InnoDB AUTO_INCREMENT=26063 DEFAULT CHARSET=utf8mb4 COMMENT='监控中心消息日志表';

CREATE TABLE `pisces_paladin_monitor_siteinfo` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
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
  `status` tinyint(255) NOT NULL DEFAULT '1' COMMENT '状态 1-有效 0-无效',
  `gmt_create` bigint(13) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL COMMENT '修改时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_home_id` (`home_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='监控中心家庭信息表';

CREATE TABLE `pisces_pisces_alarm` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `alarm_id` varchar(32) NOT NULL DEFAULT '' COMMENT '报警id',
  `home_id` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭id',
  `msg_id` varchar(64) NOT NULL DEFAULT '' COMMENT '报警消息id',
  `dealer_id` varchar(32) NOT NULL DEFAULT '' COMMENT '服务商id',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道id',
  `state` tinyint(2) NOT NULL DEFAULT '1' COMMENT '流程状态',
  `type` varchar(64) NOT NULL DEFAULT '' COMMENT '报警类型',
  `env` tinyint(2) NOT NULL DEFAULT '4' COMMENT '环境 1开发 2日常 3预发 4线上',
  `dps` varchar(256) NOT NULL DEFAULT '' COMMENT '报警dp信息',
  `biz_id` int(11) NOT NULL DEFAULT '0' COMMENT '业务id',
  `gmt_finish` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '处理时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_alarmid` (`alarm_id`),
  KEY `idx_gmtcreate` (`gmt_create`),
  KEY `idx_homeid` (`home_id`),
  KEY `idx_dealer` (`dealer_id`),
  KEY `idx_channel` (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68009 DEFAULT CHARSET=utf8mb4 COMMENT='报警';

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
  PRIMARY KEY (`id`),
  KEY `idx_alarmid` (`alarm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61191 DEFAULT CHARSET=utf8mb4 COMMENT='报警消息操作记录';

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='报警类型';

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
) ENGINE=InnoDB AUTO_INCREMENT=2248 DEFAULT CHARSET=utf8mb4 COMMENT='地区信息';

CREATE TABLE `pisces_pisces_channel` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `channel_id` varchar(32) NOT NULL COMMENT '渠道id',
  `dealer_id` varchar(32) NOT NULL COMMENT '服务商id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '渠道名',
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_channel` (`channel_id`),
  KEY `idx_dealer` (`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='渠道商信息';

CREATE TABLE `pisces_pisces_code` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '类型:1服务商 2渠道商',
  `code` varchar(12) NOT NULL COMMENT '注册码',
  `dealer_or_channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '服务商id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_code` (`code`),
  UNIQUE KEY `unq_type_dealerorchannel` (`type`,`dealer_or_channel_id`,`status`,`gmt_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='注册码';

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
) ENGINE=InnoDB AUTO_INCREMENT=3002 DEFAULT CHARSET=utf8mb4 COMMENT='安防紧急联系人表';

CREATE TABLE `pisces_pisces_dealer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(64) NOT NULL COMMENT '注册码',
  `dealer_id` varchar(64) NOT NULL COMMENT '服务商id',
  `biz` int(11) NOT NULL DEFAULT '0' COMMENT '业务线id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_code` (`code`),
  UNIQUE KEY `unq_dealerid` (`dealer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='注册码';

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
  UNIQUE KEY `unq_homeid_deviceid_mode` (`home_id`,`device_id`,`mode`),
  KEY `idx_deviceid` (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44004 DEFAULT CHARSET=utf8mb4 COMMENT='安防设备';

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='布防模式默认设备表';

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
  UNIQUE KEY `unq_fenceid_homeid` (`fence_id`,`home_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地理围栏';

CREATE TABLE `pisces_pisces_gw` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT 'homeid',
  `device_id` varchar(64) NOT NULL COMMENT '设备id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_home` (`home_id`,`status`,`gmt_delete`),
  UNIQUE KEY `unq_device` (`device_id`,`status`,`gmt_delete`)
) ENGINE=InnoDB AUTO_INCREMENT=34036 DEFAULT CHARSET=utf8mb4 COMMENT='家庭网关';

CREATE TABLE `pisces_pisces_gw_tmp` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT 'homeid',
  `device_id` varchar(64) NOT NULL COMMENT '设备id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid` (`home_id`,`status`,`gmt_delete`),
  UNIQUE KEY `unq_deviceid` (`device_id`,`status`,`gmt_delete`)
) ENGINE=InnoDB AUTO_INCREMENT=8003 DEFAULT CHARSET=utf8mb4 COMMENT='家庭网关';

CREATE TABLE `pisces_pisces_home` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT 'homeid',
  `dealer_id` varchar(64) NOT NULL COMMENT 'dealer',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道',
  `biz` int(11) NOT NULL DEFAULT '0' COMMENT '业务线id',
  `service_plan` tinyint(2) NOT NULL DEFAULT '0' COMMENT '服务类型',
  `mode` tinyint(2) DEFAULT NULL COMMENT '布防状态',
  `mc_state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '监控中心设置 0-初始 1-个人 2-专业',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid` (`home_id`),
  KEY `idx_dealerid` (`dealer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14002 DEFAULT CHARSET=utf8mb4 COMMENT='安防家庭';

CREATE TABLE `pisces_pisces_message` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `msg_id` varchar(64) NOT NULL COMMENT '消息id',
  `home_id` varchar(64) NOT NULL DEFAULT '' COMMENT '家庭id',
  `product_id` varchar(64) NOT NULL DEFAULT '' COMMENT '产品id',
  `product_type` varchar(64) NOT NULL DEFAULT '' COMMENT '设备类型',
  `device_ids` varchar(256) NOT NULL DEFAULT '' COMMENT '设备Id',
  `icon` varchar(255) NOT NULL DEFAULT '' COMMENT '消息图片',
  `msg_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '消息类型',
  `msg_title` varchar(150) DEFAULT NULL COMMENT '消息标题',
  `msg_content` varchar(300) DEFAULT NULL COMMENT '消息内容',
  `attach_pics` varchar(512) DEFAULT NULL COMMENT '消息附加图片',
  `state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '消息状态 0未读 1已读',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态字段 0-无效，1-有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_mid` (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62338 DEFAULT CHARSET=utf8mb4 COMMENT='安防消息中心表';

CREATE TABLE `pisces_pisces_password` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `home_id` varchar(64) NOT NULL COMMENT '家庭id',
  `type` tinyint(4) NOT NULL COMMENT '密码类型',
  `password` varchar(512) NOT NULL DEFAULT '' COMMENT '围栏数据',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_homeid_type` (`home_id`,`type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='安防密码';

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
) ENGINE=InnoDB AUTO_INCREMENT=17318 DEFAULT CHARSET=utf8mb4 COMMENT='安防协议上报关系表';

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
  UNIQUE KEY `unq_homeid_sourceid_entityid_mode` (`home_id`,`source_id`,`entity_id`,`mode`),
  KEY `idx_entityid` (`entity_id`),
  KEY `idx_homeid` (`home_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46007 DEFAULT CHARSET=utf8mb4 COMMENT='安防规则';

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT='地理围栏';

CREATE TABLE `pisces_pisces_schema` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='schema配置';

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
  UNIQUE KEY `unq_homeid_mode_type` (`home_id`,`mode`,`type`)
) ENGINE=InnoDB AUTO_INCREMENT=33007 DEFAULT CHARSET=utf8mb4 COMMENT='安防延迟时间';

CREATE TABLE `pisces_pisces_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(64) NOT NULL COMMENT 'uid',
  `dealer_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'dealer',
  `channel_id` varchar(32) NOT NULL DEFAULT '' COMMENT '渠道',
  `biz` int(11) NOT NULL DEFAULT '0' COMMENT '业务线id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0无效 1有效',
  `gmt_create` bigint(13) unsigned NOT NULL COMMENT '生成时间',
  `gmt_modified` bigint(13) unsigned NOT NULL COMMENT '更新时间',
  `gmt_delete` bigint(13) unsigned NOT NULL DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_uid` (`uid`),
  KEY `idx_dealerid` (`dealer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22003 DEFAULT CHARSET=utf8mb4 COMMENT='安防用户';














