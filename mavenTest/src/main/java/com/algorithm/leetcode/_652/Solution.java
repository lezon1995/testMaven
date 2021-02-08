package com.algorithm.leetcode._652;

import com.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * <p>
 * 示例 1：
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 * /
 * 4
 * 下面是两个重复的子树：
 * <p>
 * 2
 * /
 * 4
 * 和
 * <p>
 * 4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travase(root);
        return list;
    }

    public String travase(TreeNode root) {
        if (root == null) return "#";

        String left = travase(root.left);
        String right = travase(root.right);
        String subTree = left + "," + right + "," + root.val;

        int count = memo.getOrDefault(subTree, 0);
        if (count == 1) {
            list.add(root);
        }

        memo.put(subTree, count + 1);
        return subTree;
    }
}