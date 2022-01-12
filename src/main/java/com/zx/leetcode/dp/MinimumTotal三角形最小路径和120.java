package com.zx.leetcode.dp;

import com.sun.jdi.InvalidTypeException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022-01-08 11:30
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class MinimumTotal三角形最小路径和120 {

    public static int minimumTotal(List<List<Integer>> triangle) {

        //int ans = fun(triangle, 0, 0);
        int ans = fun2(triangle);
        return ans;
    }

    //递归超时 思路正确
    //leetcode超时
    public static int fun(List<List<Integer>> triangle, int height, int wide) {

        if (height == triangle.size() - 1) {
            return triangle.get(height).get(wide);
        }
        int left = fun(triangle, height + 1, wide);
        int right = fun(triangle, height + 1, wide + 1);
        int ans = triangle.get(height).get(wide) + Math.min(left, right);
        return ans;

    }

    //动态规划
    public static int fun2(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];

        for (int i = 0; i < dp[triangle.size()-1].length; i++) {
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }

        for (int i=triangle.size()-2;i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {

        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);
        int ans = minimumTotal(triangle);

        System.out.println(ans);

    }
}
