package com.guava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Wentworth .
 * @date 2019/12/6 3:00 下午
 */
public class MultiSetDemo {
    public static void main(String[] args) throws IOException {
//        Multiset<String> multiset = HashMultiset.create();
//        Stream<String> lines = Files.lines(Paths.get("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/com/guava/MultiSetDemo.java"));
//        ;
//        lines.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String line) {
//                Stream.of(line.split("")).forEach(new Consumer<String>() {
//                    @Override
//                    public void accept(String c) {
//                        multiset.add(c);
//                    }
//                });
//            }
//        });
//        multiset.elementSet().stream().sorted(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return multiset.count(o2) - multiset.count(o1);
//            }
//        }).forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println("[" + s + "]" + "出现了" + multiset.count(s) + "次");
//            }
//        });
        test1();
    }

    public static void test() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Set<Set<Integer>> sets = Sets.powerSet(set);
        System.out.println(JSONObject.toJSONString(sets, true));
    }

    public static void test1() {
        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set2 = Sets.newHashSet(4,5);
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<List<Integer>> sets = Sets.cartesianProduct(set1, set2);
        List<List<Integer>> partition = Lists.partition(list, 2);
        System.out.println(JSONObject.toJSONString(partition, false));
    }
}
