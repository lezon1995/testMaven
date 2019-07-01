package com.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zhuliang
 * @date 2019/6/30 16:24
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

//        Collections.rotate(list,-3);
//        int frequency = Collections.frequency(list, 1);

//        System.out.println(frequency);


        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            next++;
            iterator.set(next);
        }
        while (iterator.hasPrevious()){
            Integer previous = iterator.previous();
            previous++;
            iterator.set(previous);
        }
        System.out.println(list);
    }
}
