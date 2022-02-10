package com.zx.leetcode.sort;

/**
 * @author : xkdtm
 * @date : 2022-02-08 15:11
 **/
public class MergeSort归并排序第二遍 {

    public static void mergeSort(int[] arr, int L, int R) {

        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    public static void merge(int[] arr, int L, int mid, int R) {

        int[] temp = new int[R - L + 1];

        int i = L;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= R) {

            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= R) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);

    }
}


