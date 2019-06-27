package com.thread.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuliang
 * @date 2019/5/29 11:56
 */
public class ExecutorsExceptionDemo {
    public static void main(String[] args) throws Exception {


        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.printf("线程[%s] 遇到了异常 详细信息: %s\n", t.getName(), e.getMessage());
            }
        });


        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> {
            throw new RuntimeException("asd");
        });

        service.awaitTermination(1, TimeUnit.SECONDS);

        service.shutdown();
    }
}
