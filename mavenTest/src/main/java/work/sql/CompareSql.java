package work.sql;


import com.alibaba.fastjson.JSONObject;
import work.sql.bean.ResponseResult;
import work.sql.util.HttpsUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wentworth .
 * @date 2019-08-22 11:02
 */
public class CompareSql {

    public static void main(String[] args) throws Exception {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> pmap = new HashMap<>();
        boolean ishttps = true;
//        String region = "us";
//        String tableName = "pisces_paladin_door_lock_dp";

        List<String> regionList = new ArrayList() {
            {
//                add("cn");
//                add("ind");
//                add("eu");
//                add("us");
//                add("ueaz");
                add("weaz");
            }

        };

        List<String> tableList_US = new ArrayList() {
            {
                add("security_monitor_log");
                add("security_msg_center");
                add("smart_security_code");
                add("pisces_pisces_jupiter_rule_action");
                add("smart_security_home");
                add("smart_security_alarm");
                add("smart_security_time");
                add("smart_security_user");
                add("smart_security_device");
                add("pisces_pisces_service_plan");
                add("smart_security_gw");
                add("security_alarm_operation_log");
                add("smart_security_password");
                add("smart_security_rule_source");
                add("smart_security_fence");
                add("pisces_pisces_gw_tmp");
                add("security_emergency_contact");
            }
        };

        List<String> tableList_CN = new ArrayList() {
            {
                add("pisces_paladin_alarm_relation_ag");
                add("pisces_pisces_user_geo");
                add("pisces_pisces_dealer");
                add("pisces_pisces_alarm_operation_log");
                add("pisces_pisces_code");
                add("pisces_pisces_disturb_time");
                add("pisces_pisces_custom_rule_template");
                add("pisces_pisces_channel");
                add("pisces_pisces_operation_log");
                add("pisces_pisces_message_type_mapping");
                add("pisces_pisces_dp");
                add("pisces_pisces_jupiter_linkage_rule");
                add("pisces_pisces_device_default");
                add("pisces_pisces_rule");
                add("pisces_pisces_common_phone");
                add("pisces_pisces_password");
                add("pisces_pisces_alarm");
                add("pisces_pisces_fence");
                add("pisces_pisces_rule_source_tmp");
                add("pisces_pisces_ipc_cover");
                add("pisces_pisces_time");
                add("pisces_paladin_monitor_log");
                add("pisces_pisces_fence_home_member_state");
                add("pisces_pisces_user");
                add("pisces_paladin_message_ext");
                add("pisces_pisces_fence_home_member");
                add("pisces_pisces_message");
                add("pisces_pisces_product_category");
                add("pisces_paladin_door_lock_dp");
                add("pisces_pisces_protocol_state");
                add("pisces_pisces_gw");
                add("pisces_pisces_area");
                add("pisces_pisces_rule_source");
                add("pisces_pisces_contacts");
                add("pisces_paladin_lock_dp");
                add("pisces_pisces_alarm_type");
                add("pisces_paladin_monitor_siteinfo");
                add("pisces_pisces_base_rule_template");
                add("pisces_pisces_user_switch_config");
                add("pisces_pisces_home");
                add("pisces_pisces_device_operation");
                add("pisces_pisces_user_phone");
                add("pisces_pisces_meal_statistics");
                add("pisces_pisces_notification_phone");
                add("pisces_pisces_schema");
                add("pisces_pisces_device");
                add("pisces_pisces_reminder");
            }
        };

        List<String> tableList_EU_IND_UEAZ = new ArrayList() {
            {
                add("pisces_paladin_alarm_relation_ag");
                add("pisces_paladin_door_lock_dp");
                add("pisces_paladin_lock_dp");
                add("pisces_paladin_message_ext");
                add("pisces_paladin_monitor_log");
                add("pisces_pisces_alarm");
                add("pisces_pisces_alarm_operation_log");
                add("pisces_pisces_alarm_type");
                add("pisces_pisces_area");
                add("pisces_pisces_contacts");
                add("pisces_pisces_dealer");
                add("pisces_pisces_device");
                add("pisces_pisces_device_default");
                add("pisces_pisces_fence");
                add("pisces_pisces_gw");
                add("pisces_pisces_home");
                add("pisces_pisces_message");
                add("pisces_pisces_password");
                add("pisces_pisces_protocol_state");
                add("pisces_pisces_rule");
                add("pisces_pisces_rule_source");
                add("pisces_pisces_schema");
                add("pisces_pisces_time");
                add("pisces_pisces_user");
            }
        };

//        List<String> tableList = tableList_US;
        List<String> tableList = tableList_CN;


        setHeadersWEAZ(headers);
        String url = null;
        Writer writer;

//        String urlForTablelist = "https://dms-cn.tuya-inc.top:7799/api/v1/mysqltablelist/?cluster_name=tuya-device&database_name=tuya_pisces";
//        String json = HttpsUtil.sendHttpsGet(urlForTablelist, headers, pmap, ishttps);
//        System.out.println(json);


        for (String region : regionList) {
            writer = new BufferedWriter(new FileWriter(new File("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/work/sql/西欧.sql")));
            for (String tableName : tableList) {
                url = "https://dms-" + region + ".tuya-inc.top:7799/api/v1/mysqltableinfo/" +
                        "?cluster_name=tuya-device-we&database_name=tuya_pisces&table_name=" +
                        tableName;
                String json = HttpsUtil.sendHttpsGet(url, headers, pmap, ishttps);
                ResponseResult responseResult = JSONObject.parseObject(json, ResponseResult.class);
                writer.write(responseResult.data.tablestruct + "\n\n");
                System.out.println("======写完" + region + ".log 的" + tableName);
//                System.out.println(responseResult.data.tablestruct);
            }
            writer.close();
            System.out.println("==========写完" + region + ".log");
        }

        System.out.println("完毕！");

    }
    public static void setHeadersCN(Map<String, String> headers) {
        headers.put("authorization", "TUYA eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTc0ODY2LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.5AslpG-hvrbPW2BzqQq9MGbtWH-UcqbcPqHNThYeGss");
        headers.put("cookie", "7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_73088b6279c3cb07f63dc06908ed2052; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTc0ODY2LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.5AslpG-hvrbPW2BzqQq9MGbtWH-UcqbcPqHNThYeGss; sessionid=eeselqwsq54cl6y1rq9ih9jm3sxru1xa");

    }

    public static void setHeadersUS(Map<String, String> headers) {
        headers.put("authorization", "TUYA eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNjAzMTc2MDQyLCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.dQsMnJRNGME10FWDTa6UgcYUmLz2mU4B4amD6NQne2w");
        headers.put("cookie", "token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNjAzMTc2MDQyLCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.dQsMnJRNGME10FWDTa6UgcYUmLz2mU4B4amD6NQne2w; UM_distinctid=16e64285220b73-050504f3524093-1c3a6a5b-13c680-16e6428522138a; sidebarStatus=0; 7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_66f470169dfcb585f0d9efb30c2324a5; a608ea7c4cbd1919ce039822a2e5d753=01897; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; sessionid=qk4hhu8zmdlon222sg09tat8lfd5ogrx");
    }

    public static void setHeadersUEAZ(Map<String, String> headers) {
        headers.put("authorization", "TUYA eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTg2MDA4LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.dImBcv9OTzep3IvQbcfobSSHKG87726kEqbx3NMtIFk");
        headers.put("cookie", "7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_73088b6279c3cb07f63dc06908ed2052; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; sessionid=7bz5dzezu7nxeviboibbs7g6hrfw53tg; token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTg2MDA4LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.dImBcv9OTzep3IvQbcfobSSHKG87726kEqbx3NMtIFk");
    }
    public static void setHeadersWEAZ(Map<String, String> headers) {
        headers.put("authorization", "TUYA eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNjA5NTU4MDM1LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.kKGhM-qvnY4LYrxNAo0pAjf8u_Yj1589LUv6ggLKAag");
        headers.put("cookie", "UM_distinctid=16e64285220b73-050504f3524093-1c3a6a5b-13c680-16e6428522138a; 7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_66f470169dfcb585f0d9efb30c2324a5; a608ea7c4cbd1919ce039822a2e5d753=01897; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNjA5NTU4MDM1LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.kKGhM-qvnY4LYrxNAo0pAjf8u_Yj1589LUv6ggLKAag");
    }

    public static void setHeadersIND(Map<String, String> headers) {
        headers.put("authorization", "TUYA eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTc0ODk1LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.WXkbEQOt22714mouewKnE4FkS8z0JNNReET3NCAOYYA");
        headers.put("cookie", "7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_73088b6279c3cb07f63dc06908ed2052; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTc0ODk1LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.WXkbEQOt22714mouewKnE4FkS8z0JNNReET3NCAOYYA; sidebarStatus=0; sessionid=6x4slzqladk3pnw3ji5j37wy6yrfanqr");
    }

    public static void setHeadersEU(Map<String, String> headers) {
        headers.put("authorization", "TUYA eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTc1NzI3LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.DVsbdj8-zwHAqsVx73HNzSRwStNlNHZJXj9m3eiZSz0");
        headers.put("cookie", "7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_73088b6279c3cb07f63dc06908ed2052; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxODk3LCJ1c2VybmFtZSI6InpodWxpYW5nIiwiZXhwIjoxNTk3OTc1NzI3LCJlbWFpbCI6InpodWxpYW5nQHR1eWEuY29tIiwicmVhbF9uYW1lIjoiV2VudHdvcnRoXHVmZjA4XHU2NzMxXHU0ZWFlXHVmZjA5Iiwicm9sZXMiOlsiXHU1ZGU1XHU3YTBiXHU1ZTA4Il19.DVsbdj8-zwHAqsVx73HNzSRwStNlNHZJXj9m3eiZSz0; sessionid=of4qwk0qvfbhzpa66u3j5kfsf9gcmcq6");
    }
}
