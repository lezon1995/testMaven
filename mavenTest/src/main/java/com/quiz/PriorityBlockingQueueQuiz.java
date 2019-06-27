package com.quiz;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zhuliang
 * @date 2019/5/29 16:31
 */
public class PriorityBlockingQueueQuiz {
    public static void main(String[] args) throws Exception {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(5);

//        queue.put(1);
//        queue.put(3);
//        queue.put(2);
//        queue.put(5);
//        queue.put(4);
//        queue.put(7);
//        queue.put(6);
//        queue.put(9);
//        queue.put(8);

        queue.put(8);
        queue.put(1);
        queue.put(7);
        queue.put(6);
        queue.put(9);
        queue.put(3);

        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue = " + queue);
    }
}
