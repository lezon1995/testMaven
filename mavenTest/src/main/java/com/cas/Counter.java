package com.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一个线程安全的计数器
 *
 * @author zhuliang
 * @date 2019/7/24 11:58
 */
public class Counter {
    private static int a = 0;
    private static AtomicInteger safeA = new AtomicInteger(0);

    private static void count() {
        a++;
    }

    private static void safeCount() {
        for (; ; ) {
            int i = safeA.get();
            boolean isSuccess = safeA.compareAndSet(i, i+1);
            i++;
            if (isSuccess) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    count();
                    safeCount();
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("a = " + a);
        System.out.println("safeA = " + safeA.get());
        pool.shutdown();

    }

}
