package com.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 8, 2, 7, 3, 4, 6, 5, 10, 20, 11, 19, 12, 18, 13, 17, 14, 16, 15};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = getMidIndex(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }

    public static int getMidIndex(int[] array, int left, int right) {
        int pivot = array[right];
        while (left < right) {
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
        }
        array[left] = pivot;
        return left;
    }
}