package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 39.组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * @author : zhangxin
 * @date : 2021-11-26 17:55
 **/
public class CombinationSum组合总和39 {

    static List<Integer> path = new ArrayList<>();

    static List<List<Integer>> result = new ArrayList<>();


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        combinationSumHelper(candidates, target,0);

        return result;
    }

    public static void combinationSumHelper(int[] candidates, int target,int startIndex) {
        int sum = 0;
        for (Integer a : path) {
            sum = sum + a;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
        } else if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            combinationSumHelper(candidates, target,i);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates,target);
    }

}
