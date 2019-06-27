package com.thread.java8;

/**
 * @author zhuliang
 * @date 2019/5/30 11:50
 */
public class InterruptDemo {
    static int a = 0;

    public static void main(String[] args) throws Exception {
        Thread we = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    a++;
                    System.out.println(a);
                    System.out.println("running . . .");
                    if (a == 5) {
                        Thread.interrupted();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }, "we");
        we.start();

//        Thread.sleep(3000);

//        System.out.println("线程终止");
    }
}
