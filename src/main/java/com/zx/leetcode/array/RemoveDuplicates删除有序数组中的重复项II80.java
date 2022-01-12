package com.zx.leetcode.array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates删除有序数组中的重复项II80 {


    public static int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int left = 2;
        int right = 2;

        for (; right < nums.length; ) {
            if (nums[left - 2] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};

        int ans = removeDuplicates(arr);
        System.out.println(ans);
    }

}
