package cn.collection;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author zhuliang
 * @date 2019/6/19 11:58
 */
public class SetDemo {
    public static void main(String[] args) {
        SortedSet<Integer> sortedSet=new TreeSet();
        sortedSet.add(9);
        sortedSet.add(1);
        sortedSet.add(8);
        sortedSet.add(2);
        sortedSet.add(7);
        sortedSet.add(3);
        sortedSet.add(4);
        System.out.println(sortedSet);
        SortedSet<Integer> headSet = sortedSet.headSet(4);
        System.out.println(headSet);
    }
}
