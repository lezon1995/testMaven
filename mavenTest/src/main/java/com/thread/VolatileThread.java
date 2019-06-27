package com.thread;

public class VolatileThread extends Thread {
    boolean isRunning = true;

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("start...");
        while (isRunning) {
            System.out.print(".");
        }
        System.out.println();
        System.out.println("stop...");
    }

    public static void main(String[] args) throws Exception {
        VolatileThread thread = new VolatileThread();
        thread.start();
        Thread.sleep(500);
        thread.setRunning(false);
        System.out.println("已经修改为false");
//        Thread.sleep(1000);
//        System.out.println(thread.isRunning);
    }
}
