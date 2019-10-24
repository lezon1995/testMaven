package com.stream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

        Map<String, List<JSONObject>> listMap = cameraInfos.stream().collect(Collectors.groupingBy(new Function<JSONObject, String>() {
            @Override
            public String apply(JSONObject jsonObject) {
                return jsonObject.getString("type");
            }
        }, Collectors.toList()));

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
    }

}
