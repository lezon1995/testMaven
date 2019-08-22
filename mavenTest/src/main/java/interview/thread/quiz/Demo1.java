package interview.thread.quiz;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程轮流打印数字，一直到100
 *
 * @author wentworth
 * @date 2019-08-20 15:34
 */
public class Demo1 {
    private static int i = 0;

    public static void main(String[] args) throws IOException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread t1 = new Thread(() -> {
            while (i <= 100) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "----" + i);
                i++;
                try {
                    condition1.signalAll();
                    System.out.println("condition2 waiting ...");
                    condition2.await();
                    System.out.println("condition2 start");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition1.signalAll();
            System.out.println(Thread.currentThread().getName() + "----结束");
        });
        Thread t2 = new Thread(() -> {
            while (i <= 100) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "----" + i);
                i++;
                try {
                    condition2.signalAll();
                    System.out.println("condition1 waiting ...");
                    condition1.await();
                    System.out.println("condition1 start");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            condition2.signalAll();
            System.out.println(Thread.currentThread().getName() + "----结束");
        });

        t1.start();
        t2.start();
        System.in.read();
    }
}
