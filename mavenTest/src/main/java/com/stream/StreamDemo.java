package com.stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author zhuliang
 * @date 2019/5/27 11:48
 */
public class StreamDemo {
    public static void main(String[] args) {
        fun2();
    }

    private static void fun1() {
        Stream<Double> randoms = Stream.generate(Math::random).limit(50);
        Stream<Double> stream = randoms.filter(new Predicate<Double>() {
            @Override
            public boolean test(Double aDouble) {
                return aDouble >= 0.5d;
            }
        }).map(new Function<Double, Double>() {
            @Override
            public Double apply(Double aDouble) {
                return aDouble + 1;
            }
        });
        stream.forEach(new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });
    }

    private static void fun2() {
       /* Random random = new Random();
        String s = "abcdefghijklmnopqrstuvwxyz";
        Stream<String> limit = Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                return String.valueOf(s.charAt(random.nextInt(26)));
            }
        }).limit(26);
        limit.forEach(System.out::print);*/
        Stream<String> a = Stream.of("a", "b", "c", "d", "e", "f");
        a.filter((x) -> x.equals("a")).filter((x) -> x.equals("b")).forEach((x)-> System.out.println(x));
//        a.map(s -> s + 1).forEach(System.out::print);

    }
}
