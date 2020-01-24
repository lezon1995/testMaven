package com.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuliang
 * @date 2019/7/2 14:03
 */
public class Demo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "asd");
        System.out.println(map.get(null));
    }
}
