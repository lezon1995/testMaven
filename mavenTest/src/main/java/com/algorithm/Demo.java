package com.algorithm;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuliang
 * @date 2019/7/2 14:03
 */
public class Demo {
    static AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//            }).start();
//        }
        int a = 8;
        int b  = 0;
        b = (a++);

        System.out.println(a);
        System.out.println(b);
    }
}
