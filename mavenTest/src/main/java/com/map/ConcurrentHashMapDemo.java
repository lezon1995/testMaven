package com.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuliang
 * @date 2019/7/22 12:04
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                map.put(i*2-1, "a");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i*2, "a");
            }
        }).start();


        System.out.println(map.size());
    }
}
