package com.zx.leetcode.sort;

/**
 * @author : zhangxin
 * @date : 2021-11-26 10:35
 **/
public class GetMidNumSort {


    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    public static int getMidNumSort(int[] arr, int left, int right, int mid) {

        int index = partition(arr, left, right);

        if (index == mid) {
            return arr[index];
        } else if (index > mid) {
            return getMidNumSort(arr, left, index - 1, mid);
        } else {
            return getMidNumSort(arr, index + 1, right, mid);
        }

        /*int mid = arr.length / 2;
        int left = 0;
        int right = arr.length - 1;
        int index = partition(arr, left, right);*/

    }


    public static int partition(int[] arr, int left, int right) {

        int temp = arr[left];

        while (left < right) {

            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 3, 7, 4, 6};


        quickSort(arr, 0, arr.length - 1);

        int mid = arr.length / 2;

        int result = getMidNumSort(arr, 0, arr.length - 1, mid);
    }


}
