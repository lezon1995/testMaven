package com.algorithm.leetcode._22;

/**
 * @author zhuliang
 * @date 2019/7/20 17:30
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode（22）：括号生成
 * Medium！
 * <p>
 * 题目描述：
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Q22 {
    public static void main(String[] args) {
        List<String> fun = generateParenthesis(2);
        System.out.println(fun);
    }

    public static  List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        doadd(n,n,list,"");
        return list;
    }

    public static void doadd(int left, int right, List<String> list, String path){
        if (left == 0 && right == 0){
            list.add(path);
            return;
        }
        if (left != 0)
            doadd(left-1,right,list,path+"(");
        if (right != 0 && right > left)
            doadd(left,right-1,list,path+")");
    }



}
