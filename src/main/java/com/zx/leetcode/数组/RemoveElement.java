package com.zx.leetcode.数组;

/**
 * 移除元素  no.27
 *
 * @author : zhangxin
 * @date : 2021-10-09 14:48
 **/
public class RemoveElement {

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


    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};

        int ans = removeElement(array, 2);
    }
}
