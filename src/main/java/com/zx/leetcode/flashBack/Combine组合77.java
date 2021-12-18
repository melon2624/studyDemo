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
        combineHelper(n, k, 1);
        return resultList;
    }

    public static void combineHelper(int n, int k, int startIndex) {
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
    }

    public static void main(String[] args) {

        combine(4, 4);
        System.out.println("zx");
    }

}
