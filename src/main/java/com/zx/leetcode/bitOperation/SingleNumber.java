package com.zx.leetcode.bitOperation;

/**
 * 力扣136. 只出现一次的数字
 *
 * @author : zhangxin
 * @date : 2021-10-27 14:40
 **/
public class SingleNumber {


    //异或比较
    public static int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i = num ^ i;
        }
        return i;
    }


    //先排序
    public static int singleNUmber2(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int i = singleNumber(nums);
        System.out.println(i);

    }

}
