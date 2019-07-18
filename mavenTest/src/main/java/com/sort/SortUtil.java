package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author zhuliang
 * @date 2019/6/30 13:33
 */
public class SortUtil {
    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            ints[i] = random.nextInt(1000000);
        }
//        int[] ints = new int[]{5, 5, 4, 4, 3, 3, 2, 2, 9, 9, 8, 8, 6, 6, 7, 7};
//        int[] ints = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] temp = new int[1000000];
        long start = System.currentTimeMillis();
//        int[] ints1 = shellSortBySwap(ints);
        mergeSort(ints, 0, ints.length - 1, temp);
        long end = System.currentTimeMillis();
        long l = end - start;
        System.out.println(l + "ms");
//        System.out.println(Arrays.toString(ints));
    }

    /**
     * 1、冒泡排序（Bubble Sort）
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，
     * 一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 1.1 算法描述
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     * <p>
     * 1.4 算法分析
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        //是否进行过交换 如果一次内部循环后仍然是false说明数组已经排序完毕 不需要后面继续判断
        boolean flag = false;
        //在外层循环-1 是因为假如一个数组有10个元素，如果确定了9个元素的位置，那么最后一个就自动确定了，所以就不需要做最后一次循环了
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    flag = true;
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "次循环");
            //进行过交换 将flag设为false继续下一次循环
            if (flag) {
                flag = false;
            } else {
                //没有交换过 说明当前数组已经排序完毕
                break;
            }
        }
        return array;
    }


    /**
     * 2、选择排序（Selection Sort）
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n^2)的时间复杂度，
     * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
     * 理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
     * <p>
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     * <p>
     * 2.1 算法描述
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     * <p>
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     * <p>
     * 2.4 算法分析
     * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                //找到最小的数
                if (array[j] < array[minIndex]) {
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            //交换最小数到数组第i个位置
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }


    /**
     * 3、插入排序（Insertion Sort）
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，
     * 找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * <p>
     * 3.1 算法描述
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     * <p>
     * 3.4 算法分析
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        int current;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            int preIndex = i - 1;
            //保证preIndex不越界
            //如果当前值 < 前一个值
            while (preIndex >= 0 && array[preIndex] > current) {
                //让当前值 = 前面一个值
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }


    /**
     * 4、希尔排序（Shell Sort）
     * 希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，
     * 也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。
     * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     * <p>
     * 希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     * <p>
     * 4.1 算法描述
     * 我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，
     * 缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，
     * 称为增量序列。希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，
     * 也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。
     * <p>
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * <p>
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * <p>
     * 4.4 算法分析
     * 最佳情况：T(n) = O(nlog n)  最坏情况：T(n) = O(nlog n)  平均情况：T(n) =O(nlogn)
     * 移位式希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSortByShift(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                while (i - gap >= 0 && array[i - gap] > temp) {
                    array[i] = array[i - gap];
                    i -= gap;
                }
                array[i] = temp;
            }
            gap /= 2;
        }
        return array;
    }


    /**
     * **gap=2**
     * <p>
     * `i=2` 0,2
     * <p>
     * `i=3` 1,3
     * <p>
     * `i=4` 2,4	0,2
     * <p>
     * `i=5` 3,5	1,3
     * <p>
     * `i=6` 4,6	2,4	0,2
     * <p>
     * `i=7` 5,7	3,5	1,3
     * <p>
     * `i=8` 6,8	4,6	2,4	0,2
     * <p>
     * `i=9` 7,9	5,7	3,5	1,3
     * <p>
     * ------
     * <p>
     * **gap=1**
     * <p>
     * `i=1` 0,1
     * <p>
     * `i=2` 1,2	0,1
     * <p>
     * `i=3` 2,3	1,2	0,1
     * <p>
     * `i=4` 3,4	2,3	1,2	0,1
     * <p>
     * `i=5` 4,5	3,4	2,3	1,2	0,1
     * <p>
     * `i=6` 5,6	4,5	3,4	2,3	1,2	0,1
     * <p>
     * `i=7` 6,7	5,6	4,5	3,4	2,3	1,2	0,1
     * <p>
     * `i=8` 7,8	6,7	5,6	4,5	3,4	2,3	1,2	0,1
     * <p>
     * `i=9` 8,9	7,8	6,7	5,6	4,5	3,4	2,3	1,2	0,1
     * 交换式希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSortBySwap(int[] array) {
        int length = array.length;
        //步长
        int gap;
        int temp;
        //初始化步长gap = length / 2 ，每次gap/=2
        for (gap = length / 2; gap > 0; gap /= 2) {
            //10个元素 gap=5 可以有(0,5)、(1,6)、(2,7)、(3,8)、(4,9)5组
            //10个元素 gap=2 可以有(0,2,4,6,8)、(1,3,5,7,9) 2组
            //10个元素 gap=1 可以有(0,1,2,3,4,5,6,7,8,9) 1组
            //第二次循环可以理解为[组]中逗号的个数 意思
            for (int i = gap; i < length; i++) {
                //第三次循环就是[组]内部的排序
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
        return array;
    }


    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 5、归并排序（Merge Sort）
     * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，
     * 因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
     * <p>
     * 归并排序是建立在归并操作上的一种有效的排序算法。
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；
     * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
     * <p>
     * 5.1 算法描述
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     * <p>
     * 5. 4 算法分析
     * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }


    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左拆分
            mergeSort(array, left, mid, temp);
            //向右拆分
            mergeSort(array, mid + 1, right, temp);
            //归并
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * @param array 需要排序的原始数组
     * @param left  左边有序数组的初始索引
     * @param mid   右边有序数组的初始索引
     * @param right 最右索引
     * @param temp  临时数组 用于存放合并之后的数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int l1 = left;
        int l2 = mid + 1;
        //临时数组索引
        int t = 0;
        //将左右需要合并的数组，按从小到大的顺序加到临时数组中
        //直到有一方已经全部加完
        while (l1 <= mid && l2 <= right) {
            if (array[l1] <= array[l2]) {
                temp[t] = array[l1];
                l1++;
                t++;
            } else {
                temp[t] = array[l2];
                l2++;
                t++;
            }
        }
        //将剩余的数组的元素直接追加到临时数组最后
        while (l1 <= mid) {
            temp[t] = array[l1];
            l1++;
            t++;
        }
        while (l2 <= right) {
            temp[t] = array[l2];
            l2++;
            t++;
        }

        //将临时数组拷贝到原数组
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }


    /**
     * 6、快速排序（Quick Sort）
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
     * 其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，
     * 以达到整个序列有序。
     * <p>
     * 6.1 算法描述
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面
     * （相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。
     * 这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * <p>
     * 5.4 算法分析
     * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)
     * 空间换时间
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        //获取中值pivot 不一定是中间值
        int pivot = array[(left + right) / 2];
        //确保比pivot小的值在左边，大的值在右边
        while (l < r) {
            //从左向右遍历数组，找到一个比pivot大的值
            while (array[l] < pivot) {
                l++;
            }
            //从右向左遍历数组，找到一个比pivot小的值
            while (array[r] > pivot) {
                r--;
            }
            //如果l>=r 说明当前pivot左边的值是<右边的值的
            if (l >= r) {
                break;
            }
            //如果 大于pivot的值 在 小于pivot的值 的左边 则交换两个值
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            //如果交换完后array[l] = pivot 则让l 右移
            if (array[l] == pivot) {
                l++;
            }
            //如果交换完后array[r] = pivot 则让r 左移
            if (array[r] == pivot) {
                r--;
            }
        }
        //如果l==r 则必须让l右移 r左移 不然会栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < l) {
            quickSort(array, left, r);
        }
        //向右递归
        if (right > r) {
            quickSort(array, l, right);
        }
    }


    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //声明全局变量，用于记录数组array的长度；
    static int len;

    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }

    /**
     * 7、堆排序（Heap Sort）
     * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
     * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：
     * 即子结点的键值或索引总是小于（或者大于）它的父节点。
     * <p>
     * 7.1 算法描述
     * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)
     * 和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
     * <p>
     * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
     * 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
     * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     * <p>
     * 7.4 算法分析
     * 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }


    /**
     * 8、计数排序（Counting Sort）
     * 计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
     * <p>
     * 计数排序(Counting sort)是一种稳定的排序算法。计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。它只能对整数进行排序。
     * <p>
     * 8.1 算法描述
     * 找出待排序的数组中最大和最小的元素；
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     * <p>
     * 8.4 算法分析
     * 当输入的元素是n 个0到k之间的整数时，它的运行时间是 O(n + k)。计数排序不是比较排序，排序的速度快于任何比较排序算法。由于用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值的差加上1），这使得计数排序对于数据范围很大的数组，需要大量时间和内存。
     * <p>
     * 最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }


    /**
     * 9、桶排序（Bucket Sort）
     * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
     * <p>
     * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
     * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排
     * <p>
     * 9.1 算法描述
     * 人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，
     * 该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
     * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
     * 对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
     * 从不是空的桶里把排好序的数据拼接起来。
     * 注意，如果递归使用桶排序为各个桶排序，则当桶数量为1时要手动减小BucketSize增加下一循环桶的数量，
     * 否则会陷入死循环，导致内存溢出。
     * <p>
     * 9.4 算法分析
     * 桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
     * <p>
     * 最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n2)
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }


    /**
     * 10、基数排序（Radix Sort）
     * 基数排序也是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为O(kn),为数组长度，k为数组中的数的最大的位数；
     * <p>
     * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。
     * <p>
     * 10.1 算法描述
     * 取得数组中的最大数，并取得位数
     * arr为原始数组，从最低位开始取每个位组成radix数组
     * 对radix进行计数排序（利用计数排序适用于小范围数的特点
     * <p>
     * 10.4 算法分析
     * 最佳情况：T(n) = O(n * k)   最差情况：T(n) = O(n * k)   平均情况：T(n) = O(n * k)
     * <p>
     * 基数排序有两种方法：
     * <p>
     * MSD 从高位开始进行排序 LSD 从低位开始进行排序
     * <p>
     * <p>
     * <p>
     * 基数排序 vs 计数排序 vs 桶排序
     * <p>
     * 这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：
     * <p>
     * 基数排序：根据键值的每位数字来分配桶
     * 计数排序：每个桶只存储单一键值
     * 桶排序：每个桶存储一定范围的数值
     *
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
