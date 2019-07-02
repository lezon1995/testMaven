package com.algorithm;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuliang
 * @date 2019/7/2 14:03
 */
public class Demo {
    private static volatile int a = 0;
    static  AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
            }).start();
        }

        System.out.println(b.intValue());
    }
}
