package com.java8.function;

import java.util.function.Consumer;

/**
 * @author zhuliang
 * @date 2019/5/28 14:18
 */
public class ConsumerDemo {

    public static void run(String string, Consumer<String> c1, Consumer<String> c2) {
        c1.andThen(c2).accept(string);
    }

    public static void main(String[] args) {
        run("hello-world",
                (t) -> {
                    t = t.split("-")[0];
                    System.out.println(t);
                },
                (t) -> {
                    t.toUpperCase();
                    System.out.println(t);
                });
    }
}
