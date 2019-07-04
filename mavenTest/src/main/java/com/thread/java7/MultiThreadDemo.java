package com.thread.java7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhuliang
 * @date 2019/7/4 19:12
 */
public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        LongAdder longAdder = new LongAdder();
        Thread thread = new Thread(new AddTask(list, longAdder));
        thread.start();
        thread.join();
        System.out.println(longAdder);
    }
}

class AddTask implements Runnable {

    private List<Integer> list;
    private LongAdder longAdder;

    public AddTask(List<Integer> list, LongAdder longAdder) {
        this.list = list;
        this.longAdder = longAdder;
    }

    @Override
    public void run() {
        int size = list.size();
        if (size > 1) {
            int mid = size / 2;

            List<Integer> left = this.list.subList(0, mid);
            Thread thread = new Thread(new AddTask(left, longAdder));
            thread.start();
            List<Integer> right = this.list.subList(mid, size);
            Thread thread1 = new Thread(new AddTask(right, longAdder));
            thread1.start();
            try {
                thread.join();
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (size == 0) {
                return;
            }
            longAdder.add(list.get(0));
        }
    }
}