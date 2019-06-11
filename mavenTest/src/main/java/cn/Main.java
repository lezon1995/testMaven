package cn;


import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) throws Exception {
//        list();

        deque();

    }

    private static void set() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(random.nextInt(10000));
        }
        System.out.println(treeSet);
        System.out.println(treeSet.size());

    }

    private static void map() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            treeMap.put(random.nextInt(10000), random.nextInt(10000));
        }
        System.out.println(treeMap);
        System.out.println(treeMap.size());

    }

    private static void queue() throws Exception {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        for (int i = 0; i < 15; i++) {
            queue.put(i);
        }
        System.out.println(queue);
    }

    private static void deque() throws Exception {
        LinkedList stack =new LinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    private static void list() {
        LinkedList<Integer> linkedList = new LinkedList();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }
        System.out.println("complete");

        long start = System.currentTimeMillis();
        System.out.println(linkedList.indexOf(10000000 - 1));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(arrayList.indexOf(10000000 - 1));
        end = System.currentTimeMillis();
        System.out.println(end - start);

        Random random = new Random();

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(random.nextInt(10000));
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(random.nextInt(10000));
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
