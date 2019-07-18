package interview.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如何保证多个线程/任务按顺序执行？
 *
 * @author zhuliang
 * @date 2019/7/14 9:57
 */
public class SequentialThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        /*Thread t1 = new Thread(() -> {
            System.out.println("thread 1 is running");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("thread 2 is running");
        });
        Thread t3 = new Thread(() -> {
            System.out.println("thread 3 is running");
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();*/

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            System.out.println("thread 1 is running");
        });
        executor.submit(() -> {
            System.out.println("thread 2 is running");
        });
        executor.submit(() -> {
            System.out.println("thread 3 is running");
        });
        executor.shutdown();
    }


}
