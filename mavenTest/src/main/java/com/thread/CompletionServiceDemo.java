package com.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author zhuliang
 * @date 2019/7/27 13:44
 */
public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CompletionService<String> completionService = new ExecutorCompletionService<>(pool);

        Thread producerThread = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                int finalI = i;
                //Future<String> future = pool.submit(new Callable<String>() {
                completionService.submit(() -> {
                    int time = random.nextInt(10000);
                    Thread.sleep(time);
                    return "task_" + finalI;
                });
                System.out.println("submit_" + i);

                //futures.add(future);
            }
        });
        producerThread.start();


        Thread consumerThread = new Thread(() -> {
            while (true) {
                try {
                    Future<String> take = completionService.take();
                    System.out.println(take.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
     /*while (true) {
        for (Future<String> future : futures) {
           if (future.isDone()) {
              try {
                 System.out.println(future.get());
                 futures.remove(future);
              } catch (InterruptedException e) {
                 e.printStackTrace();
              } catch (ExecutionException e) {
                 e.printStackTrace();
              }
           }
        }
     }*/
        });
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }
}
