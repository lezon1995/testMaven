package com.thread.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuliang
 * @date 2019/5/30 10:53
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        MyCountDownLatch latch = new MyCountDownLatch(3);

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("线程[%s]  -1\n", Thread.currentThread().getName());
                latch.countDown();
            });
        }


        latch.await();

        System.out.println("end");


        service.shutdown();
    }


    /**
     * java 1.4 实现
     */
    public static class MyCountDownLatch {

        private int count = 0;

        public MyCountDownLatch(int count) {
            this.count = count;
        }

        public void await() throws Exception {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            synchronized (this) {
                while (count > 0) {
                    wait();
                }
            }
        }


        public void countDown() {
            synchronized (this) {
                if (count < 1) {
                    return;
                }
                count--;
                if (count <= 0) {
                    notifyAll();
                }
            }
        }

    }
}
