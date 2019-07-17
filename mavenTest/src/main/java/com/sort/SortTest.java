package com.sort;

import java.util.Random;

/**
 * @author zhuliang
 * @date 2019/7/1 15:04
 */
public class SortTest {
    private static int MAX = 100000000;

    private static int[] inits = new int[MAX];

    // 同样进行随机队列初始化，这里就不再赘述了
    static {
        Random r = new Random();
        for (int index = 1; index <= MAX; index++) {
            inits[index - 1] = r.nextInt(10000000);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SortUtil.quickSort(inits, 0, MAX-1);
        long end = System.currentTimeMillis();

        System.out.println("耗时:" + (end - start));
    }
}
