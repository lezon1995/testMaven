package com.thread;

public class MultiThread {

    static int num = 0;

    public static synchronized void printNum(boolean state) {
        try {
            if (state) {
                num = 100;
                System.out.println(state + " set num over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println(state + " set num over");
            }
            System.out.println(state + ",num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print1(){
        System.out.println("1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void print2(){
        System.out.println("2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                m1.printNum(true);
                m1.print1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                m2.printNum(false);
                m1.print2();
            }
        });

        t2.start();
        t1.start();
    }
}
