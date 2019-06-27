package com.thread.java8;

/**
 * @author zhuliang
 * @date 2019/5/29 11:42
 */
public class ThreadExceptionDemo {
    public static void main(String[] args) throws Exception {


        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.printf("线程[%s] 遇到了异常 详细信息: %s\n", t.getName(), e.getMessage());
            }
        });

        Thread t1 = new Thread(() -> {
            throw new RuntimeException("aaaaa");
        }, "t1");

        t1.start();
        t1.join();

        System.out.println(t1.isAlive());
    }
}
