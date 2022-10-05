package com.zx.leetcode.LinkedList;

/**
 * @author : zhangxin
 * @date : 2021-11-10 15:06
 **/
public class DetectCycle链表中环的入口节点剑指OfferII022 {


    public static ListNode detectCycle(ListNode head) {

        ListNode node = hasCycle(head);
        if (node == null) {
            return null;
        }
        ListNode str = head;
        while (str != node) {
            str = str.next;
            node = node.next;
            if (str == node) break;
        }
        return node;
    }


    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return slow;

    }

}
