package com.leetcode._0001;

import java.util.Arrays;

/**
 * @author wentworth
 * @date 2019-08-19 16:05
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3, 4, 5}, 5);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        int a, b;
        ok:for (int i = 0; i < nums.length; i++) {
            a = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] == a) {
                    result = new int[]{i, j};
                    break ok;
                }
            }
        }
        return result;
    }
}
