package com.leetcode;/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import com.algorithm.leetcode.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        if (ln1==null&&ln2==null){
            if (flag) {
                list.add(new ListNode(1));
            }
        }
        while (ln2 != null) {
            if (flag){
                ln2.val+=1;
                if (ln2.val==10){
                    ln2.val=0;
                    flag=true;
                }else {
                    flag=false;
                }
            }
            list.add(ln2);
            ln2 = ln2.next;
            if (ln2==null&&flag){
                list.add(new ListNode(1));
            }
        }
        while (ln1 != null) {
            if (flag){
                ln1.val+=1;
                if (ln1.val==10){
                    ln1.val=0;
                    flag=true;
                }else {
                    flag=false;
                }
            }
            list.add(ln1);
            ln1 = ln1.next;
            if (ln1==null&&flag){
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

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);
            
            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);
            System.out.print(out);

        }
    }
}

