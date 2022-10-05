package com.zx.leetcode.LinkedList;

/**
 * @author : zhangxin
 * @date : 2021-11-10 15:13
 **/
public class HasCycle是否有环 {


    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}
