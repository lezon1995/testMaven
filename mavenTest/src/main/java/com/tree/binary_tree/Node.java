package com.tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    public Object obj;
    public Node left;
    public Node right;

    public Node(Object object) {
        this.obj = object;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "obj=" + obj +
                '}';
    }

    /**
     * 前序遍历 mid->left->right
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 非递归前序遍历
     */
    public void preOrderUnRecursive() {
        Stack<Node> stack = new Stack<>();
        Node current = this;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.println(current);
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
    }

//    public void preOrderUnRecursive1() {
//        Stack<Node> stack = new Stack<>();
//        Node current = this;
//        while (current != null || !stack.isEmpty()) {
//            while (current != null) {
//                System.out.println(current);
//                current = current.left;
//                stack.push(current);
//            }
//            if (!stack.isEmpty()) {
//                current = stack.pop();
//                current = current.right;
//            }
//        }
//    }

    /**
     * 前序遍历查找 mid->left->right
     */
    public Node preOrderSearch(Object obj) {
        if (this.obj == obj) {
            return this;
        }
        Node result = null;
        if (this.left != null) {
            result = this.left.preOrderSearch(obj);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.preOrderSearch(obj);
        }
        return result;
    }


    /**
     * 中序遍历 left->mid->right
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 非递归中序遍历
     */
    public void midOrderUnRecursive() {
        Stack<Node> stack = new Stack<>();
        Node current = this;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.println(current);
                current = current.right;
            }
        }
    }

    /**
     * 中序遍历查找 left->mid->right
     */
    public Node midOrderSearch(Object obj) {
        Node result = null;
        if (this.left != null) {
            result = this.left.midOrderSearch(obj);
        }
        if (result != null) {
            return result;
        }
        if (this.obj == obj) {
            return this;
        }
        if (this.right != null) {
            result = this.right.midOrderSearch(obj);
        }
        return result;
    }


    /**
     * 后序遍历 left->right->mid
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 后序遍历非递归
    public void postOrderUnRecursive() {
        //用于存放节点的栈
        Stack<Node> nodeStack = new Stack<>();
        //用于存放节点是否准备好被访问的栈，跟nodeStack中元元素一一对应
        // true：准备好 false：为准备好
        Stack<Boolean> booleanStack = new Stack<>();
        Node current = this;
        while (current != null || !nodeStack.empty()) {
            //一直遍历左子节点，并将节点其压入栈中，默认都是未准备好
            while (current != null) {
                nodeStack.push(current);
                booleanStack.push(false);
                current = current.left;
            }
            //如果栈中有元素，并且栈顶的元素准备好被访问，则将其取出并操作
            while (!nodeStack.empty() && booleanStack.peek()) {
                booleanStack.pop();
                Node node = nodeStack.pop();
                System.out.println(node);
            }
            //如果栈中还有元素，将栈顶的元素设置为准备好，
            if (!nodeStack.empty()) {
                booleanStack.pop();
                booleanStack.push(true);
                current = nodeStack.peek();
                current = current.right;
            }
        }
    }


    /**
     * 后序遍历查找 left->right->mid
     */
    public Node postOrderSearch(Object obj) {
        Node result = null;
        if (this.left != null) {
            result = this.left.postOrderSearch(obj);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.postOrderSearch(obj);
        }
        if (this.obj == obj) {
            return this;
        }
        return result;
    }

    /**
     * 层序遍历(广度优先思想)
     */
    public void levelTraverse() {
        Node root = this;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 求树的最大深度
     *
     * @return 最大深度
     */
    public int maxDepth() {
        Node curRoot = this;

        int maxDepth;
        int maxDepthL = 0;
        int maxDepthR = 0;

        if (curRoot.left != null) {
            maxDepthL = curRoot.left.maxDepth();
        }

        if (curRoot.right != null) {
            maxDepthR = curRoot.right.maxDepth();
        }

        maxDepth = Math.max(maxDepthL, maxDepthR) + 1;
        return maxDepth;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node root_left = new Node(2);
        Node root_right = new Node(3);
        Node root_right_right = new Node(7);
        Node root_right_left = new Node(6);
        Node root_left_left = new Node(4);
        Node root_left_right = new Node(5);
        Node root_left_right_right = new Node(5);
        Node root_left_right_right_left = new Node(5);

        root.left = root_left;
        root.right = root_right;
        root_right.right = root_right_right;
        root_right.left = root_right_left;
        root_left.left = root_left_left;
        root_left.right = root_left_right;
        root_left_right.right = root_left_right_right;
        root_left_right_right.left = root_left_right_right_left;
//        root.postOrder();
        root.postOrderUnRecursive();

        System.out.println(root.maxDepth());
    }
}