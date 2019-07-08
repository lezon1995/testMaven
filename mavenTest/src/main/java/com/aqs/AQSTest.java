package com.aqs;

/**
 * @author zhuliang
 * @date 2019/7/8 16:37
 */
public class AQSTest {
    public static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        MLock mLock = new MLock();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mLock.lock();
                    a++;
                    mLock.unlock();
                }
            });
            threads[i] = thread;
        }

        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }


        System.out.println(a);
    }
}
