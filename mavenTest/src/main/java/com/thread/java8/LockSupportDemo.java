package com.thread.java8;

import java.util.concurrent.locks.LockSupport;

/**
 * @author zhuliang
 * @date 2019/5/29 15:11
 */
public class LockSupportDemo {
    public static void main(String[] args) throws Exception {
        Thread parkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("park begin");
                //等待获取许可
                LockSupport.park();
                //输出thread over.true
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });
        parkThread.start();

        Thread.sleep(2000);
        // 中断线程
//        parkThread.interrupt();
        LockSupport.unpark(parkThread);

        System.out.println("main over");
    }
}
