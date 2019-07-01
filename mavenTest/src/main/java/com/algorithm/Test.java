package com.algorithm;

import java.util.*;

/**
 * 一个整形数组，给定一个数，在数组中找出两个数的和等于这个数，并打印出来
 *
 * @author zhuliang
 * @date 2019/7/1 17:01
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 9, 8, 2, 7, 3, 4, 6, 5);
        HashSet<Pair> set = twoSum2(list, 5);
        System.out.println(set);

    }

    public static HashSet<Pair> twoSum2(List<Integer> list, int target) {
        HashSet<Pair> set = new HashSet<>();
        Collections.sort(list);

        //如果target在list中
        int index = list.indexOf(target);
        //找出比target小的集合
        List<Integer> subList = list.subList(0, index);
        for (int i = 0; i < subList.size(); i++) {
            int i1 = target - subList.get(i);
            if (subList.contains(i1)) {
                set.add(new Pair(i1, subList.get(i)));
            }
        }
        return set;
    }


}

class Pair {
    Integer a;
    Integer b;

    public Pair(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        return hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return Math.abs(this.a - this.b);
    }

    @Override
    public String toString() {
        return "[" + a + " , " + b + ']';
    }
}
