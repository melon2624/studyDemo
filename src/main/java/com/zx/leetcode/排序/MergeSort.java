package com.zx.leetcode.排序;

/**
 * @author : zhangxin
 * @date : 2021-08-23 10:45
 **/
public class MergeSort {


    public static void mergesort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergesort(arr, L, mid);
        mergesort(arr, mid + 1, R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int i = 0;

        int p1=left;
        int p2=mid+1;

        while (p1<=mid&&p2<=right){
            if (arr[p1]<=arr[p2]){
                temp[i++]=arr[p1++];

            }else {
                temp[i++]=arr[p2++];
            }
        }

        while (p1<=mid){
            temp[i++]=arr[p1++];
        }

        while (p2<=right){
            temp[i++]=arr[p2++];
        }

        for (int t=0;t<temp.length;t++){
            arr[left+t]=temp[t];
        }


    }


    public static int[] subTwoArr(int[] arr1, int[] arr2) {

        int a = arr1.length;
        int b = arr2.length;
        int[] arr3 = new int[a + b];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i <= a - 1 && j <= b - 1) {
            if (arr1[i] <= arr2[j]) {
                arr3[k] = arr1[i];
                i++;
                k++;
            } else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }


        while (i <= a - 1) {
            arr3[k++] = arr1[i++];
        }

        while (j <= b - 1) {
            arr3[k++] = arr2[j++];

        }

        return arr3;
    }

    public static void main(String[] args) {
      /*  int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 5, 6};

        int[] arr3 = subTwoArr(nums1, nums2);
*/
      int[] arr=new int[]{6,5,4,3,2,1};
      mergesort(arr,0,arr.length-1);
    }

}
