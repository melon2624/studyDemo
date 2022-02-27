package com.zx.leetcode.queueAndStack;

import java.util.*;

/**
 * @author zhangxin
 * @date 2022-02-15 1:09
 */
public class TopKFrequent前K个高频元素347 {


    public static int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }


        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        int[] result = topKFrequent(arr, 2);

        System.out.println(Arrays.stream(result).toArray());
    }

}
