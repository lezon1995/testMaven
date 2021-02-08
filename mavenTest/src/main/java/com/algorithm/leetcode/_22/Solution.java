package com.algorithm.leetcode._22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * 提示：
 * 1 <= n <= 8
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    String left = "(";
    String right = ")";
    int leftCount;
    int rightCount;

    public List<String> generateParenthesis(int n) {
        leftCount = n;
        rightCount = n;
        backtrack(n, 0);
        return res;
    }

    public void backtrack(int n, int index) {
        if (leftCount > rightCount) return;
        if (leftCount < 0 || rightCount < 0) return;
        if (sb.length() == n * 2) {
            res.add(sb.toString());
//            sb.setLength(0);
        }

        for (int i = index; i < n * 2; i++) {
            //选择
            sb.append(left);
            leftCount--;
            //回溯
            backtrack(n, i + 1);
            //撤销
            sb.deleteCharAt(sb.length() - 1);
            leftCount++;

            //选择
            sb.append(right);
            rightCount--;
            //回溯
            backtrack(n, i + 1);
            //撤销
            sb.deleteCharAt(sb.length() - 1);
            rightCount++;
        }
    }
}