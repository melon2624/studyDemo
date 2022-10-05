package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77 组合问题
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * @author : zhangxin
 * @date : 2021-11-22 16:07
 **/
public class Combine组合77 {

    static LinkedList<Integer> result = new LinkedList();

    static List<List<Integer>> resultList = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        combineHelper3(n, k, 1);
        return resultList;
    }

    //第二遍
    public static void combineHelper3(int n, int k, int begin) {

        if (result.size() == k) {
            resultList.add(new ArrayList<>(result));
            return;
        }

        for (int i = begin; i <= n; i++) {

            result.add(i);
            combineHelper3(n, k, i + 1);
            result.remove(result.size() - 1);

        }
    }


    public static void combineHelper2(int n, int k, int begin) {

        if (result.size() == k) {
            resultList.add(new LinkedList<>(result));
        }

        for (int i = begin; i <= n; i++) {
            result.add(i);
            combineHelper2(n, k, i + 1);
            result.remove(result.size() - 1);
        }

    }


   /* public static void combineHelper(int n, int k, int startIndex) {
        if (result.size() == k) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        //n可以剪枝
        for (int i = startIndex; i <= n; i++) {
            result.add(i);
            combineHelper(n, k, i + 1);
            result.removeLast();
        }
    }*/


    public static void main(String[] args) {

        List<List<Integer>> list = combine(4, 2);
        System.out.println("com/zx");
    }

}
