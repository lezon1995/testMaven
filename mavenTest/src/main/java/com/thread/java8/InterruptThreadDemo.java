package com.thread.java8;

/**
 * @author zhuliang
 * @date 2019/5/29 11:25
 */
public class InterruptThreadDemo {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("123");
            }
        });
        thread.start();
//        Thread.sleep(100);
        thread.interrupt();
        thread.join();
    }
}
