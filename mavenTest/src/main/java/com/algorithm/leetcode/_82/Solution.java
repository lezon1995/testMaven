package com.algorithm.leetcode._82;

import com.algorithm.leetcode.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head
                .next(new ListNode(1))
                .next(new ListNode(3))
                .next(new ListNode(3))
                .next(new ListNode(4))
                .next(new ListNode(5))
                .next(new ListNode(6))
                .next(new ListNode(7))
                .next(new ListNode(8))
                .next(new ListNode(8))
                .next(new ListNode(8))
                .next(new ListNode(8))
                .next(new ListNode(8))
                .next(new ListNode(8))
                .next(new ListNode(9))
        ;

        head = solution.deleteDuplicates(head);
        System.out.println(head);
    }

    //定义快慢指针
    ListNode slow, fast, dummy, newHead;
    ListNode slowPre, fastPre;
    //定义前驱节点 后驱节点
    ListNode predecessor, successor;

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        dummy = new ListNode(0);
        //fast指针初始比slow节点快1个单位
        slow = head;
        fast = head.next;

        //记录前驱节点=slow前一个节点   后驱节点=fast
        slowPre = dummy;
        newHead = head;

        ok:
        while (fast != null) {
            while (fast.val != slow.val) {
                slowPre = slow;
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    break ok;
                }
            }

            //当fast和slow节点的值相同时,移动fast节点 直到fast值不等于slow节点
            while (fast.val == slow.val) {
                fastPre = fast;
                fast = fast.next;
                if (fast == null) {
                    break;
                }
            }

            fastPre.next = null;

            predecessor = slowPre;

            if (predecessor == dummy) {
                newHead = dummy;
            }

            successor = fast;

            //将前驱结点的next指向后驱节点
            predecessor.next = successor;

            slow = predecessor;
            fast = successor;
        }

        //再将slow=前驱结点 fast=后驱节点 然后重复上述过程直到fast达到尾节点
        if (newHead == dummy) {
            return newHead.next;
        }
        return newHead;
    }
}