package com.collection.queue.blocking.delay;

import java.util.concurrent.DelayQueue;

public class Consumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费  
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int a=0;
        while (true) {
            try {
                Message take = queue.take();
                a++;
                System.out.println("消费消息id：" + take.getId() + " 消息体：" + take.getBody());
                if (a==2) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}