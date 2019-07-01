package com.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock(); // 模拟读操作
            System.out.println(Thread.currentThread().getName()+"正在读 value="+value);
            Thread.sleep(new Random().nextInt(2000)); // 读操作的耗时越多，读写锁的优势越明显
        } finally {
            lock.unlock();
        }
        return value;
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock(); // 模拟写操作
            System.out.println(Thread.currentThread().getName()+"正在写");
            Thread.sleep(new Random().nextInt(1000));
            value = index;
        } finally {
            lock.unlock();
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {

            @Override
            public void run() {
                try {
                    /**
                     * 使用读锁的时候 读读不互斥 读写互斥
                     */
                    demo.handleRead(readLock);
                    /**
                     * 使用reentrantLock的时候 读读 读写 写写全部互斥
                     */
//                     demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        Runnable writeRunnable = new Runnable() {

            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt(10));
//                     demo.handleWrite(lock, new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };
        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(writeRunnable).start();
        }

    }

}