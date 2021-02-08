package com.algorithm.leetcode._92;


import com.algorithm.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head
                .next(new ListNode(2))
                .next(new ListNode(3))
                .next(new ListNode(4))
                .next(new ListNode(5))
                .next(new ListNode(6));

//        for (ListNode node = head; node.next != null; node = node.next){
//            System.out.println(node);
//        }

        System.out.println(head);

//        ListNode reverse = reverse(head);
//        ListNode reverse = reverse(head, 3);
        ListNode reverse = reverseBetween(head, 2, 5);
        System.out.println(reverse);

    }

    /**
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     *
     * @param head 头结点
     * @return 反转之后的头结点
     */
    public static ListNode reverseBetween(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseBetween(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode reverseIter(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head;
        while (cur != null) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }


    static ListNode successor;

    public static ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverse(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}