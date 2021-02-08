package com.algorithm.leetcode._61;

import com.algorithm.leetcode.ListNode;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {


        int length = 0;
        //1求得链表的长度length
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        if (length == 0) return head;

        //2用k除以length求余数n
        int n = k % length;

        if (n == 0) return head;

        ListNode p1, p2, predecessor;
        p1 = p2 = head;
        predecessor = null;

        for (int i = 1; i < n; i++) {
            p2 = p2.next;
        }

        while (p2 != null && p2.next != null) {
            predecessor = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (predecessor == null) return head;
        predecessor.next = null;
        p2.next = head;
        return p1;
    }
}