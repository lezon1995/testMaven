package com.thread;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread extends Thread {

    static volatile int count = 0;
    static AtomicInteger count_ = new AtomicInteger(0);

    @Override
    public void run() {


    }

    public  int multiAdd() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {

        }
        count_.addAndGet(1);
        count_.addAndGet(2);
        count_.addAndGet(3);
        count_.addAndGet(4);
        return count_.get();
    }

    public static void main(String[] args) {
        final AtomicThread threads = new AtomicThread();
        ArrayList<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(threads.multiAdd());
                }
            }));
        }

        for (int i = 0; i < 100; i++) {
            list.get(i).start();
        }
    }
}
