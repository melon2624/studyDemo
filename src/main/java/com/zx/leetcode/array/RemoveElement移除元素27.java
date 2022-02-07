package com.zx.leetcode.array;

/**
 * 移除元素  no.27
 *
 * @author : zhangxin
 * @date : 2021-10-09 14:48
 **/
public class RemoveElement移除元素27 {

    // int[] array=new int[]{0,1,2,2,3,0,4,2};
    //快慢指针

    public static int removeElement(int[] array, int target) {

        int fast = 0, slow = 0;

        while (fast < array.length) {
            if (array[fast] != target) {
                array[slow] = array[fast];
                fast++;
                slow++;

            } else {
                fast++;
            }
        }
     /* for (;fast<nums.length;fast++){
          if (val!=nums[fast]){
              nums[slow]=nums[fast];
              slow++;
          }
      }
      return slow;*/
        return slow;
    }

    //第二遍
    public static int removeElement2(int[] array, int target) {

        int slow = 0;
        int fast = 0;

        for (; fast < array.length; fast++) {
            if (array[fast] != target) {
                array[slow]=array[fast];
                slow++;
            }
        }

        return slow;
    }


    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};

        int ans = removeElement2(array, 2);
    }
}
