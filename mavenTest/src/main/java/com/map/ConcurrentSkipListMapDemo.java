package com.map;

import java.util.LinkedList;

/**
 * @author zhuliang
 * @date 2019/6/11 23:13
 */
public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
//        Map<String,Integer> concunrrentSkipListMap = new ConcurrentSkipListMap(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length()-o1.length();
//            }
//        });
//        concunrrentSkipListMap.put("a",1);
//        concunrrentSkipListMap.put("aaaa",4);
//        concunrrentSkipListMap.put("aa",3);
//        concunrrentSkipListMap.put("aaa",2);
//        System.out.println(concunrrentSkipListMap);


        LinkedList<Object> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.addFirst(5);
        deque.addLast(6);
        deque.offer(7);
        System.out.println(deque);


    }
}
