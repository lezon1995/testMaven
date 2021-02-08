package com.algorithm.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode next(ListNode node) {
        next = node;
        return next;
    }

    @Override
    public String toString() {
        return val + ", " + next;
    }

    public static void main(String[] args) {
        int[] ints = {9, 18, 18, 1, 2, 7, 3, 6, 5, 18};
        f(ints);
    }

    public static void f(int[] arr) {

        int[] temp = new int[21];
        for (int k : arr) {
            temp[k]++;
        }
        //顺序打印
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < temp[i]; j++) {
                System.out.println(i);
            }
        }
    }
}