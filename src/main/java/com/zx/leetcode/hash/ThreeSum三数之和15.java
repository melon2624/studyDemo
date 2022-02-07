package com.zx.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022-02-05 17:16
 */
public class ThreeSum三数之和15 {
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int a = nums[i];
            if (a > 0) {
                return ans;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
               continue;
            }
           /* while (i > 0 && i < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }*/
            List<List<Integer>> list = twoSum(nums, i + 1, 0 - a);

            for (List<Integer> list1 : list) {
                list1.add(nums[i]);
                ans.add(list1);
            }
           /* while (i > 0 && i < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }*/
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {

        List<List<Integer>> list = new ArrayList<>();

     /*   int left = nums[start];
        int right = nums[nums.length - 1];*/

        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] > target) {

                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;
            } else if (nums[left] + nums[right] < target) {
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            } else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[left]);
                list1.add(nums[right]);
                list.add(list1);


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
        return list;
    }

    public static void main(String[] args) {
        //int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] num = new int[]{0, 0, 0, 0};
       // int[] num = new int[]{-2, 0, 1, 1, 2};
        int[] num=new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> ans = threeSum(num);
        System.out.println("zx");
    }

}
