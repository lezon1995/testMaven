package com.quiz;

import java.util.concurrent.SynchronousQueue;

/**
 *
 *
 * @author zhuliang
 * @date 2019/5/29 16:47
 * @see {@link SynchronousQueueDemo}
 */
public class SynchronousQueueQuiz {
    public static void main(String[] args) throws Exception {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        //SynchronousQueue是无空间的,offer 永远返回false
        //SynchronousQueue take方法会被阻塞,必须被其他线程显式的调用
        //
        System.out.println("queue.offer(1) = " + queue.offer(1));
        queue.put(2);
        System.out.println("queue.offer(2) = ");
        System.out.println("queue.offer(3) = " + queue.offer(3));
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue.size() = " + queue.size());
    }
}
