package com.thread.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author zhuliang
 * @date 2019/5/27 10:16
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        func2();
    }

    public static void func1() throws Exception {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        completableFuture.complete("hello");

        String value = completableFuture.get();

        System.out.println(value);
    }

    public static void func2() throws Exception {
        //异步操作
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            System.out.printf("[Thread = %s] hello world ...", Thread.currentThread().getName());
        });

        //仍然是阻塞操作
        //        completableFuture.join();
        Object o = completableFuture.get();

        System.out.println("start");
        System.out.println(o);
    }

    public static void func3() throws Exception {
        //异步操作
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            return String.format("[Thread = %s] hello world ...", Thread.currentThread().getName());
        });
        IntStream.rangeClosed(0, 100000000).parallel().sum();
        String o = supplyAsync.get();

        System.out.println("start");

        System.out.println(o);

    }

    public static void func4() throws Exception {

        //异步操作
        CompletableFuture.supplyAsync(() -> 5)
                .thenApply(i -> i + 1)
                .thenApply(i -> i * i)
                .thenApply(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer - 100;
                    }
                })
                .whenComplete(new BiConsumer<Integer, Throwable>() {
                    @Override
                    public void accept(Integer integer, Throwable throwable) {
                        System.out.println(integer);
                    }
                });
    }


    public static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void test1_() {
        List<String> strLst = new ArrayList<String>() {
            {
                add("adfkjsdkfjdskjfkds");
                add("asdfasdfafgfgf");
                add("public static void main");
            }
        };
        Collections.sort(strLst, String::compareToIgnoreCase);
        System.out.println(strLst);
    }
}
