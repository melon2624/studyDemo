package com.zx.leetcode.sort;

/**
 * @author : zhangxin
 * @date : 2021-11-08 10:27
 **/
public class QuickSort {

    public  static void   quickSort(int[] arr,int left,int right){

        if (left>=right){
            return;
        }
        int partitionIndex=partition1(arr,left,right);
        quickSort(arr,left,partitionIndex-1);
        quickSort(arr,partitionIndex+1,right);
    }

    public  static  int   partition1(int[] arr,int left,int right){

            int privot=arr[left];//取第一个为privot

            while (left<right){
                //从右往左遍历，遇到比privot的righ向左移动，遇到的放到左边去，此时rigth值所在处是空的，
                // 然后再从左往右遍历找到一个比privot大的放到右边 以此循环知道left=right
                while (left<right&&arr[right]>privot){
                    right--;
                }

                if (left<right){
                    arr[left]=arr[right];
                }

                while (left<right&&arr[left]<privot){
                    left++;
                }
                if (left<right){
                    arr[right]=arr[left];
                }
            }
            arr[left]=privot;
            return left;
    }


    public static void main(String[] args) {

        int[] arr=new int[]{2,5,1,3,7,4,6};

        String a="2021110820211110";
      String b=  a.substring(8);

      quickSort(arr,0,arr.length-1);

    }

}
