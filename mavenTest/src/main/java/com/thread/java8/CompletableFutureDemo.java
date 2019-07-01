package com.thread.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * @author zhuliang
 * @date 2019/5/27 10:16
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        func7();
    }

    /**
     * 同步返回
     *
     * @throws Exception
     */
    public static void func1() throws Exception {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        completableFuture.complete("hello");

        String value = completableFuture.get();

        System.out.println(value);
    }

    /**
     * 异步返回
     *
     * @throws Exception
     */
    public static void func2() throws Exception {
        //延迟一秒钟执行Runnable
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[Thread = %s] hello world ...", Thread.currentThread().getName());
        });
        //completableFuture1.get方法会阻塞直到返回hello world
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello world";
            }
        });

        //仍然是阻塞操作
//                completableFuture.join();
        Object o = completableFuture1.get();

        System.out.println("start");
        System.out.println(o);
        System.in.read();
    }

    public static void func3() throws Exception {
        //异步操作
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            return String.format("[Thread = %s] hello world ...", Thread.currentThread().getName());
        });
//        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(new Supplier<String>() {
//            @Override
//            public String get() {
//                return null;
//            }
//        });
        IntStream.rangeClosed(0, 100000000).parallel().sum();
        String o = supplyAsync.get();

        System.out.println("start");

        System.out.println(o);

    }

    public static void func4() throws Exception {

        //生产 返回5 => 将5+1后返回 => 将上一步的结果 平方后返回 => 将上一步的结果 -100后返回 =>消费者 消费: 打印最终结果 -64
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


    /**
     * 结合多个异步返回的结果 统一处理
     *
     * @throws Exception
     */
    public static void func5() throws Exception {

        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> {
            return s1 + " " + s2;
        }).join();
        System.out.println(result);
    }

    /**
     * 取多个异步操作中耗时最短的一个结果
     *
     * @throws Exception
     */
    public static void func6() throws Exception {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi Boy";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi Girl";
        }), (s) -> {
            return s;
        }).join();
        System.out.println(result);
    }

    /**
     * 运行时出现了异常，可以通过exceptionally进行补偿
     *
     * @throws Exception
     */
    public static void func7() throws Exception {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                throw new RuntimeException("exception test!");
            }
            return "Hi Boy";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "Hello world!";
        }).join();
        System.out.println(result);
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
