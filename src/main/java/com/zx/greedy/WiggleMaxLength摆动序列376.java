package com.zx.greedy;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 * @author : xkdtm
 * @date : 2021-12-13 16:01
 **/
public class WiggleMaxLength摆动序列376 {

    //[1, 7, 4, 9, 2, 5]
    public int wiggleMaxLength(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preDiff = 0;
        int curDiff = 0;

        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];

            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                preDiff = curDiff;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}



