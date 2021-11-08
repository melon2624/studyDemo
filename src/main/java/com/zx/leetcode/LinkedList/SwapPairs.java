package com.zx.leetcode.LinkedList;

/**
 * 24. 两两交换链表中的节点
 *
 * @author : zhangxin
 * @date : 2021-10-20 15:49
 **/

public class SwapPairs {


    //递归法
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;

        head.next = swapPairs(newHead.next);

        newHead.next = head;

        return newHead;

    }

    //迭代法
    public ListNode swapPairs2(ListNode head) {

        ListNode dummyHead = new ListNode(0);

        dummyHead.next = head;

        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
        }

        return dummyHead.next;

    }

    public static void main(String[] args) {

    }


}
