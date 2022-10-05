package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 *
 * @author : zhangxin
 * @date : 2021-12-01 18:04
 **/
public class Subsets子集78 {

    public static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        subSetsHepler(nums, 0);

        return result;
    }

    public static void subSetsHepler(int[] nums, int startIndex) {

        if (startIndex >= nums.length) {
            return;
        } else {
            result.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < nums.length; i++) {

            path.add(nums[i]);
            subSetsHepler(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        subsets(nums);
    }

}
