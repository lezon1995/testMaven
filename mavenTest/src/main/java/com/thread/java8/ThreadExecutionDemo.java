package com.thread.java8;

import java.util.Random;

/**
 * @author zhuliang
 * @date 2019/5/28 16:34
 */
public class ThreadExecutionDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(ThreadExecutionDemo::action, "t1");
        Thread t2 = new Thread(ThreadExecutionDemo::action, "t2");
        Thread t3 = new Thread(ThreadExecutionDemo::action, "t3");
        startAndWait(t1);
        startAndWait(t2);
        startAndWait(t3);
    }

    public static void action() {
        Random random = new Random();
        int millis = 0;
        try {
            millis = random.nextInt(100);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "====" + millis);
    }

    public static void startAndWait(Thread thread) {
        if (Thread.State.NEW.equals(thread.getState())) {
            thread.start();
        }
        //

        //thread.join方法的内部实现就是这样,所以下面的代码 等价 thread.join
        synchronized (thread) {
            while (thread.isAlive()) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
