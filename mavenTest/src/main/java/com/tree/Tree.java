package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private Node root;
    Queue<Node> queue;

    public Tree() {
        this.root = null;
        queue = new LinkedList<>();
    }

    public void add(Node item) {
        Node node = new Node(item);
        if (this.root == null) {
            this.root = node;
            return;
        }
        queue.clear();
        queue.offer(root);
        while (queue.size() > 0) {
            Node currentNode = queue.poll();
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(node);
                return;
            } else {
                queue.offer(currentNode.getLeft());
            }
            if (currentNode.getRight() == null) {
                currentNode.setRight(node);
                return;
            } else {
                queue.offer(currentNode.getRight());
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(new Node("A"));
        tree.add(new Node("B"));
        tree.add(new Node("C"));
        tree.add(new Node("D"));
        tree.add(new Node("E"));
        tree.add(new Node("F"));
        tree.add(new Node("G"));
        tree.add(new Node("H"));
        System.out.println();
    }
}

class Node {
    private Object node;
    private Node left;
    private Node right;

    public Node(Object object) {
        this.node = object;
        this.left = null;
        this.right = null;
    }

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}