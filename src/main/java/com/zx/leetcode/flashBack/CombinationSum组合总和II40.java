package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [  [1,1,6],  [1,2,5],  [1,7],  [2,6]  ]
 *
 * @author : zhangxin
 * @date : 2021-11-29 17:53
 **/
public class CombinationSum组合总和II40 {

    static List<Integer> path = new ArrayList<>();

    static List<List<Integer>> result = new ArrayList<>();

    static boolean[] used = null;


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        used = new boolean[candidates.length];
        for (boolean use : used) {
            use = false;
        }
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, 0);

        return result;
    }

    public static void combinationSumHelper(int[] candidates, int target, int startIndex, int sum) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
        } else if (sum > target) {
            return;
        }
                                 //sum + candidates[i] <= target优化
        for (int i = startIndex; i < candidates.length; i++) {

            if (i > 0 && candidates[i - 1] == candidates[i] && used[i - 1] == false) {
                continue;
            }
            sum += candidates[i];
            used[i] = true;
            path.add(candidates[i]);
            combinationSumHelper(candidates, target, i + 1, sum);
            sum -= candidates[i];
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        combinationSum2(candidates, 8);
    }
}
