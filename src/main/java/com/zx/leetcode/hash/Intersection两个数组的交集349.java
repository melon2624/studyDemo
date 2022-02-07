package com.zx.leetcode.hash;

import java.util.*;

/**
 * @author zhangxin
 * @date 2022-01-31 18:31
 */
public class Intersection两个数组的交集349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();


        for (int i : nums1) {
            set1.add(i);
        }

        List<Integer> list = new ArrayList<>();

        for (int i:nums2){
            if (set1.contains(i)){
                list.add(i);
            }
        }

        int[] ans=list.stream().distinct().mapToInt(Integer::intValue).toArray();

        return ans;

    }

}
