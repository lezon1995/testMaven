package com.sort;

import java.util.HashSet;

/**
 * @author zhuliang
 * @date 2019/9/7 20:16
 */
public class OI {
    public static void main(String[] args) {
        //n=3 m=1 1+2
        //n=3 m=2 1+2+3
        //n=3 m=3 1+2+3+4

        //n=4 m=1 1+3
        //n=4 m=2 1+3+5
        //n=4 m=3 1+3+5+7
        //n=4 m=4 1+3+5+7+9


        //n=5 m=1 1+4
        //n=5 m=2 1+4+7
        //n=5 m=3 1+4+7+10
        //n=5 m=4 1+4+7+10+13
        //n=5 m=5 1+4+7+10+13+16

        int n = 3;
        int m = 3;
        int sum = 1;
        int step = n - 1 - 1;
        for (int i = 1; i <= m; i++) {
            sum += i * step + 1;
        }
        System.out.println(sum);

    }
}
