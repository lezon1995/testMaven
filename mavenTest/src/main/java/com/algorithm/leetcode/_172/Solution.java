package com.algorithm.leetcode._172;

/**
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
class Solution {
    public int trailingZeroes(int n) {


        //n!的结果尾数有多少个0 取决于从1到n之间的数中 包含多少对 2和5 因为只有2*5的结尾是0
        //比如n=10时 n!=1*2*3*4*5*6*7*8*9*10=3 628 800; 一共2个0
        // 一共包含8个2和2个5
        //1 0个2 0个5
        //2 1个2 0个5
        //3 0个2 0个5
        //4 2个2(2*2) 0个5
        //5 0个2 1个5
        //6 1个2 0个5
        //7 0个2 0个5
        //8 3个2(2*2*2) 0个5
        //9 0个2 0个5
        //10 1个2 1个5
        //因为只要是偶数就一定至少包含一个2, 加上从上面可以看出 2的个数一定比5的个数多 所以只需要求出5的个数 就可以知道尾数0的个数

        //但是对于5 10 15 20这样的数,能够包含1个5
        //但是对于25 50 75 100这样的数,能够包含2个5
        //但是对于125 250 375 500这样的数,能够包含3个5
        //等等

        //所以需要筛选 先用5来筛选 再用25(5*5)来筛选 再用125(5*5*5)来筛选 ...

        int result = 0;
        int divisor = 5;

        while (divisor <= n) {
            result += n / divisor;
            divisor *= 5;
        }

        return result;
    }
}