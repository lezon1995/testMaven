package com.thread.java8;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

/**
 * @author zhuliang
 * @date 2019/5/29 14:25
 */
public class AllThreadJVMDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "we").start();
        ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        for (long threadId : threadIds) {
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
            System.out.println(threadInfo.toString());
//            long bytes = threadMXBean.getThreadAllocatedBytes(threadId);
//            long kb = bytes / 1024;
//            System.out.printf("线程ID:[%d]分配了%d KB\n", threadId, kb);
        }
    }

}
