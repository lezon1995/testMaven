package com.algorithm.dynamic;

/**
 * 走n阶楼梯
 * 每次跨1阶 或者 2阶
 * 走完n阶楼梯 一共有多少种走法
 */
public class StairsProblem {

    static int[] dp = new int[50];
    static int count = 0;

    public static void main(String[] args) {
        int n = 10;

//        int count = walkStairs(n);
        long count = walk(100);

        System.out.println(count);
        System.out.println(StairsProblem.count);
    }

    /**
     * 解法1 递归
     *
     * @param n 楼梯阶数
     * @return 走法数量
     */
    private static int walkStairs(int n) {
        count++;
        if (n == 1 || n == 2) {
            return n;
        }

        int pre1 = n - 1;
        int pre2 = n - 2;

       /* if (dp[pre1] == 0) {
            dp[pre1] = walkStairs(pre1);
        }

        if (dp[pre2] == 0) {
            dp[pre2] = walkStairs(pre2);
        }*/

        return walkStairs(pre1) + walkStairs(pre2);
    }


    private static long walk(int n) {

        long[] cache = new long[n];

        for (int i = 0; i < n; i++) {
            if (i < 2) {
                cache[i] = i + 1;
            } else {
                cache[i] = cache[i - 1] + cache[i - 2];
            }
        }

        return cache[n - 1];
    }


}
