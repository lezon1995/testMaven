package com.cas;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class TestSpinLock {

    private final static int THREAD_NUM = 10;
    private static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);

        // 锁
        SpinLock spinLock = new SpinLock();

        for (int i = 0; i < THREAD_NUM; i++) {
            // 启动子线程
            Thread thread = new Thread(() -> {

                // 每个线程循环多次，频繁上锁，解锁。
                for (int n = 0; n < 100000; n++) {
                    spinLock.lock();
                    x++;
//                    System.out.println(Thread.currentThread().getName() + " +1 成功");
                    spinLock.unLock();
                }

                latch.countDown();    // 子线程通知主线程，工作完毕。
            });
            thread.start();
        }
        latch.await();    // 主线程等待所有子线程结束。

        System.out.println(x);    // 最终打印结果：10000 ，未出现线程不安全的异常。
    }
}