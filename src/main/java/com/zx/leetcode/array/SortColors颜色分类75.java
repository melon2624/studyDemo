package com.zx.leetcode.array;

/**
 * @author zhangxin
 * @date 2022-02-07 21:42
 */
public class SortColors颜色分类75 {
    //TODO
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 0, 2, 1, 1, 0};

        sortColors(nums);
    }

}
