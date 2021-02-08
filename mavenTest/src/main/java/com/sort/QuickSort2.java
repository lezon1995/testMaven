package com.sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] ints = {9, 1, 3, 7, 8, 2, 6, 5, 4};
        quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = getMidIndex(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }

    }

    private static int getMidIndex(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        int mid = left;
//        int mid = right;
        array[mid] = pivot;
        return mid;

    }
}
