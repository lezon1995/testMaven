package com.algorithm.leetcode._234;

import com.algorithm.leetcode.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {


    static ListNode left;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head
                .next(new ListNode(2))
                .next(new ListNode(3))
                .next(new ListNode(4))
                .next(new ListNode(5))
                .next(new ListNode(6))
                .next(new ListNode(6))
                .next(new ListNode(6))
                .next(new ListNode(5))
                .next(new ListNode(5))
                .next(new ListNode(4))
                .next(new ListNode(3))
                .next(new ListNode(2))
                .next(new ListNode(1))
        ;


        System.out.println(isPalindrome2(head));
    }

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return travase(left);
    }

    public static boolean travase(ListNode right) {
        if (right == null) return true;
        boolean flag = travase(right.next);
        flag = flag && (left.val == right.val);
        left = left.next;
        return flag;
    }


    public static boolean isPalindrome2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == null) {
            return true;
        }

        if (fast != null) {
            slow = slow.next;
        }

        //从slow往后面开始翻转链表

        ListNode left = head;
        ListNode right = reverse(slow);

        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode node) {
        if (node.next == null) return node;
        ListNode last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }


}