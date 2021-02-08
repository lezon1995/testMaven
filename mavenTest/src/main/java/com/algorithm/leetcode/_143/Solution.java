package com.algorithm.leetcode._143;

import com.algorithm.leetcode.ListNode;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head
                .next(new ListNode(2))
                .next(new ListNode(3))
                .next(new ListNode(4))
                .next(new ListNode(5))
                .next(new ListNode(6))
                .next(new ListNode(7))
                .next(new ListNode(8))
                .next(new ListNode(9))
                .next(new ListNode(10))
        ;

        solution.reorderList(head);
    }

    ListNode left;
    ListNode head;
    int count;
    int length;

    public void reorderList(ListNode head) {
        if (head == null) return;
        left = head;
        this.head = head;
        travase(head);
        System.out.println(this.head);
    }

    public ListNode travase(ListNode head) {
        length++;
        if (head.next == null) return head;
        //先递归到最后一个节点 并顺便求出链表长度
        ListNode last = travase(head.next);

        //求出链表中点位置 如果长度为奇数中点位置则为 length / 2 + 1 即向上取整
        //求出链表中点位置 如果长度为偶数数中点位置则为 length / 2
        int half;
        if ((length & 1) == 1) {
            half = length / 2 + 1;
        } else {
            half = length / 2;
        }

        //如果计数器已经导了中点位置 则整个链表已经重排完毕
        if (++count < half) {
            //先取出左边节点的next
            ListNode next = left.next;

            //将尾节点的前节点的next设为null
            head.next = null;

            //再将尾节点的next指向顺数第二个节点
            last.next = next;

            //再将左节点的next指向尾节点
            left.next = last;

            //让后移动左指针到顺数第二个节点
            left = next;
        }

        //注意这里是返回参数head节点 因为last节点已经移动到前面去了 所以就相当于head成了尾节点
        return head;
    }
}