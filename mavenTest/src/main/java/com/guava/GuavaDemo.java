package com.guava;

import com.google.common.collect.ImmutableList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Wentworth .
 * @date 2019/12/6 2:41 下午
 */
public class GuavaDemo {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
//        List<Integer> list = new ArrayList() {{
//            add(1);
//            add(2);
//            add(3);
//        }};
//        list = Collections.unmodifiableList(list);
//        test(list);
//        System.out.println(list);

//        ImmutableList<Integer> of = ImmutableList.of(1, 2, 3);
//        Spliterator<Integer> spliterator = of.spliterator();
//        System.out.println(of);


        arraySplitDemo();
    }

    public static void test(List list) {
        list.remove(0);
    }

    private static void arraySplitDemo() {
        List<String> collect = Stream.generate(Math::random).limit(100).map(Objects::toString).collect(Collectors.toList());
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");

        Spliterator<String> spliterator = collect.spliterator();

        spliterator.tryAdvance(System.out::println);

        System.out.println("-- buld traversal");
        spliterator.forEachRemaining(System.out::println);

        System.out.println("--- attempting try advance again");
        System.out.println(spliterator.tryAdvance(System.out::println));
    }
}
