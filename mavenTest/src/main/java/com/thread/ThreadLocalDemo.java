package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值  
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    // ②获取下一个序列值  
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo sn = new ThreadLocalDemo();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // ③ 3个线程共享sn，各自产生序列号  
        for (int i = 0; i < 10; i++) {
            pool.execute(new TestClient(sn));
        }
        pool.awaitTermination(1, TimeUnit.HOURS);
        System.out.println(seqNum.get());
    }

    private static class TestClient implements Runnable {
        private ThreadLocalDemo sn;

        public TestClient(ThreadLocalDemo sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                sn.getNextNum();
                System.out.println(seqNum.get());
            }
        }
    }
}  