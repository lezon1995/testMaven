package com.thread;

public class MyThread extends Thread {
     int count = 5;

    @Override
    public void run() {
        synchronized (this) {
            count--;
            System.out.println("当前线程：" + currentThread().getName() + "count=" + count);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread, "t1");
        Thread t2 = new Thread(myThread, "t2");
        Thread t3 = new Thread(myThread, "t3");
        Thread t4 = new Thread(myThread, "t4");
        Thread t5 = new Thread(myThread, "t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
