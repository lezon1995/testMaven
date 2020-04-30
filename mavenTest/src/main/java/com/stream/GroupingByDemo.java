package com.stream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Wentworth .
 * @date 2019-10-23 10:33
 */
public class GroupingByDemo {
    public static void main(String[] args) {

        List<JSONObject> cameraInfos = new ArrayList() {{
            add(new JSONObject() {{
                put("cameraId", "camera01");
                put("type", "video");
            }});
            add(new JSONObject() {{
                put("cameraId", "camera02");
                put("type", "image");
            }});
            add(new JSONObject() {{
                put("cameraId", "camera03");
                put("type", "image");
            }});
            add(new JSONObject() {{
                put("cameraId", "camera04");
                put("type", "video");
            }});
            add(new JSONObject() {{
                put("cameraId", "camera05");
                put("type", "music");
            }});
            add(new JSONObject() {{
                put("cameraId", "camera06");
                put("type", "music");
            }});
        }};

        Map<String, List<JSONObject>> listMap = cameraInfos.stream().collect(Collectors.groupingBy(jsonObject -> jsonObject.getString("type"), Collectors.toList()));

        List<JSONObject> listVideo = listMap.get("image");
        List<JSONObject> listImage = listMap.get("video");
        List<JSONObject> listMusic = listMap.get("music");

        System.out.println(listVideo);
        System.out.println(listImage);
        System.out.println(listMusic);
//        System.out.println(JSONObject.toJSONString(listMap));

        JSONArray objects = JSONArray.parseArray("[]");
        System.out.println(objects);
        System.out.println(objects.size());


        List<JSONObject> collect = cameraInfos.stream().filter(new Predicate<JSONObject>() {
            @Override
            public boolean test(JSONObject object) {
                return object.getString("type").equals("video");
            }
        }).collect(Collectors.toList());


        String s = "[{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"声光报警器\",\"pid\":\"8scntis1\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"震动传感器\",\"pid\":\"0jmuzs0x\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"T1-GSM/Wi-Fi\",\"pid\":\"gu913ghfgnrqggag\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"X1-3G-GSM/Wi-Fi\",\"pid\":\"gsqC2ppPsorKwclP\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"X1-2G-GSM/Wi-Fi\",\"pid\":\"hxobhxvzvhqwsudc\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"Tutti\",\"pid\":\"n6xjFAADBTAsAl3O\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"Conch\",\"pid\":\"mtZrFxs5AFigIZ4R\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"网关\",\"pid\":\"qc37hvkthmonateq\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"网关\",\"pid\":\"97bgqa4a7sn0pcyq\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"报警器\",\"pid\":\"zbadebollmofdu0m\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"燃气报警器\",\"pid\":\"18pkine6\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"烟雾报警器\",\"pid\":\"tob46aoq\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"网关\",\"pid\":\"ixrksxyar2f2thwi\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"网关\",\"pid\":\"nhksegx81xfx4qqx\",\"whiteList\":true},{\"config\":{\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"网关\",\"pid\":\"e5uxbahz7ra3tnza\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"遥控器\",\"pid\":\"4xqrsogogvnp5vk9\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"门磁\",\"pid\":\"enc2jp7c6kgsumbv\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true,\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"网关\",\"pid\":\"7ubpwh6ikltyz8a1\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"CO报警器\",\"pid\":\"wpmo3ja3\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"ZigBee-烟雾报警器\",\"pid\":\"OvdBjC0PhzfdNnNX\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"门磁\",\"pid\":\"7jIGJAymiH8OsFFb\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true,\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"安防网关\",\"pid\":\"yfathczplcgedbwt\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true,\"securityGateway\":true},\"lang\":\"zh\",\"name\":\"GrKVApjzhSOPkmuQ\",\"pid\":\"GrKVApjzhSOPkmuQ\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"海曼水浸传感器\",\"pid\":\"ezhgerjm\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"CO报警器\",\"pid\":\"immt7yly\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"燃气报警器\",\"pid\":\"4z5hspgj\",\"whiteList\":true},{\"config\":{\"fixedEquipment\":true},\"lang\":\"zh\",\"name\":\"烟雾报警器\",\"pid\":\"lgpxxutv\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"人体传感器\",\"pid\":\"b3ov3nor\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"门磁\",\"pid\":\"McoO8jXh\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"人体传感器\",\"pid\":\"i9TxRD2l\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"水浸传感器\",\"pid\":\"k32nwpsm\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"海曼人体红外探测器\",\"pid\":\"mrwlggy8\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"人体传感器\",\"pid\":\"nuzg9rqz\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"海曼门磁\",\"pid\":\"ho6i0zk9\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"门磁\",\"pid\":\"phknxjoh\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"振动传感器\",\"pid\":\"l6web2ir\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"Zigbee 智能门锁\",\"pid\":\"b52wvotf\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"门磁\",\"pid\":\"xrvzm3yI\",\"whiteList\":true},{\"lang\":\"zh\",\"name\":\"人体传感器\",\"pid\":\"a8xmaxno\",\"whiteList\":true}]";


        List<SensorBean> sensorBeans = JSONArray.parseArray(s, SensorBean.class);

        sensorBeans.forEach(sensorBean -> System.out.println(sensorBean.getPid() + "---" + sensorBean.getName()));
        SensorBean1 sensorBean1 = new SensorBean1();
        SensorBean sensorBean = new SensorBean();
        List<SensorBean1.ActionInfo> actionInfos = JSONArray.parseArray(sensorBean.getActionInfos(), SensorBean1.ActionInfo.class);

        BeanUtils.copyProperties(sensorBean, sensorBean1);
        sensorBean1.setActionInfos(actionInfos);
        System.out.println("--");

        System.out.println(1 & (1 << 13));
    }

}
