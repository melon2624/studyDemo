package com.zx.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022-02-06 16:48
 */
public class FourSum四数之和18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {

                    if (nums[left] + nums[right] > target - nums[i] - nums[j]) {

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (nums[left] + nums[right] < target - nums[i] - nums[j]) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<>();

                        //list.add(nums[i],nums[j],nums[left],nums[right])
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;

                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        //int[] num = new int[]{1, 0, -1, 0, -2, 2};
        int[] num = new int[]{2, 2, 2, 2, 2};
        List<List<Integer>> list = fourSum(num, 8);
        System.out.println("com/zx");
    }

}
