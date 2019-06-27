package com.thread;

import java.util.concurrent.*;

public class FutureDemo implements Callable {
    private String data;

    public FutureDemo(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return data + "===";
    }

    public static void main(String[] args) throws Exception {
        String str = "test";
        FutureTask<String> task = new FutureTask<String>(new FutureDemo(str));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(task);
        System.out.println("请求完毕");
        System.out.println(task.get(4000,TimeUnit.MILLISECONDS));
        executorService.shutdown();

    }
}
