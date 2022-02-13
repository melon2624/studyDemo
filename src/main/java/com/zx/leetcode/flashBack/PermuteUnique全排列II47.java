package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022-02-11 0:10
 */
public class PermuteUnique全排列II47 {

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<Integer> list = new ArrayList<>();

        List<List<Integer>> ansList = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        for (int i = 0; i < use.length; i++) {
            use[i] = false;
        }
        Arrays.sort(nums);
        permuteUniqueHelper(nums, list, ansList, use);
        return ansList;
    }

    public static void permuteUniqueHelper(int[] nums, List<Integer> list, List<List<Integer>> ansList, boolean[] use) {

        if (list.size() == nums.length) {
            ansList.add(new ArrayList<>(list));

        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1] && use[i - 1] == false) {
                continue;
            }

            if (use[i]==true){
                continue;
            }

            list.add(nums[i]);
            use[i] = true;
            permuteUniqueHelper(nums, list, ansList, use);
            use[i] = false;
            list.remove(list.size() - 1);
        }

    }


    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 2};
        List<List<Integer>> ans = permuteUnique(num);
    }

}
