package com.algorithm.leetcode._90;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
class Solution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        List<List<Integer>> lists = solution.subsetsWithDup(new int[]{1, 2, 2});
//        List<List<Integer>> collect = lists.stream().distinct().collect(Collectors.toList());
//        System.out.println(collect);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
//    Stack<Integer> track = new Stack<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums, 0);
        return res.stream().distinct().collect(Collectors.toList());
    }

    public void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(track.stream().sorted().collect(Collectors.toList())));
        System.out.println(track);
        for (int i = index; i < nums.length; i++) {
            //做出选择
            track.add(nums[i]);
            //回溯
            backtrack(nums, i + 1);
            //撤销选择
            track.remove((Integer) nums[i]);
        }
    }
}