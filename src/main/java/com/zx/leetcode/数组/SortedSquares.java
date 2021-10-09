package com.zx.leetcode.数组;

/**
 * 有序数组的平方 no.977
 * @author : zhangxin
 * @date : 2021-10-09 18:44
 **/
public class SortedSquares {

    public static int[] sortedSquares(int[] nums) {

        int[] array=new int[nums.length];
        int left=0,right=nums.length-1;

       /* for (int i=nums.length-1;i>=0;i--){
            if (nums[left]*nums[left]>nums[right]*nums[right]){
                array[i]=nums[left]*nums[left];
                left++;
            }else {
                array[i]=nums[right]*nums[right];

                right--;
            }
        }*/
        int index=nums.length-1;
       while (left<=right){
           if (nums[left]*nums[left]>nums[right]*nums[right]){
               array[index--]=nums[left]*nums[left];
               left++;
           }else {
               array[index--]=nums[right]*nums[right];
               right--;
           }
       }

        return array;
    }

    public static void main(String[] args) {

        int[] arr=new int[]{ -7,-3,2,3,11};

        int[] a=sortedSquares(arr);
    }


}
