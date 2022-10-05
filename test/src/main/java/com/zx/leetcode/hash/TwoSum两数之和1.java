package com.zx.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022-01-31 19:15
 */
public class TwoSum两数之和1 {

    //hash
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public int[] twosum2(int[] nums, int target) {

        return null;
    }
}
