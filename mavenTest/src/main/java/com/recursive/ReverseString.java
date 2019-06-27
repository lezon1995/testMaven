package com.recursive;

/**
 * @author zhuliang
 * @date 2019/6/27 12:13
 */
public class ReverseString {


    public static void main(String[] args) {
        String str = "12345678";
        String head = null;
        String mid = null;
        String tail = null;
        int i = str.length() / 2;

        if (str.length() % 2 == 1) {
            //奇数
            head = str.substring(0, i);
            mid = str.substring(i, i + 1);
            tail = str.substring(i + 1);
        } else {
            //偶数
            head = str.substring(0, i);
            tail = str.substring(i);
        }
        head = reverse(head);
        tail = reverse(tail);
        if (mid == null) {
            System.out.println(head + tail);
        } else {
            System.out.println(head + mid + tail);
        }
//        String reverse = reverse(str);
//        System.out.println(reverse);
    }


    public static String reverse(String str) {
        if (str.equals("")) {
            return str;
        }
        String subStr = str.substring(1);
        String subSolution = reverse(subStr);
        String solution = subSolution + str.substring(0, 1);
        return solution;
    }
}
