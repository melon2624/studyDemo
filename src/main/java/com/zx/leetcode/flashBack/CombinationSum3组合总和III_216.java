package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * @author : zhangxin
 * @date : 2021-11-19 18:25
 **/
public class CombinationSum3组合总和III_216 {

    static List<Integer> path = new ArrayList<>();

    static List<List<Integer>> result = new ArrayList<>();


    public static List<List<Integer>> combinationSum3(int k, int n) {
            combinationSumHelper(k,n,1);
        return result;
    }

    public static void combinationSumHelper(int k, int n, int startIndex) {

        if (path.size()==k){
            int sum=0;
            for (int i=0;i<k;i++){
                sum=path.get(i)+sum;
            }
            if (sum==n){
                result.add(new ArrayList<>(path));
                return;
            }
            return;
        }

        for (int i=startIndex;i<=9-(k - path.size()) + 1;i++){
            path.add(i);
            combinationSumHelper(k,n,i+1);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args) {
        combinationSum3(3,7);
    }

}
