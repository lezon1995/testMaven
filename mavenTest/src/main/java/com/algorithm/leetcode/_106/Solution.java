package com.algorithm.leetcode._106;

import com.algorithm.leetcode.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;

        int root = postorder[postEnd];
        int rootIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode(root);

        int leftSize = rootIndex - inStart;

        int leftInStart = inStart;
        int leftInEnd = rootIndex - 1;
        int leftPostStart = postStart;
        int leftPostEnd = postStart + leftSize - 1;

        int rightInStart = rootIndex + 1;
        int rightInEnd = inEnd;
        int rightPostStart = postStart + leftSize;
        int rightPostEnd = postEnd - 1;

        treeNode.left = build(inorder, leftInStart, leftInEnd, postorder, leftPostStart, leftPostEnd);
        treeNode.right = build(inorder, rightInStart, rightInEnd, postorder, rightPostStart, rightPostEnd);

        return treeNode;
    }
}