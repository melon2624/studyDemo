package com.zx.leetcode.array;

/**
 * @author zhangxin
 * @date 2022-02-07 19:27
 */
public class Merge合并两个有序数组88 {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i=m+n-1;
        while (n>0&&m>0){
            if (nums2[n-1]>nums1[m-1]){
                nums1[i]=nums2[n-1];
                i--;
                n--;
            }else {
                nums1[i]=nums1[m-1];
                m--;
                i--;
            }
        }

        while (n>0){
            nums1[i]=nums2[n-1];
            i--;
            n--;
        }
        while (m>0){
            nums1[i]=nums1[m-1];
            m--;
            i--;
        }

    }

    public static void main(String[] args) {

        int[] num1=new int[]{1,2,3,0,0,0};
        int[] num2=new int[]{2,5,6};
        merge(num1,3,num2,3);
    }

}
