package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022-02-10 23:52
 */
public class Permute全排列46 {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ansList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        fun(nums, list, ansList);

        return ansList;
    }

    public static void fun(int[] nums, List<Integer> list, List<List<Integer>> ansList) {

        if (list.size() == nums.length) {
            List<Integer> newList = new ArrayList<>(list);
            ansList.add(newList);
        }

        for (int i=0;i<nums.length;i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            fun(nums, list, ansList);
            list.remove(list.size()-1);
        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
       List<List<Integer>> ans= permute(arr);
    }

}
