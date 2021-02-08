package com.leetcode._0002;

import com.algorithm.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(9);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        node1.next = node2;
//
//        ListNode l0 = new ListNode(1);
//        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(9);
//        ListNode l3 = new ListNode(9);
//        ListNode l4 = new ListNode(9);
//        ListNode l5 = new ListNode(9);
//        ListNode l6 = new ListNode(9);
//        ListNode l7 = new ListNode(9);
//        ListNode l8 = new ListNode(9);
//        ListNode l9 = new ListNode(9);
//        l0.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
//        l7.next = l8;
//        l8.next = l9;

        System.out.println(addTwoNumber(node, node1));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0;
        long counter1 = 1, counter2 = 1;
        ListNode ln1 = l1;
        ListNode ln2 = l2;
        while (ln1 != null) {
            num1 += ln1.val * counter1;
            counter1 *= 10;
            ln1 = ln1.next;
        }
        while (ln2 != null) {
            num2 += ln2.val * counter2;
            counter2 *= 10;
            ln2 = ln2.next;
        }
        System.out.println(num1);
        System.out.println(num2);
        long sum = num1 + num2;
        ListNode result = new ListNode((int) (sum % 10L));
        ListNode temp = result;
        while (sum > 0) {
            sum /= 10;
            if (sum == 0) {
                break;
            }
            temp.next = new ListNode((int) (sum % 10L));
            temp = temp.next;
        }
        return result;
    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        List<ListNode> list = new ArrayList<>();
        ListNode ln1 = l1;
        ListNode ln2 = l2;
        boolean flag = false;
        while (ln1 != null && ln2 != null) {
            int x = ln1.val + ln2.val;
            if (flag) {
                x += 1;
                flag = false;
            }
            if (x / 10 == 0) {
                list.add(new ListNode(x));
            } else {
                list.add(new ListNode(x % 10));
                flag = true;
            }
            ln1 = ln1.next;
            ln2 = ln2.next;

        }
        if (ln1 == null && ln2 == null) {
            if (flag) {
                list.add(new ListNode(1));
            }
        }
        while (ln2 != null) {
            if (flag) {
                ln2.val += 1;
                if (ln2.val == 10) {
                    ln2.val = 0;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            list.add(ln2);
            ln2 = ln2.next;
            if (ln2 == null && flag) {
                list.add(new ListNode(1));
            }
        }
        while (ln1 != null) {
            if (flag) {
                ln1.val += 1;
                if (ln1.val == 10) {
                    ln1.val = 0;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            list.add(ln1);
            ln1 = ln1.next;
            if (ln1 == null && flag) {
                list.add(new ListNode(1));
            }
        }
        result = list.get(0);
        temp = result;
        for (int i = 1; i < list.size(); i++) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        return result;
    }
}

