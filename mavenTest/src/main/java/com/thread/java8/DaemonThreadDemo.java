package com.thread.java8;

/**
 * @author zhuliang
 * @date 2019/5/29 15:22
 */
public class DaemonThreadDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            System.out.println("hello world");
            System.out.println("hello world");
            System.out.println("hello world");
            System.out.println("hello world");
            System.out.println("hello world");
        }, "daemon");
        t1.setDaemon(true);
        t1.start();
//        Thread.sleep(1);
    }
}
