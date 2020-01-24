package com.java8.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Wentworth .
 * @date 2019/12/6 2:26 下午
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> asd = Optional.ofNullable(null);
        asd.map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                System.out.println("s");
                return null;
            }
        });
        String zxc = asd.orElse("zxc");
        String s = asd.orElseGet(new Supplier<String>() {
            @Override
            public String get() {

                return "wqe";
            }
        });
        try {
            asd.orElseThrow(new Supplier<Throwable>() {
                @Override
                public Throwable get() {
                    return new RuntimeException("123");
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(zxc);
        System.out.println(s);
    }
}
