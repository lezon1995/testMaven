package com.sort;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ints = {5, 9, 1, 8, 2, 7, 3, 6, 4};

        System.out.println(solution.findKthLargest(ints, 3));
    }

    public void printArray(int[] nums) {
        Arrays.stream(nums)
                .forEach(value -> System.out.print(value + "-"));
        System.out.println();
    }

    /**
     * 解法0. 堆 O(klogn)
     * 解法1. 快速选择: O(n)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int position = partition(nums, left, right);
            System.out.println("position=" + position);
            if (position == k - 1) {
                return nums[position]; //每一轮返回当前pivot的最终位置，它的位置就是第几大的，如果刚好是第K大的数
            } else if (position > k - 1) {
                right = position - 1; //二分的思想
            } else {
                left = position + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        int l = left + 1; //记住这里l是left + 1
        int r = right;
        while (l <= r) {
            while (l <= r && nums[l] >= nums[pivot]) l++; //从左边找到第一个小于nums[pivot]的数
            while (l <= r && nums[r] <= nums[pivot]) r--; //从右边找到第一个大于nums[pivot]的数
            if (l <= r && nums[l] < nums[pivot] && nums[r] > nums[pivot]) {
                swap(nums, l++, r--);
            }
        }
        swap(nums, pivot, r); //交换pivot到它所属的最终位置，也就是在r的位置，因为此时r的左边都比r大，右边都比r小
        return r; //返回最终pivot的位置
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
        printArray(nums);
    }


}