package com.thread.java8;

/**
 * @author zhuliang
 * @date 2019/5/29 14:40
 */
public class SynchronizeDemo {
    private static void synchronizedBlock(){
        synchronized (SynchronizeDemo.class){

        }
    }

    private synchronized static void synchronizedMethod(){
    }
}
