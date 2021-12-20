package com.zx.greedy;

/**
 * 跳跃游戏45II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author : xkdtm
 * @date : 2021-12-15 18:30
 **/
public class Jump跳跃游戏45II {

    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }

        int curDistance = 0;
        int count = 0;
        int nextDistance;
      /*  for (int i = 0; i < nums.length; i++) {

            maxDistance = nums[i] + i;

            if (nums[i] + i > cover) {
                cover = nums[i] + i;
            }
        }*/
        return 0;
    }
}
