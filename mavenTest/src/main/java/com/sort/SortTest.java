package com.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhuliang
 * @date 2019/7/1 15:04
 */
public class SortTest {
    private static int MAX = 100;

    private static int[] inits = new int[MAX];

    // 同样进行随机队列初始化，这里就不再赘述了
    static {
        Random r = new Random();
        for (int index = 1; index <= MAX; index++) {
            inits[index - 1] = r.nextInt(100);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{76, 94, 63, 58, 82, 44, 67, 4, 67, 89,
                5, 37, 52, 61, 98, 60, 96, 66, 62, 85,
                88, 13, 1, 95, 17, 19, 94, 16, 52, 68,
                59, 58, 22, 90, 19, 51, 33, 82, 78, 73,
                4, 51, 20, 24, 70, 64, 65, 9, 11, 28,
                0, 17, 47, 13, 28, 8, 71, 14, 3, 8, 15, 38,
                67, 54, 38, 71, 99, 67, 5, 83, 75, 87, 31,
                35, 68, 63, 87, 18, 54, 93, 12, 89, 44, 34,
                97, 45, 26, 16, 16, 29, 31, 94, 2, 18, 87, 74,
                46, 41, 12, 22};
        int[] result = heapSort(array, 20);
        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(inits));
    }

    /**
     * 去前n个最大的数
     *
     * @param array 原始数组
     * @param n 前n个
     */
    public static int[] heapSort(int[] array, int n) {
        int size = n;
        //第一次构建大顶堆
        int length = array.length;
        buildMaxHeap(array, length);
        //此时顶端是数组中最大的节点，将顶端与数组末尾交换，然后在剩下的数组中再次构建大顶堆
        while (n > 0 && n <= length) {
            // 交换首尾元素
            int temp = array[0];
            array[0] = array[length - 1];
            array[length - 1] = temp;
            n--;
            length--;
            buildMaxHeap(array, length);
        }
        int[] result = new int[size];
        System.arraycopy(array, array.length - size, result, 0, size);
        return result;
    }

    private static void buildMaxHeap(int[] array, int length) {
        //从最后一个非叶子节点开始
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, length);
        }
    }

    /**
     * 调整大顶堆
     *
     * @param array  被调整数组
     * @param i      非叶子节点
     * @param length 需要调整的长度
     */
    private static void adjustHeap(int[] array, int i, int length) {
        //获取当前非叶子节点的值
        int temp = array[i];
        //依次遍历非叶子节点的左子节点
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            //让j指向左右子节点较大的哪个
            if (j + 1 < length && array[j] < array[j + 1]) {
                j++;
            }
            //如果子节点>父节点
            if (array[j] > temp) {
                //让当前非叶子节点的值等于子节点的值
                array[i] = array[j];
                //让当前非叶子节点的下标指向当前字节点的下标
                i = j;
            } else {
                //因为大顶堆是从下到上构建的，所以如果父节点是最大的那个的话就可以直接退出循环
                break;
            }
            //让大的子节点等于之前非叶子节点的值
            array[j] = temp;
        }
    }
}
