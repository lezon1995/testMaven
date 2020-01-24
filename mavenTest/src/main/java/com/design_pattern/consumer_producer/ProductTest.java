package com.design_pattern.consumer_producer;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductTest {

    private static Random random = new Random();
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread producerThread = new Thread(new Producer(clerk));
        Thread consumerThread = new Thread(new Consumer(clerk));

        producerThread.start();
        consumerThread.start();
    }

    static class Clerk {
        private static final int MAX_PRODUCT = 20;
        private static final int MIN_PRODUCT = 5;

        private int PRODUCT = 0;

        public void addProduct() {
            try {
                lock.lock();
                if (this.PRODUCT >= MAX_PRODUCT) {
                    System.out.println("产品已满,请稍候再生产");
                    condition.await();
                }
                this.PRODUCT++;
                System.out.println("生产者生产了第" + this.PRODUCT + "个产品");
                condition.signalAll();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }

        public void getProduct() {
            try {
                lock.lock();
                if (this.PRODUCT <= MIN_PRODUCT) {
                    System.out.println("产品处于缺货状态");
                    condition.await();
                }
                System.out.println("消费者消费了第" + this.PRODUCT + "个产品");
                this.PRODUCT--;
                condition.signalAll();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer implements Runnable {
        private Clerk clerk;

        public Producer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            System.out.println("生产者开始生产产品");
            while (true) {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (Exception e) {
                }
                clerk.addProduct();
            }

        }

    }

    static class Consumer implements Runnable {
        private Clerk clerk;

        public Consumer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            System.out.println("消费者开始消费产品");
            while (true) {
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (Exception e) {
                }
                clerk.getProduct();
            }

        }

    }
}
