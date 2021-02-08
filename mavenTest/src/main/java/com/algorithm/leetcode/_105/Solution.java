package com.algorithm.leetcode._105;

import com.algorithm.leetcode.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildRoot(
                preorder,
                0,
                preorder.length - 1,
                inorder,
                0,
                inorder.length - 1);
    }


    /**
     * 构建树节点
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return
     */
    public TreeNode buildRoot(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) return null;

        int rootValue = preorder[preStart];
        int inRootIndex = 0;
        TreeNode root = new TreeNode(rootValue);
        //求出左子树的root值和inorderIndex
        for (int i = inStart; i <= inEnd; i++) {
            if (rootValue == inorder[i]) {
                inRootIndex = i;
                break;
            }
        }

        int leftSize = inRootIndex - inStart;
        int rightSize = inEnd - inRootIndex;

        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftSize - 1;

        int rightPreStart = preStart + leftSize + 1;
//        int rightPreEnd = rightPreStart + rightSize - 1;
        int rightPreEnd = preEnd;

        int leftInStart = inStart;
        int leftInEnd = inRootIndex - 1;

        int rightInStart = inRootIndex + 1;
        int rightInEnd = inEnd;

        root.left = buildRoot(preorder, leftPreStart, leftPreEnd, inorder, leftInStart, leftInEnd);
        root.right = buildRoot(preorder, rightPreStart, rightPreEnd, inorder, rightInStart, rightInEnd);

        return root;
    }
}