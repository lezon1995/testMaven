package com.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author zhuliang
 * @date 2019/6/12 0:08
 */
public class AbstractQueuedSynchronizerDemo {
    public static void main(String[] args) {
        MyAQS aqs = new MyAQS();
        System.out.println(123);
        aqs.acquire(1);
        System.out.println(123);
    }
}

class MyAQS extends AbstractQueuedSynchronizer{
    public MyAQS() {
    }
}
