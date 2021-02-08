package com.algorithm.leetcode._46;

import com.google.common.base.Stopwatch;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

/**
 * for 选择 in 选择列表:
 * # 做选择
 * 将该选择从选择列表移除
 * 路径.add(选择)
 * backtrack(路径, 选择列表)
 * # 撤销选择
 * 路径.remove(选择)
 * 将该选择再加入选择列表
 */


class Solution {

    List<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3, 4, 5});
        System.out.println(permute);
        System.out.println(permute.size());
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {

        //当走完一次全排列
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }

        for (Integer num : nums) {

            //做出选择
            if (track.contains(num)) continue;
            track.add(num);

            //回溯
            backtrack(nums);

            //撤销选择
            track.remove(num);
        }
    }
}