package com.algorithm.hanoi;

/**
 * @author zhuliang
 * @date 2019/7/18 23:21
 */
public class HanoiTowerDemo {
    static int count = 0;

    public static void main(String[] args) {
        hanoi(30, "A", "B", "C");
        System.out.println(count);
    }

    /**
     * 将num个盘 从a移动到c 借助b
     * 移动次数为2^num - 1
     *
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoi(int num, String a, String b, String c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println(String.format("第%d个盘 从 %s -> %s", num, a, c));
        } else {
            //如果盘数>=2，我们总是可以看做是两种盘
            //第一种 最下面的一个盘
            //第二种 上面的所有盘
            //先把第二中盘 从A移动到B，借助C
            hanoi(num - 1, a, c, b);
            //把第一种盘从A移动到C
            System.out.println(String.format("第%d个盘 从 %s -> %s", num, a, c));
            //再将第二种盘从B移动到C，借助A
            hanoi(num - 1, b, a, c);
        }
        count++;
    }
}
