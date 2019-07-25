package com.algorithm.thread;


import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用多线程统计一个目录内所有文件大小的总和
 *
 * @author zhuliang
 * @date 2019/7/25 11:37
 */
public class DirectorySize {
    private static AtomicLong totalSize = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        String path = "E:\\github";
        ExecutorService pool = Executors.newFixedThreadPool(10);
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                pool.execute(() -> {
                    recursiveFile(file);
                });
            } else {
                pool.execute(() -> {
                    safeAdd(file.length());
                });
            }
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("totolSize=" + totalSize.get());
    }

    public static void recursiveFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                recursiveFile(f);
            } else {
                long length = f.length();
                safeAdd(length);
            }
        }
    }

    public static void safeAdd(long length) {
        for (; ; ) {
            long total = totalSize.get();
            boolean b = totalSize.compareAndSet(total, total + length);
            if (b) {
                break;
            }
        }
    }
}
