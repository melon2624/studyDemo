package com.zx.leetcode.array;

/**
 * 二分查找
 * @author : zhangxin
 * @date : 2021-10-08 13:41
 **/
public class BinarySearch {


    public  static  int  binarySearch(int[] array,int tartget){

        if (array.length==0||array==null){
            return -1;
        }

        int left =0,right=array.length-1;

        while (left<=right){
            int mid=(left+right)/2;

           if (array[mid]==tartget){
               return mid;
           }else if (array[mid]>tartget){
               right=mid-1;
           }else if (array[mid]<tartget){
               left=mid+1;
           }
        }

        return -1;
    }

    public static void main(String[] args) {
            int[] array=new int[]{1,2,3,4,5,6,7,8,9};

           int  inedex= binarySearch(array,28);
    }

}
