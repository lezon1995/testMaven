package com.tree.binary_tree;

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


    public static void main(String[] args) {
        Node root = new Node(1);
        Node root_left = new Node(2);
        Node root_right = new Node(3);
        Node root_right_right = new Node(4);
        Node root_right_left = new Node(5);
        root.left = root_left;
        root.right = root_right;
        root_right.right = root_right_right;
        root_right.left = root_right_left;
        root.midOrderUnRecursive();

    }
}