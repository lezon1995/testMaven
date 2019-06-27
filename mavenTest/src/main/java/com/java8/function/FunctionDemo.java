package com.java8.function;

import java.util.function.Function;

/**
 * @author zhuliang
 * @date 2019/5/28 14:33
 */
public class FunctionDemo {

    private static void func(String string, Function<String, String> f1, Function<String, Integer> f2, Function<Integer, Integer> f3) {
        Integer apply = f1.andThen(f2).andThen(f3).apply(string);
        System.out.println(apply);
    }

    public static void main(String[] args) {
        func(
                "123-456",
                str -> str.split("-")[1],
                Integer::valueOf,
                num -> num + 10
        );
    }
}
