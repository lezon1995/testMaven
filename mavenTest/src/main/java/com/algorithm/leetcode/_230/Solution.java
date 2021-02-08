package com.algorithm.leetcode._230;

import com.algorithm.leetcode.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
class Solution {

    int count;
    int result;
    /**
     * 二叉搜索树的中序遍历结果是一个升序序列
     * 所以为了求第k小的元素 只需要在中序遍历访问元素的时候 记录第k次访问的元素 就是第k小的元素
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        travase(root, k);
        return result;
    }

    public void travase(TreeNode root, int k) {
        if (root == null) return;
        travase(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        travase(root.right, k);
    }
}