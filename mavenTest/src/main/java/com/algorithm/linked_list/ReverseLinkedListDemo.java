package com.algorithm.linked_list;

/**
 * @author zhuliang
 * @date 2019/7/18 18:55
 */
public class ReverseLinkedListDemo {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        sout(root);
    }

    private static void reverseSout(Node node) {

    }

    private static void sout(Node root) {
        if (root == null) {
            return;
        }
        sout(root.next);
        System.out.println(root);
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + value + '}';
    }
}