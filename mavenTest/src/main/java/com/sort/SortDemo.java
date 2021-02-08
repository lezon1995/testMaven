package com.sort;

import java.util.Arrays;

/**
 * @author zhuliang
 * @date 2019/7/27 10:04
 */
public class SortDemo {
    static int[] ints = {9, 1, 3, 7, 8, 2, 6, 5, 4};
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
//        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] temp = new int[ints.length];
//        heapSort(ints);
        System.out.println(Arrays.toString(ints));
        quickSort(ints, 0, ints.length - 1);
//        mergeSort(ints, 0, ints.length - 1, temp);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 冒泡排序
     * 两层循环
     * 内存循环一次将数组中最大的值依次交换到最后
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean flag = false;
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * 每次选出一个最小值放在最前面
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        int minIndex;
        int temp;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 插入排序
     * 将数组看做两个部分，左边有序部分，右边无序部分
     * 每次从无序部分中拿出最左边的一个值放入有序部分，并排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        //取出当前数组位置为0的值
        int current;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && array[preIndex] > current) {
                array[i] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }


    /**
     * 希尔排序
     * 减少缩量排序
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int length = array.length;
        int gap;
        int temp;
        for (gap = length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < length; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j + gap];
                        array[j + gap] = array[j];
                        array[j] = temp;
                    }
                }

            }

        }

    }

    /**
     * 快速排序
     * 每次取一个中值，可以是数组中任意一个数，一般取中位数
     * 然后让中值左边的数全部小于中值，右边的数全部大于中值
     *
     * @param arr
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            str.append("----");
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 取最左边的数作为基准数
        int pivot = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = pivot;
        System.out.println(str + Arrays.toString(ints));
        return low; // 返回tmp的正确位置
    }

    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            //右分
            mergeSort(array, mid + 1, right, temp);
            //合并
            merge(array, left, mid, right, temp);
        }
    }

    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int l1 = left;
        int l2 = mid + 1;
        int t = 0;

        //1.将两个数组中从小到大的顺序加入到temp数组中，等其中一个数组加完了，总会有另一个数组没有加完
        while (l1 <= mid && l2 <= right) {
            if (array[l1] <= array[l2]) {
                temp[t++] = array[l1++];
            } else {
                temp[t++] = array[l2++];
            }
        }

        //2.将另外一个数组中的元素加入到temp数组中
        while (l1 <= mid) {
            temp[t++] = array[l1++];
        }
        while (l2 <= right) {
            temp[t++] = array[l2++];
        }

        //3.将temp数组中的元素复制到array原数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft++] = temp[t++];
        }

    }


    /**
     * 堆排序
     * 根据大顶堆的特点，根节点最大，然后将根节点与数组末尾的值交换，然后再在剩下的元素里再次得到大顶堆
     *
     * @param array
     */
    private static void heapSort(int[] array) {
        int length = array.length;
        int max;
        buildMaxHeap(array, length);
        while (length > 0) {
            max = array[0];
            array[0] = array[length - 1];
            array[length - 1] = max;
            length--;
            buildMaxHeap(array, length);
        }
    }

    /**
     * 构建大顶堆
     *
     * @param array
     * @param length
     */
    private static void buildMaxHeap(int[] array, int length) {
        //从最后一个非叶子节点开始往前走
        for (int i = length / 2 - 1; i >= 0; i--) {
            int temp = array[i];
            //一直往左子节点遍历
            for (int j = i * 2 + 1; j < length; j = 2 * j + 1) {
                if (j + 1 < length && array[j] < array[j + 1]) {
                    j++;
                }
                if (temp < array[j]) {
                    array[i] = array[j];
                    i = j;
                } else {
                    break;
                }
                array[j] = temp;
            }
        }
    }
}
